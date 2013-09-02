<%@ taglib prefix="s" uri="/struts-tags"%>
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
						<td id="plogo">
							<a href="#"> <img src="../img/logo.png" alt="Logo"> </a>
						</td>
						<td style="padding-left: 0.5em">
							<div id="pname">
								<a href="#"><span>TSEG项目报告管理系统</span> </a>
							</div>
							<div id="psum">
								<a id="project_summary_link" href="#"><span>TSEG
										Project Report System</span> </a>
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