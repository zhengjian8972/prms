<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" type="image/vnd.microsoft.icon" href="../img/logo.png">

		<title>成员资料</title>
		<link type="text/css" rel="stylesheet" href="../css/core.css">
		<link type="text/css" rel="stylesheet" href="../css/ph_detail.css">
		<link type="text/css" rel="stylesheet" href="../css/member.css">
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
		<script type="text/javascript" src="../js/member.js"></script>
		<script type="text/javascript" src="../js/ga.js"></script>
	</head>

	<body class="t1">
		
		
<div class="headbg">
			<div id="gaia">
				<span> 欢迎，<b><s:property value="#session.MEMBER_NAME"/></b> | <a href="#"
					title="Profile, Updates, and Settings"><u>个人资料</u> </a> | <a
					href="../logout"><u>退 出</u> </a> </span>
			</div>
			<div class="gbh" style="left: 0pt;"></div>
			<div class="gbh" style="right: 0pt;"></div>
			<div style="height: 1px"></div>

			<table style="padding: 0px; margin: 0px 0px 10px 0px; width: 100%"
				cellpadding="0" cellspacing="0">
				<tbody>
 <tr style="height: 58px;">
 
 <td style="padding-left: 0.5em">
 
 <div id="pname">
 <a href="#" style="text-decoration:none;">XXXXX</a>
 </div>
 
 </td>
						<td
							style="white-space: nowrap; text-align: right; vertical-align: bottom;">
							<form action="http://google.com/search">
								<input size="30" name="q" value="" type="text">
								<input type="submit" class="ulib-btn " name="search" value="Search">
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
	<div id="colcontrol">
<br/>
 <div class="profile-container">
 <div><b>Username: </b> 
 <span>
 Diamond.<a href="#" onclick="_showID('captcha')">...</a>@gmail.com
 </span>
 </div>
 <div>
 <span id="star_msg">
 Star this developer
 </span>
 </div>
 
 <div>
 <b>Starred&nbsp;developers:</b>
 <i>None</i>
 </div>
 
 </div>
 
 <br style="clear:both" />
</div>
<br style="clear:both" />

		<div><jsp:include page="../commen/footer.jsp"></jsp:include></div>
		
		
	</body>
</html>
