
$('#btn-upload').on('click', function () {
    console.log('btn-upload');
    var form3 = new FormData(document.getElementById('uploadForm'));

    if($('#file-name').val() == ""){
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: '파일을 선택해주세요!',
        })
    } else {
        $.ajax({
            url: "/resume/upload",
            data: form3,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            success: function () {
                Swal.fire({
                    icon: 'success',
                    title: 'complete',
                    text: 'Upload Sucess!',
                })
            },
            error: function ( ) {
                Swal.fire({
                    icon: 'error',
                    title: 'Warning',
                    text: 'Upload Fail!',
                })
            }
        });
    }
});

$('input[type="file"]').change(function(e){
    var fileName = e.target.files[0].name;
    $('.custom-file-label').html(fileName);
});

$('#selectStatus').change(function(){
    $('#resumeStatus').val($('#selectStatus option:selected').text());
})

// 주소찾기---------------------------------------------------------------------------
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function juso() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            var addr1 = "";

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('basicAddrs').value = data.zonecode + " " + roadAddr + " " + data.jibunAddress;
            // document.getElementById("sample4_roadAddress").value = roadAddr;
            // document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("basicAddrs2").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            // var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            // if(data.autoRoadAddress) {
            //     var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
            //     guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
            //     guideTextBox.style.display = 'block';

            // } else if(data.autoJibunAddress) {
            //     var expJibunAddr = data.autoJibunAddress;
            //     guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
            //     guideTextBox.style.display = 'block';
            // } else {
            //     guideTextBox.innerHTML = '';
            //     guideTextBox.style.display = 'none';
            // }
        }
    }).open();
}


$('.DOC_TEXT').keyup(function (e){
    var content = $(this).val();
    $('#counter').html("("+content.length+" / 최대 1000자)");    //글자수 실시간 카운팅

    if (content.length > 1000){
        Swal.fire({
            icon: 'error',
            title: '글자수 제한을 초과하였습니다.',
            text: '1000자까지만 입력이 가능합니다.',
        })
        $(this).val(content.substring(0, 1000));
        $('#counter').html("(1000 / 최대 1000자)");
    }
});
$('#selectJopType').change(function(){
    $('#HopeJobType').val($('#selectJopType option:selected').text());
})

$('#option1').change(function () {
    $(this).attr('name',"optionSelected");

    $('#option2').attr('name',"notSelected");
})

$('#option2').change(function () {
    $(this).attr('name',"optionSelected");

    $('#option1').attr('name',"notSelected");
})


$('#resumeUpdate').on('click',function () {
    var form1 = new FormData(document.getElementById('form1'));

    $.ajax({
        url: "/resume/resumeUpdateOk",
        data: form1,
        processData: false,
        contentType: false,
        type: 'POST',
        success: function () {
            Swal.fire({
                icon: 'success',
                title: 'complete',
                text: 'Upload Sucess!',
            }).then((result) => {
                if(result){
                    location.href = "../resumeList";
                }
            })
        }
        ,
        error: function ( ) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: 'Upload Fail!',
            })
        }
    });
})

