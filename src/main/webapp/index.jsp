<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("App_Path", request.getContextPath());%>
<!doctype html>
<html lang="zh-CN">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <title>杭职马院</title>
    <link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap-grid.css">
    <link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="com/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="com/css/reset.css"/>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
<!-- 移动端导航栏 -->
<nav class="navbar navbar-dark navbarBoxMOB">
    <a class="navbar-brand" href="">马克思主义学院</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample01"
            aria-controls="navbarsExample01"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExample01">
        <ul class="navbar-nav navSection">
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
    <ul class="nav justify-content-lg-around container navSection">
        <li class="nav-item">
            <a class="nav-link active" href="index">首页</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">学校链接</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">学院简介</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                教学科研
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Link 1</a>
                <a class="dropdown-item" href="#">Link 2</a>
                <a class="dropdown-item" href="#">Link 3</a>
            </div>
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

<div class="main container">
    <div class="row">
        <!-- 轮播图 -->
        <div class="col-sm-12 col-lg-6">

            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                    <li data-target="#myCarousel" data-slide-to="3"></li>
                </ul>

                <!-- 轮播图片 -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-80" src="com/img/carousel/5.JPG" alt="First slide">
                        <div class="carousel-caption d-none d-md-block">
                            <p>杭州职业技术学院欢迎您</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-80" src="com/img/carousel/2.jpg" alt="Second slide">
                        <div class="carousel-caption d-none d-md-block">
                            <p>学校树林</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-80" src="com/img/carousel/3.jpg" alt="Third slide">
                        <div class="carousel-caption d-none d-md-block">
                            <p>图书馆</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-80" src="com/img/carousel/1.JPG" alt="Third slide">
                        <div class="carousel-caption d-none d-md-block">
                            <p>实训中心</p>
                        </div>
                    </div>
                </div>

                <!-- 左右切换按钮 -->
                <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#myCarousel" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>

            </div>
        </div>
        <!-- 学院新闻 -->
        <div class="col-sm-12 col-lg-6 news-box ">
            <div class="news-title row no-gutters justify-content-between">
                <div class="title">学院新闻</div>
                <a class="more" href="sectionList">更多 ></a>
            </div>
            <div class="news-content">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row">
                        <a href="detail" class="col-sm-8 col-lg-9 news-link">学院新闻学院新闻学院院新闻学院</a><span class="col-lg-3">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="detail" class="col-lg-9 news-link">学院新闻学院新闻学院新闻学院院新闻学院</a><span class="col-lg-3">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="detail" class="col-lg-9 news-link">学院新闻学院新闻学学院新闻学院院新闻学院</a><span class="col-lg-3">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-9 news-link">学院新闻闻学院院新闻学院</a><span class="col-lg-3">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-9 news-link">学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-3">2020.10.20</span>
                    </li>
                </ul>
            </div>

        </div>
        <!-- 通知公告 -->
        <div class="col-sm-12 col-lg-4 news-box ">
            <div class="news-title row no-gutters justify-content-between">
                <div class="title">党建与思想政治工作</div>
                <a class="more" href="#">更多 ></a>
            </div>
            <div class="news-content">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻闻学院院新闻学院</a><span class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-12 col-lg-4 news-box ">
            <div class="news-title row no-gutters justify-content-between">
                <div class="title">理论学习</div>
                <a class="more" href="#">更多 ></a>
            </div>
            <div class="news-content">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻闻学院院新闻学院</a><span class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                </ul>
            </div>

        </div>
        <!-- 理论学习 -->
        <div class="col-sm-12 col-lg-4 news-box ">
            <div class="news-title row no-gutters justify-content-between">
                <div class="title">学院公告</div>
                <a class="more" href="#">更多 ></a>
            </div>
            <div class="news-content">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻闻学院院新闻学院</a><span class="col-lg-4">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-8 news-link">学院新闻学院新闻学院院新闻学院</a><span
                            class="col-lg-4">2020.10.20</span>
                    </li>
                </ul>
            </div>
        </div><!-- 习近平新时代中国特色社会主义思想三十讲 -->
        <div class="col-sm-12 col-lg-6 news-box ">
            <div class="news-title row no-gutters justify-content-between">
                <div class="title">习近平新时代中国特色社会主义思想三十讲</div>
                <a class="more" href="#">更多 ></a>
            </div>
            <div class="news-content">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-10 news-link">习近平新时代中国特色社会主义思想是党和国家必须长期坚持的指导思想</a><span
                            class="col-lg-2">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-10 news-link">坚持和发展中国特色社会主义是当代中国发展进步的根本方向</a><span class="col-lg-2">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-10 news-link">实现中华民族伟大复兴是近代以来中华民族最伟大的梦想</a><span class="col-lg-2">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-10 news-link">党和国家事业历史性、根本性的变革和成就</a><span
                            class="col-lg-2">2020.10.20</span>
                    </li>
                    <li class="list-group-item row">
                        <a href="#" class="col-lg-10 news-link">中国特色社会主义新时代标示我国发展新的历史方位</a><span class="col-lg-2">2020.10.20</span>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 学习贯彻十九大精神专栏 -->
        <div class="col-sm-12 col-lg-6 cap-box text-center">
            <div class="img-box">
                <img src="./com/img/shijiu.jpg" class="cap-img img-fluid" alt="">
                <div class="cap-title">
                    <a href="">慧智睿思学堂</a>
                </div>
            </div>
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
<script src="com/js/jquery-3.5.1.js"></script>
<script src="com/bootstrap-4.5.0-dist/js/bootstrap.js"></script>
<script src="com/js/com.js"></script>
<script>
    var flag = true;


    $(function () {
        getSection();
    })

    function getSection() {
        $.ajax({
            url: "getPlates",
            type: "GET",
            dataType: "json",
            success: function (result) {
                console.log(result)
                if (result.code == 100) {
                    build(result)
                } else {
                    alert("获取信息失败")
                }
            },
            error: function () {

            }
        });
    }

    function build(result) {
        var plates = result.extend.plates;
        var ul = $(".navSection")
        ul.empty()
        var home =$("<li></li>").addClass("nav-item").append($("<a></a>").addClass("nav-link").attr("href","index").html("首页"))
        ul.append(home)
        $.each(plates, function (index, plate) {
            if(plate.secType == 1){
                var item =$("<li></li>").addClass("nav-item").append($("<a></a>").addClass("nav-link").attr("href",plate.secUrl).html(plate.secName))
                ul.append(item)
            }else if(plate.secType == 2){
                console.log(plate)
            }
        })
    }
</script>
</body>
</html>
