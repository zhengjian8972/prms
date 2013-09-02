<%@ taglib prefix="s" uri="/struts-tags"%>
<table cellspacing="0" cellpadding="0" width="100%" align="center"
			border="0" class="st">
			<tbody>
				<tr>
					<td class="subt">
						<div class="st1">
							<div class="isf">
								<span class="inst1"> <a>Home</a> </span> &nbsp;
									<s:iterator value="#session.participateProjects">
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
						Report Information
					</div>
					<div class="psicon">
						<span class="SPRITE_star_off goog-inline-block vt"
							title="Report Information"
							style="cursor: pointer line-height :       15px;"> </span> 你共有
						<span id="report_count"><s:property value="reportNum" /> </span>&nbsp;篇报告。

					</div>

					<div class="psicon func_link">
						<div class="SPRITE_pencil-y14 goog-inline-block vt"></div>
						<a class="func_link_word" id="add_report">撰写周报</a>
					</div>

				</td>
				<td id="report-list" style="width: 75%;">
					<div id="colcontrol">
						<div class="list">
							<div class="pagination">
								1 -
								<s:property value="reportNum" />
								of
								<s:property value="reportNum" />
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
										<a href="#" style="text-decoration: none">报告类型 </a>
									</th>

									<th class="col_1" nowrap="nowrap" id="description" width="100%">
										<a href="#" style="text-decoration: none">对应项目</a>
									</th>

									<th class="col_2" nowrap="nowrap">
										<a href="#" style="text-decoration: none">提交时间 </a>
									</th>

									<th class="col_3" nowrap="nowrap">
										<a href="#" style="text-decoration: none">操作 </a>
									</th>
								</tr>
							</thead>

							<tbody id="reportTable">
								

							</tbody>
						</table>
						<div class="list-foot">
							<div class="pagination">
								1 -
								<s:property value="reportNum" />
								of
								<s:property value="reportNum" />
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