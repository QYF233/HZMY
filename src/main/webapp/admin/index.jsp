<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("App_Path", request.getContextPath());%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>首页</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="robots" content="all,follow">
		<!-- Bootstrap CSS-->
		<link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css">
		<!-- Font Awesome CSS-->
		<link rel="stylesheet" href="../com/admin/vendor/font-awesome/css/font-awesome.min.css">
		<!-- Fontastic Custom icon font-->
		<link rel="stylesheet" href="../com/admin/css/fontastic.css">
		<!-- Google fonts - Roboto -->
		<link rel="stylesheet" href="../com/admin/https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
		<!-- jQuery Circle-->
		<link rel="stylesheet" href="../com/admin/css/grasp_mobile_progress_circle-1.0.0.min.css">
		<!-- Custom Scrollbar-->
		<link rel="stylesheet" href="../com/admin/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
		<!-- theme stylesheet-->
		<link rel="stylesheet" href="../com/admin/css/style.blue.css" id="theme-stylesheet">
		<!-- Custom stylesheet - for your changes-->
		<link rel="stylesheet" href="../com/admin/css/custom.css">
		<!-- Favicon-->
		<link rel="shortcut icon" href="../com/admin/img/favicon.ico">
		<!-- Tweaks for older IEs-->
		<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
	</head>
	<body>
		<!-- Side Navbar -->
		<nav class="side-navbar">
			<div class="side-navbar-wrapper">
				<!-- Sidebar Header    -->
				<div class="sidenav-header d-flex align-items-center justify-content-center">
					<!-- User Info-->
					<div class="sidenav-header-inner text-center"><img src="../com/admin/img/avatar-7.jpg" alt="person" class="img-fluid rounded-circle">
						<h2 class="h5">求琰锋</h2><span>超级管理员</span>
					</div>
					<!-- 收缩小标题 -->
					<div class="sidenav-header-logo"><a href="index.html" class="brand-small text-center">
							<!-- <strong>HZ</strong> --><strong class="text-primary">HZMY</strong></a></div>
				</div>
				<!-- 侧边栏导航 -->
				<div class="main-menu">
					<h5 class="sidenav-heading">主要功能</h5>
					<ul id="side-main-menu" class="side-menu list-unstyled">
						<li class="active"><a href="admin/index"> <i class="icon-home"></i>首页</a></li>
						<li><a href="Navigation.html"> <i class="fa fa-bars"></i>导航管理</a></li>
						<li><a href="Section.html"> <i class="icon-grid"></i>板块管理</a></li>
						<li><a href="Article.html"> <i class="fa fa-file-text"></i>文章管理</a></li>

					</ul>
				</div>
				<div class="admin-menu">
					<h5 class="sidenav-heading">其他功能</h5>
					<ul id="side-admin-menu" class="side-menu list-unstyled">
						<li> <a href="#"> <i class="fa fa-bar-chart"> </i>统计</a></li>
						<li> <a href="#"> <i class="icon-flask"> </i>文件管理 <div class="badge badge-info">Special</div></a></li>

					</ul>
				</div>
			</div>
		</nav>
		<div class="page">
			<!-- navbar-->
			<header class="header">
				<nav class="navbar">
					<div class="container-fluid">
						<div class="navbar-holder d-flex align-items-center justify-content-between">
							<div class="navbar-header"><a id="toggle-btn" href="#" class="menu-btn"><i class="icon-bars"> </i></a><a href="index.html"
								 class="navbar-brand">
									<div class="brand-text d-none d-md-inline-block"><span>马克思主义学院 </span><strong class="text-primary">后台管理系统</strong></div>
								</a></div>
							<ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">

								<!-- Languages dropdown    -->
								<li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
									 aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><img src="../com/admin/img/flags/16/GB.png"
										 alt="English"><span class="d-none d-sm-inline-block">中文</span></a>
									<ul aria-labelledby="languages" class="dropdown-menu">
										<li><a rel="nofollow" href="#" class="dropdown-item"> <img src="../com/admin/img/flags/16/DE.png" alt="English" class="mr-2"><span>German</span></a></li>
										<li><a rel="nofollow" href="#" class="dropdown-item"> <img src="../com/admin/img/flags/16/FR.png" alt="English" class="mr-2"><span>French
												</span></a></li>
									</ul>
								</li>
								<!-- Log out-->
								<li class="nav-item"><a href="login.html" class="nav-link logout"> <span class="d-none d-sm-inline-block">登出</span><i
										 class="fa fa-sign-out"></i></a></li>
							</ul>
						</div>
					</div>
				</nav>
			</header>
			<!-- Counts Section -->
			<section class="dashboard-counts section-padding">
				<div class="container-fluid">
					<div class="row">
						<!-- Count item widget-->
						<div class="col-xl-3 col-md-4 col-6">
							<div class="wrapper count-title d-flex">
								<div class="icon"><i class="icon-user"></i></div>
								<div class="name"><strong class="text-uppercase">管理员数</strong><span>当前普通管理员数量</span>
									<div class="count-number">25</div>
								</div>
							</div>
						</div>
						<!-- Count item widget-->
						<div class="col-xl-3 col-md-4 col-6">
							<div class="wrapper count-title d-flex">
								<div class="icon"><i class="icon-padnote"></i></div>
								<div class="name"><strong class="text-uppercase">板块数</strong><span>开放板块数量</span>
									<div class="count-number">400</div>
								</div>
							</div>
						</div>
						<!-- Count item widget-->
						<div class="col-xl-3 col-md-4 col-6">
							<div class="wrapper count-title d-flex">
								<div class="icon"><i class="icon-bill"></i></div>
								<div class="name"><strong class="text-uppercase">文章数</strong><span>发布总文章数</span>
									<div class="count-number">123</div>
								</div>
							</div>
						</div>
						<!-- Count item widget-->
						<div class="col-xl-3 col-md-4 col-6">
							<div class="wrapper count-title d-flex">
								<div class="icon"><i class="icon-check"></i></div>
								<div class="name"><strong class="text-uppercase">阅读量</strong><span>文章总阅读量</span>
									<div class="count-number">342</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</section>
			<!-- Header Section-->
			<section class="dashboard-header section-padding">
				<div class="container-fluid">
					<div class="row d-flex align-items-md-stretch">
						<!-- To Do List-->
						<!-- <div class="col-lg-2 col-md-12 flex-lg-last flex-md-first align-self-baseline">
							<div class="card">
								<h2 class="display h4">板块概览</h2>
								<div class="">
									<ul class="list-group">
									  <li class="">Cras justo odio</li>
									  <li class="">Dapibus ac facilisis in</li>
									  <li class="">Morbi leo risus</li>
									</ul>
								</div>
							</div>
						</div> -->
						<div class="col-lg-6 col-md-12 flex-lg-last flex-md-first align-self-baseline">
							<div class="card">
								<h2 class="display h4">板块概览</h2>
								<div class="card-body">
									<canvas id="barChartExample"></canvas>
								</div>
							</div>
						</div>
						<!-- Line Chart -->
						<div class="col-lg-6 col-md-12 flex-lg-last flex-md-first align-self-baseline">
							<div class="card">
								<h2 class="display h4">文章阅读量-折线统计图</h2>
								<div class="line-chart">
									<canvas id="lineCahrt"></canvas>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<footer class="main-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-6">
							<p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
						</div>
						<div class="col-sm-6 text-right">
						</div>
					</div>
				</div>
			</footer>
		</div>
		<!-- JavaScript files-->
		<script src="../com/admin/vendor/jquery/jquery.min.js"></script>
		<script src="../com/admin/vendor/popper.js/umd/popper.min.js"> </script>
		<script src="../com/admin/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="../com/admin/js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
		<script src="../com/admin/vendor/jquery.cookie/jquery.cookie.js"> </script>
		<script src="../com/admin/vendor/chart.js/Chart.min.js"></script>
		<script src="../com/admin/vendor/jquery-validation/jquery.validate.min.js"></script>
		<script src="../com/admin/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
		<script src="../com/admin/js/charts-home.js"></script>
		<!-- Main File-->
		<script src="../com/admin/js/front.js"></script>
		<script src="../com/admin/js/charts-custom.js"></script>

	</body>
</html>
