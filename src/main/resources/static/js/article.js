// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"


let dataTable
$(document).ready(function () {
    setTable()


});

$('#dataTable').on('click', 'td', function () {
    let data = dataTable.cell(this, 0).data()
    console.log(data)
})


$('#toArticleForm').click(function () {
    location.replace("/articleform")
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
        ],
        buttons: [
            {
                text: '글쓰기',
                action: function ( e, dt, node, config ) {
                    alert( 'Button activated' );
                }
            }
        ]
    })
}


