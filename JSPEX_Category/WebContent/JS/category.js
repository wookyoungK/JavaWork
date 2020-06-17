$(document).ready(function() {
   loadPage(page);
   $('#mycate').on('change', function() {
	   
   })
});

function loadPage(page) {
      $.ajax({
            url : 'http://localhost:8082/JSPEX_Category/list.ajax?depth= a &parent= b',
            type : "GET",
            cache : false,
            success : function(data, status) {
               if (status == "success") {
                  alert("AJAX 성공: 받아쮸~");

                  if (updateList(data)) {
                     addViewEvent();
                  }
               }
            }
         });
} // end loadPage()