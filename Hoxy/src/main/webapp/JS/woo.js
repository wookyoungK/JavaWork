var page = 1  // 현재 페이지
var pageRows = 5   // 한 페이지에 보여지는 게시글 개수



$(document).ready(function () {



    $('#h_position2').hide();
    $('#h_date').hide();
    // 모든 datepicker에 대한 공통 옵션 설정
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd' // Input Display Format 변경
        , showOtherMonths: true // 빈 공간에 현재월의 앞뒤월의 날짜를 표시
        , showMonthAfterYear: true // 년도 먼저 나오고, 뒤에 월 표시
        , changeYear: true // 콤보박스에서 년 선택 가능
        , changeMonth: true // 콤보박스에서 월 선택 가능
        , showOn: "both" // button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을
                         // 누르거나 input을 클릭하면 달력 표시
        , buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" // 버튼
        // 이미지
        // 경로
        , buttonImageOnly: true // 기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
        , buttonText: "선택" // 버튼에 마우스 갖다 댔을 때 표시되는 텍스트
        , yearSuffix: "년" // 달력의 년도 부분 뒤에 붙는 텍스트
        , monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'] // 달력의
        // 월 부분
        // 텍스트
        , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'] // 달력의
        // 월 부분
        // Tooltip
        // 텍스트
        , dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] // 달력의 요일 부분 텍스트
        , dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'] // 달력의 요일 부분
        // Tooltip 텍스트
        , minDate: "-1M" // 최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
        , maxDate: "+1M" // 최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
    });

    // input을 datepicker로 선언
    $("#h_upDate").datepicker();
    $("#h_regDate").datepicker();

    // From의 초기값을 오늘 날짜로 설정
    $('#h_upDate').datepicker('setDate', 'today'); // (-1D:하루전, -1M:한달전,
    // -1Y:일년전), (+1D:하루후,
    // -1M:한달후, -1Y:일년후)
    // To의 초기값을 내일로 설정
    $('#h_regDate').datepicker('setDate', '+1D'); // (-1D:하루전, -1M:한달전,
    // -1Y:일년전), (+1D:하루후,
    // -1M:한달후, -1Y:일년후)

    $('#h_position1').on('change', function () {
        $('#h_position2').show();

    })

    $("#h_endDate").change(function () {
        if ($("#h_endDate").is(":checked")) {
            $('#h_date').show();
        } else {
            $('#h_date').hide();
        }
    });


}); //end document

$(document).ready(function () {
    var c_uid = document.getElementById("CID").innerText;
    loadPage(c_uid);

}); //end document



function chkSubmit() {
    frm = document.forms["frm"];
    var h_name = frm["h_name"].value.trim();
    var c_uid = frm["c_uid"].value.trim();
    var h_title = frm["h_title"].value.trim();
    var h_salary = frm["h_salary"].value.trim();
    var h_part = frm["h_part"].value.trim();
    var h_position1 = frm["h_position1"].value.trim();
    var h_position2 = frm["h_position2"].value.trim();


    var career_count = document.getElementsByName("h_career").length;
    var degree_count = document.getElementsByName("h_degree").length;
    var workform_count = document.getElementsByName("h_workform").length;
    var upDate = frm["h_upDate"].value.trim();
    var regDate = frm["h_regDate"].value.trim();
    /*    var upDate_count = document.getElementsByName("datepicker").length;
        var regDate_count = document.getElementsByName("datepicker2").length;*/
    var h_content = frm["h_content"].value.trim();

    for (var i = 0; i < career_count; i++) {
        if (document.getElementsByName("h_career")[i].checked == true) {
            var h_career = frm["h_career"].value.trim();
        }
    }
    for (var i = 0; i < degree_count; i++) {
        if (document.getElementsByName("h_degree")[i].checked == true) {
            var h_degree = frm["h_degree"].value.trim();
        }
    }
    for (var i = 0; i < workform_count; i++) {
        if (document.getElementsByName("h_workform")[i].checked == true) {
            var h_workform = frm["h_workform"].value.trim();
        }
    }


    if (h_name == "") {
        alert("기업명 반드시 작성해야 합니다");
        frm["h_title"].focus();
        return false;
    }
    if (h_title == "") {
        alert("공고 제목 반드시 작성해야 합니다");
        frm["h_title"].focus();
        return false;
    }
    if (h_salary == "") {
        alert("급여 반드시 작성해야 합니다");
        frm["h_salary"].focus();
        return false;
    }
    if (h_position2 == "") {
        alert("상세주소는 반드시 작성해야 합니다");
        frm["h_position2"].focus();
        return false;
    }
    if (h_part == "") {
        alert("직무 반드시 작성해야 합니다");
        frm["h_part"].focus();
        return false;
    }

    if(h_content ==""){
        ("모집내용 반드시 작성해야 합니다");
        frm["h_content"].focus();
        return false;
    }


}


