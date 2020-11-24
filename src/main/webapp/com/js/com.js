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

/*构建导航*/
function build_nav(plate) {
    var ul = $(".navSection")
    var item = $("<li></li>").addClass("nav-item animate").append()
    var nav_link = $("<a></a>").addClass("nav-link").attr("href", plate.plaUrl).html(plate.plaName)
    /*如果存在子导航*/
    var dropdown_menu;
    if (plate.childPlate.length > 0) {
        nav_link.addClass("dropdown-toggle")
        dropdown_menu = $("<ul></ul>")
        $.each(plate.childPlate, function (index, child) {
            var child_nav = $("<li></li>").addClass("dropdown-li").append($("<a></a>").addClass("dropdown-item").attr("href", child.plaUrl).html(child.plaName))
            dropdown_menu.append(child_nav)
        })
    }
    item.append(nav_link).append(dropdown_menu)
    ul.append(item)
    $(".navbarBoxMOB .dropdown-toggle").attr("role", "button").attr("data-toggle", "dropdown")
    $(".navbarBoxMOB .dropdown-toggle+ul").addClass("dropdown-menu")
}






/*构建页底*/
function build_footer() {
    $.ajax({
        url: "getLink",
        type: "GET",
        dataType: "json",
        success: function (result) {
            // console.log(result)
            if (result.code === 100) {
                var links = result.extend.links;
                var linksBox = $(".links")
                linksBox.empty();
                $.each(links, function (index, link) {
                    var item = $("<div></div>").addClass("link-item")
                    var a = $("<a></a>").attr("href", "http://" + link.linkUrl).html(link.linkName)
                    item.append(a)
                    linksBox.append(item)
                })
            } else {
                alert("获取信息失败")
            }
        },
        error: function () {

        }
    });
}