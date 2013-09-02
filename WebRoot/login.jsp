<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ch" xml:lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" type="image/vnd.microsoft.icon" href="img/logo.png"/>
<title>TSEG项目报告管理系统</title>
<meta name="description" content="TSEG项目报告管理系统用于北京邮电大学通信软件工程中心内部项目、报告管理所用"/>
<meta name="keywords" content="TSEG项目报告管理系统,TSEG,通信软件工程中心,项目报告管理系统"/>
<meta name="author" content="tseg.org"/>
<script type="text/javascript" src="tool/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/login_validation.js"></script>
<link type="text/css" rel="stylesheet" href="css/core.css"/>
<style>
/* initialize */
html,body,div,span,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,code,del,dfn,em,img,q,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,textarea,input[type="text"]{font-size:100%;font-family:Verdana, Arial, Helvetica, sans-serif, "宋体";vertical-align:baseline;}
body{background:#fff;color:#333;font:normal normal normal 12px/1.6 normal;}
h1{font-size:200%;}
h2{font-size:180%;}
h3{font-size:150%;}
h4{font-size:130%;}
h5{font-size:115%;}
h6{font-size:100%;}
p{font-size:1em;}
a{color:#28c;text-decoration:none;*blr:expression(this.onFocus=this.blur());}
a:focus,input:focus{-moz-outline-style:none;outline-style:none;}
a:hover{text-decoration:underline;}
img{vertical-align:middle;}
ul,ol{list-style:none;}
.ulib-btn{display:inline-block;padding:0 8px;height:27px;line-height:27px;white-space:nowrap;color:#333;font-size:12px;text-align:center;outline:0;border:1px solid #bbb;background-color:#f6f6f6;background-image:-webkit-linear-gradient(top,#f6f6f6,#eee);background-image:-moz-linear-gradient(top,#f6f6f6,#eee);background-image:-ms-linear-gradient(top,#f6f6f6,#eee);background-image:-o-linear-gradient(top,#f6f6f6,#eee);background-image:linear-gradient(top,#f6f6f6,#eee);}
.ulib-btn:hover{text-decoration:none;}
.ulib-btn,
.ulib-r3{moz-border-radius:3px;-webkit-border-radius:3px;border-radius:3px;border-top-left-radius:3px 3px;border-top-right-radius:3px 3px;border-bottom-right-radius:3px 3px;border-bottom-left-radius:3px 3px;}
.slight{color:#777;}
.alittle{color:#aaa;}
.obvious{color:#28c;}
.inspire{color:#5b0;}
.serious{color:#e64d00;}
.severe{color:#e61717;}
.hidden{display:none;}
.hd,
.ft,
.login{position:absolute;left:50%;}
.hd{top:20px;margin-left:-480px;width:960px;height:80px;}
.ft{top:500px;margin-left:-480px;margin-top:240px;width:960px;height:40px;}
.ft p{display:inline;padding-left:10px;font-size:1em;}
.ft .link{float:left;}
.ft .copy{float:right;}
.ft .link a{margin-right:10px;}
.hd h1 a,

.hd h1{float:left;}
.hd a{display:block;height:51px;text-indent:-999em;}
.hd h1 a{width:378px;height:46px;}
.hd h2{float:right;width:161px;height:51px;background-position:0 -46px;}
.login{top:198px;margin-left:-212px;/*top:50%;margin-top:-212px;*/width:424px;height:252px; background:url("img/login.png") 0 0 no-repeat;overflow:hidden;text-align:left;_background-image:url("img/login.png")}
.login .form p{margin:5px 0;}
.login .form .text input{padding:7px 5px;width:180px;border:1px solid #ddd;-webkit-transition:-webkit-box-shadow .2s ease-out;-moz-transition:-moz-box-shadow .2s ease-out;transition:box-shadow .2s ease-out;}
.login .form .text input:focus{border-color:#0af;color:#333;-webkit-box-shadow:0 0 5px rgba(34,136,204,.6);-moz-box-shadow:0 0 5px rgba(34,136,204,.6);box-shadow:0 0 5px rgba(34,136,204,.6);}
.login .form .check{overflow:hidden;zoom:1;}
.login .form .check label{float:left;}
.login .form .check input{vertical-align:-2px;}
.login .form .check a{float:right;}
.login .form .btn{margin-top:16px;text-align:center;}
.login .form .btn .ulib-btn{padding:0px 20px;}
.login .form,
.login .app{position:absolute;}
.login .form{top:60px;left:40px;width:300px;}
.login .app{top:22px;right:30px;width:80px;}
.login .app a{display:block;height:80px;text-indent:-999em;}
.rt-skin-login{background:url("img/login_bg.png") no-repeat center 0px;}
.prompt{margin-left:10px; color: #B1B1B1;}
.text input.alert{
	background: #f8dbdb;
}
span.alert{
color:#C00;
}

.ft {
	top: 300px;
}
</style>
</head>

<body class="rt-skin-login">

<div class="login">
    <div class="form ulib-r5 ulib-sl">
        <form action="login" method="post" id="form">
        <p class="text">
            <input name="userId" id="userId" value="学工号" title="学工号"  maxlength="100" class="ulib-r3 alittle" type="text" alt="学工号"
            onfocus="if(this.value==this.title){this.value = '' }"
			onblur="if(this.value==''){this.value = this.title}"/><span id="id-info" class="prompt">你的学工号</span>
            
        </p>
        <p class="text"><input name="password" value="" maxlength="100" class="ulib-r3 alittle"  type="password" alt="密码" id="password" /> <span id="password-info" class="prompt">你的密码</span></p>
        <p class="check slight"><label><input id="autologin" name="rememberme" value="1"  type="checkbox"/>下次自动登录</label>  <span style = "margin-left:20px; color:#000;">	<s:property value="errorInfo" /> </span></p>
        <p class="btn"><input type="submit" class="ulib-btn" style ="margin-left:-15px;" value="登录系统"/> </p>
        
        </form>
        

  
    </div>


</div><!--/end .login-->
    <div class="ft">
  <div id="footer" dir="ltr">
			<div class="text">
				©2012 TSEG
				<a href="#">Terms</a> -
				<a href="#">Privacy</a> -
				<a href="#">Project Hosting Help</a>
			</div>
		</div>
		<div class="hostedBy" style="margin-top: -20px;">
			<span style="vertical-align: top;">Powered by <a
				href="http://www.renren.com/234803681">ZhengJian</a>&nbsp; <a
				href="http://www.renren.com/234079982">ZhangRenBo</a>&nbsp;<a
				href="http://www.renren.com/257622847">YuXingLong</a> </span>
		</div>
		</div>
</body>
</html>