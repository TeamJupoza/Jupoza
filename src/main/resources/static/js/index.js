// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"

let indexImgCount = 1


// portfolio 접속시 화면 페이지 구성 함수 실행
$(document).ready(function () {
    $("#indexImg").attr("src","/img/indexImg"+indexImgCount+".png")

});


$('#indexImgClick').click(function () {
    if (indexImgCount == 6)
    {
        location.replace("/list")
    }
    else
    {
        indexImgCount++
        $("#indexImg").attr("src","/img/indexImg"+indexImgCount+".png")
    }



})

