<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" type="image/vnd.microsoft.icon"
			href="../img/logo.png">

		<title>TSEG报告管理系统——报告管理</title>
		<link type="text/css" rel="stylesheet" href="../css/core.css">
		<link type="text/css" rel="stylesheet" href="../css/ph_detail.css">
		<link type="text/css" rel="stylesheet" href="../css/report.css">
		<!--[if IE]>
 		<link type="text/css" rel="stylesheet" href="../css/ie.css" >
 		<![endif]-->
		<!-- jQuery -->
		<script type="text/javascript"
			src="../tool/jquery-ui/js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript"
			src="../tool/jquery-ui/js/jquery-ui-1.8.17.custom.min.js"></script>
		<link type="text/css" rel="stylesheet"
			href="../tool/jquery-ui/css/ui-lightness/jquery-ui-1.8.17.custom.css" />
		<script type="text/javascript"
			src="../tool/jquery-raty/js/jquery.raty.min.js"></script>
		<script type="text/javascript"
			src="../tool/jquery-raty/js/jquery.raty.js"></script>
		<script type="text/javascript" src="../js/report.js"></script>
		<script type="text/javascript" src="../js/ga.js"></script>
	</head>

	<body class="t1">
		<jsp:include page="../commen/headbg.jsp"></jsp:include>
		<div id="mt" class="gtb">
			<a href="../project/home" class="tab ">Projects</a>
			<a href="../member/home" class="tab ">Members</a>
			<a href="../report/home" class="tab active">Reports</a>
			<a href="#" class="tab ">Wiki</a>
			<div class="gtbc"></div>
		</div>
		
		<div id="wrap">
			<jsp:include page="home.jsp"></jsp:include>
		</div>

		<div><jsp:include page="../commen/footer.jsp"></jsp:include></div>
		<jsp:include page="addReport.jsp"></jsp:include>
	</body>
</html>