function updatebtn(h_uid) {
        location.href = 'view.do?h_uid=' + h_uid;

}


//page 번째 페이지 로딩
function loadPage(cuid) {
    $.ajax({
        // url: "hirelist.ajax?page=" + page + "&pageRows=" + pageRows +"&c_uid="+cuid
        url: "hirelist.ajax?c_uid="+cuid
        , type: "GET"
        , cache: false
        , success: function (data, status) {
            if (status == "success") {
                if (updateList(data)) {

                    $(".deletebtn").click(function () {

                        deleteUid($(this).attr('data-uid'));


                    });

                }
            }
        }
    });
} // end loadPage()

//
function updateList(jsonObj) {
    result = "";

    if (jsonObj.status == "OK") {
        var count = jsonObj.count;
         // var value = document.getElementById("Hsession").innerHTML;
         var CeoName = document.getElementById("CeoName").innerHTML;
         var CName = document.getElementById("CName").innerHTML;

        var remain;
        var i;
        var items = jsonObj.data;
        for (i = 0; i < count; i++) {


                if (items[i].h_remainDate < 0) {
                    remain = "모집 마감";
                }
                if (items[i].h_remainDate == 0) {
                    remain = "오늘 종료";
                }
                if (items[i].h_remainDate > 0) {
                    remain = items[i].h_remainDate + "일";
                }

                // if(itmes[i].h_uid == value )
                result += "<tr id='h_hirelist'>\n";
                //result += "<td>" + "<i class='fas fa-user-tie'></i>" + "</td>\n";
                result += "<td id='h_list_content'>" + "기업명:" + "&nbsp" + CName + "<br>"
                    + "공고제목:" + "&nbsp" + items[i].h_title + "<br>"
                    + "대표명:" + "&nbsp" + CeoName + "<br>"
                    + "마감기한:" + "&nbsp" + remain + "<br>"
                    +"<p id='hcnt'>"+ "조회수:"+ "&nbsp"+items[i].h_cnt+"</p>" +"</td>"
                // result += "<td>" + "<button class='updatebtn' type='button' data-uid='" + items[i].h_uid + "'>상세보기</button>" + "</td>\n";
                result += "<td>" + "<button id='upbtn' class='org_Btn' type='button' onclick='updatebtn(" + items[i].h_uid + ")'>상세보기</button>" + "</td>\n";
                result += "<td>" + "<button id='deletebtn' class='deletebtn org_Btn' data-uid='" + items[i].h_uid + "' type='button'>삭제</button> " + "</td>\n";

                result += "</tr>\n";
            } // end for

        $("#list tbody").html(result);  // 테이블 업데이트!

        // 페이지 정보 업데이트
        // $("#pageinfo").text(jsonObj.page + "/" + jsonObj.totalpage + "페이지, " + jsonObj.totalcnt + "개의 글");
        //

        // pageRows
        // var txt = "<select id='rows' onchange='changePageRows()'>\n";
        // txt += "<option " + ((window.pageRows == 5) ? "selected" : "") + " value='5'>5개씩</option>\n";
        // txt += "<option " + ((window.pageRows == 10) ? "selected" : "") + " value='10'>10개씩</option>\n";
        // txt += "<option " + ((window.pageRows == 15) ? "selected" : "") + " value='15'>15개씩</option>\n";
        // txt += "<option " + ((window.pageRows == 20) ? "selected" : "") + " value='20'>20개씩</option>\n";
        // txt += "</select>\n";
        // $("#pageRows").html(txt);


        // 페이징 업데이트
        // var pagination = buildPagination(jsonObj.writepages, jsonObj.totalpage, jsonObj.page, jsonObj.pagerows);
        // $("#pagination").html(pagination);

        return true;
    } else {
        alert(jsonObj.message);
        return false;
    }
    return false;
} // end updateList()


