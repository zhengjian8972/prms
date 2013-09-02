<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="maincol">
	<!-- IE -->
	<table width="100%">
		<tbody>
			<tr class="pscontent">
				<td class="pscolumnl" style="width: 25%;">
					<div class="phead">Projects Information</div>
					<div class="psicon" style="margin-top: 20px; line-height: 15px;">
						<span class="SPRITE_people-y16 goog-inline-block vt"></span> <span>
							实验室共有成员 <span id="member-count"><s:property
									value="memberNum" />&nbsp;</span>名。 </span>
					</div>

					<div class="psicon func_link">
						<div class="SPRITE_new-23 goog-inline-block vt"></div>
						<a class="func_link_word" id="add_member">添加成员 </a>
					</div></td>
				<td id="project-list" style="width: 75%;">
					<div id="colcontrol">
						<div class="list">
							<div class="pagination">
								1 -
								<s:property value="memberNum" />
								of
								<s:property value="memberNum" />
							</div>
							&nbsp;&nbsp;
						</div>
						<table cellspacing="0" cellpadding="2" border="0" class="results"
							id="resultstable" width="100%">
							<thead>
								<tr id="headingrow">
									<th style="border-left: 0">&nbsp;</th>
									<th class="col_0" nowrap="nowrap"><a href="#"
										style="text-decoration: none">学号 </a></th>

									<th class="col_1" nowrap="nowrap" id="description" width="100%">
										<a href="#" style="text-decoration: none">姓名</a></th>

									<th class="col_2" nowrap="nowrap"><a href="#"
										style="text-decoration: none">所属项目 </a></th>

									<th class="col_3" nowrap="nowrap"><a href="#"
										style="text-decoration: none">操作 </a></th>
								</tr>
							</thead>

							<tbody id="memberTable">
								<tr class="ifOpened">
									<td class="vt" nowrap="nowrap" style="padding: 2px 2px 0 2px">
										<span class="SPRITE_star_off goog-inline-block vt"
										style="width: 15px; height: 15px;"></span></td>
									<td class="vt id col_0"><a href="#"> 2011110776 </a></td>


									<td class="vt col_1" width="100%"><a
										onclick="cancelBubble=false" href="#">Agüero </a></td>

									<td class="vt col_2"><a onclick="cancelBubble=false"
										href="#" style="white-space: nowrap">PDM;PETL;打败曼联</a></td>

									<td class="vt col_3"><a
										class="SPRITE_close_icon goog-inline-block vt operator"
										style="width: 16px; height: 16px;" title="删除"></a></td>
								</tr>



							</tbody>
						</table>
						<div class="list-foot">
							<div class="pagination">
								1 -
								<s:property value="memberNum" />
								of
								<s:property value="memberNum" />
							</div>
						</div>
						&nbsp;&nbsp;
						<div style="margin-top: 1px; font-size: small"></div>
					</div></td>
			</tr>
		</tbody>
	</table>

</div>