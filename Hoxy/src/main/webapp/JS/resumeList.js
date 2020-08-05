
$('button[id^="btn-delete_"]').on('click',function () {
    var id = $(this).attr('id').split("_")[1];

    $.ajax({
        url: "/resume/resumeDeleteOk/" + id,
        processData: false,
        contentType: false,
        type: 'GET',
        success: function () {
            Swal.fire({
                icon: 'success',
                title: 'complete',
                text: 'Delete Sucess!',
            }).then((result) => {
                if(result){
                    location.href = "resumeList";
                }
            })
        }
        ,
        error: function ( ) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: 'Delete Fail!',
            })
        }
    });
})

$('button[id^="resumeUpdate_"]').on('click',function () {
    var id = parseInt($(this).attr('id').split("_")[1]);

    location.href = "resumeUpdate/" + id;
})

