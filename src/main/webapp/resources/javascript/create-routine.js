$(document).ready(function(){
	
	function init() {

		var drag = $('.drag');
		var assignTeacher = $('#assign-teacher tbody');
	

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

			var $this = $(this).children('td').eq(0);
			return '<h2 style="font-weight:bold;font-family:sans-serif;">'+ $this.text() + '</h2>';
		}
		
		var drop = $('.drop');
		
		drop.droppable({

			accept : ".drag",
			drop : handleDropEvent,
			hoverClass: 'ui-state-highlight'

		});
		
		var idQueue = [];
		var codeQueue = [];
		
		function handleDropEvent(event, ui) {

			ui.draggable.draggable("option", "revert",false);
			
			var dragged = ui.draggable;
			var id = dragged.children('td').data('id');
			var code = dragged.children('td').eq(0).text();
				
			idQueue.push(id); 
			codeQueue.push(code);
			
			
			if(idQueue.length==2 && codeQueue.length == 2){
				
				var code1 = codeQueue.shift();
				var code2 = codeQueue.shift();
				var id1 = idQueue.shift();
				var id2 = idQueue.shift();
				
				var tr = '<tr><td data-id1="'+ id1 + '">'+ code1 +'</td><td data-id2="'+ id2 +'">'+ code2+'</td><td><button class="btn btn-danger">Delete</button>'+'</td></tr>';
				assignTeacher.append(tr);
				
			}

		}
		
		$('#createRoutine').on('click',function(){
			
			var teachesList = new Array();
			$('#assign-teacher tbody tr').each(function() {
				
				var  Teaches= {};
				
			    var courseId = $(this).children('td').eq(0).data('id1');  
			    var teacherId = $(this).children('td').eq(1).data('id2');
			    
			    Teaches['courseId'] = courseId;
			    Teaches['instructorId'] = teacherId;
			   	  
			    teachesList.push(Teaches);
			});
			
			teachesList = JSON.stringify({

	            'teachesList' : teachesList 

	        });  
			
			console.log(teachesList);
			
			$.ajax({
				
		        type: 'post',
		        url: pageUrl + '/admin/createTeaches',
		        data: teachesList,
		        contentType: 'application/json; charset=utf-8',
		        success: function(data) {
		            console.log(data);
		            window.location = pageUrl +'/admin/adminview/';
		        },
		        error: function(e) {
		            alert(e.message);
		        }
			});
			
		});
			
	}

	init();
});