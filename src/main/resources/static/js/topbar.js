// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"





$(document).ready(function () {
    setTopBar()

});

function setTopBar() {

    let userId = localStorage.getItem("userId")
    let token = localStorage.getItem("accessToken")

    if((userId != "") && (token != "") )
    {
        if(ValidationUserInfo(userId, token) == "success")
        {
            // localstorage 에 toekn 과 id가 있을경우 Topbar에 유저 아이디와 로그아웃 버튼 세팅
            setTopBarWithUser()
        }
        else
        {
            // localstorage 에 token 과 id가 없을경우 로그인 회원가입 버튼 링크 생성
            setTopBarWithoutUser()
        }
    }
    else
    {
        setTopBarWithoutUser()
    }



}

function ValidationUserInfo(userId, token) {
    let result = ""
    // 서버로 부터 아이디와 비밀번호가 맞는지 확인
    $.ajax({
        type: 'GET',
        url: '/user/validation/'+userId,
        async:false,
        beforeSend: function (xhr)
        {
            xhr.setRequestHeader("Content-type","application/json");
            xhr.setRequestHeader("Authorization",token);
        }
        ,
        success: function (response) {
            // 아이디와 비밀번호가 맞을경우
            result= "success"
        }
        ,
        // 아이디와 비밀번호가 틀릴경우
        error : function (response) {
            result = "fail"
        }

    })
    console.log("result : ",result)
    return result
}

// localStorage에 유저정보가 있고 validation 이 맞을경우 실행 -> 유저아이디 정보, 로그아웃 버튼 생성
function setTopBarWithUser() {
    $('#topbar').append(`
        <!-- Topbar -->
    <nav class="navbar navbar-expand navbar-light bg-white topbar  static-top shadow">
        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
    
        <div class="eight">
            <h1>Stock Portfolio Advisory</h1>
        </div>
    
    
        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">
            <!-- Nav Item - User Information -->
            <span id ="TopbarUserId"></span>
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="mr-2 d-none d-lg-inline text-gray-600 small" id="topbarUserId">${localStorage.getItem("userId")}님</span>
                    <img class="img-profile rounded-circle"
                         src="img/undraw_profile.svg">
                </a>
                <!-- Dropdown - User Information -->
                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                     aria-labelledby="userDropdown">
    
                    <a class="dropdown-item"  id = "logoutBtn">
                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                        Logout
                    </a>
                </div>
            </li>
    
    </nav>
    <!-- End of Topbar -->
`)

    $('#logoutBtn').click(function () {
        if(confirm("정말로 로그아웃 하겠습니까?")) {
            localStorage.clear()
            location.reload()
        }

    })



}
// localstorage에 유저정보 없거나 validation이 실패한경우 -> localstorage 정보 삭제, 회원가입 로그인 버튼 생성
function setTopBarWithoutUser() {
    $('#topbar').append(`
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar  static-top shadow">
                <!-- Nav Item - Search Dropdown (Visible Only XS) -->

                <div class="eight">
                    <h1>Stock Portfolio Advisory</h1>
                </div>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">
                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="/login"  role="button"
                            aria-haspopup="true" aria-expanded="false">
                            <span class="  text-gray-600 small">로그인</span>
                        </a>
                    </li>
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="/register"  role="button"
                           aria-haspopup="true" aria-expanded="false">
                            <span class="  text-gray-600 small">화원가입</span>
                        </a>
                    </li>
            </nav>
            <!-- End of Topbar -->
`)


}

