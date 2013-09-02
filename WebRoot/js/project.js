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

					$(".add_project_wrap").dialog({
						resizable : false,
						modal : true,
						autoOpen : false,
						height : 330,
						width : 650,
						title : "添加项目"
					});

					$(".add_member_wrap").dialog({
						resizable : false,
						modal : true,
						autoOpen : false,
						height : 330,
						width : 650,
						title : "添加成员"
					});

					$(".add_task_wrap").dialog({
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
						} else
							return false;
					});

					function validateProjectName() {
						if (projectExist(projectName.val())) {
							projectNameAlert.text("项目已存在！");
							return false;
						} else {
							projectNameAlert.text("");
							return true;
						}
					}
					function validateAdmin() {

						if (!memberExist(projectAdmin.val())) {
							projectAdminAlert.text("用户不存在");
							return false;
						} else {
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

					$(".inst3")
							.click(
									function() {
										$("#home").hide();
										$("#project").show();
										var projectId = $(this).attr("id");
										var params = {
											projectId : $(this).attr("id")
										};
										$
												.post(
														'../projectAjax/loadProject.action',
														params,
														function callback(data) {
															var memberNameArr = new Array();
															var groupNameArr = new Array();
															var groupTables = "";
															var dataObj = eval("("
																	+ data
																	+ ")");
															$
																	.each(
																			dataObj,
																			function(
																					idx,
																					item) {
																				var groupName = item.groupName;
																				var memberInfo = item.groupMember;
																				var groupInfo = item.groupDes;
																				groupNameArr
																						.push(groupName);
																				groupTables += '<!-- 成列组名单 --><span class="group_title">';
																				groupTables += groupName;
																				groupTables += '</span> <span class="group_op"><span class="SPRITE_new-23 goog-inline-block vt"></span> <a class="func_link_word" id="delete_group">删除该组 </a> <span class="SPRITE_people-y16 goog-inline-block vt"></span><a class="func_link_word" id="add_member">添加成员 </a> </span><div class="list"><div class="pagination">1 - 6 of 6</div>&nbsp;&nbsp;</div><table cellspacing="0" cellpadding="2" border="0" class="results" id="resultstable" width="100%"><thead><tr id="headingrow"><th style="border-left: 0">&nbsp;</th><th class="col_0" nowrap="nowrap"><a href="#" style="text-decoration: none">学号 </a></th><th class="col_1" nowrap="nowrap" id="description" width="100%"><a href="#" style="text-decoration: none">姓名</a></th><th class="col_2" nowrap="nowrap"><a href="#" style="text-decoration: none">组内权限 </a></th><th class="col_3" nowrap="nowrap"><a href="#" style="text-decoration: none">操作 </a></th></tr></thead><tbody id="memberTable">';

																				var memberArr = memberInfo
																						.split("|");
																				for (x in memberArr) {
																					if (x.length != 0) {
																						var name = x
																								.split("#")[0];
																						var id = x
																								.split("#")[1];
																						memberNameArr
																								.push(name);
																						groupTables += '<tr class="ifOpened"><td class="vt" nowrap="nowrap" style="padding: 2px 2px 0 2px"><span class="SPRITE_star_off goog-inline-block vt" style="width: 15px; height: 15px;"></span></td><td class="vt id col_0"><a href="#">';
																						groupTables += id;
																						groupTables += '</a></td><td class="vt col_1" width="100%"><a onclick="cancelBubble=false" href="#">';
																						groupTables += name;
																						groupTables += ' </a></td><td class="vt col_2"><a onclick="cancelBubble=false" href="#" style="white-space: nowrap">';
																						groupTables += groupInfo;
																						groupTables += ' </a></td><td class="vt col_3"><a class="SPRITE_close_icon goog-inline-block vt operator" style="width: 16px; height: 16px;" title="删除"></a></td></tr>';
																					}
																				}
																				groupTables += '</tbody></table><div class="list-foot"><div class="pagination">1 - 6 of 6</div></div><!-- 组名单结束 -->&nbsp;&nbsp;';
																			});
															document.getElementById("colcontrol").innerHTML=groupTables;
															$("#group_count")
																	.html(
																			groupNameArr.length);
															$("#member_count")
																	.html(
																			memberArr.length);
															var groupList = "";
															for (x in groupNameArr) {
																groupList += '<li class="psmeta"><a href="#">';
																groupList += x;
																groupList += '</a></li>';
															}
															alert(groupList);
															$("#group_list")
																	.html(
																			groupList);
															var memberList = "";
															for (x in groupNameArr) {
																memberList += '<li class="psmeta"><a href="#">';
																memberList += x;
																memberList += '</a></li>';
															}
															alert(groupList);
															$("#member_list")
																	.html(
																			memberList);
														}, 'json');
									});

					$("#add_member").click(function() {
						$(".add_member_wrap").dialog("open");
					});
					$("#add_member_form").submit(function() {
						alert("成功添加成员到项目中");
					});

					$("#add_task_form").submit(function() {
						alert("成功发送任务信息至成员邮箱");
					});

					$("#add_task").click(function() {
						$(".add_task_wrap").dialog("open");
					});
				});