$(document).ready(function(){



	var a = $.trim($('#a').html());
	


	loadPage(a);
	
	$("#frmWrite").submit(function(){
		
		return chkWrite();
	});
	
	
	var link = document.location.href;

	
	$('#copy_btn').click(function(){
		$.trim($('#copy_text_input').val(link));
		$('#copy_text_input').select() //복사할 텍스트를 선택
		document.execCommand("copy") //클립보드 복사 실행
		Swal.fire({
			icon: 'success',
			title: '복사 완료!',
			text: '현재 페이지의 링크 복사 완료.!',
			buttons : {
				confirm : {
					text : 'OK',
					value : true
				}
			}

		})
	})

	
   
	
	
	
	
});

function loadPage(page){

	$.ajax({
		
		url : "list.ajax?uid=" + page
		, type : "GET"
		, cache : false
		, success : function(data, status){
			
			if(status == "success"){
				
				if(updateList(data)){
					
					$(".deletebtn").click(function(){
						
						deleteUid($(this).attr('data-uid'));
						
						
					});
					
					$(".updatebtn").click(function(){
						
						$(".updatebtn").hide();
						$("#btnclick"+($(this).attr('updata-uid'))).css("marginTop", "0px")
						var lastcontent = $("#btnclick"+($(this).attr('updata-uid'))).html();

						var result = "";
							result += "<div class='input-group'>"
							result +=  "<textarea class='input newtextarea form-control' style='width: 50%; resize: none;'>"+lastcontent + "</textarea>"
							result += "<div class='input-group-append' id='button-addon4'>"
							result += "<button type='button' class='submitbtn btn btn-outline-secondary' com-uid='"+ ($(this).attr('updata-uid'))+ "'>수정완료</button><div class='output' style='display: none'></div>";
							result += "<button type='button' class='canclebtn btn btn-outline-secondary' com-uid='"+ ($(this).attr('updata-uid'))+ "'>취소</button>"
							result += "</div></div>"
						

					
						$("#btnclick"+($(this).attr('updata-uid'))).html(result);
						      
						      
						$(".input").keyup(function(){
							
							$(".output").text($(".input").val());
						})
					  $(".submitbtn").click(function(){


					  	      var content = $.trim($('.output').html());
							  var uid =(($(this).attr('com-uid')));

							  updateUid(uid,content);

						  })

						$(".canclebtn").click(function () {

							var content2 = $.trim($('.input').html());

							$(".updatebtn").show();
							$("#btnclick"+($(this).attr('com-uid'))).css("marginTop", "20px")
							$("#btnclick"+($(this).attr('com-uid'))).html(content2);
						})
						

						
						
					});
					
				
					
				
					
					// 업데이트된 list 에 필요한 이벤트 가동
					
					// ★ 만약 위 코드를 $(document).ready() 에 두면 동작 안할것이다.!
				}
				
			}			
		}
	});

}

