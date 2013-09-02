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
						Projects Information
					</div>
					<div class="psicon">
						<span class="SPRITE_star_off goog-inline-block vt"
							title="Project Information"
							style="cursor: pointer line-height : 15px;"> </span> 实验室中共有
						<span id="project_count"><s:property value="projectNum"/></span>&nbsp;个项目。

					</div>

					<div class="psicon func_link" >
						<div class="SPRITE_new-23 goog-inline-block vt"></div>
						<a class="func_link_word" id="add_project">添加项目 </a>
					</div>

				</td>
				<td id="project-list" style="width: 75%;">
					<div id="colcontrol">
						<div class="list">
							<div class="pagination">
								1 - <s:property value="projectNum"/> of <s:property value="projectNum"/>
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
										<a href="#" style="text-decoration: none">项目名 </a>
									</th>

									<th class="col_1_p" nowrap="nowrap" id="description" width="100%">
										<a href="#" style="text-decoration: none">项目描述</a>
									</th>

									<th class="col_2_p" nowrap="nowrap">
										<a href="#" style="text-decoration: none"> 项目成员数 </a>
									</th>

									<th class="col_3" nowrap="nowrap">
										<a href="#" style="text-decoration: none">项目管理员 </a>
									</th>
								</tr>
							</thead>

							<tbody id="projectTable">
								<!-- project list -->
							</tbody>
						</table>
						<div class="list-foot">
							<div class="pagination">
								1 - <s:property value="projectNum"/> of <s:property value="projectNum"/>
							</div>
						</div>
						&nbsp;&nbsp;
						<div style="margin-top: 1px; font-size: small">

						</div>
					</div>
				</td>
			</tr>
		</tbody>
	</table>

</div>