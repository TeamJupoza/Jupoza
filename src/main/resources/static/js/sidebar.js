$(document).ready(function () {
    $('#sidebar').append(`
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center"
               href="/">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">JUPOJA</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="/">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Main</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                    <!-- Heading -->
                    <div class="sidebar-heading">
                        Stock
                    </div>

                    <!-- Nav Item - Pages Collapse Menu -->
                    <li class="nav-item">
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                           aria-expanded="true" aria-controls="collapseTwo">
                            <i class="fas fa-fw fa-cog"></i>
                            <span>Category</span>
                        </a>
                        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                            <div class="bg-white py-2 collapse-inner rounded">
                                <h6 class="collapse-header">Stock Category:</h6>
                                <a class="collapse-item"
                                   href="list?category=per">저평가</a>
                                <a class="collapse-item"
                                   href="list?category=dividend">성장률</a>
                                <a class="collapse-item"
                                   href="list?category=rate">배당금</a>
                                <a class="collapse-item"
                                   href="list?category=score">안정성</a>
                                <a class="collapse-item"
                                   href="list?category=std">고위험</a>
                            </div>
                        </div>
                    </li>


                    <!-- Divider -->
                    <hr class="sidebar-divider">

                        <!-- Heading -->
                        <div class="sidebar-heading">
                            Result
                        </div>


                        <!-- Nav Item - Tables -->
                        <li class="nav-item">
                            <a class="nav-link" href="portfolio">
                                <i class="fas fa-fw fa-table"></i>
                                <span>Portfolio</span></a>
                        </li>
                        <!-- TODO : 내 포트폴리오 접속시 유저아이디 입력을 바꿔야함 -->
                        <li class="nav-item">
                            <a class="nav-link" href="myportfolio?userId=minsang">
                                <i class="fas fa-fw fa-table"></i>
                                <span>MyPortfolio</span></a>
                        </li>
                                                <li class="nav-item">
                            <a class="nav-link" href="article">
                                <i class="fas fa-fw fa-table"></i>
                                <span>포트폴리오 공유 게시판</span></a>
                        </li>
                        <!-- Divider -->
                        <hr class="sidebar-divider d-none d-md-block">

                            <!-- Sidebar Toggler (Sidebar) -->
                            <div class="text-center d-none d-md-inline">
                                <button class="rounded-circle border-0" id="sidebarToggle"></button>
                            </div>
        </ul>
    <!-- End of Sidebar -->
    `
)

});
