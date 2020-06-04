function showData(){
        var result = "측정결과<br>";
        var frm =document.forms.myform1;
        
        var gender = "";
            for(i=0; i < frm["gender"].length; i++){
                if(frm["gender"][i].checked){
                  gender += frm["gender"][i].value;
                break; //어차피 하나일테니까.
              }
            }
        var key = frm["key"].value.trim(); 
    
            if(isNaN(key) || frm['key'].value.trim() == "" ){
                alert("키가 유효한값이 아닙니다\n숫자만 입력");
                return false;
            }


        var weight = frm["weight"].value.trim(); 
        if(isNaN(weight) || frm['weight'].value.trim() =="" ){
            alert("몸무게가 유효한값이 아닙니다\n숫자만 입력");
            return false;
        }
    

        result += "\n"+"<br>"+"키: " + key+"cm" + "<br>";
        result +="\n"+"<br>"+"성별: " + gender + "<br>";
        result += "\n"+"<br>"+"몸무게: " + weight +"kg"+ "<br>";
        
        // ------------------------- bmi 계산----------------
        var cm, kg;
        var kg = frm["weight"].value.trim(); 
        var cm  =frm["key"].value.trim();
        cm =cm *0.01;
        bmi = kg/(cm*cm); 
        if(bmi>0)
        {
            result +="BMI: " + bmi;
        }else{
          alert("잘못된값입니다")
        }
        document.getElementById("result").innerHTML =result;
        
  
}//end showData 데이터 보여주기 (join.html)



//-----------------------------사진전환--------------------

$(document).ready(function(){
    function slide(){
    $("#a").hide();
    $("#b").hide();
    $("#c").hide();
    $("#d").hide();
        
    $("#a").fadeIn(0)
    $("#a").delay(2000).fadeOut(1000)
    $("#b").delay(2000).fadeIn(1000).promise()
    .then(function(){
        $("#b").delay(2000).fadeOut(1000)
        return $("#c").delay(2000).fadeIn(1000).promise()
    })
    
    .then(function(){
        $("#c").delay(3000).fadeOut(1000)
        return $("#d").delay(2000).fadeIn(1000).promise()
    })
    .then(function(){
        $("#d").delay(2000).fadeOut(1000)
        return $("#a").delay(2000).fadeIn(1000).promise()
    })
    
    .then(slide)
    }   
    slide()
}) // 사진slide function  --introduce.html


//-----------------------------맵--------------------
    var marker;
    function initMap() {
      var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 17,
        center: {lat: 37.2953901, lng: 126.9814657}
      });
    //   var image= 여기에 내가원하는그림넣어주면됨
      marker = new google.maps.Marker({
        map: map,
        draggable: true,
        animation: google.maps.Animation.BOUNCE,
        position: {lat: 37.2953901, lng: 126.9814657}
      });
      marker.addListener('click', toggleBounce);
    }

    function toggleBounce() {
      if (marker.getAnimation() !== null) {
        marker.setAnimation(null);
      } else {
        marker.setAnimation(google.maps.Animation.BOUNCE);
      }
    }
 

    $(document).ready(function(){

        $("#btn01").click(function(){
            $("div#d01").animate({right: '250px'});
        });
    });

    // ----------------------------------------------------
  $(document).ready(function(){

    $("#side1").mouseenter(function(){
      $(this).animate({width: '130px'}, 1000)

    })

    $("#side1").mouseleave(function(){
      $(this).animate({width: '60px'}, 1000)
    })
      
      $("#side2").mouseenter(function(){
        $(this).animate({width: '130px'}, 1000)
        
      })
      
      $("#side2").mouseleave(function(){
        $(this).animate({width: '60px'}, 1000)
      
      })
      // 주의: animate() 는 색상에 대해서는 애니메이션 안한다
		
  });

  

//-------------------팝업--------------
var modal = document.getElementById("myModal");
var btn =document.getElementById("myBtn");
var span =document.getElementsByClassName("close")[0];

// 버튼 클릭하면 팝업 보이게 하기
btn.onclick = function(){
  modal.style.display = "block";

}

//팝업의 x 버튼 누르면 닫히게 하기
span.onclick = function(){
  modal.style.display ="none";
}

//팝업 창 바깥을 클릭해도 팝업이 닫히게 하기(modal) <-->(반대: modaless)
window.onclick = function(event){
  //event.target : event 발생한 element 객체
  if(event.target == modal){
    modal.style.display="none";
  }
}