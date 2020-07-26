$(document).ready(function () {


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










