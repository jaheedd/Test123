var userRole;
$(document).ready(function() {
	userRole = getRole();
	appendHeader();
	appendFooter();
	document.title="AutoFits - Integrated Production Reporting System";
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
function appendHeader() {
	var homeMenu = '<nav class="navbar navbar-default navbar-fixed-top">'+
	  '<div class="container" style="max-width: 900px">'+
	    '<div class="navbar-header">'+
	      '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse-1">'+
	        '<span class="icon-bar"></span>'+
	        '<span class="icon-bar"></span>'+
	        '<span class="icon-bar"></span>'+
	      '</button>'+
	      '<a class="navbar-brand" href="/main.html">'+
	        '<span><img style="max-width:110px; margin-top: -15px;" src="/images/company_logo.png"></span>'+
	      '</a>	'+
	      '<a class="navbar-brand" href="/main.html"><span class="glyphicon glyphicon-home"></span>Home</a>'+
	    '</div>' +
	    '<div class="navbar-header collapse navbar-collapse" id="collapse-1">';
	      
	  
	var orderManagementHomeMenu = '<nav class="navbar navbar-default navbar-fixed-top">'+
	  '<div class="container" style="max-width: 900px">'+
	    '<div class="navbar-header">'+
	      '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse-1">'+
	        '<span class="icon-bar"></span>'+
	        '<span class="icon-bar"></span>'+
	        '<span class="icon-bar"></span>'+
	      '</button>'+
	      '<a class="navbar-brand" href="/main.html">'+
	        '<span><img style="max-width:110px; margin-top: -15px;" src="/images/company_logo.png"></span>'+
	      '</a>	'+
	      '<a class="navbar-brand" href="/ordermanagement/orderInfo.html"><span class="glyphicon glyphicon-home"></span>Home</a>'+
	    '</div>' +
	    '<div class="navbar-header collapse navbar-collapse" id="collapse-1">';
	
	
	      var operatorMenu =
	    	  '<ul class="nav navbar-nav">'+
		        '<li class="dropdown">'+
		         ' <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> '+
		          '		<span class="glyphicon glyphicon-tasks"></span> Operator <span class="caret"></span>'+
		          '</a>'+
		          '<ul class="dropdown-menu" role="menu">'+
		          '	<li><a href="#" id="orderDataEntry"><span class="glyphicon glyphicon-pencil"></span> Order Data Entry</a></li>'+
		          '	<li><a href="#" id="orderView"><span class="glyphicon glyphicon-eye-open"></span> View Running Orders</a></li> '+
		          '	<li class="divider"></li> '+
		          '  <li><a href="#" id="prodDataEntry"><span class="glyphicon glyphicon-pencil"></span> Machine Data Entry</a></li>'+
		          '	<li class="divider"></li>'+
		          '  <li><a href="#" id="productDataEntry"><span class="glyphicon glyphicon-pencil"></span> Product Data Entry</a></li>'+
		          '  <li class="divider"></li> '+
		          '  <li><a href="#" id="stopDataEntry"><span class="glyphicon glyphicon-pencil"></span> Stoppage Data Entry</a></li> '+
		          '</ul> '+
		        '</li>  '+
		        '</ul>' ;
	      
	      var reportsMenu_old =
	    	  '<ul class="nav navbar-nav">'+
		        '<li class="dropdown"> '+
		        '  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> '+
		         ' 		<span class="glyphicon glyphicon-stats"></span> Reports <span class="caret"></span>  '+
		         ' </a>  '+
		         ' <ul class="dropdown-menu" role="menu"> '+
					'			<li><a href="/reports/managerdashboards.html" id="summary"><span  '+ 
					'				class="glyphicon glyphicon-list-alt"></span>Summary</a></li>  '+
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/mainreports.html" id="mainReports"><span  '+ 
				'				class="glyphicon glyphicon-list-alt"></span>Reports</a></li>  '+
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/maindashboards.html" id="mainDashboards"><span  '+
				'				class="glyphicon glyphicon-dashboard"></span>Main-DashBoard</a></li> '+
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/machinedashboards.html" id="machinePerformanceDashboards"><span  '+ 
				'			class="glyphicon glyphicon-dashboard"></span>Machine-DashBoard</a></li>	 '+
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/orderdashboards.html" id="orderPerformanceDashboards"><span  '+
				'				class="glyphicon glyphicon-list-alt"></span>Order</a></li> '+
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/downtimedashboards.html" id="downTimeDashboards"><span  '+ 
				'				class="glyphicon glyphicon-dashboard"></span>Downtime</a></li>	 '+						
		        '  </ul>  '+
		          
		       ' </li>'+  
	      	' </ul>';
	      
	      var reportsMenu=
	    	  '<ul class="nav navbar-nav">'+
		        '<li class="dropdown"> '+
		        '  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> '+
		         ' 		<span class="glyphicon glyphicon-stats"></span> Reports <span class="caret"></span>  '+
		         ' </a>  '+
		         ' <ul class="dropdown-menu" role="menu"> '+
					'			<li><a href="/reports/productiondashboards.html" id="production"><span  '+ 
					'				class="glyphicon glyphicon-list-alt"></span> Production Dashboard</a></li>  '+
				'	<li class="divider"></li> '+
//				'			<li><a href="/reports/OEEdashboards.html" id="oee"><span  '+ 
//				'				class="glyphicon glyphicon-list-alt"></span>OEE Dashboard</a></li>  '+
				
				'			<li><a href="/reports/productivitydashboards.html" id="productivity"><span  '+ 
				'				class="glyphicon glyphicon-list-alt"></span> Productivity Dashboard</a></li>  '+
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/downtimesnapshot.html" id="downtimeSnapshot"><span  '+
				'				class="glyphicon glyphicon-dashboard"></span> Downtime Snapshot</a></li> '+				
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/downtimedashboards.html" id="downtimeDashboards"><span  '+
				'				class="glyphicon glyphicon-dashboard"></span> Downtime Dashboard</a></li> '+
				'	<li class="divider"></li> '+
				'			<li><a href="/reports/downloadreports.html" id="download"><span  '+ 
				'			class="glyphicon glyphicon-dashboard"></span> Download Reports</a></li>	 '+
				'<li class="divider"></li> '+
				'			<li><a href="/reports/downloadreports.html" id="downloadDaily"><span  '+ 
				'			class="glyphicon glyphicon-dashboard"></span> Download Daily Reports</a></li>	 '+
		        '  </ul>  '+
		          
		       ' </li>'+  
	      	' </ul>';	      
	      
	      
	      var adminMenu= 
			'<ul class="nav navbar-nav"> '+ 
			'<li class="dropdown">'+ 
			'	<a href="#" class="dropdown-toggle"'+ 
			'   data-toggle="dropdown" role="button" aria-expanded="false"> <span '+ 
			'	class="glyphicon glyphicon-user"></span> Admin <span '+ 
			'		class="caret"></span> '+ 
			'	</a> '+ 
			'	<ul class="dropdown-menu" role="menu"> '+ 
			'		<li><a href="/admin/usermanagement.html" id="userManagementMenuItem"><span '+ 
			'				class="glyphicon glyphicon-edit"></span>User Management</a></li> '+ 
			
			/**
			'		<li class="divider"></li> '+ 
			'		<li><a href="/admin/shiftmanagement.html" id="shiftDataMenuItem"><span '+ 
			'			class="glyphicon glyphicon-pencil"></span>Shift Management</a></li> '+ 

			'		<li><a href="/admin/holidaymanagement.html" id="addAndViewholidaysMenuItem"><span '+ 
			'				class="glyphicon glyphicon-off"></span>Enter Holidays/Shutdown Days</a></li> '+ 
			*/
			
			'	</ul> '+ 
			'</li> '+ 
		    '</ul> ';
	
	      var orderManagementMenu_Master=
				'		<li class="divider"></li> '+ 
				'		<li><a href="/ordermanagement/ordermanagement_masters.html" id="orderManagementMasters"><span '+ 
				'			class="glyphicon glyphicon-pencil"></span> Manage Master Data</a></li> '; 
	      
	     // if(!(userRole=='marketing' || userRole=='admin_manager' || userRole=='admin')) {
	      if(!(userRole=='marketing')) {
	    	  orderManagementMenu_Master = '';
	      }
	      
	      var orderManagementMenu= 
				'<ul class="nav navbar-nav"> '+ 
				'<li class="dropdown">'+ 
				'	<a href="#" class="dropdown-toggle"'+ 
				'   data-toggle="dropdown" role="button" aria-expanded="false"> <span '+ 
				'	class="glyphicon glyphicon-blackboard"></span> Order Management <span '+ 
				'		class="caret"></span> '+ 
				'	</a> '+ 
				'	<ul class="dropdown-menu" role="menu"> '+ 
				'		<li><a href="/ordermanagement/orderInfo.html" id="orderManagement"><span '+ 
				'				class="glyphicon glyphicon-th-list"></span> Manage Orders</a></li> '+ 
				orderManagementMenu_Master +
				'	</ul> '+ 
				'</li> '+ 
			    '</ul> ';   
	      

	      
	      var orderManagementMenuOld =
		 	     ' <ul class="nav navbar-nav">'+
		 	     '   <li class="dropdown"><a href="/ordermanagement/orderInfo.html" id="orderManagement"><span class="glyphicon glyphicon-th-list"></span>Order Management</a></li>  '+
		 	     ' </ul>  ';
	      
	      var logOffMenu =
	     ' <ul class="nav navbar-nav navbar-right">'+
	     '   <li><a href="#" id="logoff"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  '+
	     ' </ul>  '+
	    '</div><!-- /.navbar-collapse -->  '+
	  '</div><!-- /.container-fluid -->  '+
	'</nav>  ';
	
	 
	var header;
	if(userRole=="operator") {
		header = homeMenu+ logOffMenu;
	} else if (userRole=="admin") {
		header = homeMenu+ adminMenu + logOffMenu;
	} else if(userRole=="admin_manager") {
		header = homeMenu+ reportsMenu + adminMenu + logOffMenu;
	} else if(userRole=="marketing" || userRole == "planning" || userRole=="printing" || userRole == "cutting" || userRole=="qc" || userRole=="dispatch" || userRole=="stores" || userRole=="production") {
		header = orderManagementHomeMenu + orderManagementMenu  + logOffMenu;
	}
	$(".header").replaceWith(header);
}

function appendFooter() {
	var footer = 
		
	'<nav class="navbar navbar-default navbar-fixed-bottom hidden-xs"> '+
	  '<div class="container" style="max-width: 900px"> '+
	  
	   '  <div class="navbar-header "> '+
	    '  <a class="navbar-brand" href="#"> '+
	     '   <span><img style="max-width:110px; margin-top: -15px;" src="/images/company_logo.png"></span> '+
	     ' </a> '+
	    '</div> '+
	    
	    '<div class="navbar-header "> '+
	     ' <ul class="nav navbar-nav"> '+
	      '  <li><a href="http://www.autofits.com/" target="_blank"><b>E-Durables</b></a></li> '+
	     ' </ul> '+
	    '</div> '+
	    '<div class="navbar-header navbar-right"> '+
	     ' <ul class="nav navbar-nav"> '+
	      '	<li> '+
	 	   '  <a class="navbar-brand" href="http://www.clairviz.com" target="_blank"><small>Powered by <b>ClairViz Osprey</b> Engine</small> '+
		    '    <span><img style="max-width:110px; margin-top: -1px;" src="/images/ClairVizIcon.png"></span> '+
		    ' </a> '+
		    ' </li> '+
	       '</ul> '+
	    '</div><!-- /.navbar-collapse --> '+
	  '</div><!-- /.container-fluid --> '+
	'</nav> ';
	
	$(".footer").replaceWith(footer);
}