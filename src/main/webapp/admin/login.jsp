<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("App_Path", request.getContextPath());%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>杭职马院-后台管理系统</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="com/admin/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="com/admin/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="com/admin/css/fontastic.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <!-- jQuery Circle-->
    <link rel="stylesheet" href="com/admin/css/grasp_mobile_progress_circle-1.0.0.min.css">
    <!-- Custom Scrollbar-->
    <link rel="stylesheet" href="com/admin/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="com/admin/css/style.blue.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="com/admin/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="com/admin/img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <div class="page login-page">
      <div class="container">
        <div class="form-outer text-center d-flex align-items-center">
          <div class="form-inner">
            <div class="logo text-uppercase"><span>马克思主义学院</span><strong class="text-primary">后台管理系统</strong></div>
            <p>欢迎来到杭州职业技术学院马克思主义学院后台管理系统</p>
            <form method="get" class="text-left form-validate">
              <div class="form-group-material">
                <input id="login-username" type="text" name="loginUsername" required data-msg="Please enter your username" class="input-material">
                <label for="login-username" class="label-material">用户名</label>
              </div>
              <div class="form-group-material">
                <input id="login-password" type="password" name="loginPassword" required data-msg="Please enter your password" class="input-material">
                <label for="login-password" class="label-material">密码</label>
              </div>
              <div class="form-group text-center"><a id="login" href="index.html" class="btn btn-primary">登录</a>
                <!-- This should be submit button but I replaced it with <a> for demo purposes-->
              </div>
            </form><a href="#" class="forgot-pass">忘记密码?</a><small>还没有注册? </small><a href="register.html" class="signup">注册</a>
          </div>
          <div class="copyrights text-center">
            
            
          </div>
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="com/admin/vendor/jquery/jquery.min.js"></script>
    <script src="com/admin/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="com/admin/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="com/admin/js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
    <script src="com/admin/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="com/admin/vendor/chart.js/Chart.min.js"></script>
    <script src="com/admin/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="com/admin/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- Main File-->
    <script src="com/admin/js/front.js"></script>
  </body>
</html>