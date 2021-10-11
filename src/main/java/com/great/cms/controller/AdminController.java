package com.great.cms.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.great.cms.controller.bean.AvailableRoom;
import com.great.cms.controller.bean.CourseAndTeacher;
import com.great.cms.controller.bean.CourseAndTeacherList;
import com.great.cms.db.dao.DayDao;
import com.great.cms.db.dao.GeneralTypeDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.MainRoutine;
import com.great.cms.db.entity.Room;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;
import com.great.cms.generator.Lecture;
import com.great.cms.generator.OutputGenerator;
import com.great.cms.inpout.CustomFileWriter;
import com.great.cms.service.CourseService;
import com.great.cms.service.DayService;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.ExamCommitteeService;
import com.great.cms.service.ExamService;
import com.great.cms.service.MainRoutineService;
import com.great.cms.service.RoomService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	TeacherService teacherService;

	@Autowired
	DepartmentService deptService;

	@Autowired
	ExamService examService;

	@Autowired
	ExamCommitteeService examCommitteeService;

	@Autowired
	MainRoutineService mainRoutineService;

	@Autowired
	RoomService roomService;

	@Autowired
	CourseService courseService;

	@Autowired
	TeachesService teachesService;

	@Autowired
	DayDao dayDao;

	@Autowired
	GeneralTypeDao gtDao;

	@Autowired
	CustomFileWriter customFileWriter;

	@Autowired
	DayService dayService;

	// @Autowired
	// Mapper mapper;

	// @Autowired
	// Lecture lecture;

	private Exam exam = null;
	private List<ExamCommittee> examCommittees = null;
	private Teacher teacher = null;

	@RequestMapping({ "/adminview", "/", "" })
	public String teacherView(Model model, Principal principal, HttpServletResponse response) {

		String username = principal.getName();

		Teacher teacher = teacherService.getTeacher(username.trim());
		this.teacher = teacher;

		Department department = (Department) deptService.getDept(teacher.getDeptId().getDeptCode());
		Exam exam = (Exam) examService.getExam(department);

		this.exam = exam;

		List<ExamCommittee> examCommittees = null;

		if (exam != null) {
			examCommittees = examCommitteeService.getCommittees(exam);
		}

		this.examCommittees = examCommittees;

		List<MainRoutine> routine1 = null;
		List<MainRoutine> routine2 = null;
		List<MainRoutine> routine3 = null;
		List<MainRoutine> routine4 = null;
		List<Teaches> teaches1 = null;
		List<Teaches> teaches2 = null;
		List<Teaches> teaches3 = null;
		List<Teaches> teaches4 = null;

		ExamCommittee com1 = null;
		ExamCommittee com2 = null;
		ExamCommittee com3 = null;
		ExamCommittee com4 = null;

		if (examCommittees != null) {

			for (ExamCommittee examCommittee : examCommittees) {

				if (examCommittee == null) {
					continue;
				}

				if (examCommittee.getSemester() == 11 || examCommittee.getSemester() == 12) {

					System.out.println("Fetching routine For semester 1\n\n");

					routine1 = mainRoutineService.getRoutineForTeacher(department, examCommittee);
					com1 = examCommittee;
					teaches1 = teacherService.getTeaches(examCommittee.getSession(), teacher.getDeptId());

				} else if (examCommittee.getSemester() == 21 || examCommittee.getSemester() == 22) {

					System.out.println("Fetching routine For semester 2\n\n");

					routine2 = mainRoutineService.getRoutineForTeacher(department, examCommittee);
					com2 = examCommittee;
					teaches2 = teacherService.getTeaches(examCommittee.getSession(), teacher.getDeptId());

				} else if (examCommittee.getSemester() == 31 || examCommittee.getSemester() == 32) {

					System.out.println("Fetching routine For semester 3\n\n");

					routine3 = mainRoutineService.getRoutineForTeacher(department, examCommittee);
					com3 = examCommittee;
					teaches3 = teacherService.getTeaches(examCommittee.getSession(), teacher.getDeptId());

				} else if (examCommittee.getSemester() == 41 || examCommittee.getSemester() == 42) {

					System.out.println("Fetching routine For semester 4\n\n");

					routine4 = mainRoutineService.getRoutineForTeacher(department, examCommittee);
					com4 = examCommittee;
					teaches4 = teacherService.getTeaches(examCommittee.getSession(), teacher.getDeptId());

				}

			}
		}

		model.addAttribute("routine1", routine1);
		model.addAttribute("routine2", routine2);
		model.addAttribute("routine3", routine3);
		model.addAttribute("routine4", routine4);

		model.addAttribute("teaches1", teaches1);
		model.addAttribute("teaches2", teaches2);
		model.addAttribute("teaches3", teaches3);
		model.addAttribute("teaches4", teaches4);

		model.addAttribute("department", teacher.getDeptId().getDeptCode());
		model.addAttribute("teacher", teacher);

		// model.addAttribute("com1", com1.getExamCommitteeId());
		// model.addAttribute("com2", com2.getExamCommitteeId());
		// model.addAttribute("com3", com3.getExamCommitteeId());
		// model.addAttribute("com4", com4.getExamCommitteeId());

		return "adminview";
	}

	@RequestMapping("/createroutine")
	public String createRoutine(Model model, @RequestParam String employeeCode) {

		Teacher teacher = teacherService.getTeacher(employeeCode);

		List<Course> courses = courseService.getCourseByAcceptingDept(teacher.getDeptId().getDeptCode());
		List<Teacher> teachers = teacherService.getListByDept(teacher.getDeptId());
		List<Room> theoryRooms = roomService.getTheoryRoomsByDept(teacher.getDeptId());
		List<Room> labRooms = roomService.getLabRoomsByDept(teacher.getDeptId());

		if (courses == null || teachers == null || theoryRooms == null || labRooms == null) {

			return "error";
		}

		customFileWriter.writeCourse(courses);
		customFileWriter.writeTeacher(teachers);
		customFileWriter.writeTheoryRoom(theoryRooms);
		customFileWriter.writeLabRoom(labRooms);

		model.addAttribute("courses", courses);
		model.addAttribute("teachers", teachers);

		return "create_routine_final";
	}

	@RequestMapping("/availablerooms")
	@ResponseBody
	public String getAvailableRooms(int com1, int com2, int com3, int com4, int day, int time, int dept,
			int currentSemester, int mainRoutineId, int teachesId) {

		System.out.println("\n\nSEARCHING FOR AVAILABLE ROOMS:....." + currentSemester + "\n\n");

		List<Room> rooms = roomService.getAvailableRooms(dept, day, time, com1, com2, com3, com4, currentSemester,
				mainRoutineId, teachesId);

		List<AvailableRoom> list = new ArrayList<AvailableRoom>();
		if (rooms != null) {

			for (Room room : rooms) {

				AvailableRoom availableRoom = new AvailableRoom();

				if (room.getHour() > 0) {

					availableRoom.setRoomId(room.getRoomId());
					availableRoom.setRoomNum(room.getRoomNum());
					availableRoom.setHour(room.getHour());
					availableRoom.setBuildingName(room.getBuildingId().getBuildingName());
					availableRoom.setRoomType(room.getGeneralTypeId().getType());
					list.add(availableRoom);
				}
			}

			if (list.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				String value = null;

				try {

					value = mapper.writeValueAsString(list);

				} catch (JsonProcessingException e) {

					return "error";

				} catch (IOException e) {

					return "error";
				}

				return value;

			}

		}

		return "noroom";

	}

	// @RequestMapping("/update")
	// @ResponseBody
	// public String updateCourse(MainRoutine mainRoutine) {
	//
	// MainRoutine routine =
	// mainRoutineService.getRoutineById(mainRoutine.getMainRoutineId());
	//
	// if (routine != null) {
	//
	// Teacher teacher = routine.getTeachesId().getInstructorId();
	// Course course = routine.getTeachesId().getCourseId();
	// Department department = routine.getDeptId();
	// Room room =
	// roomService.getRoomByRoomId(mainRoutine.getRoomId().getRoomId());
	//
	// if (room != null) {
	//
	// int oldHour = course.getHour() + (routine.getEndTime() -
	// routine.getStartTime());
	// int newHour = mainRoutine.getEndTime() - mainRoutine.getStartTime();
	// if ((oldHour - newHour) < 0) {
	//
	// return "hourlessthan";
	// }
	//
	// if (mainRoutineService.update(mainRoutine)) {
	//
	// int hour = oldHour - newHour;
	// course.setHour(hour);
	// if (courseService.update(course)) {
	//
	// MainRoutineBean bean = new MainRoutineBean();
	//
	// bean.setMainRoutineId(routine.getMainRoutineId());
	// bean.setDeptId(routine.getDeptId().getDeptId());
	// bean.setExamCommitteeId(routine.getExamCommitteeId().getExamCommitteeId());
	// bean.setRoomNum(room.getRoomNum());
	// bean.setDayId(mainRoutine.getDayId().getDayId());
	// bean.setEmployeeCode(routine.getTeachesId().getInstructorId().getEmployeeCode());
	// bean.setStartTime(mainRoutine.getStartTime());
	// bean.setEndTime(mainRoutine.getEndTime());
	// bean.setTeachesId(routine.getTeachesId().getTeachesId());
	// bean.setCourseCode(routine.getTeachesId().getCourseId().getCourseCode());
	// bean.setBuildingName(routine.getDeptId().getBuildingId().getBuildingName());
	//
	// List<Teaches> teachesList = teacherService.getTeaches(teacher,
	// course.getSession(), department);
	// List<TeachesBean> teachesBeanList = new ArrayList<TeachesBean>();
	//
	// if (teachesList != null) {
	//
	// for (Teaches teach : teachesList) {
	//
	// TeachesBean teachesBean = new TeachesBean();
	//
	// teachesBean.setTeachesId(teach.getTeachesId());
	// teachesBean.setCourseCode(teach.getCourseId().getCourseCode());
	// teachesBean.setHour(teach.getCourseId().getHour());
	//
	// teachesBeanList.add(teachesBean);
	//
	// }
	//
	// bean.setTeachesList(teachesBeanList);
	// }
	//
	// ObjectMapper mapper = new ObjectMapper();
	// String value = null;
	//
	// try {
	//
	// value = mapper.writeValueAsString(bean);
	// return value;
	//
	// } catch (Exception ex) {
	//
	// return "error";
	// }
	//
	// }
	//
	// }
	//
	// }
	//
	// }
	//
	// return "error";
	// }
	//
	// @RequestMapping("/delete")
	// @ResponseBody
	// public String deleteCourse(@RequestParam int mainRoutineId) {
	//
	// System.out.println("\n\nDeleting mainroutine: mainRoutineId " +
	// mainRoutineId);
	//
	// MainRoutine mainRoutine =
	// mainRoutineService.getRoutineById(mainRoutineId);
	//
	// if (mainRoutine == null) {
	// return "error";
	// }
	//
	// Teacher teacher = mainRoutine.getTeachesId().getInstructorId();
	// Course course = mainRoutine.getTeachesId().getCourseId();
	// Department department = mainRoutine.getDeptId();
	//
	// if (mainRoutineService.deleteById(mainRoutineId)) {
	//
	// int hour = course.getHour() + (mainRoutine.getEndTime() -
	// mainRoutine.getStartTime());
	// course.setHour(hour);
	//
	// if (courseService.update(course)) {
	//
	// System.out.println(course.getHour());
	//
	// List<Teaches> teaches = teacherService.getTeaches(teacher,
	// course.getSession(), department);
	// List<TeachesBean> teachesList = new ArrayList<TeachesBean>();
	//
	// if (teaches != null) {
	// for (Teaches teach : teaches) {
	//
	// TeachesBean teachesBean = new TeachesBean();
	// teachesBean.setTeachesId(teach.getTeachesId());
	// teachesBean.setCourseCode(teach.getCourseId().getCourseCode());
	// teachesBean.setHour(teach.getCourseId().getHour());
	//
	// teachesList.add(teachesBean);
	//
	// }
	// }
	// ObjectMapper mapper = new ObjectMapper();
	// String value = null;
	// try {
	// value = mapper.writeValueAsString(teachesList);
	// return value;
	// } catch (Exception ex) {
	// return "error";
	// }
	//
	// }
	//
	// }
	//
	// return "error";
	//
	// }
	//
	// @RequestMapping("/add")
	// @ResponseBody
	// public String addCourse(MainRoutine mainRoutine) {
	//
	// Teaches teaches =
	// teacherService.getTeachesById(mainRoutine.getTeachesId().getTeachesId());
	//
	// if (teaches == null) {
	// return "error";
	// }
	//
	// Course course = teaches.getCourseId();
	//
	// int hour = course.getHour() - (mainRoutine.getEndTime() -
	// mainRoutine.getStartTime());
	//
	// if (hour < 0) {
	//
	// return "hourlessthan";
	// }
	//
	// if (mainRoutineService.addRoutine(mainRoutine)) {
	//
	// MainRoutineBean bean = new MainRoutineBean();
	// MainRoutine routine =
	// mainRoutineService.getRoutineById(mainRoutine.getMainRoutineId());
	//
	// if (routine != null) {
	//
	// Teacher teacher = routine.getTeachesId().getInstructorId();
	// Department department = routine.getDeptId();
	// course.setHour(hour);
	//
	// if (courseService.update(course)) {
	//
	// System.out.println("Updating Course by adding");
	//
	// bean.setMainRoutineId(routine.getMainRoutineId());
	// bean.setDeptId(routine.getDeptId().getDeptId());
	// bean.setExamCommitteeId(routine.getExamCommitteeId().getExamCommitteeId());
	// bean.setRoomNum(routine.getRoomId().getRoomNum());
	// bean.setDayId(routine.getDayId().getDayId());
	// bean.setEmployeeCode(routine.getTeachesId().getInstructorId().getEmployeeCode());
	// bean.setStartTime(routine.getStartTime());
	// bean.setEndTime(routine.getEndTime());
	// bean.setTeachesId(routine.getTeachesId().getTeachesId());
	// bean.setCourseCode(routine.getTeachesId().getCourseId().getCourseCode());
	// bean.setBuildingName(routine.getDeptId().getBuildingId().getBuildingName());
	//
	// List<Teaches> teachesList = teacherService.getTeaches(teacher,
	// course.getSession(), department);
	// List<TeachesBean> teachesBeanList = new ArrayList<TeachesBean>();
	//
	// if (teachesList != null) {
	// for (Teaches teach : teachesList) {
	//
	// TeachesBean teachesBean = new TeachesBean();
	//
	// teachesBean.setTeachesId(teach.getTeachesId());
	// teachesBean.setCourseCode(teach.getCourseId().getCourseCode());
	// teachesBean.setHour(teach.getCourseId().getHour());
	//
	// teachesBeanList.add(teachesBean);
	//
	// }
	// bean.setTeachesList(teachesBeanList);
	//
	// }
	//
	// ObjectMapper mapper = new ObjectMapper();
	// String value = null;
	// try {
	// value = mapper.writeValueAsString(bean);
	// return value;
	// } catch (Exception ex) {
	//
	// return "error";
	// }
	//
	// }
	//
	// }
	//
	// }
	//
	// return "error";
	//
	// }
	@RequestMapping("/createTeaches")
	@ResponseBody
	public String createTeaches(@RequestBody CourseAndTeacherList teachesList) throws ParseException, IOException {

		customFileWriter.writeTeaches(teachesList.getTeachesList());

		for (CourseAndTeacher c : teachesList.getTeachesList()) {

			System.out.println(c);

			Teaches teaches = new Teaches();
			teaches.setCourseId(courseService.getCourse(c.getCourseId()));
			teaches.setInstructorId(teacherService.getTeacherById(Long.valueOf(c.getInstructorId())));

			teachesService.addTeaches(teaches);
		}

		Lecture lecture = new Lecture();
		OutputGenerator outputGenerator = new OutputGenerator(
				"/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/in.txt");

		createRoutine();

		return "ok";

	}

	public void createRoutine() {

		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(
					new FileReader("/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/out.txt"));

			while ((line = br.readLine()) != null) {

				if (line == null || line.length() == 0) {
					continue;
				}

				String[] arr = line.split(",");

				MainRoutine mainRoutine = new MainRoutine();

				ExamCommittee examCommitteeId = examCommitteeService
						.getExamCommitteeBySemester(Integer.parseInt(arr[0]));
				Day dayId = dayService.getDay(Integer.parseInt(arr[1]));
				Course courseId = courseService.getCourse(Integer.parseInt(arr[2]));
				Room roomId = roomService.getRoomByRoomId(Integer.parseInt(arr[3]));
				Teacher teacherId = teacherService.getTeacherById(Long.valueOf(arr[4]));

				Teaches teachesId = teachesService.getTeaches(courseId, teacherId);

				Department department = deptService.getDeptById(1);

				mainRoutine.setDayId(dayId);
				mainRoutine.setExamCommitteeId(examCommitteeId);
				mainRoutine.setStartTime(Integer.parseInt(arr[5]));
				mainRoutine.setEndTime(Integer.parseInt(arr[6]));
				mainRoutine.setTeachesId(teachesId);
				mainRoutine.setRoomId(roomId);
				mainRoutine.setDeptId(department);

				mainRoutineService.addRoutine(mainRoutine);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
