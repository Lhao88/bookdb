$(function () {
    toPage(1);


})
var current = 1;

function toPage(pageNum) {
    $.ajax({
        url: "/book/page",
        type: "GET",
        data: {
            "pageNum": pageNum,
        },
        success: function (result) {
            build_book_info(result);
            build_navigate_info(result);
        }
    })
}

function build_book_info(result) {
    //清空表格内容
    $("#tables_book tbody").empty();
    //获取图书信息集合
    var bookList = result.books.list;
    //遍历每一本图书
    $.each(bookList, function (index, book) {
        var row = $("<tr></tr>");
        var idTd = $("<td></td>").append(index + 1);
        var nameTd = $("<td></td>").append($("<a></a>")).append(book.bname);
        nameTd.click(function () {
            window.location.href = "book/detail/" + book.id;
            window.event.returnValue = false;
        })


        var typeTd = $("<td></td>");
        switch (book.typeId) {
            case 1:
                typeTd.append("童书");
                break;
            case 2:
                typeTd.append("小说");
                break;
            case 3:
                typeTd.append("科技");
                break;
            case 4:
                typeTd.append("社科");
                break;
            case 5:
                typeTd.append("文艺");
                break;
            case 6:
                typeTd.append("动漫");
                break;
            case 7:
                typeTd.append("人文社科");
                break;
            case 8:
                typeTd.append("经管");
                break;
            case 13:
                typeTd.append("杂志");
                break;
            default:
                typeTd.append("");
                break;
        }
        var authorTd = $("<td></td>").append(book.author);
        var publishTd = $("<td></td>").append(book.publish);
        var stockTd = $("<td></td>").append(book.stock);
        var pictureTd = $("<td></td>").append($("<img>").attr("src", book.pic).attr("class", "cover"));
        var btnTd = $("<td></td>");
        var editBtn = $("<button></button>").attr("id", "edit").attr("class", "btn btn-info").append("修改");
        editBtn.click(function () {
            location.href = "book/" + book.id;
            window.event.returnValue = false;
        })
        var delBtn = $("<button></button>").attr("bName", book.bname).attr("detId", book.id).attr("id", "delete").attr("class", "btn btn-danger").append("删除");
        btnTd.append(editBtn).append(" ").append(delBtn);

        row.append(idTd).append(nameTd).append(typeTd).append(authorTd).append(publishTd)
            .append(stockTd).append(pictureTd).append(btnTd).appendTo($("#tables_book tbody"))

    })
}

function build_navigate_info(result) {
    $("#page_navigate").empty();
    var ul = $("<ul></ul>").addClass("pagination");
    current = result.books.pageNum;
    var firstPageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append("首页"));
    firstPageLi.click(function () {
        toPage(1);
    })
    var prePageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append("&laquo;"));
    if (result.books.hasPreviousPage === false) {
        prePageLi.addClass("disabled ");
    } else {
        prePageLi.click(function () {
            toPage(result.books.prePage)
        })
    }
    //导航条中加入首页和前一页
    ul.append(firstPageLi).append(prePageLi);
    $.each(result.books.navigatepageNums, function (index, num) {
        var numLi = $("<li></li>").append($("<a></a>").append(num));
        //导航条中加入数字选项
        numLi.click(function () {
            toPage(num);
        })
        if (result.books.pageNum === num) {
            numLi.addClass("active ");
        }
        ul.append(numLi);
    })
    var nextPageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append("&raquo;"))
    if (result.books.hasNextPage === false) {
        nextPageLi.addClass("disabled");
    } else {
        nextPageLi.click(function () {
            toPage(result.books.nextPage)
        })
    }
    var lastPageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append("末页"));
    lastPageLi.click(function () {
        toPage(result.books.pages);
    })
    //导航条中加入下一页和末页
    ul.append(nextPageLi).append(lastPageLi);
    $("<nav></nav>").append(ul).appendTo($("#page_navigate"));
}

$(document).on("click", "#delete", function () {
    if (confirm("是否删除" + $(this).attr("bName"))) {
        $.ajax({
            url: "book/" + $(this).attr("detId"),
            type: "DELETE",
            async: false,
            success: function (result) {
                console.log(current);
                toPage(current);
                alert("hello");
            }
        })
    }

})


