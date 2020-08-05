$(document).ready(function () {


    $('div[id^="nav_box"]').click(function() {
        $('div[id^="nav_box"]').removeClass('ID');
        $(this).addClass('ID');

        var scrollPosition = $(".ID").offset().top;

        $("body").animate({
            scrollTop: scrollPosition
        }, 500);
    })


});
