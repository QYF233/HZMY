<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("App_Path", request.getContextPath());%>
<!doctype html>
<html lang="zh">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">

    <link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap-grid.css">
    <link rel="stylesheet" href="./com/bootstrap-4.5.0-dist/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="./com/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="./com/css/reset.css"/>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <title>杭职马院</title>
    <style type="text/css">
        .main {
            min-height: 800px;
        }
    </style>
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
                            <a class="nav-link" href="#">党建思政</a>
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
            <img src="./com/img/header/logo.png" class="img-fluid">
        </div>
        <div class="motto col-6 text-right">
            <img src="com/img/header/motto.png" class="img-fluid">
        </div>
        <div class="headline col-sm-12 text-center">
            <img src="./com/img/header/makesiTM.png" class="img-fluid">
        </div>
    </div>
</div>
<div class="header container headerPC">
    <div class="row text-center">
        <div class="logo col-sm-6 col-lg-4 text-left ">
            <img src="./com/img/header/logo.png" class="img-fluid">
        </div>
        <div class="headline col-sm-12 col-lg-4 text-center">
            <img src="./com/img/header/makesiTM.png" class="img-fluid">
        </div>
        <div class="motto col-sm-6 col-lg-4 text-right">
            <img src="com/img/header/motto.png" class="img-fluid">
        </div>
    </div>
</div>
<!-- 导航栏 -->
<div class="navbarBoxPC nav2">
    <ul class="nav navSection justify-content-lg-around container">
        <%--        <li class="nav-item">
                    <a class="nav-link active" href="index">首页</a>
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
                </li>--%>
    </ul>
</div>
<div class="container">
    <div class="section ">
        <div class="sectionName">

            学院新闻

        </div>
    </div>
</div>

