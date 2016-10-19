/**
 * 
 */
$(document).ready(function()
		{
	alert("load");

	$("#saveBtn").click(function(){
	
	var solutionID = $("#solutionID").val();
	var descriptionID = $("#descriptionID").val();
	var keywordID = $("#keywordID").val();
	var technologyID = $("#technologyID").val();
	var linkedIncidentID = $("#linkedIncidentID").val();
	var categoryID = $("#categoryID").val();
	
		if( solutionID =='' || descriptionID =='' || keywordID =='' || technologyID =='' || linkedIncidentID =='' || categoryID ==''){
			$('input[type="text"],input[type="password"],input[type="select"] ').css("border","2px solid red");
			$('input[type="text"],input[type="password"],input[type="select"] ').css("box-shadow","0 0 3px red");
			alert("Please fill all fields...!!!!!!");
		}else {
			alert("testt");
			//$("#loginForm").submit();
			$.post("/savesolution",{ solutionID: solutionID, descriptionID:descriptionID,keywordID:keywordID,technologyID:technologyID,linkedIncidentID:linkedIncidentID,categoryID:categoryID},
			function(data) {
				if(data.status == "STATUS_FAILURE") {
					$('input[type="text"],input[type="password"],input[type="select"] ').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
					$("#alertPanel").show();
					$("#alertMessage").text(data.statusDesc);
				} else {
					//$( location ).attr("href", "/main.html");
					handleNextView();
				}
			});
		}
	});
});
