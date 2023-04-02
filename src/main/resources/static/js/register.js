// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"



$('#registerBtn').click(function () {

    $.ajax({
        type: 'POST',
        url: '/user/register',
        contentType: 'application/json',
        data: JSON.stringify({
            'userId': $("#userId").val(),
            'userPassword': $("#userPassword").val(),
            'userEmail': $("#userEmail").val(),
            'userNickname': $("#userNickname").val(),

        })
        ,
        success: function (response)
        {

            if (response['result'] === 'success') {
                alert("회원가입에 성공했습니다.")
                location.replace("/category")
            }
            else{
                alert("회원가입에 실패했습니다.")
            }
        }

    })

})