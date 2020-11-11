<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("App_Path", request.getContextPath());%>
<!doctype html>
<html lang="zh">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">

		<link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap.css">
		<link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap-grid.css">
		<link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap-reboot.css">
		<link rel="stylesheet" type="text/css" href="com/css/index.css" />
		<link rel="stylesheet" type="text/css" href="com/css/reset.css" />
		<title>杭职马院</title>
		<style type="text/css">
			.main {
				min-height: 500px;
			}
		</style>
	</head>
	<body>
		<!-- 移动端导航栏 -->
		<nav class="navbar navbar-dark navbarBoxMOB">
			<a class="navbar-brand" href="">马克思主义学院</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample01" aria-controls="navbarsExample01"
			 aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarsExample01">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href="#">学校链接</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">学院简介</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">教学科研</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">党建思政</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">文化建设</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">文件制度</a>
					</li>
				</ul>
			</div>
		</nav>
		<!-- 顶部图片 -->
		<div class="header container headerMOB">
			<div class="row text-center">
				<div class="logo col-6 text-left ">
					<img src="com/img/header/logo.png" class="img-fluid">
				</div>
				<div class="motto col-6 text-right">
					<img src="com/img/header/motto2.png" class="img-fluid">
				</div>
				<div class="headline col-sm-12 text-center">
					<img src="com/img/header/makesiTM.png" class="img-fluid">
				</div>
			</div>
		</div>
		<div class="header container headerPC">
			<div class="row text-center">
				<div class="logo col-sm-6 col-lg-4 text-left ">
					<img src="com/img/header/logo.png" class="img-fluid">
				</div>
				<div class="headline col-sm-12 col-lg-4 text-center">
					<img src="com/img/header/makesiTM.png" class="img-fluid">
				</div>
				<div class="motto col-sm-6 col-lg-4 text-right">
					<img src="com/img/header/motto2.png" class="img-fluid">
				</div>
			</div>
		</div>
		<!-- 导航栏 -->
		<div class="navbarBoxPC">
			<ul class="nav justify-content-lg-around container">
				<li class="nav-item">
					<a class="nav-link active" href="index.html">首页</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">学校链接</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">学院简介</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">教学科研</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">党建思政</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">文化建设</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">文件制度</a>
				</li>
			</ul>
		</div>
		<div class="container">
			<div class="section ">
				<div class="sectionName">
					<div class="">
						学院新闻
					</div>
				</div>
			</div>
		</div>

		<div class="main container">
			<div class="row">
				<div class="col-3">
					<div class="list-group">
						<button type="button" class="list-group-item list-group-item-action active">
							学院新闻
						</button>
						<button type="button" class="list-group-item list-group-item-action">党建与思想政治工作</button>
						<button type="button" class="list-group-item list-group-item-action">理论学习</button>
						<button type="button" class="list-group-item list-group-item-action">学院公告</button>
					</div>
				</div>
				<div class="col-9">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">首页</a></li>

							<li class="breadcrumb-item active" aria-current="page">学院新闻</li>
						</ol>
					</nav>
					<div class="list-group newsList">
						<a href="detail" class="list-group-item list-group-item-action">我校学生陈龙获浙江省高职高专院校国家奖学金特别评审奖推荐资格<span class="">2020.10.20</span></a>
						<a href="detail" class="list-group-item list-group-item-action">Morbi leo risus<span class="">2020.10.20</span></a>
						<a href="detail" class="list-group-item list-group-item-action">Porta ac consectetur ac<span class="">2020.10.20</span></a>
						<a href="detail" class="list-group-item list-group-item-action">Vestibulum at eros<span class="">2020.10.20</span></a>
						<a href="detail" class="list-group-item list-group-item-action">Vestibulum at eros<span class="">2020.10.20</span></a>
						<a href="detail" class="list-group-item list-group-item-action">Vestibulum at eros<span class="">2020.10.20</span></a>
					</div>
					<nav aria-label="Page navigation example" class="">
						<ul class="pagination justify-content-center">
							<li class="page-item">
								<a class="page-link" href="#" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item">
								<a class="page-link" href="#" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</ul>
					</nav>
				</div>

			</div>
		</div>
		<div class="end">
			<div class="container">
				<div class="row">
					<div class="col-lg-1 important-links" style="">
						重要链接
					</div>
					<div class="col-lg-11 links row justify-content-lg-around">
						<div class="link-item">
							<a href="">中华人民共和国教育部</a>
						</div>
						<div class="link-item">
							<a href="">中国高职高专教育网</a>
						</div>
						<div class="link-item">
							<a href="">浙江省教育厅</a>
						</div>
						<div class="link-item">
							<a href="">人民网</a>
						</div>
						<div class="link-item">
							<a href="">新华网</a>
						</div>
						<div class="link-item">
							<a href="">光明网</a>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="contact">
			<div class="container">
				<div class="row">
					<div class="about col-lg-1 " style="">
						联系我们
					</div>
					<div class="address col-lg-11  text-center">
						<a href="">地址：杭州市钱塘新区学源街68号 办公室电话：(0571)56700081</a>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="./com/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="./com/bootstrap-4.5.0-dist/js/bootstrap.js"></script>
		<script type="text/javascript" src="./com/bootstrap-4.5.0-dist/js/bootstrap.bundle.js"></script>
	</body>
</html>
