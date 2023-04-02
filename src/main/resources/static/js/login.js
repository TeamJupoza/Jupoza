// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"

$('#loginBtn').click(function () {

    $.ajax({
        type: 'POST',
        url: '/user/login',
        contentType: 'application/json',
        data: JSON.stringify({
            'userId': $("#userId").val(),
            'userPassword': $("#userPassword").val()
        })
        ,
        success: function (response)
        {
            localStorage.clear()
            localStorage.setItem("accessToken","Bearer " + response['accessToken']);
            localStorage.setItem("userId", $("#userId").val())
            alert("로그인에 성공했습니다.")
            location.replace("/category")
        },
        error: function (response) {
            console.log(response)
            alert("로그인에 실패했습니다.")

        }

    })

})