// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"


$('#register-btn').click(function () {
    let title = $('#article-title').val()
    let content = $('#article-text').val()
    console.log(title)
    console.log(content)
    // TODO: 유저  인증 정보를 넣어줘야한다.
    let userId = "minsang"
    saveArticle(title,content,userId)

})

function saveArticle(title, content, userId) {

    $.ajax({
        type: 'POST',
        url: '/article/api/save',
        contentType: 'application/json',
        data: JSON.stringify({
            'title' : title,
            'userId' : userId,
            'content' : content
        })
        ,
        success: function (response) {
            if (response['result'] === 'success') {
                alert("글 등록에 성공했습니다.")
                location.replace("/")
            }
            else{
                alert("포트폴리오 등록에 실패했습니다.")
            }
        }

    })
}