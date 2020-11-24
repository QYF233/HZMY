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
<!-- 移动端导航栏 -->
<nav class="navbar navbar-dark navbarBoxMOB">
    <a class="navbar-brand" href="">马克思主义学院</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample01"
            aria-controls="navbarsExample01"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExample01">
        <ul class="navbar-nav nav navSection">
<%--            <li class="nav-item">
                <a class="nav-link" href="#">学校链接</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">学院简介</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">教学科研</a>
            </li>
            <li class="nav-item">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown">
                    Dropdown
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">文化建设</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">文件制度</a>
            </li>--%>
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
            <img src="com/img/header/motto.png" class="img-fluid">
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
            <img src="com/img/header/motto.png" class="img-fluid">
        </div>
    </div>
</div>
<!-- 导航栏 -->
<nav class="navbarBoxPC nav2">
    <ul class="nav navSection justify-content-lg-around container">
        <%--                <li class="nav-item animate">
                            <a class="nav-link active" href="index.html">首页</a>
                        </li>
                        <li class="nav-item animate">
                            <a class="nav-link" href="#">学校链接</a>
                        </li>
                        <li class="nav-item animate">
                            <a class="nav-link" href="#">学院简介</a>
                        </li>
                        <li class="nav-item animate">
                            <a class="nav-link dropdown-toggle" href="#">
                                教学科研
                            </a>
                            <ul class="">
                                <li><a class="dropdown-item" href="#">教学科研</a></li>
                                <li><a class="dropdown-item" href="#">教学科研</a></li>
                                <li><a class="dropdown-item" href="#">教学科研</a></li>
                            </ul>
                        </li>
                        <li class="nav-item animate">
                            <a class="nav-link dropdown-toggle" href="#">
                                教学科研
                            </a>
                            <ul class="">
                                <li><a class="dropdown-item" href="#">Link 1</a></li>
                                <li><a class="dropdown-item" href="#">Link 2</a></li>
                                <li><a class="dropdown-item" href="#">Link 3</a></li>
                                <li><a class="dropdown-item" href="#">Link 2</a></li>
                                <li><a class="dropdown-item" href="#">Link 3</a></li>
                            </ul>
                        </li>
                        <li class="nav-item animate">
                            <a class="nav-link" href="#">文化建设</a>
                        </li>
                        <li class="nav-item animate">
                            <a class="nav-link" href="#">文件制度</a>
                        </li>--%>
    </ul>
</nav>

<div class="main container">
    <div class="row mainRow">
        <!-- 轮播图 -->
        <div class="col-sm-12 col-lg-6">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <%--                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                        <li data-target="#myCarousel" data-slide-to="1"></li>
                                        <li data-target="#myCarousel" data-slide-to="2"></li>
                                        <li data-target="#myCarousel" data-slide-to="3"></li>--%>
                </ul>

                <!-- 轮播图片 -->
                <div class="carousel-inner">
                    <%--                    <div class="carousel-item active">
                                            <img class="d-block w-80" src="com/img/carousel/5.JPG" alt="First slide">
                                            <div class="carousel-caption d-none d-md-block">
                                                <p>杭州职业技术学院欢迎您</p>
                                            </div>
                                        </div>--%>
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
        <%--        <div class="col-sm-12 col-lg-6 news-box ">
                    <div class="news-title row no-gutters justify-content-between">
                        <div class="title">学院新闻</div>
                        <a class="more" href="list">更多 ></a>
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
                </div>--%>
        <!-- 通知公告 -->
        <%--        <div class="col-sm-12 col-lg-4 news-box ">
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

                </div>--%>
        <!-- 理论学习 -->
        <%--        <div class="col-sm-12 col-lg-4 news-box ">
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
                </div>--%>
        <!-- 学习贯彻十九大精神专栏 -->
        <%--        <div class="col-sm-12 col-lg-6 cap-box text-center">
                    <div class="img-box">
                        <img src="./com/img/shijiu.jpg" class="cap-img img-fluid" alt="">
                        <div class="cap-title">
                            <a href="">慧智睿思学堂</a>
                        </div>
                    </div>
                </div>--%>
    </div>