function updateList(jsonObj){
	result = "";
	result2 = "";
	if(jsonObj.status == "OK"){




		var count = jsonObj.count;
		
		var i;
		var items = jsonObj.data;  
		for(i = 0; i < count; i++){
			var b = $.trim($('#us').html());
			var c = items[i].u_uid;
			result2 += "<div class='row border p3' style='height: 70px; margin-top: 10px'>\n";
			result2 += "<div class='col-md-1' style='margin-top: 20px;'><i class='fas fa-user-tie'></i></div>\n";
			result2 += "<div class='col-md-1' style='margin-top: 20px;'>" + "익명" + (i+1)+ "</div>\n";
			result2 += "<div class='col-md-6' id='btnclick"+ items[i].uid + "' style='margin-top: 20px;'>" + items[i].content + "</div>\n";
			result2 += "<div class='col-md-2' style='margin-top: 20px;'>" + items[i].regdate + "</div>\n";

			if(b == c) {

				result2 += "<div class='col-md-1'>" + "<button class='updatebtn border_btn' updata-uid='" + items[i].uid + "' type='button' style='margin-top: 20px'>수정</button> " + "</div>\n";
				result2 += "<div class='col-md-1'>" + "<button class='deletebtn border_btn' data-uid='" + items[i].uid + "' type='button' style='margin-top: 20px'>삭제</button> " + "</div>\n";
			} else {
				result2 += "<div class='col-md-1'></div>"
				result2 += "<div class='col-md-1'></div>"
			}

			result2 += "</div>\n"


			result += "<tr>\n";
			result += "<td class='retd'>" +"<i class='fas fa-user-tie'></i>" + "</td>\n";


			result += "<td class='retd2'>" + "익명 " +  (i+1)+ "]</td>\n";

			result += "<td id='btnclick"+ items[i].uid + "'>" + items[i].content + "</td>\n";

			result += "<td>" + items[i].regdate + "</td>\n";
			result += "<td>" + "<button class='updatebtn' updata-uid='"+ items[i].uid + "' type='button'>수정</button> "+  "</td>\n";
			result += "<td>" + "<button class='deletebtn' data-uid='"+ items[i].uid + "' type='button'>삭제</button> "+  "</td>\n";



			result += "</tr>\n";
		} // end for
		$("#list tbody").html(result);
		$("#ajaxin").html(result2);
		$("#replycnt").html("댓글수:" + count);
		return true;
	}
	
} // end updateList()


function chkWrite(){
	var data = $("#frmWrite").serialize();
	var c = $.trim($('#a').html());
	$.ajax({
		url : "writeOk.ajax",
		type : "POST",
		cache : false,
		data : data,  // POST 로 ajax request 하는 경우 parameter 담기
		success : function(data, status){
			if(status == "success"){
				
				if(data.status == "OK"){
				loadPage(c);
				
				} else {
					Swal.fire({
						icon: 'success',
						title: '등록 실패!',
						text: '로그인 페이지로 이동합니다.!',
						buttons : {
							confirm : {
								text : 'OK',
								value : true
							}
						}

					}).then((result) => {
						if(result){
							location.href = "../../user/login";
						}
					})
				}
			}
		}
	});
	
	
	$('#frmWrite')[0].reset();
	
	
	
	return false;
	
} // end chkWrite()

function deleteUid(uid){
	var c = $.trim($('#a').html());
	Swal.fire({
		title: '댓글을 삭제하시겠습니까?',
		text: "삭제시 복구되지 않습니다.",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'YES'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url : "deleteOk.ajax",
				type : "POST",
				data : "uid=" + uid,
				cache : false,
				success : function(data, status){
					if(status == "success"){
						if(data.status == "OK"){
							Swal.fire({
								icon: 'success',
								title: '삭제 성공!',
								text: '해당 댓글이 삭제되었습니다.',
								buttons : {
									confirm : {
										text : 'OK',
										value : true
									}
								}

							})
							loadPage(c); // 현재 페이지 리로딩
						} else {
							alert("DELETE 실패" + data.message);

						}
					}
				}

			});

		}
	})

	// POST 방식

	return false;
		
		
	
} // end deleteUid(uid)





function updateUid(uid,content){
	var c = $.trim($('#a').html());
	Swal.fire({
		title: '댓글을 수정하시겠습니까?',
		text: "수정시 복구되지 않습니다.",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'YES'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url : "updateOk.ajax",
				type : "POST",
				data : "uid=" + uid + "&content=" +content,
				cache : false,
				success : function(data, status){
					if(status == "success"){
						if(data.status == "OK"){
							Swal.fire({
								icon: 'success',
								title: '수정 성공!',
								text: '해당 댓글이 수정되었습니다.',
								buttons : {
									confirm : {
										text : 'OK',
										value : true
									}
								}

							})
							loadPage(c); // 현재 페이지 리로딩
						} else {
							alert("Update 실패" + data.message);

						}
					}
				}

			});
		}
	})



	
	return false;
		
} 
