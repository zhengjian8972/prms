<%@ taglib prefix="s" uri="/struts-tags"%>
	<table cellspacing="0" cellpadding="0" width="100%" align="center"
			border="0" class="st">
			<tbody>
				<tr>
					<td class="subt">
						<div class="st1">
							<div class="isf">
								<span class="inst1"> <a>Home</a> </span> &nbsp;
								<s:iterator value="#session.allProjectMap">
								<span class="inst3" id="<s:property value="key"/>"> <a><s:property value="value"/></a> </span>&nbsp;
								</s:iterator>
								
							</div>
						</div>
					</td>

				</tr>
			</tbody>
		</table>

<div id="maincol">
	<!-- IE -->
	<table width="100%">
		<tbody>
			<tr class="pscontent">
				<td class="pscolumnl" style="width: 25%;">
					<div class="phead">
						Project Information
					</div>
					<div class="psicon">
						<span class="SPRITE_star_off goog-inline-block vt"
							title="Project Information"
							style="cursor: pointer line-height : 15px;"> </span> 项目中有
						<span id="project_count">2</span>&nbsp;个组。
						
 <ul class="pslist">
 <li class="psmeta">
 <a href="#">管理组</a>
 </li>
 <li class="psmeta">
 <a href="#">后台编程组</a>
 </li>
  <li class="psmeta">
 <a href="#">前台编程组</a>
 </li>
 </ul>
					</div>
 <div class="psicon">
 <span class="psicon-container goog-inline-block">
 <span style="float:right" class="SPRITE_people-y16 goog-inline-block vt"></span>
 </span> 项目中有
						<span id="member_count">5</span>&nbsp;名成员。
 <ul class="pslist">
  <li class="psmeta">
 <a href="#">阿信</a>
 </li>
   <li class="psmeta">
 <a href="#">玛莎</a>
 </li>
   <li class="psmeta">
 <a href="#">怪兽</a>
 </li>
   <li class="psmeta">
 <a href="#">石头</a>
 </li>
   <li class="psmeta">
 <a href="#">冠佑</a>
 </li>
   <li class="psmeta">
 <a href="#">脑残粉</a>
 </li>
 </ul>
 </div>
 	<div class="psicon func_link" >
						<div class="SPRITE_people-y16 goog-inline-block vt"></div>
						<a class="func_link_word" id="add_member">添加成员 </a>
					</div>
				
				 	<div class="psicon func_link" >
						<div class="SPRITE_people-y16 goog-inline-block vt"></div>
						<a class="func_link_word" id="add_task">分配任务 </a>
					</div>
				
				
	 	<div class="psicon func_link" >
						<div class="SPRITE_filedownload-g16 goog-inline-block vt"></div>
						<a class="func_link_word" id="load_project_report">导出项目周报 </a>
					</div>				
				</td>
				<td id="project-list" style="width: 75%;">
					<div id="colcontrol">



<!-- 成列组名单 -->
<span class="group_title">管理组		</span> 
<span class= "group_op">
<span class="SPRITE_new-23 goog-inline-block vt"></span>
						<a class="func_link_word" id="delete_group">删除该组 </a>
						 <span  class="SPRITE_people-y16 goog-inline-block vt"></span><a class="func_link_word" id="add_member">添加成员 </a>
 </span> 
						
						<div class="list">

							<div class="pagination">

								1 - 6 of 6

							</div>

							&nbsp;&nbsp;

						</div>

						<table cellspacing="0" cellpadding="2" border="0" class="results"

							id="resultstable" width="100%">

							<thead>

								<tr id="headingrow">

									<th style="border-left: 0">

										&nbsp;

									</th>

									<th class="col_0" nowrap="nowrap">
										<a href="#" style="text-decoration: none">学号 </a>
									</th>
									<th class="col_1" nowrap="nowrap" id="description" width="100%">
										<a href="#" style="text-decoration: none">姓名</a>
									</th>
									<th class="col_2" nowrap="nowrap">
										<a href="#" style="text-decoration: none">组内权限 </a>
									</th>
									<th class="col_3" nowrap="nowrap">

										<a href="#" style="text-decoration: none">操作 </a>
									</th>
								</tr>
							</thead>
							<tbody id="memberTable">

								<tr class="ifOpened" >
									<td class="vt" nowrap="nowrap" style="padding: 2px 2px 0 2px">
										<span class="SPRITE_star_off goog-inline-block vt"
											style="width: 15px; height: 15px;"></span>
									</td>
									<td class="vt id col_0">
										<a href="#"> 2011110776 </a>
									</td>
									<td class="vt col_1" width="100%">
										<a onclick="cancelBubble=false" href="#">Agüero </a>
									</td>
									<td class="vt col_2">
										<a onclick="cancelBubble=false" href="#"
											style="white-space: nowrap">组长</a>
									</td>
									<td class="vt col_3">
										<a class="SPRITE_close_icon goog-inline-block vt operator"
											style="width: 16px; height: 16px;" title="删除"></a>
									</td>
								</tr>
							</tbody>

						</table>

						<div class="list-foot">

							<div class="pagination">

								1 - 6 of 6

							</div>

						</div>
<!-- 组名单结束 -->
						&nbsp;&nbsp;
<!-- 成列组名单 -->
<span class="group_title">前台编码组		</span> 
<span class= "group_op">
<span class="SPRITE_new-23 goog-inline-block vt"></span>
						<a class="func_link_word" id="delete_group">删除该组 </a>
						 <span  class="SPRITE_people-y16 goog-inline-block vt"></span><a class="func_link_word" id="add_member">添加成员 </a>
 </span> 
						<div class="list">

							<div class="pagination">

								1 - 6 of 6

							</div>

							&nbsp;&nbsp;

						</div>

						<table cellspacing="0" cellpadding="2" border="0" class="results"

							id="resultstable" width="100%">

							<thead>

								<tr id="headingrow">

									<th style="border-left: 0">

										&nbsp;

									</th>

									<th class="col_0" nowrap="nowrap">
										<a href="#" style="text-decoration: none">学号 </a>
									</th>
									<th class="col_1" nowrap="nowrap" id="description" width="100%">
										<a href="#" style="text-decoration: none">姓名</a>
									</th>
									<th class="col_2" nowrap="nowrap">
										<a href="#" style="text-decoration: none">组内权限 </a>
									</th>
									<th class="col_3" nowrap="nowrap">

										<a href="#" style="text-decoration: none">操作 </a>
									</th>
								</tr>
							</thead>
							<tbody id="memberTable">

								<tr class="ifOpened" >
									<td class="vt" nowrap="nowrap" style="padding: 2px 2px 0 2px">
										<span class="SPRITE_star_off goog-inline-block vt"
											style="width: 15px; height: 15px;"></span>
									</td>
									<td class="vt id col_0">
										<a href="#"> 2011110776 </a>
									</td>
									<td class="vt col_1" width="100%">
										<a onclick="cancelBubble=false" href="#">Agüero </a>
									</td>
									<td class="vt col_2">
										<a onclick="cancelBubble=false" href="#"
											style="white-space: nowrap">组长</a>
									</td>
									<td class="vt col_3">
										<a class="SPRITE_close_icon goog-inline-block vt operator"
											style="width: 16px; height: 16px;" title="删除"></a>
									</td>
								</tr>
							</tbody>

						</table>

						<div class="list-foot">

							<div class="pagination">

								1 - 6 of 6

							</div>

						</div>
<!-- 组名单结束 -->
						&nbsp;&nbsp;
						<div style="margin-top: 1px; font-size: small">



						</div>

					</div>
 
				</td>
			</tr>
		</tbody>
	</table>
</div>