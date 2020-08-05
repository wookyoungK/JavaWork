var viewItem = undefined;   // 가장 최근에 view 한 글 데이터
var page=1;
var pageRows=10;
var search = "%%";
var searchWord = "%%";

$(document).ready(function () {
    loadPage(page);
    $("#searchbtn").click(function () {
        search = $("#search").val();
        searchWord = $("#searchWord").val();
        loadPage(page);
    });

}); //end document


//------------------------ 공고 검색 ajax 부분 ---------------------------------------------------------------------------------------


//page 번째 페이지 로딩
function loadPage(page) {
    $.ajax({
        url: "hireSearch.ajax?page=" + page + "&pageRows=" + pageRows + "&search=" + search + "&searchWord=" + searchWord
        // url: "hireSearch.ajax?search=" + search + "&searchWord=" + searchWord
        , type: "GET"
        , cache: false
        , success: function (data, status) {
            if (status == "success") {
                if (updateList1(data)) {

                }
            } else {
                alert("공고가 없습니다")
                history.back();
            }

        }
    });
} // end loadPage()


//
function updateList1(jsonObj) {
    result = "";

    if (jsonObj.status == "OK") {
        var count = jsonObj.count;
        var remain;
        var i;
        var items = jsonObj.data;
        for (i = 0; i < count; i++) {


            if (items[i].h_remainDate < 0) {
                remain = "<p id='endhire'>"+"모집 마감"+"</p>";
            }
            if (items[i].h_remainDate == 0) {
                remain = "오늘 종료";
            }
            if (items[i].h_remainDate > 0) {
                remain = items[i].h_remainDate + "일";
            }


            // result += "<div id='h_search_"+items[i].h_uid+"'>\n";
            result += "<tr>" + "<td id='h_search_list'>\n"
                + "<a id='h_search_title' href='/app/hireDetail?h_uid=" + items[i].h_uid + "'>" + items[i].h_title + "[" + "&nbsp" + items[i].h_cnt + "&nbsp" + "]" + "</a>" + "<br>" + "<br>"
                + "기업:" + "&nbsp" + items[i].h_name + "<br>" +
                "<h id='h_search_content'>" + "&nbsp" +
                items[i].h_career +
                "&nbsp" + "*" + "&nbsp" + "&nbsp" + "&nbsp" +
                items[i].h_position1 +
                "&nbsp" + items[i].h_position2 +
                "&nbsp" + "*" + "&nbsp" + "&nbsp" + "&nbsp" +
                items[i].h_part +
                "&nbsp" + "*" + "&nbsp" + "&nbsp" + "&nbsp" +
                items[i].h_workform +
                "&nbsp" + "*" + "&nbsp" + "&nbsp" + "&nbsp" +
                items[i].h_degree + "</h>" + "<br>" + "<br>" + "<br>" + "<h id='h_search_date'>" + remain + "</h>" +
                "</td>" + "</tr>";
        } // end for


        $("#list tbody").html(result);  // 테이블 업데이트!


        // pageRows
        var txt = "<select id='rows' onchange='changePageRows()'>\n";
        txt += "<option " + ((window.pageRows == 5) ? "selected" : "") + " value='5'>5개씩</option>\n";
        txt += "<option " + ((window.pageRows == 10) ? "selected" : "") + " value='10'>10개씩</option>\n";
        txt += "<option " + ((window.pageRows == 15) ? "selected" : "") + " value='15'>15개씩</option>\n";
        txt += "<option " + ((window.pageRows == 20) ? "selected" : "") + " value='20'>20개씩</option>\n";
        txt += "</select>\n";
        $("#pageRows").html(txt);


        // 페이징 업데이트
        var pagination = buildPagination(jsonObj.writepages, jsonObj.totalpage, jsonObj.page, jsonObj.pagerows);
        $("#pagination").html(pagination);

        return true;
    } else {
        alert(jsonObj.message);
        return false;
    }
    return false;
} // end updateList()


//------------------------ 공고 검색 ajax 부분 ---------------------------------------------------------------------------------------


function buildPagination(writePages, totalPage, curPage, pageRows) {

    var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성

    // 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
    var start_page = ((parseInt((curPage - 1) / writePages)) * writePages) + 1;
    var end_page = start_page + writePages - 1;

    if (end_page >= totalPage) {
        end_page = totalPage;
    }

    //■ << 표시 여부
    if (curPage > 1) {
        str += "<li><a onclick='loadPage(1)' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
    }

    //■  < 표시 여부
    if (start_page > 1)
        str += "<li><a onclick='loadPage(" + (start_page - 1) + ")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";

    //■  페이징 안의 '숫자' 표시
    if (totalPage > 1) {
        for (var k = start_page; k <= end_page; k++) {
            if (curPage != k)
                str += "<li><a onclick='loadPage(" + k + ")'>" + k + "</a></li>\n";
            else
                str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
        }
    }

    //■ > 표시
    if (totalPage > end_page) {
        str += "<li><a onclick='loadPage(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }

    //■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='loadPage(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }

    return str;


} // end buildPagination()


function changePageRows() {
    window.pageRows = $("#rows").val();
    loadPage(window.page);
}




