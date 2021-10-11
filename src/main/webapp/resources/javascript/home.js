var dept = $('#dept');
var semester = $('#semester');
$('#directSearch').on('submit', function(e) {
	if (!validation()) {
		e.preventDefault();
	}
});
function validation() {
	var semester = document.directSearch.semester;
	if (semester.value == "") {
		return false;
	}
	if (isNaN(semester.value)) {
		return false;
	}
	return (true);
}
dept.on('change', function() {
	var deptCode = this.value;
	$.ajax({
		url : '${pageContext.request.contextPath}/normal/getExamCommittees',
		type : 'POST',
		//dataType:'json',
		data : {
			deptCode : deptCode
		},
		success : function(data) {
			if (data == "no") {
				semester.empty().append("<option value=''>----</option>");
			} else {
                var items = "";
				var semesters = JSON.parse(data);
				for (var i = 0; i < semesters.length; i++) {
					items += "<option value=" + semesters[i].id + ">"
						  + semesters[i].name + "</option>";
				}
				semester.empty().append(items);
			}

		},
		error : function(data, status, er) {
			alert("Your request cannot be processed at this moment");
		}
	});
});