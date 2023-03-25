// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"

let dataTable
$(document).ready(function () {
    setTable()
    articleFormValidation()


});

$('#dataTable').on('click', 'td', function () {
    let data = dataTable.cell(this, 0).data()
    console.log(data)
})


function setTable() {

    dataTable = $('#dataTable').DataTable({
        responsive: true,
        "ajax":
            {
                "url": "/article/api/get-all-articles",
            },
        columns: [
            {data: "articleId"},
            {
                data: "title",
                render: function (data, type, row, meta) {
                    if (type === 'display') {
                        data = '<a style="color:blue;" href="/articledetail/'  +row['articleId'] + '">' + data + '</a>';
                    }
                    return data;
                }
            }
            ,
            {data: "createdBy"},
            {data: "createdAt"}
        ]
    })
}

function articleFormValidation() {
    $.ajax({
        type: 'GET',
        url: 'article/api/article-form/validation/'+localStorage.getItem("userId"),
        async:false,
        beforeSend: function (xhr)
        {
            xhr.setRequestHeader("Content-type","application/json");
            xhr.setRequestHeader("Authorization",localStorage.getItem("accessToken"));
        }
        ,
        success: function (response) {
            $("#articleFormBtn").append(`
                    <a href="/articleform" class="btn btn-primary" id="toArticleForm" style="color: white">글쓰기</a>
            `)
        }
        ,
        // 아이디와 비밀번호가 틀릴경우
        error : function (response) {
            result = "fail"
        }

    })

}


