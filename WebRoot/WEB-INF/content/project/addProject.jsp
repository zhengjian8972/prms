<div class="add_project_wrap ">
	<form class="add_project_main" action="addProject" method="post"
		id="add_project_form">
		<p>
			<label class="form_label"> 项目名称： </label> <span class="form_input"><input
				type="text" class="form_project_input1" name="projectName"
				value="请输入项目名称" id="projectName" title="请输入项目名称"> </span> <span
				id="addPNAlert" class="addprojectAlert"></span>
		</p>
		<p>
			<label class="form_label"> 项目管理： </label> <span class="form_input"><input
				type="text" id="projectAdmin" class="form_project_input1"
				name="projectAdmin" value="请输入项目管理员ID" title="请输入项目管理员ID"> </span><span
				id="addPAAlert" class="addprojectAlert"></span>
		</p>
		<p>
			<label class="form_label"> 项目简介： </label> <span class="form_input"><textarea
					class="form_project_input2" id="form_project_desc"
					name="projectDesc" title="请输入项目简介">请输入项目简介</textarea> </span>
		</p>
		<p>
			<span class="form_button"> <input type="submit"
				class="ulib-btn form_project_btn" value="提　交" /> <input
				type="reset" id="add_project_reset"
				class="ulib-btn form_project_btn" value="重　置" /> </span>
		</p>

	</form>
</div>