</div>
<div class="end">
    <div class="container">
        <div class="row">
            <div class="col-lg-1 important-links" style="">
                重要链接
            </div>
            <div class="col-lg-11 links row justify-content-lg-around">
                <%--                <div class="link-item">
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
                                </div>--%>
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

    /*获取页面信息*/
    function getSection() {
        $.ajax({
            url: "getPlates",
            type: "GET",
            dataType: "json",
            success: function (result) {
                // console.log(result)
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

    var swiper_flag = true

    /*构建*/
    function build(result) {
        var plates = result.extend.plates;
        var ul = $(".navSection")
        ul.empty()
        var home = $("<li></li>").addClass("nav-item animate").append($("<a></a>").addClass("nav-link").attr("href", "index").html("首页"))
        ul.append(home)
        $.each(plates, function (index, plate) {
            if (plate.plaType === 1) {
                /*搭建导航栏*/
                build_nav(plate)
            } else if (plate.plaType === 2) {
                /*搭建轮播图*/
                if (swiper_flag) {
                    build_swiper()
                    swiper_flag = false
                }
                /*搭建板块*/
                build_section(plate)
            } else if (plate.plaType === 4) {
                build_special(plate)
            }
        })

        /*构建页底*/
        build_footer()
    }

    /*构建轮播图*/
    function build_swiper() {
        $.ajax({
            url: "getSwiper",
            type: "GET",
            dataType: "json",
            success: function (result) {
                if (result.code == 100) {
                    var swiper = result.extend.swiper;
                    var swiperBox = $(".carousel-inner");
                    var carousel = $(".carousel-indicators");
                    carousel.empty();
                    swiperBox.empty();
                    $.each(swiper, function (index, s) {
                        var item = $("<div></div>").addClass("carousel-item");
                        if (index === 0) {
                            item.addClass("active");
                        }
                        var img = $("<img>").addClass("d-block w-80").attr("src", "com/img/swiper/" + s.swiPic).attr("alt", "First slide");
                        var text = $("<div></div>").addClass("carousel-caption d-none d-md-block").append($("<p></p>").html(s.swiDescribe));
                        item.append(img).append(text);
                        swiperBox.append(item)
                        /*构造轮播图的点*/
                        var li = $("<li></li>").attr("data-target", "#myCarousel").attr("data-slide-to", index);
                        if (index === 0) {
                            li.addClass("active");
                        }
                        carousel.append(li)
                    })
                } else {
                    alert("获取信息失败")
                }
            },
            error: function () {

            }
        });

    }

    /*构建板块*/
    function build_section(section) {
        var main = $(".mainRow")
        // console.log(section)
        var colBox = $("<div></div>").addClass("news-box col-sm-12");
        if (section.plaSort === 1 || section.plaSort === 5) {
            colBox.addClass("col-lg-6");
        } else {
            colBox.addClass("col-lg-4");
        }
        /*标题*/
        var newsTitle = $("<div></div>").addClass("news-title row no-gutters justify-content-between");
        var title = $("<div></div>").addClass("title").html(section.plaName);
        var a = $("<a></a>").addClass("more").attr("href", "section?"+section.id).html("更多 >");
        newsTitle.append(title).append(a);
        /**/
        var content = $("<div></div>").addClass("news-content");
        var ul = $("<ul></ul>").addClass("list-group list-group-flush");
        /*构建文章列表*/
        ul = build_article(section.id, ul, section.plaSort);
        content.append(ul);
        colBox.append(newsTitle).append(content);
        main.append(colBox);
    }

    /*构建文章列表*/
    function build_article(id, ul, sort) {
        $.ajax({
            url: "getArticle",
            type: "GET",
            data: {"plateId": id},
            dataType: "json",
            success: function (result) {
                var articles = result.extend.articles;
                $.each(articles, function (index, article) {
                    var li = $("<li></li>").addClass("list-group-item row");
                    var a = $("<a></a>").addClass("col-sm-8 news-link").attr("href", "article?" + article.id).html(article.artTitle);
                    var time = article.artTime.substring(0, 10);
                    var span = $("<span></span>").html(time);
                    if (sort === 1 || sort === 5) {
                        a.addClass("col-lg-10")
                        span.addClass("col-lg-2");
                    } else {
                        a.addClass("col-lg-8")
                        span.addClass("col-lg-4");
                    }
                    li.append(a).append(span)
                    ul.append(li)
                })
            },
            error: function () {
                ul.html("获取列表失败")
                console.log("获取列表失败")
            }
        });
        return ul
    }

    /*构建专栏*/
    function build_special(special) {
        var main = $(".mainRow")
        var specialBox = $("<div></div>").addClass("col-sm-12 col-lg-6 cap-box text-center")
        var imgbox = $("<div></div>").addClass("img-box");
        var img = $("<img>").attr("src", "com/img/" + special.plaPic).addClass("cap-img img-fluid")
        var cap = $("<div></div>").addClass("cap-title");
        var a = $("<a></a>").attr("href", special.plaUrl).html(special.plaName);
        cap.append(a)
        imgbox.append(img).append(cap)
        specialBox.append(imgbox)
        main.append(specialBox)
    }

</script>
</body>
</html>
