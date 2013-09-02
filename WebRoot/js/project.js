$("document")
		.ready(
				function() {

					var allProject = new Array();
					$
							.post(
									'../projectAjax/loadAllProjects.action',
									null,
									function callback(data) {
										var dataObj = eval("(" + data + ")");
										var listContent = "";
										$
												.each(
														dataObj,
														function(idx, item) {
															allProject
																	.push(item.projectName);
															listContent += '<tr class="ifOpened "><td class="vt inst3" nowrap="nowrap" style="padding: 2px 2px 0 2px"><span class="SPRITE_star_off goog-inline-block vt"style="width: 15px; height: 15px;"></span>	</td><td class="vt id col_0"><a href="#" id="';
															listContent += item.projectId;
															listContent += '">';
															listContent += item.projectName;
															listContent += '</a></td><td class="vt col_1_p" width="100%"><a onclick="cancelBubble=false" href="#">';
															listContent += item.desc;
															listContent += ' </a>	</td>	<td class="vt col_2_p">	<a onclick="cancelBubble=false" href="#" style="white-space: nowrap">';
															listContent += item.memberNum;
															listContent += '</a></td><td class="vt col_3"><a onclick="cancelBubble=false" href="#"> ';
															listContent += item.projectAdmin;
															listContent += '</a></td>	</tr>';
														});
										$("#projectTable").html(listContent);
									}, 'json');

					var allMember = new Array();

					$("#add_project")
							.click(
									function() {
										$(".add_project_wrap").dialog("open");
										$
												.post(
														'../memberAjax/loadBriefMemberList.action', // 服务器要接受的url
														null, // 传递的参数
														function callback(data) { // 显示列表
															var dataObj = eval("("
																	+ data
																	+ ")");// 转换为json对象
															$("#projectAdmin")
																	.autocomplete(
																			{
																				minLength : 0,
																				source : dataObj,
																				focus : function(
																						event,
																						ui) {
																					$(
																							"#projectAdmin")
																							.val(
																									ui.item.value);
																					return false;
																				},
																				select : function(
																						event,
																						ui) {
																					$(
																							"#projectAdmin")
																							.val(
																									ui.item.value);

																					return false;
																				}
																			})
																	.data(
																			"autocomplete")._renderItem = function(
																	ul, item) {
																allMember
																		.push(item.value);
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

					$(".add_project_wrap").dialog( {
						resizable : false,
						modal : true,
						autoOpen : false,
						height : 330,
						width : 650,
						title : "添加项目"
					});
					
					$(".add_member_wrap").dialog( {
						resizable : false,
						modal : true,
						autoOpen : false,
						height : 330,
						width : 650,
						title : "添加成员"
					});
					
					$(".add_task_wrap").dialog( {
						resizable : false,
						modal : true,
						autoOpen : false,
						height : 330,
						width : 650,
						title : "分配任务"
					});

					$(".form_project_input1").blur(function() {
						if (this.value == '') {
							this.value = this.title
						}
					});
					$(".form_project_input1").focus(function() {
						if (this.value == this.title) {
							this.value = ''
						}
					});

					$(".form_project_input2").blur(function() {
						if (this.value == '') {
							this.value = this.title
						}
					});
					$(".form_project_input2").focus(function() {
						if (this.value == this.title) {
							this.value = ''
						}
					});

					var form = $("#add_project_form");
					var projectNameAlert = $("#addPNAlert");
					var projectAdminAlert = $("#addPAAlert");
					var projectName = $("#projectName");
					var projectAdmin = $("#projectAdmin");

					form.submit(function() {
						if (validateProjectName() & validateAdmin()) {
							return true;
						}
						else
							return false;
					});

					function validateProjectName() {
						if (projectExist(projectName.val())) {
							projectNameAlert.text("项目已存在！");
							return false;
						}
						else {
							projectNameAlert.text("");
							return true;
						}
					}
					function validateAdmin() {
						
						if (!memberExist(projectAdmin.val())) {
							projectAdminAlert.text("用户不存在");
							return false;
						}
						else {
							projectAdminAlert.text("");
							return true;
						}
					}

					// 项目是否存在
					function projectExist(projectName) {
						for (x in allProject) {
							if (allProject[x] == projectName) {
								return true;
							}
						}
						return false;
					}
					// 成员是否存在
					function memberExist(projectAdmin) {
						for (x in allMember) {
							if (allMember[x] == projectAdmin) {
								return true;
							}
						}
						return false;
					}
					
					$(".form_member_input1").blur(function() {
						if (this.value == '') {
							this.value = this.title
						}
					});
					$(".form_member_input1").focus(function() {
						if (this.value == this.title) {
							this.value = ''
						}
					});
					
					$(".inst1").click(function() {
						$("#home").show();
						$("#project").hide();
					});
					
					$(".inst3").click(function() {
						$("#home").hide();
						$("#project").show();
					var projectId =  $(this).attr("id");
						var params = {
								projectId : $(this).attr("id")
							};
						$
						.post(
								'../projectAjax/loadProject.action',
								params,
								function callback(data) {
								}, 'json');
					});
					
					$("#add_member").click(function(){
						$(".add_member_wrap").dialog("open");
					});
					 $("#add_member_form").submit(function() {
							alert("成功添加成员到项目中");
						});
					
					 $("#add_task_form").submit(function() {
							alert("成功发送任务信息至成员邮箱");
						});
					
					 
					$("#add_task").click(function(){
						$(".add_task_wrap").dialog("open");
					});
				});