function deleteUid(h_uid) {
    var cuid = document.getElementById("CID").innerText;
    if (!confirm( "선택한 공고를 삭제 하시겠습니까?")) return false;

    // POST 방식
    $.ajax({
        url: "deleteOk.ajax",
        type: "POST",
        data: "h_uid=" + h_uid,
        cache: false,
        success: function (data, status) {
            if (status == "success") {
                if (data.status == "OK") {
                    Swal.fire({
                        icon: 'success',
                        title: 'Delete Success',
                        text: 'Show list',
                        buttons : {
                            confirm : {
                                text : 'OK',
                                value : true
                            }
                        }

                    })
                    loadPage(cuid);
                } else {
                    alert("DELETE 실패" + data.message);

                }
            }
        }

    });

    return false;


} // end deleteUid(uid)




// function buildPagination(writePages, totalPage, curPage, pageRows) {
//
//     var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성
//
//     // 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
//     var start_page = ((parseInt((curPage - 1) / writePages)) * writePages) + 1;
//     var end_page = start_page + writePages - 1;
//
//     if (end_page >= totalPage) {
//         end_page = totalPage;
//     }
//
//     //■ << 표시 여부
//     if (curPage > 1) {
//         str += "<li><a onclick='loadPage(1)' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
//     }
//
//     //■  < 표시 여부
//     if (start_page > 1)
//         str += "<li><a onclick='loadPage(" + (start_page - 1) + ")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
//
//     //■  페이징 안의 '숫자' 표시
//     if (totalPage > 1) {
//         for (var k = start_page; k <= end_page; k++) {
//             if (curPage != k)
//                 str += "<li><a onclick='loadPage(" + k + ")'>" + k + "</a></li>\n";
//             else
//                 str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
//         }
//     }
//
//     //■ > 표시
//     if (totalPage > end_page) {
//         str += "<li><a onclick='loadPage(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
//     }
//
//     //■ >> 표시
//     if (curPage < totalPage) {
//         str += "<li><a onclick='loadPage(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
//     }
//
//     return str;
//
//
// } // end buildPagination()
//
//
// function changePageRows() {
//     window.pageRows = $("#rows").val();
//     loadPage(window.page);
// }
//
//
//


function chkUpdate() {
    frm = document.forms['chkUpdate'];
    var h_uid=frm["h_uid"].value.trim();
    var h_name = frm["h_name"].value.trim();
    var h_title = frm["h_title"].value.trim();
    var h_career = frm["h_career"].value.trim();
    var h_position1 = frm["h_position1"].value.trim();
    var h_position2 = frm["h_position2"].value.trim();
    var h_part = frm["h_part"].value.trim();
    var h_degree= frm["h_degree"].value.trim();
    var h_workform = frm["h_workform"].value.trim();
    var h_salary= frm["h_salary"].value.trim();
    var h_content= frm["h_content"].value.trim();
    var h_upDate= frm["h_upDate"].value.trim();
    var h_regDate= frm["h_regDate"].value.trim();

    if (h_name == "") {
        alert("기업명 반드시 작성해야 합니다");
        frm["h_title"].focus();
        return false;
    }
    if (h_title == "") {
        alert("공고 제목 반드시 작성해야 합니다");
        frm["h_title"].focus();
        return false;
    }
    if (h_salary == "") {
        alert("급여 반드시 작성해야 합니다");
        frm["h_salary"].focus();
        return false;
    }
    if (h_position2 == "") {
        alert("모집내용 반드시 작성해야 합니다");
        frm["h_position2"].focus();
        return false;
    }
    if (h_part == "") {
        alert("직무 반드시 작성해야 합니다");
        frm["h_part"].focus();
        return false;
    }
    if(h_content ==""){
        ("모집내용 반드시 작성해야 합니다");
        frm["h_content"].focus();
        return false;
    }
    return true;
}
