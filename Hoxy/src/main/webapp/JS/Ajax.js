$(document).ready(function () {

    f();

});

function f() {

    var q = document.getElementById("location").value.trim();

    //ajax 시작
    //adress
    $.ajax({
        url: 'https://dapi.kakao.com/v2/local/search/address.json',
        headers: {'Authorization': 'KakaoAK 96456f6d0e5f0db221b5025473bb3a0e'},
        type: 'GET',
        data: {'query': q},
        success: function (data) {
            //호출 성공하면 작성할 내용
            if (data.documents.length != 0) { // 값이 있으면
                parseJSON(data)

            }
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    }).done(function (data) {
        console.log(data);
    });


}

function parseJSON(jsonObj) {
    var x = jsonObj.documents[0].x;
    var y = jsonObj.documents[0].y
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(y, x), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다
    var markerPosition  = new kakao.maps.LatLng(y, x);

// 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

// 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

}