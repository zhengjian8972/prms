$("document")
		.ready(
				function() {

					$
							.post(
									'../reportAjax/loadPrivateReports.action', // 服务器要接受的url
									null, // 传递的参数
									// var params = {
									// loginName:$("#loginName").val(),
									// password:$("#password").val(),
									// }
									function callback(data) { // 显示列表
										var dataObj = eval("(" + data + ")");// 转换为json对象
										var listContent = "";
										$
												.each(
														dataObj,
														function(idx, item) {
															listContent += '<tr class="ifOpened" id="';
															listContent += item.reportId;
															listContent += '_r"><td class="vt" nowrap="nowrap" style="padding: 2px 2px 0 2px"><span class="SPRITE_star_off goog-inline-block vt"style="width: 15px; height: 15px;"></span>	</td><td class="vt id col_0">	<a href="#">';
															if (item.reportType == 0)
																listContent += "周报";
															else
																listContent += "报告";
															listContent += ' </a></td><td class="vt col_1" width="100%"><a onclick="cancelBubble=false" href="#">';
															listContent += item.projectName;
															listContent += ' </a></td><td class="vt col_2"><a onclick="cancelBubble=false"style="white-space: nowrap"> ';
															listContent += item.date;
															listContent += '</a></td><td class="vt col_3"><a class="SPRITE_filedownload-g16 goog-inline-block vt operator loadReport" style="width: 16px; height: 16px;" title="导出" value="';
															listContent += item.reportId;
															listContent += '"></a><a class="SPRITE_close_icon goog-inline-block vt operator deleteReport"style="width: 16px; height: 16px;"  title="删除" value="';
															listContent += item.reportId;
															listContent += '"></a></td></tr>';
														});
										$("#reportTable").html(listContent);
										$(".deleteReport")
												.click(
														function() {
															// var rowId
															// =$(this).attr('value');
															var params = {
																reportId : $(
																		this)
																		.attr(
																				'value')
															};
															$
																	.post(
																			'../reportAjax/deleteReport.action',
																			params,
																			function callback(
																					data) {
																				window.location
																						.reload();
																			});
														});
										$(".loadReport")
												.click(
														function() {
															// var rowId
															// =$(this).attr('value');
															var params = {
																reportId : $(
																		this)
																		.attr(
																				'value')
															};
															$
																	.post(
																			'../reportAjax/getReportContent.action',
																			params,
																			function callback(
																					data) {
																				var dataObj = eval("("
																						+ data
																						+ ")");
																				var url = ""; // 转向网页的地址;
																				var name = "个人周报"; // 网页名称，可为空;
																				var iWidth = 750; // 弹出窗口的宽度;
																				var iHeight = 730; // 弹出窗口的高度;
																				var iTop = (screen.availHeight - 30 - iHeight) / 2; // 获得窗口的垂直位置;
																				var iLeft = (screen.availWidth - 10 - iWidth) / 2; // 获得窗口的水平位置;
																				var reportWindow = window
																						.open(
																								url,
																								name,
																								'height='
																										+ iHeight
																										+ ',innerHeight='
																										+ iHeight
																										+ ',width='
																										+ iWidth
																										+ ',innerWidth='
																										+ iWidth
																										+ ',top='
																										+ iTop
																										+ ',left='
																										+ iLeft
																										+ ',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
																				// 写成一行
																				reportWindow.document
																						.write('<html>	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>个人周报</title>	<link type="text/css" rel="stylesheet" href="../css/core.css"><link type="text/css" rel="stylesheet" href="../css/ph_detail.css"><link type="text/css" rel="stylesheet" href="../css/report.css"><!--[if IE]> 		<link type="text/css" rel="stylesheet" href="../css/ie.css" > <![endif]--><!-- jQuery --><script type="text/javascript"			src="../tool/jquery-ui/js/jquery-1.7.1.min.js"></script>		<script type="text/javascript"			src="../tool/jquery-ui/js/jquery-ui-1.8.17.custom.min.js"></script>		<link type="text/css" rel="stylesheet"			href="../tool/jquery-ui/css/ui-lightness/jquery-ui-1.8.17.custom.css" />		<script type="text/javascript"			src="../tool/jquery-raty/js/jquery.raty.min.js"></script>		<script type="text/javascript"			src="../tool/jquery-raty/js/jquery.raty.js"></script>		</head>		<body>	<div class="show_report_main">		<p>			<label class="form_label ">				项目名：			</label>			<span class="form_input1"><span  class="form_report_input1" id="project">');
																				reportWindow.document
																						.write(dataObj.project);
																				reportWindow.document
																						.write('</span> </span><span class="form_label form_label_right"> 报告时间： <span class="form_input1"><span class="form_report_input1" id="reportdate"> </span>');
																				reportWindow.document
																						.write(dataObj.reportdate);
																				reportWindow.document
																						.write('</span> </span></p><p>	<label class="form_label">本周工作背景：</label><span class="form_input form_input2"><span class="form_report_input2" id="workcontent" >');
																				reportWindow.document
																						.write(dataObj.workcontent);
																				reportWindow.document
																						.write('</span> </span></p><p><label class="form_label">本周工作具体内容：</label><span class="everyday"><span class="day">周一：<span class="workcontent_ed" >');
																				reportWindow.document
																						.write(dataObj.reportdatecontent1);
																				reportWindow.document
																						.write('</span>工作时间：<span class="worktime_ed">');
																				reportWindow.document
																						.write(dataObj.reportdatetime1);
																				reportWindow.document
																						.write('</span> </span> <span class="day">周二：<span class="workcontent_ed" >');
																				reportWindow.document
																						.write(dataObj.reportdatecontent2);
																				reportWindow.document
																						.write('</span>工作时间：<span class="worktime_ed">');
																				reportWindow.document
																						.write(dataObj.reportdatetime2);
																				reportWindow.document
																						.write('</span> </span> <span class="day">周三：<span class="workcontent_ed" >');
																				reportWindow.document
																						.write(dataObj.reportdateContent3);
																				reportWindow.document
																						.write('</span>工作时间：<span class="worktime_ed">');
																				reportWindow.document
																						.write(dataObj.reportdatetime3);
																				reportWindow.document
																						.write('</span> </span> <span class="day">周四：<span class="workcontent_ed" >');
																				reportWindow.document
																						.write(dataObj.reportdatecontent4);
																				reportWindow.document
																						.write('</span>工作时间：<span class="worktime_ed">');
																				reportWindow.document
																						.write(dataObj.reportdatetime4);
																				reportWindow.document
																						.write('</span> </span> <span class="day">周五：<span class="workcontent_ed" >');
																				reportWindow.document
																						.write(dataObj.reportdatecontent5);
																				reportWindow.document
																						.write('</span>工作时间：<span class="worktime_ed">');
																				reportWindow.document
																						.write(dataObj.reportdatetime5);
																				reportWindow.document
																						.write('</span> </span> <span class="day">其他：<span class="workcontent_ed" >');
																				reportWindow.document
																						.write(dataObj.reportdateContent6);
																				reportWindow.document
																						.write('</span>工作时间：<span class="worktime_ed">');
																				reportWindow.document
																						.write(dataObj.reportdatetime6);
																				reportWindow.document
																						.write('</span> </span> </span></p><p><label class="form_label">本周工作成果：</label><span class="form_span form_span2"><span class="form_report_span2" id="workresult" >');
																				reportWindow.document
																						.write(dataObj.workresult);
																				reportWindow.document
																						.write('</span> </span></p><p><label class="form_label">下周工作计划：</label><span class="form_span form_span2"><span class="form_report_span2" id="workplan" >');
																				reportWindow.document
																						.write(dataObj.workplan);
																				reportWindow.document
																						.write('</span> </span></p><p><label class="form_label">需要资源情况：</label><span class="form_span form_span2"><span class="form_report_span2" id="workresource" >');
																				reportWindow.document
																						.write(dataObj.workresource);
																				reportWindow.document
																						.write('</span> </span></p>	<p><label class="form_label">工作满意度：</label><span id="rate">');
																				switch (dataObj.rate_score) {
																				case '0':
																					reportWindow.document
																							.write("无");
																					break;
																				case '1':
																					reportWindow.document
																							.write("在打酱油");
																					break;
																				case '2':
																					reportWindow.document
																							.write("状态不佳");
																					break;
																				case '3':
																					reportWindow.document
																							.write("工作顺利");
																					break;
																				case '4':
																					reportWindow.document
																							.write("表现不错");
																					break;
																				case '5':
																					reportWindow.document
																							.write("状态神勇");
																					break;
																				default:
																					break;
																				}

																				reportWindow.document
																						.write('</span><label class="form_label form_label_right">代码量：');
																				reportWindow.document
																						.write(dataObj.codeline);
																				reportWindow.document
																						.write('</label></p></div></body></html>');
																			},
																			'json');
															// alert(rowId);
															// $("tr[name^=rowId]").hide("slow");

														});
									}, 'json');

					$("#add_report")
							.click(
									function() {
										// 动态获取项目
										// ajax 动态获取
										$(".add_report_wrap").dialog("open");
										$
												.post(
														'../projectAjax/loadUserProjects.action', // 服务器要接受的url
														null, // 传递的参数
														function callback(data) { // 显示列表
															var dataObj = eval("("
																	+ data
																	+ ")");// 转换为json对象
															$("#project")
																	.autocomplete(
																			{
																				minLength : 0,
																				source : dataObj,
																				focus : function(
																						event,
																						ui) {
																					$(
																							"#project")
																							.val(
																									ui.item.value);
																					return false;
																				},
																				select : function(
																						event,
																						ui) {
																					$(
																							"#project")
																							.val(
																									ui.item.value);

																					return false;
																				}
																			})
																	.data(
																			"autocomplete")._renderItem = function(
																	ul, item) {
																return $(
																		"<li></li>")
																		.data(
																				"item.autocomplete",
																				item)
																		.append(
																				"<a>"
																						+ item.label
																						+ "<br>"
																						+ item.desc
																						+ "</a>")
																		.appendTo(
																				ul);
															};

														}, 'json');

									});

					$(".add_report_wrap").dialog({
						resizable : false,
						modal : true,
						autoOpen : false,
						height : 790,
						width : 750,
						title : "撰写报告"
					});

					$(".form_report_input1").blur(function() {
						if (this.value == '') {
							this.value = this.title
						}
					});
					$(".form_report_input1").focus(function() {
						if (this.value == this.title) {
							this.value = ''
						}
					});

					$(".form_report_input2").blur(function() {
						if (this.value == '') {
							this.value = this.title
						}
					});
					$(".form_report_input2").focus(function() {
						if (this.value == this.title) {
							this.value = ''
						}
					});

					$(".workcontent_ed").blur(function() {
						if (this.value == '') {
							this.value = this.title
						}
					});

					$(".workcontent_ed").focus(function() {
						if (this.value == this.title) {
							this.value = ''
						}
					});

					$(".worktime_ed").blur(function() {
						if (this.value == '') {
							this.value = this.title
						}
					});

					$(".worktime_ed").focus(function() {
						if (this.value == this.title) {
							this.value = ''
						}
					});

					$("#add_report_form").submit(function() {
						var str = form2json();
						$("#content").val(JsonToStr(str));
						return true;
					});

					// 添加日历
					$("#reportdate").datepicker({
						dateFormat : "yy/mm/dd",
						showOtherMonths : true,
						selectOtherMonths : true,
						showWeek : true,
						showAnim : "drop"
					});

					// 评分
					$('#rate').raty({});

					function JsonToStr(o) {
						var arr = [];
						var fmt = function(s) {
							if (typeof s == 'object' && s != null)
								return JsonToStr(s);
							return /^(string|number)$/.test(typeof s) ? "'" + s
									+ "'" : s;
						}
						for ( var i in o)
							arr.push("'" + i + "':" + fmt(o[i]));
						return '{' + arr.join(',') + '}';
					}

					function form2json() {
						var reportForm = document
								.getElementById("add_report_form");
						var json = {};
						for ( var i = 0; i < reportForm.length; i++) {
							var id = reportForm.elements[i].id;
							var value = reportForm.elements[i].value;
							json[id] = value;
						}
						return json;
					}

				});
