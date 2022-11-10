// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"

/*
    페이지 로딩시 5개 종목을 서버로 전송해 5개 종목의 정보를 받아오는 함수
 */

// portfolio 접속시 화면 페이지 구성 함수 실행
$(document).ready(function () {
    loadPortfolio()
});

// 요청을 보낼 포트폴리오 종목들
let RequestStocks = ["삼성전자", "SK하이닉스", "CJ제일제당", "LG전자", "효성화학"]
let ResponseStock

// 서버에서 포트폴리오 종목들의 정보(비중 + 종목 상세 정보)를 요청 하는 함수
function loadPortfolio() {
    $.ajax({
        type: "POST",
        url: "/api/portfolio",
        contentType: 'application/json',
        data: JSON.stringify({
            "RequestStock": RequestStocks
        }),
        success: function (response) {
            if (response['result'] === 'success') {
                console.log("hello")
                console.log(response)
                ResponseStock = response.stocks
                setPortfolio(ResponseStock)
            }


        }
    })

}

// 서버에서 받아온 포트폴리오 종목들의 정보를 이용해 포트폴리오 결과페이지를 꾸미는 함수
function setPortfolio(response) {
    setPieChart()
    portfolioWeightCard()
    setWeightChart()
    setPortfolioCards()
}


function setPieChart() {
    // Pie Chart Example
    var ctx = document.getElementById("myPieChart");

    let label = []
    let data = [20, 10, 15, 30, 20]

    for (i = 0; i < 5; i++) {
        label.push(ResponseStock[i]['name'])
        // data.push(20)
    }
    console.log(label)
    console.log(data)

    config2 = {
        type: 'pie',
        data: {
            labels: label,
            datasets: [{
                data: data,
                backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#f6c23e', '#e74a3b'],
                hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
                hoverBorderColor: "rgba(234, 236, 244, 1)",
            }],
        },

        options: {
            maintainAspectRatio: false,
            tooltips: {
                backgroundColor: "rgb(255,255,255)",
                bodyFontColor: "#858796",
                borderColor: '#dddfeb',
                borderWidth: 1,
                xPadding: 15,
                yPadding: 15,
                displayColors: false,
                caretPadding: 10,
            },
            legend: {
                position: 'top',
                fontColor: 'black',
                align: 'center',
                display: true,
                fullWidth: true,
                labels: {
                    fontColor: 'rgb(0, 0, 0)'
                }
            },
            plugins: {
                labels: {//두번째 script태그를 설정하면 각 항목에다가 원하는 데이터 라벨링을 할 수 있다.
                    render: 'value',
                    fontColor: 'black',
                    fontSize: 15,
                    precision: 1
                }

            }
        }
    }
    myPieChart = new Chart(ctx, config2)
}

function portfolioWeightCard() {
    //let card = document.getElementById('portfolioWeightCard')
    let card = $('#portfolioWeightCard')


    //1
    card.append(`
                        <div style="width: 100%; overflow: auto;" id = 'portfolioWeightCard'>
                            <div class="col-xl-3 col-md-6 mb-4 " style=" float: left; width: 20%;">
                                <div class="card border-left-primary shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                    ${ResponseStock[0]['name']}
                                                </div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">20%</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                   
                                    <div class="col-xl-3 col-md-6 mb-4 " style=" float: left; width: 20%;">
                                <div class="card border-left-success shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                    ${ResponseStock[1]['name']}
                                                </div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">10%</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                <div class="col-xl-3 col-md-6 mb-4 " style="float: left; width: 20%;">
                                <div class="card border-left-info shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-info text-xs font-weight-bold  text-uppercase mb-1">
                                                    ${ResponseStock[2]['name']}
                                                </div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">15%</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-comments fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                                <div class="col-xl-3 col-md-6 mb-4 " style="float: left; width: 20%;">
                                <div class="card border-left-warning shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                    ${ResponseStock[3]['name']}
                                                </div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">30%</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-comments fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                                    <div class="col-xl-3 col-md-6 mb-4 " style="float: left; width: 20%;">
                                <div class="card border-left-danger shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-danger text-uppercase mb-1">
                                                    ${ResponseStock[4]['name']}
                                                </div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">20%</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-comments fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
    `)


}


function setPortfolioCards() {
    let cards = $('#portfolioCards')
    let label = ['주가 상승률', '순이익 상승률', '매출 상승률', '연간 배당률']
    let labels = []
    for (let i = 0; i < 5; i++) {
        labels.push(ResponseStock[i]['name'])
    }
    let dataset0 = []
    let dataset1 = []
    let dataset2 = []
    let dataset3 = []
    let dataset4 = []

     dataset0 = getData(dataset0, 0)
     dataset1 = getData(dataset1, 1)
     dataset2 = getData(dataset2, 2)
     dataset3 = getData(dataset3, 3)
     dataset4 = getData(dataset4, 4)

        cards.append(`
            <div class="card shadow mb-4">
            <!-- Card Header - Accordion -->
            <a href="#card${i.toString()}" class="d-block card-header py-3" data-toggle="collapse"
               role="button"
               aria-expanded="true" aria-controls="card${i.toString()}">
                <h6 class="m-0 font-weight-bold text-primary">${ResponseStock[i]['name']}</h6>
            </a>
            <!-- Card Content - Collapse -->
            <div class="collapse" id="card${i.toString()}">
                <div class="card-body">
                
                <div id = 'portfoliocard'>
                    <canvas id = "stockChart"></canvas>
                </div>


                </div>
            </div>
        </div>`)
        ctx = document.getElementById('stockChart')
        let myBarChart = new Chart(ctx, getConfig2(labels, dataset0,dataset1,dataset2,dataset3,dataset4))


}

