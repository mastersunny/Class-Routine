<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">

<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/javascript/myscript.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.min.js"></script>

<title>AdminView</title>

<style type="text/css">
.hour {
	background-color: #888888;
	height: 4em;
	border: 1px solid white;
	margin-bottom: 1px;
	text-align: center;
}

.time, .day {
	color: #F8F8F8;
}

#PopUp {
	height: 52%;
	border: 1px solid black;
	background-color: transparent;
	display: none;
	position: absolute;
	z-index: 1;
	border-radius: 10px;
	box-shadow: 1px 1px 5px grey;
	overflow: auto;
	top: 10%;
}

.close {
	position: absolute;
	right: 10px;
	top: 10px;
	font-weight: bold;
	font-family: sans-serif;
	cursor: pointer;
}

.course-info {
	text-align: center;
	background-color: #f5f5f5;
	border-radius: 4px;
	position: relative;
	left: 3%;
	min-height: 6em;
}

#course-taken {
	list-style-type: none;
}

ul li {
	font-size: 88%;
	list-style-type: none;
	color: #F8F8F8;
	list-style-type: none;
}

ul {
	padding: 0em;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}">Home</a></li>
				</ul>
				<h3 class="nav navbar-text text-primary"
					style="position: relative; left: 31%;">Routine:
					${department.deptCode}</h3>
				<ul class="nav navbar-nav navbar-right">
					<li><a id="logOut"
						href="<c:url value='/j_spring_security_logout'/>"><span
							class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
				</ul>
			</div>

		</div>
	</nav>

	<div class="container-fluid">
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title text-primary"></h4>
					</div>
					<div class="modal-body" style="overflow:auto;">
						<div id="currentCourse">
						   
						</div>
						
						<div id="noroom">
						     <h3 class="text-danger">No room available at this moment</h3>
						</div>
						<div style="display:none;text-align:center;" id="confirmDiv" class="well">
						     <button type="button" id="confirm" class="btn btn-lg btn-primary" >Confirm</button>
						     <button type="button" id="cancel" class="btn btn-lg btn-danger">Cancel</button>
						</div>
						<div id="hasroom">						    
						     <p class="text-primary"></p>
                             <table id ="room-info" class="table table-bordered" style="text-align:center;">
                                  <thead>
                                       <tr>
                                           <th>Room Number</th>
                                           <th>Hours Available</th>
                                           <th>Select</th>
                                       </tr>
                                  </thead>
                                  <tbody>
                                  </tbody>
                              </table>
                              <p class="text-danger">Please select a time less than or equal to 3 hours</p>
	                          <form role="form" id="update">
	                               <div  class="room-time" style="margin-bottom:5%;"></div>
	                               <button type="submit" class="btn btn-primary btn-sm">Update</button>
	                          </form>
	                          <form role="form" id="add">
	                               <div  class="room-time" style="margin-bottom:5%;"></div>
	                               <button type="submit" class="btn btn-primary btn-sm">Add</button>
	                          </form>
	                                                                         
						</div>
						<div>
						    <button id="delete" type="button" class="btn btn-danger btn-sm pull-right">Delete</button>  
						</div>
						<div id="error">
						   <h3 class="text-danger">Sorry your request cannot be processed at this moment</h3>
						</div>
						
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<div id="semester1" data-sem1="${com1}" data-sem2="${com2}" data-sem3="${com3}" data-sem4="${com4}" class="row">

			<div class="col-xs-2">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Current Semesters <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/admin/getRoomsAndCourses/${com1.session}/${department.deptId}/${com1.semester}">Semester
								- ${com1.semester}</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/getRoomsAndCourses/${com2.session}/${department.deptId}/${com2.semester}">Semester
								- ${com2.semester}</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/getRoomsAndCourses/${com3.session}/${department.deptId}/${com3.semester}">Semester
								- ${com3.semester}</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/getRoomsAndCourses/${com4.session}/${department.deptId}/${com4.semester}">Semester
								- ${com4.semester}</a></li>
					</ul>
				</div>
			</div>
			<div class="col-xs-8">
				<div class="row">
					<div class="col-xs-1 hour">
						<h4 class="day">DAY</h4>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">08-09</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">09-10</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">10-11</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">11-12</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">12-01</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">01-02</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">02-03</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">03-04</h5>
					</div>
					<div class="col-xs-1 hour">
						<h5 class="time">04-05</h5>
					</div>
				</div>
				<c:forEach var="i" begin="1" end="7">

					<div class="row">
						<c:choose>
							<c:when test="${i==1}">
								<div class="col-xs-1 hour">
									<h4 class="day">Sun</h4>
								</div>
							</c:when>
							<c:when test="${i==2}">
								<div class="col-xs-1 hour">
									<h4 class="day">Mon</h4>
								</div>
							</c:when>
							<c:when test="${i==3}">
								<div class="col-xs-1 hour">
									<h4 class="day">Tue</h4>
								</div>
							</c:when>
							<c:when test="${i==4}">
								<div class="col-xs-1 hour">
									<h4 class="day">Wed</h4>
								</div>
							</c:when>
							<c:when test="${i==5}">
								<div class="col-xs-1 hour">
									<h4 class="day">Thus</h4>
								</div>
							</c:when>
							<c:when test="${i==6}">
								<div class="col-xs-1 hour">
									<h4 class="day">Fri</h4>
								</div>
							</c:when>
							<c:when test="${i==7}">
								<div class="col-xs-1 hour">
									<h4 class="day">Sat</h4>
								</div>
							</c:when>
						</c:choose>

						<c:set var="flag" value="${0}"></c:set>
						<c:forEach var="j" begin="8" end="17">

							<c:forEach var="routine" items="${routine1}">
								<c:if test="${routine.dayId.dayId==i && routine.startTime==j}">
									<c:choose>
										<c:when test="${(routine.endTime-routine.startTime)==1}">


											<div
												class='col-xs-1 hour <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
												data-dept="${teacher.deptId.deptId}"
												data-teaches="${routine.teachesId.teachesId}"
												data-sem="${com1}" data-day="${i}"
												data-id="${routine.mainRoutineId}" data-time="${j}"
												data-hour="${1}">

												<ul>
													<li style="font-size: 60%">${routine.teachesId.courseId.courseCode}</li>
													<li style="font-size: 60%">${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
													<li style="font-size: 60%">${routine.teachesId.instructorId.employeeCode}</li>
												</ul>

											</div>


											<c:set var="flag" value="${1}"></c:set>

										</c:when>
										<c:when test="${(routine.endTime-routine.startTime)==2}">

											<div
												class='col-xs-2 hour <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
												data-dept="${teacher.deptId.deptId}"
												data-teaches="${routine.teachesId.teachesId}"
												data-sem="${com1}" data-day="${i}"
												data-id="${routine.mainRoutineId}" data-time="${j}"
												data-hour="${2}">

												<ul>
													<li>${routine.teachesId.courseId.courseCode}</li>
													<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
													<li>${routine.teachesId.instructorId.employeeCode}</li>
												</ul>
											</div>

											<c:set var="flag" value="${2}"></c:set>
										</c:when>
										<c:when test="${(routine.endTime-routine.startTime)==3}">
											<div
												class='col-xs-3 hour <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
												data-dept="${teacher.deptId.deptId}"
												data-teaches="${routine.teachesId.teachesId}"
												data-sem="${com1}" data-day="${i}"
												data-id="${routine.mainRoutineId}" data-time="${j}"
												data-hour="${3}">

												<ul>
													<li>${routine.teachesId.courseId.courseCode}</li>
													<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
													<li>${routine.teachesId.instructorId.employeeCode}</li>
												</ul>
											</div>

											<c:set var="flag" value="${3}"></c:set>
										</c:when>
									</c:choose>

								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${flag!=0}">
									<c:set var="flag" value="${flag-1}"></c:set>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${j!=17}">
											<div class="col-xs-1 hour courseDrop clickable"
												data-dept="${teacher.deptId.deptId}" data-sem="${com1}"
												data-day="${i}" data-time="${j}"></div>
										</c:when>
										<c:otherwise>
											<div class="col-xs-1" data-sem="${com1}" data-day="${i}"
												data-time="${j}"></div>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:forEach>

					</div>
				</c:forEach>


			</div>
			<div class="col-md-offset-9">

				<div class="availableCourse col-md-2"
					style="position: absolute; background-color: #F0F0F0; padding: 1em;">
					<c:choose>
						<c:when test="${teaches==null}">
							<div style="background-color: #FFFFFF;">
								<p>You have no courses available to add</p>
							</div>
						</c:when>
						<c:otherwise>
							<c:forEach var="teach" items="${teaches}">
								<div style="background-color: #FFFFFF" class="drag"
									data-new="newCourse" data-teaches="${teach.teachesId}">
									<p style="font-weight: bold; font-family: sans-serif;">Course
										Code: ${teach.courseId.courseCode}</p>
									<p style="font-family: sans-serif;">Available Hours:
										${teach.courseId.hour}</p>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>


		</div>

	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			
			
// 			$('.test1').draggable({
// 				 cursor: 'move',
// 				    containment: 'document',
// 				    cursor:'move',
				    
// 			});
// 			$( ".test2" ).droppable({
// 			      accept: ".test1",
// 			      activeClass: "ui-state-hover",
// 			      hoverClass: "ui-state-active",
// 			      drop: function( event, ui ) {
// 			        $( this )
// 			          .addClass( "ui-state-highlight" );
			          
// 			      }
// 			    });
		
			 var dayId,startTime,deptId,
			 examCommitteeId,teachesId,
			 time,mainRoutineId,roomId,
			 currentHour,newHour,
			 currentDayId,currentStartTime,currentExamCommitteeId;
			 
			 var room_time = $('.room-time');
			 var flag_for_room_info = 0;
			 
			 //checking available rooms for all the semesters.
       	  
             var  com1 = $('#semester1').data('sem1'),
                  com2 = $('#semester2').data('sem2'),
                  com3 = $('#semester3').data('sem3'),
                  com4 = $('#semester4').data('sem4');
			 
			    function getRooms(){
			    	
			    	$.ajax({
	                	   
						url : '${pageContext.request.contextPath}/admin/availablerooms',
						type : 'POST',
						//dataType: 'json', 
						data : {
							
							com1:com1,
							com2:com2,
							com3:com3,
							com4:com4,
							day:dayId,
							time:time,
							dept:deptId,
							currentSemester: examCommitteeId,
							mainRoutineId: mainRoutineId,
							teachesId: teachesId
							
						},
						success : function(data) {

							
							if(data=="noroom"){
								
								$('#hasroom').hide();
								$('#noroom').show();
								$('#error').hide();
								flag_for_room_info = 0;
								
							}
							else {
								
								var obj = JSON.parse(data);
								
								$('#noroom').hide();
								$('#hasroom').show();
								$('#error').hide();
								
								flag_for_room_info = 1;
								
								if(time<12){
									
									time = time+' am';
								}
								else{
									time = time+' pm';
								}
								
								var dayName = ""; 
								
								if(dayId==1){
									dayName = "Sun";
								}else if(dayId==2){
									dayName="Mon";
								}else if(dayId==3){
									dayName="Tue";
								}else if(dayId==4){
								    dayName="Wed";	
								}else if(dayId==5){
									dayName="Thus";
								}else if(dayId==6){
									dayName="Fri";
								}else if(dayId==7){
									dayName="Sat";
								}
								
								$('#hasroom').children('p').eq(0).empty().text('Room availabe from '+dayName+ " " + time);
								
								var items = "";			                    
								for(var i=0;i<obj.length;i++){
									
									 items += "<tr><td>"+obj[i].roomNum+"</td><td>"+obj[i].hour+
					                    "</td><td><input type='radio' name='otpion' value=" +obj[i].roomId+ "></td></tr>";
								}
			                    $('#room-info tbody').empty().append(items);
			                    
			                    $("tbody input").on("click",function(){
			                        
			                        items="";
			                        roomId = $('input:checked').val();
			                        
			                        
			                        for(var i=0;i<obj.length;i++){
			                        	
				                        if(roomId==obj[i].roomId){
				                            
				                            for(var j=1;j<=obj[i].hour;j++){
				                            	
				                                items += "<label class='radio-inline'><input type='radio' name='hour' value="+j+">" + j + "</label>";
				                            }
				                           
				                            room_time.empty().append(items);
				                           
				                        }
			                        }
			             
			                     });
                         
								
							}
						},
						error : function(data,status,er) {
							
							$('#noroom').hide();
							$('#hasroom').hide();
							$('#error').show();
							
						}
					});
			    }
			
			    
							
              	function init() {
                    
						var drag = $('.drag');
					    var string,courseCode,room,teacher,ul;

					    drag.draggable({

						     containment: "document",
						     cursor: "move",
						     distance: 20,
						     helper: myHelper,
						     zIndex: 100,
						     start: function(event,ui){
						    	    
						            $(this).draggable("option","revert",true);
						      }	                

						 });
						  function myHelper(event){
						            	
							  room_time.empty();
							  
							  if($(this).data('new') == "newCourse"){
								   
								  var $this = $(this).children('p').eq(0).text();
								  string = $this.split(":");
								  return '<h2 style="font-weight:bold;font-family:sans-serif;">' + string[1] + '</h2>';
								  
								  
							  }
						      var $this = $(this).find('ul').children('li').eq(0);
						      return '<h2 style="font-weight:bold;font-family:sans-serif;">' + $this.text() + '</h2>';
						  }
						  
						  var drop = $('.courseDrop');
						  
				          drop.droppable({

				                accept: ".drag",
				                //hoverClass: ".test",
				                drop: handleDropEvent

				               
				          });
				              
				          function handleDropEvent(event,ui){
				            	      		  
				        	  $('#confirmDiv').hide();
				        	  ui.draggable.draggable("option","revert",false);
				        	  
		                          //getting the dropped location.  
	
				                  dayId = $(this).data('day'),
				                  time = $(this).data('time'),
				                  deptId = $(this).data('dept');
				                  examCommitteeId = $(this).data('sem');
				                                
				                  startTime = time;
				                    			                 		                  
				                  var dragged = ui.draggable;
				                  
				                  if(dragged.data('new')=="newCourse"){
				                	    
				                	  ul = '<ul style="background-color:#888888;text-align:center;"><li>'
						                  + string[1] +'</li>';
				                	  $('#currentCourse').empty().append(ul);
					                  $('.modal-title').text("ADD A COURSE");    
					                  $('#delete').hide();
					                  $('#update').hide();
					                  $('#add').show();
					                  mainRoutineId = -100000;
					                  teachesId = dragged.data('teaches');
					                  getRooms();
					                  $('#myModal').modal('show'); 
					                  return;
				                	   
				                  }
				                  
				                  
				                  courseCode = dragged.find('ul').children('li').eq(0).text();
				                  room = dragged.find('ul').children('li').eq(1).text();
				                  teacher = dragged.find('ul').children('li').eq(2).text();
				                  
				                  teachesId = dragged.data('teaches');
				                  mainRoutineId = dragged.data('id');
				                  currentHour = dragged.data('hour');
				                  currentDayId = dragged.data('day');
				                  currentStartTime = dragged.data('time');
				                  currentExamCommitteeId = dragged.data('sem');
				                  
				                 
				                                                   
				                  ul = '<ul style="background-color:#888888;text-align:center;"><li>'
				                  +courseCode+'</li><li>'
				                  +room+'</li><li>'
				                  + teacher + '</ul>';
				                  
				                  $('#currentCourse').empty().append(ul);
				                  $('.modal-title').text("UPDATE A COURSE");    
				                  $('#delete').hide();
				                  $('#update').show();
				                  $('#add').hide();
				                  getRooms();
				                  $('#myModal').modal('show');


				                   
				          }   
				          
				          
							 
							 
							 
							 
				          
			     }

			  init();
			  
			  function click(){
				  
				  var clickable = $('.clickable');
				  var title = $('.modal-title');
				  var myModal = $('#myModal');
			  
					 clickable.dblclick(function(){
						 
						 $('#confirmDiv').hide();
						 $('#add').hide();
						 $('#update').show();
					 
						 var $this = $(this);
						 room_time.empty();
					 
						 if($this.find('ul').length>0){
						  
							  var courseCode = $this.find('ul').children('li').eq(0).text();
			                  var room = $this.find('ul').children('li').eq(1).text();
			                  var teacher = $this.find('ul').children('li').eq(2).text();
		                  
			                  var ul = '<ul style="background-color:#888888;text-align:center;"><li>'
			                  +courseCode+'</li><li>'
			                  +room+'</li><li>'
			                  + teacher + '</ul>'
			                  
			                  $('#currentCourse').empty().append(ul);		                  
			                  title.text("UPDATE OR DELETE A COURSE");
			                  $('#delete').show();
			                  $('#myModal').modal('show');
			                  
			                  //getting the clicked location.  
			              	
			                  dayId = $this.data('day'),
			                  time = $this.data('time'),
			                  deptId = $this.data('dept');
			                  examCommitteeId = $this.data('sem');               
			                  startTime = time;
			                  teachesId = $this.data('teaches');
			                  mainRoutineId = $this.data('id');
			                  currentHour = $this.data('hour');
			                  currentDayId = $this.data('day');
			                  currentStartTime = $this.data('time');
			                  currentExamCommitteeId = $this.data('sem');
			                  
			                  
			                  getRooms();
			                 
							  
							 
						 }
						 
						 
					 });
			  }
			  
			 click();
			 
			 $('#add').on('submit',function(e){
				 
				  e.preventDefault(); 
				  console.log("submitted");
				  
				  var $this = $(this).serialize(); 
				  var hour = $this.split("=");			 
				 
				 if(hour[1]==null || hour[1]>3){
					 
					 
					  return;					 
				 }		
				 
				 newHour = parseInt(hour[1]);
				 var endTime = startTime + newHour; 					
				 var mainRoutine = { };
				 
				 
				 mainRoutine['startTime'] = startTime;
				 mainRoutine['endTime'] = endTime;
				 mainRoutine['teachesId.teachesId'] = teachesId;
				 mainRoutine['roomId.roomId'] = parseInt(roomId);
				 mainRoutine['deptId.deptId'] = deptId;
				 mainRoutine['examCommitteeId.examCommitteeId'] = examCommitteeId;
				 mainRoutine['dayId.dayId'] = dayId;								 
										
				 $.ajax({
					
					 url: '${pageContext.request.contextPath}/teacher/add',
					 type:'POST',
					// dataType:'json',
					 data: mainRoutine,
					 success: function(data){
						 
						 console.log(data);
					
						 if(data=="hourlessthan"){
							 window.alert("current hour is less than course hour");
							 
						 }
						 else if(data == "error"){
							 
							  window.alert("ERROR!!!!");
							 
						 }
						 else{
                              
							 var obj = JSON.parse(data);
							 
							 afterCourseAdd(obj);
							 newTeachesList(obj.teachesList);
							 init();
							 
						 }
						
						 
					 },
					error: function(data,status,er){
						
						console.log("cannot update this routine");
					}
				 });
				 
				 
				
			});
			 
			 $('#update').on('submit',function(e){
				 
				  e.preventDefault(); 
				  console.log("submitted");
				  
				  var $this = $(this).serialize(); 
				  var hour = $this.split("=");			 
				 
				 if(hour[1]==null || hour[1]>3){
					 
					 
					  return;					 
				 }		
				 
				 newHour = parseInt(hour[1]);
				 var endTime = startTime + newHour; 					
				 var mainRoutine = { };
				 
				console.log(endTime);
				 
				 mainRoutine['mainRoutineId'] = mainRoutineId;
				 mainRoutine['startTime'] = startTime;
				 mainRoutine['endTime'] = endTime;
				 mainRoutine['teachesId.teachesId'] = teachesId;
				 mainRoutine['roomId.roomId'] = parseInt(roomId);
				 mainRoutine['deptId.deptId'] = deptId;
				 mainRoutine['examCommitteeId.examCommitteeId'] = examCommitteeId;
				 mainRoutine['dayId.dayId'] = dayId;								 
				
				
							 				 
				
			
				 $.ajax({
					
					 url: '${pageContext.request.contextPath}/teacher/update',
					 type:'POST',
					 data: mainRoutine,
					 //dataType: 'json',
					 success: function(data){
						 
						 console.log(data);
						 
						 if(data=="hourlessthan"){
							 window.alert("Course hour is less than new hour");
						 }else if(data=="error"){
							 window.alert("ERROR!!!!");
						 }else{
							 
                                if(currentHour==1){
								 
								 $( "div[class][data-sem=" +currentExamCommitteeId+ "][data-day = " +currentDayId+ "][data-time = " + currentStartTime +"]")
				                    .remove();
								
								 var s =  $( "div[class][data-sem=" +currentExamCommitteeId+ "][data-day = " +currentDayId+ "][data-time = " + (currentStartTime+1) +"]");
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':currentExamCommitteeId,
				                            'data-day':currentDayId,
				                            'data-time':currentStartTime,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
				                      

							 }
							 if(currentHour==2){
								 
								 $( "div[class][data-sem=" +currentExamCommitteeId+ "][data-day = " +currentDayId+ "][data-time = " + currentStartTime +"]")
				                    .remove();
								
								 var s =  $( "div[class][data-sem=" +currentExamCommitteeId+ "][data-day = " +currentDayId+ "][data-time = " + (currentStartTime+2) +"]");
								
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':currentExamCommitteeId,
				                            'data-day':currentDayId,
				                            'data-time':currentStartTime,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':currentExamCommitteeId,
				                            'data-day':currentDayId,
				                            'data-time':currentStartTime+1,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
				                      

							 }
							 if(currentHour==3){
								 
								 $( "div[class][data-sem=" +currentExamCommitteeId+ "][data-day = " +currentDayId+ "][data-time = " + currentStartTime +"]")
				                    .remove();
								
								 var s =  $( "div[class][data-sem=" +currentExamCommitteeId+ "][data-day = " +currentDayId+ "][data-time = " + (currentStartTime+3) +"]");
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':currentExamCommitteeId,
				                            'data-day':currentDayId,
				                            'data-time':currentStartTime,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':currentExamCommitteeId,
				                            'data-day':currentDayId,
				                            'data-time':currentStartTime+1,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':currentExamCommitteeId,
				                            'data-day':currentDayId,
				                            'data-time':currentStartTime+2,
				                            'data-dept':deptId
				                 }).insertBefore(s);
							 
						    }
						 
							 
							 
							 var obj = JSON.parse(data);
							 
							 afterCourseAdd(obj);
							 newTeachesList(obj.teachesList);
							 init();
						 }
						
						 
					 },
					error: function(data,status,er){
						
						$('.modal-title')
						 .text("Sorry your request cannot be processed at this moment")
						   .addClass("text-success");
						window.alert("ok");
					}
				 });
				 
				 
				
			});
			 
			$('button#delete').click(function(){
				
				$('#hasroom').hide();
				$('#noroom').hide();
				$('#confirmDiv').show();
			});
			
			$('button#confirm').click(function(){
				
				$.ajax({
					
					 url: '${pageContext.request.contextPath}/teacher/delete',
					 type:'POST',
					 dataType:'json',
					 data:{
						 mainRoutineId:mainRoutineId,
						 teachesId:teachesId
					 },
					 success: function(data){
						 
						 
						 if(data!="error"){
							 
							 newTeachesList(data);
								 
							 if(currentHour==1){
								 
								 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + startTime +"]")
				                    .remove();
								
								 var s =  $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+1) +"]");
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':examCommitteeId,
				                            'data-day':dayId,
				                            'data-time':startTime,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
				                      

							 }
							 if(currentHour==2){
								 
								 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + startTime +"]")
				                    .remove();
								
								 var s =  $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+2) +"]");
								
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':examCommitteeId,
				                            'data-day':dayId,
				                            'data-time':startTime,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':examCommitteeId,
				                            'data-day':dayId,
				                            'data-time':startTime+1,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
				                      

							 }
							 if(currentHour==3){
								 
								 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + startTime +"]")
				                    .remove();
								
								 var s =  $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+3) +"]");
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':examCommitteeId,
				                            'data-day':dayId,
				                            'data-time':startTime,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':examCommitteeId,
				                            'data-day':dayId,
				                            'data-time':startTime+1,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
								 jQuery('<div/>', {
		                                
				                        class:'col-xs-1 clickable courseDrop hour',
				                            'data-sem':examCommitteeId,
				                            'data-day':dayId,
				                            'data-time':startTime+2,
				                            'data-dept':deptId
				                 }).insertBefore(s);
								 
				                      

							 }
							 
							 $('#myModal').modal('hide'); 
						    init();
							 
						 }
						
						 
					 },
					error: function(data,status,er){
						
						console.log("cannot delete at this moment");
					}
				 });
				
			});
			
			$('button#cancel').click(function(){
				
				$('#confirmDiv').hide();
				if(flag_for_room_info == 1){
					$('#hasroom').show();
				}else{
					$('#noroom').show();
				}
				
				
			});
			
			var icons = {
				      header: "ui-icon-circle-arrow-e",
				      activeHeader: "ui-icon-circle-arrow-s"
				    };
			  
			$('#semester1').find('.accordion').accordion({
			      collapsible: true,
			      icons: icons
			    });
			
			$('#semester2').find('.accordion').accordion({
			      collapsible: true,
			      icons: icons
			    });
			$('#semester3').find('.accordion').accordion({
			      collapsible: true,
			      icons: icons
			    });
			$('#semester4').find('.accordion').accordion({
			      collapsible: true,
			      icons: icons
			    });
			 
			function afterCourseAdd(data){
								 
				if(newHour==1){
					 
					 var s =  $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+1) +"]");
					
					 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + startTime +"]")
	                    .remove();
					
					var hourToAsign = data.endTime - data.startTime;
					 
					 jQuery('<div/>', {
                           
	                        class:'col-xs-1 hour drag clickable',
	                            'data-sem':examCommitteeId,
	                            'data-day':dayId,
	                            'data-time':startTime,
	                            'data-dept':deptId,
	                            'data-teaches':data.teachesId,
	                            'data-id':data.mainRoutineId,
	                            'data-hour': hourToAsign
	                            
	                 }).insertBefore(s).html("<ul><li style='font-size:60%;'>" + data.courseCode + "</li>"
	                		 + "<li style='font-size:60%;'>" + data.roomNum + "--" + data.buildingName + "</li>" 
	                		 + "<li style='font-size:60%;'>" + data.employeeCode + "</li>"
	                		 + "</ul>");
					
					    

				 }
				
				
				 if(newHour==2){
					 
					 var s =  $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+2) +"]");
					 
					 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + startTime +"]")
	                    .remove();
					 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+1) +"]")
	                    .remove();	
					 
					 jQuery('<div/>', {
                         
	                        class:'col-xs-2 hour drag clickable',
	                            'data-sem':examCommitteeId,
	                            'data-day':dayId,
	                            'data-time':startTime,
	                            'data-dept':deptId,
	                            'data-teaches':data.teachesId,
	                            'data-id':data.mainRoutineId,
	                            'data-hour': (data.endTime-data.startTime)
	                            
	                 }).insertBefore(s).html("<ul><li>" + data.courseCode + "</li>"
	                		 + "<li>" + data.roomNum + "--" + data.buildingName + "</li>" 
	                		 + "<li>" + data.employeeCode + "</li>"
	                		 + "</ul>");
					 
					  

				 }
				 if(newHour==3){
					 
					 var s =  $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+3) +"]");
					 
					 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + startTime +"]")
	                    .remove();
					 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+1) +"]")
	                    .remove();
					 $( "div[class][data-sem=" +examCommitteeId+ "][data-day = " +dayId+ "][data-time = " + (startTime+2) +"]")
	                    .remove();
					
					
					 
					 jQuery('<div/>', {
                         
	                        class:'col-xs-3 hour drag clickable',
	                            'data-sem':examCommitteeId,
	                            'data-day':dayId,
	                            'data-time':startTime,
	                            'data-dept':deptId,
	                            'data-teaches':data.teachesId,
	                            'data-id':data.mainRoutineId,
	                            'data-hour': (data.endTime-data.startTime)
	                            
	                 }).insertBefore(s).html("<ul><li>" + data.courseCode + "</li>"
	                		 + "<li>" + data.roomNum + "--" + data.buildingName + "</li>" 
	                		 + "<li>" + data.employeeCode + "</li>"
	                		 + "</ul>");
				
			     }
				 
				 $('#myModal').modal('hide'); 
				 init();
				 click();

			}
			
			function newTeachesList(data){
				
				 var id="";

				 if(examCommitteeId == com1){
					 					
					 id = $('#semester1').find('.availableCourse');
					 id.empty();
				 }
				 if(examCommitteeId == com2){
					 
					 id = $('#semester2').find('.availableCourse');
					 id.empty();
				 }
				 if(examCommitteeId == com3){
					 
					 id = $('#semester3').find('.availableCourse');
					 id.empty();
				 }
				 if(examCommitteeId == com4){
					 
					 id = $('#semester4').find('.availableCourse');
					 id.empty();
				 }
				 
				 if(data==null){
					 id.append("<div style='background-color:#FFFFFF;'><p>You have no courses available to add<p></div>");
					 return;
				 }
				
				 
				 for(var i=0;i<data.length;i++){
					 var test = $("<div style='background-color: #FFFFFF'  class='drag' data-new='newCourse' data-teaches="
					          + data[i].teachesId +"><p style='font-weight:bold;font-family:sans-serif;'>Course Code: " 
					          + data[i].courseCode + "</p><p style='font-family:sans-serif;'>Available Hours: "
					          + data[i].hour + "</p></div>");
					     
					   id.append(test);				   
				    
				 }
			}

                         
	     });
	</script>
</body>
</html>