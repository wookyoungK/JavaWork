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
        var weight = frm["weight"].value.trim(); 
        if(isNaN(weight) || frm['weight'].value.trim() =="" ){
            alert(weight + "몸무게가 유효한값이 아닙니다\n숫자만 입력");
            return false;
        }
        result += "몸무게: " + weight +"kg"+ "<br>";
    

        var key = frm["key"].value.trim(); 

        if(isNaN(key) || frm['key'].value.trim() == "" ){
            alert(key + "키가 유효한값이 아닙니다\n숫자만 입력");
            return false;
        }
        result += "키: " + key+"cm" + "<br>";
        result +="성별: " + gender + "<br>";
        
        // ------------------------- bmi 계산----------------
        var cm, kg, bmi;
        var kg = frm["weight"].value.trim(); 
        var cm  =frm["key"].value.trim();
        cm =cm *0.01;
        bmi = kg/(cm*cm); 
        if(bmi>0)
        {
            result +="BMI: " + bmi;
        } 
        document.getElementById("result").innerHTML =result;

        return true;

        
        
}//end showData 데이터 보여주기 (join.html)

//-----------------------------사진전환--------------------
// $(document).ready(function(){

    
//     $("#a").hide();
//     $("#b").hide();
//     $("#c").hide();
//     $("#d").hide();
// })

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
            $("div#d01").animate({left: '250px'});
        });
    });

    // ----------------------------------------------------

    $("#btn06").click(function(){
        var div = $("div#d06");  
        div.animate({left: '100px', width:'200px'}, "slow");
        
		// 주의: animate() 는 색상에 대해서는 애니메이션 안한다
		
    });