function setWeightChart() {
    let label = []
    let rate = []
    let net = []
    let dividend = []
    let sale = []
    for (let i = 0; i < 5; i++) {
        label.push(ResponseStock[i]['name'])
        rate.push(ResponseStock[i]['rate'])
        sale.push(ResponseStock[i]['sale'])
        net.push(ResponseStock[i]['net'])
        dividend.push(ResponseStock[i]['dividend'])
    }




    let ctx = document.getElementById("myBarChart");
    let ctx2 = document.getElementById("myBarChart2");
    let ctx3 = document.getElementById("myBarChart3");
    let ctx4 = document.getElementById("myBarChart4");
    let myBarChart = new Chart(ctx, getConfig('포트폴리오 연간 주가 상승률', label, rate))
    let myBarChart2 = new Chart(ctx2, getConfig('포트폴리오 연간 순이익 상승률',label, net))
    let myBarChart3 = new Chart(ctx3, getConfig('포트폴리오 연간 매출 상승률',label, sale))
    let myBarChart4 = new Chart(ctx4, getConfig('포트폴리오 연간 배당율', label, dividend))

}

function getConfig(title,label, data) {
    let config = {
        // The type of chart we want to create
        type: 'bar',
        // The data for our dataset
        data: {
            labels: label,
            datasets: [{
                label: title,
                backgroundColor:
                    [
                        'rgba(255, 99, 132, 0.5)',
                        'rgba(54, 162, 235, 0.5)',
                        'rgba(255, 206, 86, 0.5)',
                        'rgba(75, 192, 192, 0.5)',
                        'rgba(153, 102, 255, 0.5)',
                    ],
                borderColor:
                    [
                        'rgb(255, 99, 132,1.5)',
                        'rgba(54, 162, 235, 1.5)',
                        'rgba(255, 206, 86, 1.5)',
                        'rgba(75, 192, 192, 1.5)',
                        'rgba(153, 102, 255, 1.5)',
                    ],
                data: data
            }]
        },
        // Configuration options go here
        options: {

            legend: {
                labels: {
                    fontColor: 'rgba(83, 51, 237, 1)',
                    fontSize: 12
                }
            },
            scales: {
                xAxes: [{
                    ticks: {
                        fontColor: 'rgba(27, 163, 156, 1)',
                        fontSize: '12'
                    }
                }],
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                        fontColor: 'rgba(246, 36, 89, 1)',
                        fontSize: '12'
                    }
                }]
            },
            plugins: { labels: { render: 'value' } }

        }
    }
    return config

}

function getConfig2(label, dataset0, dataset1, dataset2, dataset3, dataset4) {
    let config = {
        // The type of chart we want to create
        type: 'bar',
        // The data for our dataset
        data: {
            labels: ['주가 상승률', '순이익 상승률', '매출 상승률', '연간 배당률'],
            datasets: [{
                label: label.pop(0),
                backgroundColor: 'rgba(255, 99, 132, 0.5)',
                borderColor: 'rgb(255, 99, 132,1.5)',
                data: dataset0
            },
            {
                label: label.pop(1),
                backgroundColor: 'rgba(54, 162, 235, 0.5)',
                borderColor: 'rgba(54, 162, 235, 1.5)',
                data: dataset1
            },
            {
                label: label.pop(2),
                backgroundColor:'rgba(255, 206, 86, 0.5)',
                borderColor: 'rgba(255, 206, 86, 1.5)',
                data: dataset2
            },
            {
                label: label.pop(3),
                backgroundColor: 'rgba(153, 102, 255, 0.5)',
                borderColor: 'rgba(75, 192, 192, 1.5)',
                data: dataset3
            },
            {
                label: label.pop(4),
                backgroundColor: 'rgba(75, 192, 192, 0.5)',
                borderColor: 'rgba(75, 192, 192, 0.5)',
                data: dataset4
            }]
        },
        // Configuration options go here
        options: {
            indexAxis: 'y',
            // Elements options apply to all of the options unless overridden in a dataset
            // In this case, we are setting the border of each horizontal bar to be 2px wide
            elements: {
                bar: {
                    borderWidth: 2,
                }
            },
            legend: {
                labels: {
                    fontColor: 'rgba(83, 51, 237, 1)',
                    fontSize: 12
                }
            },
            scales: {
                xAxes: [{
                    ticks: {
                        fontColor: 'rgba(27, 163, 156, 1)',
                        fontSize: '12'
                    }
                }],
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                        fontColor: 'rgba(246, 36, 89, 1)',
                        fontSize: '12'
                    }
                }]
            },
            plugins: { labels: { render: 'value' } }

        }
    }
    return config

}

function getData(dataset, i) {
    dataset.push(ResponseStock[i]['rate'])
    dataset.push(ResponseStock[i]['sale'])
    dataset.push(ResponseStock[i]['net'])
    dataset.push(ResponseStock[i]['dividend'])

    return dataset
}
