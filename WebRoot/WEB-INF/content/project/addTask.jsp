<div class="add_task_wrap ">
	<form class="add_task_main" action="addTask" method="post"
		id="add_task_form">
		<p>
			<label class="form_label">
				学工号：
			</label>
			<span class="form_input"><input type="text" id="taskMemberId"
					class="form_member_input1" name="taskMemberId" value="请输入成员学工号"
					title="请输入成员学工号"> </span>
		</p>
		<p>
			<label class="form_label">
				任　务：
			</label>
			<span class="form_input"><textarea class="form_project_input2"
					id="taskContent" name="taskContent" title="请输入任务内容">请输入任务内容</textarea>
			</span>
		</p>
		
		<p>
		<span id="add_member_alert" ></span>
			<span class="form_button"> <input type="submit"
					class="ulib-btn form_member_btn" value="分　配" /> <input
					type="reset" id="add_member_reset"
					class="ulib-btn form_member_btn" value="重　置" /> </span>
		</p>
	</form>
</div>