/**
 * 
 */
var userRole;
	$(document).ready(function(){
		
		if (validUser()) {
			userRole = getRole();
			alert(userRole);
			$.post("/findCategory", function(data) {
					$.each(data.response, function(index, apllicationCategory) {
						$("#categorystatus").append("<option value="+apllicationCategory.categoryId+">"+apllicationCategory.categoryName);
					});	
			
			});
			
			$.post("/findIncidentStatus", function(data) {
				$.each(data.response, function(index, incidentStatus) {
					$("#ticketstatus").append("<option value="+incidentStatus.statusId+">"+incidentStatus.statusName);
				});	
		
		});
		}
		if(userRole=='creator'){
			$("#administrationlink").hide();
		}
	
});
	
	function getRole() {
		var role = "";
		$.ajax({
			url : "/getUserRole",
			async : false,
			success : function(data) {
				role = data.response;
			}
		});
		return role;
	}
	
	function validUser() {
		var result = false;
		$.ajax({
			url : "/validateSession",
			async : false,
			success : function(data) {
				if (data == "true") {
					result = true;
				} else {
					result = false;
				}
			}
		});
		return result;
	}

	
