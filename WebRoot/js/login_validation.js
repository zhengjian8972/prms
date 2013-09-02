$(document).ready(function() {
	// global vars
	var form = $("#form");
	var username = $("#userId");
	var idInfo = $("#id-info");
	var password = $("#password");
	var passwordInfo = $("#password-info");

	username.value = getCookieValue("userName");
	password.value = getCookieValue("password");

	// On blur
	username.blur(validateId);
	password.blur(validatePass);

	// On Submitting
	form.submit(function() {
		if (validateId() & validatePass()) {
			if ($("saveCookie").checked) {
				setCookie("userName", username.value, 24, "/");
				setCookie("password", password.value, 24, "/");
				return true;
			}
		} else
			return false;
	});

	function validateId() {
		var reg = /^[0-9]+$/;
		// if it's NOT valid
		if (reg.exec(username.val()) == null) {
			username.addClass("alert");
			idInfo.text("请输入数字ID");
			idInfo.addClass("alert");
			return false;
		}
		// if it's valid
		else {
			username.removeClass("alert");
			idInfo.text("你的学工号");
			idInfo.removeClass("alert");
			return true;
		}
	}
	function validatePass() {
		// it's NOT valid
		if (password.val().length <= 0) {
			password.addClass("alert");
			passwordInfo.text("请输入密码");
			passwordInfo.addClass("alert");
			return false;
		}
		// it's valid
		else {
			password.removeClass("alert");
			passwordInfo.text("你的密码");
			passwordInfo.removeClass("alert");
			return true;
		}
	}

});