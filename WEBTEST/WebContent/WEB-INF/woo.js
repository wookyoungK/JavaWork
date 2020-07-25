var page = 1  // 현재 페이지
var pageRows = 10   // 한 페이지에 보여지는 게시글 개수
var viewItem = undefined;   // 가장 최근에 view 한 글 데이터

$(document).ready(function () {

    // 게시판 목록 1페이지 로딩
    loadPage(page);


    $('#position2').hide();
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
    $("#upDate").datepicker();
    $("#regDate").datepicker();

    // From의 초기값을 오늘 날짜로 설정
    $('#upDate').datepicker('setDate', 'today'); // (-1D:하루전, -1M:한달전,
    // -1Y:일년전), (+1D:하루후,
    // -1M:한달후, -1Y:일년후)
    // To의 초기값을 내일로 설정
    $('#regDate').datepicker('setDate', '+1D'); // (-1D:하루전, -1M:한달전,
    // -1Y:일년전), (+1D:하루후,
    // -1M:한달후, -1Y:일년후)

    $('#position1').on('change', function () {
        $('#position2').show();

    })

    $("#endDate").change(function () {
        if ($("#endDate").is(":checked")) {
            $('#h_date').show();
        } else {
            $('#h_date').hide();
        }
    });

});

function chkSubmit() {
    frm = document.forms["frm"];
    var C_UID = frm["C_UID"].value.trim();
    var name = frm["name"].value.trim();
    var title = frm["title"].value.trim();
    var salary = frm["salary"].value.trim();
    var part = frm["part"].value.trim();
    var position1 = frm["position1"].value.trim();
    var position2 = frm["position2"].value.trim();

    var career_count = document.getElementsByName("career").length;
    var degree_count = document.getElementsByName("degree").length;
    var workform_count = document.getElementsByName("workform").length;
    var upDate = frm["upDate"].value.trim();
    var regDate = frm["regDate"].value.trim();
    /*    var upDate_count = document.getElementsByName("datepicker").length;
        var regDate_count = document.getElementsByName("datepicker2").length;*/

    for (var i = 0; i < career_count; i++) {
        if (document.getElementsByName("career")[i].checked == true) {
            var career = frm["career"].value.trim();
        }
    }
    for (var i = 0; i < degree_count; i++) {
        if (document.getElementsByName("degree")[i].checked == true) {
            var degree = frm["degree"].value.trim();
        }
    }
    for (var i = 0; i < workform_count; i++) {
        if (document.getElementsByName("workform")[i].checked == true) {
            var workform = frm["workform"].value.trim();
        }
    }


    if (name == "") {
        alert("이름 반드시 작성해야 합니다");
        frm["title"].focus();
        return false;
    }
    if (title == "") {
        alert("이름 반드시 작성해야 합니다");
        frm["title"].focus();
        return false;
    }
    if (salary == "") {
        alert("직책 반드시 작성해야 합니다");
        frm["salary"].focus();
        return false;
    }
    if (position2 == "") {
        alert("직책 반드시 작성해야 합니다");
        frm["position2"].focus();
        return false;
    }
    if (part == "") {
        alert("직책 반드시 작성해야 합니다");
        frm["part"].focus();
        return false;
    }


}


function chkDelete(uid) {
    // 삭제 여부, 다시 확인 하고 진행하기
    var r = confirm("삭제하시겠습니까?");
    if (r) {
        location.href = 'deleteOk.do?uid=' + uid;
    }
    ;
};














// page 번째 페이지 로딩
function loadPage(page){

    $.ajax({
        url : "list.do?page=" + page + "&pageRows=" + pageRows
        , type : "GET"
        , cache : false
        , success : function(data, status){
            if(status == "success"){
                //alert("AJAX 성공: 받아쮸~");

                if(updateList(data)){

                    // 업데이트된 list 에 필요한 이벤트 가동
                    addViewEvent();
                    // ★ 만약 위 코드를 $(document).ready() 에 두면 동작 안할것이다.!
                }
            }
        }
    });
} // end loadPage()

//
function updateList(jsonObj){
    result = "";

    if(jsonObj.status == "OK"){

        var count = jsonObj.count;

        // 전역변수 업데이트!
        window.page = jsonObj.page;
        window.pageRows = jsonObj.pagerows;

  /*      var i;
        var items = jsonObj.data;   // 배열
        for(i = 0; i < count; i++){
            result += "<tr>\n";
            result += "<td><input type='checkbox' name='uid' value='" + items[i].uid + "'></td>\n";
            result += "<td>" + items[i].uid + "</td>\n";
            result += "<td><span class='subject' data-uid='" + items[i].uid + "'>" + items[i].subject + "</span></td>\n";
            result += "<td>" + items[i].name + "</td>\n";
            result += "<td><span data-viewcnt='" + items[i].uid + "'>" + items[i].viewcnt + "</span></td>\n";
            result += "<td>" + items[i].regdate + "</td>\n";
            result += "</tr>\n";
        } // end for
        $("#list tbody").html(result);  // 테이블 업데이트!*/

        // 페이지 정보 업데이트
        $("#pageinfo").text(jsonObj.page + "/" + jsonObj.totalpage + "페이지, " + jsonObj.totalcnt + "개의 글");

        // pageRows
        var txt = "<select id='rows' onchange='changePageRows()'>\n";
        txt += "<option " + ((window.pageRows == 10)?"selected":"") + " value='10'>10개씩</option>\n";
        txt += "<option " + ((window.pageRows == 20)?"selected":"") + " value='20'>20개씩</option>\n";
        txt += "<option " + ((window.pageRows == 50)?"selected":"") + " value='50'>50개씩</option>\n";
        txt += "<option " + ((window.pageRows == 100)?"selected":"") + " value='100'>100개씩</option>\n";
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


function buildPagination(writePages, totalPage, curPage, pageRows){

    var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성

    // 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
    var start_page = ( (parseInt( (curPage - 1 ) / writePages ) ) * writePages ) + 1;
    var end_page = start_page + writePages - 1;

    if (end_page >= totalPage){
        end_page = totalPage;
    }

    //■ << 표시 여부
    if(curPage > 1){
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
    if (totalPage > end_page){
        str += "<li><a onclick='loadPage(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }

    //■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='loadPage(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }

    return str;



} // end buildPagination()


function changePageRows(){
    window.pageRows = $("#rows").val();
    loadPage(window.page);
}
