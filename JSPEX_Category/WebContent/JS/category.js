var parent = 0;
var depth = 1;

$(document).ready(function() {
	loadPage();
	$('select').on('change', function() {
		if ($(this).val() > 0) {
			parent = $(this).val();
			depth = $("select").index(this) + 2;
		}else{
			parent = -$(this).val();
			depth = $("select").index(this) + 1;
		}
		loadPage();

	})
});

function loadPage() {

	$.ajax({
		url : 'list.ajax',
		type : "POST",
		data : {
			parent : parent,
			depth : depth
		},
		cache : false,
		success : function(data, status) {
			if (status == "success") {
				updateList(data)
			} else {
				alert("ddd")
			}
		}
	})

	;
} // end loadPage()

function updateList(jsonObj) {
	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;
		var i;
		var j;
		var items = jsonObj.list; // 배열

		$('#mycate select:eq(' + (depth - 1) + ')').html("");
		$('#mycate select:eq(' + (depth - 1) + ')').append(
				"<option value='-" + parent + "'>" + "선택해주세요" + "</option>");
		for (i = 0; i < count; i++) {
			$('#mycate select:eq(' + (depth - 1) + ')').append(
					"<option value=" + items[i].uid + ">" + items[i].name
							+ "</option>");
		}
		$('#mycate select:eq(' + (depth - 1) + ')').removeAttr('disabled');
		for (j = depth; j <= 2; j++) {
			$('#mycate select:eq(' + j + ')').html("");
			$('#mycate select:eq(' + j + ')').attr("disabled", "disabled")
		}
		return true;

	} else {
		return false;
	}
	return false;
} // end updateList()
