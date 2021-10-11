
	
		var dayId, startTime, deptId, examCommitteeId, teachesId, time, mainRoutineId, roomId, currentHour, newHour, currentDayId, currentStartTime, currentExamCommitteeId, count = 0;

		var room_time = $('.room-time');
		var flag_for_room_info = 0;

		//checking available rooms for all the semesters.

		var com1 = $('#semester1').data('sem'), 
			com2 = $('#semester2').data('sem'), 
			com3 = $('#semester3').data('sem'), 
			com4 = $('#semester4').data('sem');

		function getRooms() {

			count = 0;

			$.ajax({
				url : pageUrl + '/teacher/availablerooms',
				type : 'GET',
						//dataType: 'json', 
				data : {
					com1 : com1,
					com2 : com2,
					com3 : com3,
					com4 : com4,
					day  : dayId,
					time : time,
					dept : deptId,
					currentSemester : examCommitteeId,
					mainRoutineId : mainRoutineId,
					teachesId : teachesId
				},
				success : function(data) {

					if (data == "error") {
						$('#hasroom').hide();
						$('#noroom').hide();
						$('#error').show();
					}

					if (data == "noroom") {

						$('#hasroom').hide();
						$('#noroom').show();
						$('#error').hide();
						flag_for_room_info = 0;

					}else {

						var obj = JSON.parse(data);

						$('#roomHourMessage').removeClass('text-danger').css("font-size","100%");

						$('#noroom').hide();
						$('#hasroom').show();
						$('#error').hide();
						$('.modal-title').children('h4').eq(1).text("");

						flag_for_room_info = 1;

						if (time < 12) {
							time = time + ' am';
						} else {
							time = time + ' pm';
						}

						var dayName = "";

						if (dayId == 1) {
							dayName = "Sun";
						} else if (dayId == 2) {
							dayName = "Mon";
						} else if (dayId == 3) {
							dayName = "Tue";
						} else if (dayId == 4) {
							dayName = "Wed";
						} else if (dayId == 5) {
							dayName = "Thus";
						} else if (dayId == 6) {
							dayName = "Fri";
						} else if (dayId == 7) {
							dayName = "Sat";
						}

						$('#hasroom').children('p').eq(0)
							.empty().text('Room availabe from '
								+ dayName+ " "+ time);

						var items = "";
						for (var i = 0; i < obj.length; i++) {

							items += "<tr><td>"
							+ obj[i].roomNum
							+ "</td>"
							+ "<td>"
							+ obj[i].buildingName
							+ "</td>"
							+ "<td>"
							+ obj[i].roomType
							+ "</td>"
							+ "<td>"
							+ obj[i].hour
							+ "</td>"
							+ "<td><input type='radio' name='otpion' value=" 
							+obj[i].roomId
							+ "></td></tr>";
						 }
						 $('#room-info tbody').empty().append(items);

						 $("tbody input").on("click",function() {

							items = "";
							roomId = $('input:checked').val();

							for (var i = 0; i < obj.length; i++) {

								if (roomId == obj[i].roomId) {

									for (var j = 1; j <= obj[i].hour; j++) {

										items += "<label class='radio-inline'><input type='radio' name='hour' value="+j+">"
										+ j
										+ "</label>";
									}

							room_time.empty().append(items);
	
									}
								}

						   });

						}
					},
					error : function(data, status, er) {

						$('#noroom').hide();
						$('#hasroom').hide();
						$('#error').show();

					 }
				});
			}

			function init() {

				var drag = $('.drag');
				var string, courseCode, room, teacher, ul;
				//dragging an element.

				drag.draggable({

					containment : "document",
					cursor : "move",
					distance : 20,
					helper : myHelper,
					zIndex : 100,
					start : function(event, ui) {
						
						$(this).draggable("option", "revert",true);
					}

				});
				function myHelper(event) {

					room_time.empty();

					if ($(this).data('new') == "newCourse") {

						var $this = $(this).children('p').eq(0).text();
							string = $this.split(":");
							return '<h2 style="font-weight:bold;font-family:sans-serif;">'+ string[1] + '</h2>';

					}
					var $this = $(this).find('ul').children('li').eq(0);
							return '<h2 style="font-weight:bold;font-family:sans-serif;">'+ $this.text() + '</h2>';
				}

				var drop = $('.courseDrop');

				drop.droppable({

					accept : ".drag",
					//hoverClass: ".test",
					drop : handleDropEvent

				});

				function handleDropEvent(event, ui) {

					$('#confirmDiv').hide();
					ui.draggable.draggable("option", "revert",false);

						//getting the dropped location.  

					dayId = $(this).data('day'), 
					time = $(this).data('time'), 
					deptId = $(this).data('dept'),
					examCommitteeId = $(this).data('sem');
					startTime = time;

					var dragged = ui.draggable;

					if (dragged.data('new') == "newCourse") {

						ul = '<ul style="background-color:#888888;text-align:center;font-size:130%;"><li>'+ string[1] + '</li>';
							
						$('#currentCourse').empty().append(ul);
							
						$('.modal-title').children('h4').eq(0).text("ADD A COURSE");
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
					    + courseCode
					    + '</li><li>'
					    + room
						+ '</li><li>' 
						+ teacher 
						+ '</ul>';

					$('#currentCourse').empty().append(ul);
					$('.modal-title').children('h4').eq(0).text("UPDATE A COURSE");
					$('#delete').hide();
					$('#update').show();
					$('#add').hide();
					getRooms();
					$('#myModal').modal('show');

				}

			}

			init();

			function click() {

				var clickable = $('.clickable');
				var title = $('.modal-title').children('h4').eq(0);
				var myModal = $('#myModal');

				clickable.dblclick(function() {

					$('#confirmDiv').hide();
					$('#add').hide();
					$('#update').show();

					var $this = $(this);
					room_time.empty();

					if ($this.find('ul').length > 0) {

						var courseCode = $this.find('ul').children('li').eq(0).text();
						var room = $this.find('ul').children('li').eq(1).text();
						var teacher = $this.find('ul').children('li').eq(2).text();

						var ul = '<ul style="background-color:#888888;text-align:center;"><li>'
								+ courseCode
								+ '</li><li>'
								+ room
								+ '</li><li>'
								+ teacher
								+ '</ul>'

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

			$('#add').on('submit',function(e) {

				e.preventDefault();
				console.log("add button clicked");
				if (count > 2)
					return;

				var $this = $(this).serialize();
				var hour = $this.split("=");

				if (hour[1] == null|| hour[1] > 3) {

					$('#roomHourMessage').addClass('text-danger').css("font-size","130%");
					return;
				}

				newHour = parseInt(hour[1]);
				var endTime = startTime + newHour;
				
				var mainRoutineBean = {};
				
				mainRoutineBean['startTime'] = startTime;
				mainRoutineBean['endTime'] = endTime;
				mainRoutineBean['teachesId'] = teachesId;
				mainRoutineBean['roomId'] = parseInt(roomId);
				mainRoutineBean['deptId'] = deptId;
				mainRoutineBean['examCommitteeId'] = examCommitteeId;
				mainRoutineBean['dayId'] = dayId;

				console.log(JSON.stringify(mainRoutineBean));

				$.ajax({

					url : pageUrl + '/teacher/add',
					type : 'POST',
					// dataType:'json',
					data : JSON.stringify(mainRoutineBean),
					contentType: 'application/json; charset=utf-8',
					mimeType: 'application/json',
					success : function(data) {

						console.log(data);

						if (data == "hourlessthan") {

							$('.modal-title').children('h4').eq(1).text("Given Hour is greater than available course hour");
							count++;

						} else if (data == "error") {

							$('#noroom').hide();
							$('#hasroom').hide();
							$('#error').show();

						} else {

							var obj = JSON.parse(data);

							afterCourseAdd(obj);
							newTeachesList(obj.teachesList);
							init();

						}

					},
					error : function(data,status, er) {

						$('#noroom').hide();
						$('#hasroom').hide();
						$('#error').show();
					}
				});
			});

			$('#update').on('submit',function(e) {

				e.preventDefault();

				if (count > 2)
					return;
					console.log("submitted");

				var $this = $(this).serialize();
				var hour = $this.split("=");

				if (hour[1] == null|| hour[1] > 3) {

					$('#roomHourMessage').addClass('text-danger').css("font-size","130%");
					return;
				}

				newHour = parseInt(hour[1]);
				var endTime = startTime + newHour;
				var mainRoutine = {};

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

					url : pageUrl + '/teacher/update',
					type : 'PUT',
					data : mainRoutine,
					//dataType: 'json',
					success : function(data) {

						console.log(data);

						if (data == "hourlessthan") {

							$('.modal-title').children('h4').eq(1).text("Given Hour is greater than available course hour");
								count++;

						} else if (data == "error") {

							$('#noroom').hide();
							$('#hasroom').hide();
							$('#error').show();

						} else {

						if (currentHour == 1) {

							$("div[class][data-sem=" + currentExamCommitteeId
																						
							+ "][data-day = " + currentDayId
							+ "][data-time = " + currentStartTime
							+ "]").remove();

							var s = $("div[class][data-sem="
																				+ currentExamCommitteeId
																				+ "][data-day = "
																				+ currentDayId
																				+ "][data-time = "
																				+ (currentStartTime + 1)
																				+ "]");

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : currentExamCommitteeId,
																					'data-day' : currentDayId,
																					'data-time' : currentStartTime,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																	}
																	if (currentHour == 2) {

																		$(
																				"div[class][data-sem="
																						+ currentExamCommitteeId
																						+ "][data-day = "
																						+ currentDayId
																						+ "][data-time = "
																						+ currentStartTime
																						+ "]")
																				.remove();

																		var s = $("div[class][data-sem="
																				+ currentExamCommitteeId
																				+ "][data-day = "
																				+ currentDayId
																				+ "][data-time = "
																				+ (currentStartTime + 2)
																				+ "]");

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : currentExamCommitteeId,
																					'data-day' : currentDayId,
																					'data-time' : currentStartTime,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : currentExamCommitteeId,
																					'data-day' : currentDayId,
																					'data-time' : currentStartTime + 1,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																	}
																	if (currentHour == 3) {

																		$(
																				"div[class][data-sem="
																						+ currentExamCommitteeId
																						+ "][data-day = "
																						+ currentDayId
																						+ "][data-time = "
																						+ currentStartTime
																						+ "]")
																				.remove();

																		var s = $("div[class][data-sem="
																				+ currentExamCommitteeId
																				+ "][data-day = "
																				+ currentDayId
																				+ "][data-time = "
																				+ (currentStartTime + 3)
																				+ "]");

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : currentExamCommitteeId,
																					'data-day' : currentDayId,
																					'data-time' : currentStartTime,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : currentExamCommitteeId,
																					'data-day' : currentDayId,
																					'data-time' : currentStartTime + 1,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : currentExamCommitteeId,
																					'data-day' : currentDayId,
																					'data-time' : currentStartTime + 2,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																	}

																	var obj = JSON
																			.parse(data);

																	afterCourseAdd(obj);
																	newTeachesList(obj.teachesList);

																	init();
																}

															},
															error : function(
																	data,
																	status, er) {

																$('noroom')
																		.hide();
																$('hasroom')
																		.hide();
																$('error')
																		.show();
															}
														});

											});

							$('button#delete').click(function() {

								$('#hasroom').hide();
								$('#noroom').hide();
								$('#error').hide();
								$('#confirmDiv').show();
							});

			$('button#confirm').click(function() {

				$.ajax({

					url : pageUrl + '/teacher/delete',
					type : 'POST',
					dataType : 'json',
					data : {
					mainRoutineId : mainRoutineId,
					teachesId : teachesId
				},
				success : function(data) {

					if (data != "error") {

						newTeachesList(data);

						if (currentHour == 1) {

								$("div[class][data-sem="
								+ examCommitteeId
								+ "][data-day = "
								+ dayId
																						+ "][data-time = "
																						+ startTime
																						+ "]")
																				.remove();

																		var s = $("div[class][data-sem="
																				+ examCommitteeId
																				+ "][data-day = "
																				+ dayId
																				+ "][data-time = "
																				+ (startTime + 1)
																				+ "]");

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : examCommitteeId,
																					'data-day' : dayId,
																					'data-time' : startTime,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																	}
																	if (currentHour == 2) {

																		$(
																				"div[class][data-sem="
																						+ examCommitteeId
																						+ "][data-day = "
																						+ dayId
																						+ "][data-time = "
																						+ startTime
																						+ "]")
																				.remove();

																		var s = $("div[class][data-sem="
																				+ examCommitteeId
																				+ "][data-day = "
																				+ dayId
																				+ "][data-time = "
																				+ (startTime + 2)
																				+ "]");

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : examCommitteeId,
																					'data-day' : dayId,
																					'data-time' : startTime,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : examCommitteeId,
																					'data-day' : dayId,
																					'data-time' : startTime + 1,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																	}
																	if (currentHour == 3) {

																		$(
																				"div[class][data-sem="
																						+ examCommitteeId
																						+ "][data-day = "
																						+ dayId
																						+ "][data-time = "
																						+ startTime
																						+ "]")
																				.remove();

																		var s = $("div[class][data-sem="
																				+ examCommitteeId
																				+ "][data-day = "
																				+ dayId
																				+ "][data-time = "
																				+ (startTime + 3)
																				+ "]");

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : examCommitteeId,
																					'data-day' : dayId,
																					'data-time' : startTime,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : examCommitteeId,
																					'data-day' : dayId,
																					'data-time' : startTime + 1,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																		jQuery(
																				'<div/>',
																				{

																					class : 'col-xs-1 clickable courseDrop hour',
																					'data-sem' : examCommitteeId,
																					'data-day' : dayId,
																					'data-time' : startTime + 2,
																					'data-dept' : deptId
																				})
																				.insertBefore(
																						s);

																	}

																	$(
																			'#myModal')
																			.modal(
																					'hide');
																	$(
																			'#successMessage')
																			.text(
																					"Course Successfully Deleted");
																	$(
																			'#alertModal')
																			.modal(
																					'show');
																	init();

																} else if (data == "error") {

																	$('#noroom')
																			.hide();
																	$(
																			'#hasroom')
																			.hide();
																	$('#error')
																			.show();
																}

															},
															error : function(
																	data,
																	status, er) {

																$('#noroom')
																		.hide();
																$('#hasroom')
																		.hide();
																$('#error')
																		.show();
															}
														});

											});

							$('button#cancel').click(function() {

								$('#confirmDiv').hide();
								if (flag_for_room_info == 1) {
									$('#hasroom').show();
								} else {
									$('#noroom').show();
								}

							});

							var icons = {
								header : "ui-icon-circle-arrow-e",
								activeHeader : "ui-icon-circle-arrow-s"
							};

							$('#semester1').find('.accordion').accordion({
								collapsible : true,
								icons : icons
							});

							$('#semester2').find('.accordion').accordion({
								collapsible : true,
								icons : icons
							});
							$('#semester3').find('.accordion').accordion({
								collapsible : true,
								icons : icons
							});
							$('#semester4').find('.accordion').accordion({
								collapsible : true,
								icons : icons
							});

			function afterCourseAdd(data) {

				if (newHour == 1) {

					var s = $("div[class][data-sem="
						+ examCommitteeId + "][data-day = "
						+ dayId + "][data-time = "
						+ (startTime + 1) + "]");

					$("div[class][data-sem="
						+ examCommitteeId
						+ "][data-day = " + dayId
						+ "][data-time = "
						+ startTime + "]").remove();

					var hourToAsign = data.endTime - data.startTime;

					jQuery('<div/>', {

						class : 'col-xs-1 col1 drag clickable',
						'data-sem' : examCommitteeId,
						'data-day' : dayId,
						'data-time' : startTime,
						'data-dept' : deptId,
						'data-teaches' : data.teachesId,
						'data-id' : data.mainRoutineId,
						'data-hour' : hourToAsign

					}).insertBefore(s).html("<ul><li>" 
						+ data.courseCode + "</li>"
						+ "<li>" + data.roomNum + "--" + data.buildingName + "</li>"
						+ "<li>" + data.employeeCode + "</li>"
						+ "</ul>");

				}

				if (newHour == 2) {

					var s = $("div[class][data-sem="
						+ examCommitteeId + "][data-day = "
						+ dayId + "][data-time = "
						+ (startTime + 2) + "]");

					$("div[class][data-sem="
						+ examCommitteeId
						+ "][data-day = " + dayId
						+ "][data-time = "
						+ startTime + "]").remove();
					
					$("div[class][data-sem="
						+ examCommitteeId
						+ "][data-day = " + dayId
						+ "][data-time = "
						+ (startTime + 1) + "]").remove();

					jQuery('<div/>', {

						class : 'col-xs-2 col2 drag clickable',
						'data-sem' : examCommitteeId,
						'data-day' : dayId,
						'data-time' : startTime,
						'data-dept' : deptId,
						'data-teaches' : data.teachesId,
						'data-id' : data.mainRoutineId,
						'data-hour' : (data.endTime - data.startTime)

					}).insertBefore(s).html("<ul><li>" + data.courseCode + "</li>" 
						+ "<li>" + data.roomNum + "--"
						+ data.buildingName + "</li>" + "<li>"
						+ data.employeeCode
						+ "</li>" + "</ul>");

				}
				if (newHour == 3) {

					var s = $("div[class][data-sem="
						+ examCommitteeId + "][data-day = "
						+ dayId + "][data-time = "
						+ (startTime + 3) + "]");

					$("div[class][data-sem="
						+ examCommitteeId
						+ "][data-day = " + dayId
						+ "][data-time = "
						+ startTime + "]").remove();
					
					$("div[class][data-sem="
						+ examCommitteeId
						+ "][data-day = " + dayId
						+ "][data-time = "
						+ (startTime + 1) + "]").remove();
					
					$("div[class][data-sem="
						+ examCommitteeId
						+ "][data-day = " + dayId
						+ "][data-time = "
						+ (startTime + 2) + "]").remove();

					jQuery('<div/>', {

						class : 'col-xs-3 col3 drag clickable',
						'data-sem' : examCommitteeId,
						'data-day' : dayId,
						'data-time' : startTime,
						'data-dept' : deptId,
						'data-teaches' : data.teachesId,
						'data-id' : data.mainRoutineId,
						'data-hour' : (data.endTime - data.startTime)

					}).insertBefore(s).html("<ul><li>" + data.courseCode
							+ "</li>" + "<li>" + data.roomNum + "--"
							+ data.buildingName + "</li>"
							+ "<li>" + data.employeeCode
							+ "</li>" + "</ul>");

				}

				$('#myModal').modal('hide');
				$('#successMessage').text("Course Successfully Updated");
				$('#alertModal').modal('show');
				
				init();
				click();

			}

							function newTeachesList(data) {

								var id = "";

								if (examCommitteeId == com1) {

									id = $('#semester1').find(
											'.availableCourse');
									id.empty();
								}
								if (examCommitteeId == com2) {

									id = $('#semester2').find(
											'.availableCourse');
									id.empty();
								}
								if (examCommitteeId == com3) {

									id = $('#semester3').find(
											'.availableCourse');
									id.empty();
								}
								if (examCommitteeId == com4) {

									id = $('#semester4').find(
											'.availableCourse');
									id.empty();
								}

								if (data == null) {
									id
											.append("<div style='background-color:#FFFFFF;'><p>You have no courses available to add<p></div>");
									return;
								}

								for (var i = 0; i < data.length; i++) {
									var test = $("<div style='background-color: #FFFFFF'  class='drag' data-new='newCourse' data-teaches="
			          + data[i].teachesId +"><p style='font-weight:bold;font-family:sans-serif;'>Course Code: "
											+ data[i].courseCode
											+ "</p><p style='font-family:sans-serif;'>Available Hours: "
											+ data[i].hour + "</p></div>");

									id.append(test);

								}
							}

				