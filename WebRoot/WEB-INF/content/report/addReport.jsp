<div class="add_report_wrap">
	<form class="add_report_main" action="homesave" method="post"
		id="add_report_form">
		<input style="display: none;" type="text" id="content" name="content">
		<p>
			<label class="form_label ">
				项目名：
			</label>
			<span class="form_input1"><input type="text"
					class="form_report_input1" name="project" value="项目名" title="项目名"
					id="project"> </span>

			<span class="form_label form_label_right"> 报告时间： <span
				class="form_input1"><input type="text"
						class="form_report_input1" name="reportDate" value="报告时间"
						title="报告时间" id="reportdate"> </span> </span>
		</p>
		<p>
			<label class="form_label">
				本周工作背景：
			</label>
			<span class="form_input form_input2"><textarea
					class="form_report_input2" id="workcontent" name="workContent"
					title="本周工作背景">本周工作背景</textarea> </span>
		</p>
		<p>
			<label class="form_label">
				本周工作具体内容：
			</label>
			<span class="everyday"> <span class="day">周一：<input
						type="text" class="workcontent_ed" name="reportDateContent1"
						value="周一工作内容" title="周一工作内容" id="reportdatecontent1">工作时间：<input
						type="text" class="worktime_ed" name="reportDateTime1" value="H"
						title="H" id="reportdatetime1"> </span> <span class="day">周二：<input
						type="text" class="workcontent_ed" name="reportDateContent2"
						value="周二工作内容" title="周二工作内容" id="reportdatecontent2">工作时间：<input
						type="text" class="worktime_ed" name="reportDateTime2" value="H"
						title="H" id="reportdatetime2"> </span> <span class="day">周三：<input
						type="text" class="workcontent_ed" name="reportDateContent3"
						value="周三工作内容" title="周三工作内容" id="reportdateContent3">工作时间：<input
						type="text" class="worktime_ed" name="reportDateTime3" value="H"
						title="H" id="reportdatetime3"> </span> <span class="day">周四：<input
						type="text" class="workcontent_ed" name="reportDateContent4"
						value="周四工作内容" title="周四工作内容" id="reportdatecontent4">工作时间：<input
						type="text" class="worktime_ed" name="reportDateTime4" value="H"
						title="H" id="reportdatetime4"> </span> <span class="day">周五：<input
						type="text" class="workcontent_ed" name="reportDateContent5"
						value="周五工作内容" title="周五工作内容" id="reportdatecontent5">工作时间：<input
						type="text" class="worktime_ed" name="reportDateTime5" value="H"
						title="H" id="reportdatetime5"> </span> <span class="day">其他：<input
						type="text" class="workcontent_ed" name="reportDateContent6"
						value="其他工作内容" title="其他工作内容" id="reportdateContent6">工作时间：<input
						type="text" class="worktime_ed" name="reportDateTime6" value="H"
						title="H" id="reportdatetime6"> </span> </span>
		</p>
		<p>
			<label class="form_label">
				本周工作成果：
			</label>
			<span class="form_input form_input2"><textarea
					class="form_report_input2" id="workresult" name="workResult"
					title="本周工作成果">本周工作成果</textarea> </span>
		</p>
		<p>
			<label class="form_label">
				下周工作计划：
			</label>
			<span class="form_input form_input2"><textarea
					class="form_report_input2" id="workplan" name="workPlan"
					title="下周工作计划">下周工作计划</textarea> </span>
		</p>
		<p>
			<label class="form_label">
				需要资源情况：
			</label>
			<span class="form_input form_input2"><textarea
					class="form_report_input2" id="workresource" name="workResource"
					title="需要资源情况">需要资源情况</textarea> </span>
		</p>
		<p>
			<label class="form_label">
				工作满意度：
			</label>
			<span id="rate"></span>
			<label class="form_label form_label_right">
				代码量：

				<span class="form_input1"><input type="text"
						class="form_report_input1" name="codeLine" value="代码量" title="代码量"
						id="codeline"> </span>
			</label>
		</p>
		<p>
			<span class="form_button"> <input type="submit"
					class="ulib-btn form_btn" value="提　交" /> <input type="reset"
					id="add_report_reset" class="ulib-btn form_btn" value="重　置" /> </span>
		</p>

	</form>
</div>