<div class="add_member_wrap ">
	<form class="add_member_main" action="addMember" method="post"
		id="add_member_form">
		<p>
			<label class="form_label">
				学工号：
			</label>
			<span class="form_input"><input type="text" id="memberId"
					class="form_member_input1" name="memberId" value="请输入成员学工号"
					title="请输入成员学工号"> </span>
		</p>
		<p>
			<label class="form_label">
				成员名：
			</label>
			<span class="form_input"><input type="text" id="memberName"
					class="form_member_input1" name="memberName" value="请输入成员名"
					title="请输入成员名"> </span>
		</p>
		<p>
			<label class="form_label">
				邮　箱：
			</label>
			<span class="form_input"><input type="text" id="memberEmail"
					class="form_member_input1" name="memberEmail" value="请输入邮箱"
					title="请输入邮箱"> </span>
		</p>
		<p>
		<span id="add_member_alert" ></span>
			<span class="form_button"> <input type="submit"
					class="ulib-btn form_member_btn" value="提　交" /> <input
					type="reset" id="add_member_reset"
					class="ulib-btn form_member_btn" value="重　置" /> </span>
		</p>
	</form>
</div>