<div class="main container">
    <div class="row">
        <div class="col-3">
            <div class="list-group sideList">
                <%--                <button type="button" class="list-group-item list-group-item-action active">--%>
                <%--                    学院新闻--%>
                <%--                </button>--%>
                <%--                <button type="button" class="list-group-item list-group-item-action">党建与思想政治工作</button>--%>
                <%--                <button type="button" class="list-group-item list-group-item-action">理论学习</button>--%>
                <%--                <button type="button" class="list-group-item list-group-item-action">学院公告</button>--%>
            </div>
        </div>
        <div class="col-9">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index">首页</a></li>
                    <%--                    <li class="breadcrumb-item active" aria-current="page">学院新闻</li>--%>
                </ol>
            </nav>

            <div class="article border">
                <div class="title text-center">
                    <div class="artTitle" id="artTitle">我校学生陈龙获浙江省高职高专院校国家奖学金特别评审奖推荐资格</div>
                    <div class="articleDetail">
                        上传时间: <span id="artTime">2020-10-12</span> 作者：<span id="artAuthor">杨晓光</span> 浏览次数：<span
                            id="artCount">0</span>
                    </div>
                    <br>
                    <hr>
                    <div class="artPic">
                        <%--<img class="img-fluid" src="./com/img/plate/art.jpg" alt="">--%>
                    </div>
                    <div class="artContent text-justify">
                        <%--                        10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。--%>
                    </div>
                    <div class="artMore d-flex justify-content-between">
                        <div class="prev"
                             style="max-width: 50%;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                            <%--                            <a href="#">上一条：<span class="prevArticle">后勤服务中心组织开展食品安全专项检查工作</span></a>--%>
                        </div>
                        <div class="next"
                             style="max-width: 50%;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                            <%--                            <a href="#">下一条：<span class="nextArticle">机关党总支召开10月理论学习中心组（扩大）会议</span></a>--%>
                        </div>
                    </div>
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
                <%--                <div class="link-item">--%>
                <%--                    <a href="">中华人民共和国教育部</a>--%>
                <%--                </div>--%>
                <%--                <div class="link-item">--%>
                <%--                    <a href="">中国高职高专教育网</a>--%>
                <%--                </div>--%>
                <%--                <div class="link-item">--%>
                <%--                    <a href="">浙江省教育厅</a>--%>
                <%--                </div>--%>
                <%--                <div class="link-item">--%>
                <%--                    <a href="">人民网</a>--%>
                <%--                </div>--%>
                <%--                <div class="link-item">--%>
                <%--                    <a href="">新华网</a>--%>
                <%--                </div>--%>
                <%--                <div class="link-item">--%>
                <%--                    <a href="">光明网</a>--%>
                <%--                </div>--%>
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
<%--<script type="text/javascript" src="./com/bootstrap-4.5.0-dist/js/bootstrap.bundle.js"></script>--%>
<script src="com/js/com.js"></script>
<script>
    var articleId;
    var plateId;
    $(function () {
        var test = window.location.search;
        articleId = test.substr(1);
        if (/^\d+$/.test(articleId)) {
            build(articleId);
        }
        getSection();
    })

    /*获取页面信息*/
    function getSection() {
        $.ajax({
            url: "getPlates",
            type: "GET",
            dataType: "json",
            success: function (result) {
                if (result.code == 100) {
                    buildOther(result)
                } else {
                    alert("获取信息失败")
                }
            },
            error: function () {

            }
        });
    }

    /*构建*/
    function buildOther(result) {
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
                /*构建左边栏子板块*/
                build_section(plate)
            }
        })
        /*构建页底*/
        build_footer()
    }

    /*构建*/
    function build(id) {
        $.ajax({
            url: "article/getArticle",
            type: "GET",
            data: {"id": id},
            dataType: "json",
            success: function (result) {
                if (result.code === 100) {
                    build_article(result.extend.article)
                } else {
                    alert("获取信息失败")
                }
            },
            error: function () {

            }
        });
    }

    /*构建文章*/
    function build_article(art) {
        plateId = art.artPlateId;
        console.log(art)
        $("#artTitle").html(art.artTitle)
        $("#artTime").html(art.artTime)
        $("#artAuthor").html(art.artAuthor)
        var pic = art.artPic.split(",");
        var picBox = $(".artPic")
        $.each(pic, function (index, p) {
            console.log(p)
            var img = $("<img>").addClass("img-fluid").attr("src", "com/img/article/" + p).attr("alt", "图片");
            picBox.append(img)
        })
        $(".artContent").html(art.artContent)
        other()
    }

    function build_section(plate) {
        var sideList = $(".sideList");
        var button = $("<button></button>").attr("type", "button").addClass("list-group-item list-group-item-action").html(plate.plaName)
        if (plate.id === plateId) {
            button.addClass("active");
            $(".sectionName").html(plate.plaName);
            var li = $("<li></li>").addClass("breadcrumb-item active").html(plate.plaName)
            $(".breadcrumb").append(li);
        }
        sideList.append(button)
    }

    function other() {
        console.log(plateId)
        console.log(articleId)
        $.ajax({
            url: "article/getOtherArticle",
            type: "POST",
            data: {plateId: plateId, articleId: articleId},
            dataType: "json",
            success: function (result) {
                if (result.code === 100) {
                    console.log("获取上一条")
                    console.log(result.extend.prev)
                    console.log(result.extend.next)
                    var prev = result.extend.prev;
                    var next = result.extend.next;
                    if (prev != null) {
                        var p = $("<a></a>").attr("href", "article?" + prev.id).html("上一条：")
                        var spanPrev = $("<span></span>").addClass("prevArticle").html(prev.artTitle)
                        p.append(spanPrev)
                        $(".prev").append(p)
                    }
                    if (next != null) {
                        var n = $("<a></a>").attr("href", "article?" + next.id).html("下一条：")
                        var spanNext = $("<span></span>").addClass("nextArticle").html(next.artTitle)
                        n.append(spanNext)
                        $(".next").append(n)
                    }
                } else {
                    alert("获取信息失败")
                }
            },
            error: function () {

            }
        });
    }
</script>
</body>
</html>
