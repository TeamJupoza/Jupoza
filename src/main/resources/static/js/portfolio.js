// Jquery Import
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
// 쿠키 사용을 위한 Jquery-cookie 임포트
src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"

// 요청을 보낼 포트폴리오 종목들
let RequestStocks = []
let ResponseStock
let ResponseWeight




// portfolio 접속시 화면 페이지 구성 함수 실행
$(document).ready(function () {
    //RequestStocks = ["삼성전자", "LG", "포스코케미칼", "현대차", "삼성중공업"]
    // 로컬스토리지에서 포트폴리오 변수들을 가져옴
    let storage = []
    storage = JSON.parse(localStorage.getItem('items'))
    console.log(typeof storage)
    for (let i = 0 ; i < 5; i++) {
        RequestStocks.push(storage[i]['name'])
    }
    console.log(RequestStocks)
    $("#outputBalanceCard").css("display","none")
    loadPortfolio()

});

$('#balanceBtn').click(function () {
    setBalance(Number($("#inputBalance").val()))
    $("#InputBalanceCard").css("display","none")
    $("#outputBalanceCard").css("display","block")


})


// 서버에서 포트폴리오 종목들의 정보(비중 + 종목 상세 정보)를 요청 하는 함수
function loadPortfolio() {
    console.log("ResopnseStocks" + RequestStocks)
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
                ResponseWeight = response.weights
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
    let data = ResponseWeight

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
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">${ResponseWeight[0]}</div>
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
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">${ResponseWeight[1]}</div>
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
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">${ResponseWeight[2]}</div>
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
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">${ResponseWeight[3]}</div>
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
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">${ResponseWeight[4]}</div>
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
    for (let i = 4; i >= 0; i--) {
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
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">포트폴리오 종합 지표</h6>
                    </div>
                <div class="card-body">
                    <div id = 'portfoliocard'>
                        <canvas id = "stockChart"></canvas>
                    </div>
                    </div>
                </div>   
    `)
    ctx = document.getElementById('stockChart')
    let myBarChart = new Chart(ctx, getConfig2(labels, dataset0 , dataset1, dataset2, dataset3, dataset4))


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
    let myBarChart2 = new Chart(ctx2, getConfig('포트폴리오 연간 순이익 상승률', label, net))
    let myBarChart3 = new Chart(ctx3, getConfig('포트폴리오 연간 매출 상승률', label, sale))
    let myBarChart4 = new Chart(ctx4, getConfig('포트폴리오 연간 배당율', label, dividend))

}

function getConfig(title, label, data) {
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
            plugins: {labels: {render: 'value'}}

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
                    backgroundColor: 'rgba(255, 206, 86, 0.5)',
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
            plugins: {labels: {render: 'value'}}

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


function getBalance(weight, balance) {
    // 포트폴리오 종목들의 balance
    let balance1 = balance * weight[0] / 100
    let balance2 = balance * weight[1] / 100
    let balance3 = balance * weight[2] / 100
    let balance4 = balance * weight[3] / 100
    let balance5 = balance * weight[4] / 100


    // 실현손익
    let sale1 = balance1 * ResponseStock[0]['sale'] / 100
    let sale2 = balance2 * ResponseStock[1]['sale'] / 100
    let sale3 = balance3 * ResponseStock[2]['sale'] / 100
    let sale4 = balance4 * ResponseStock[3]['sale']/ 100
    let sale5 = balance5 * ResponseStock[4]['sale']/ 100
    let sale = sale1 + sale2 + sale3 + sale4 + sale5

    // 배당 수익
    let dividend1 = balance1 * ResponseStock[0]['dividend'] / 100
    let dividend2 = balance2 * ResponseStock[1]['dividend'] / 100
    let dividend3 = balance3 * ResponseStock[2]['dividend'] / 100
    let dividend4 = balance4 * ResponseStock[3]['dividend'] / 100
    let dividend5 = balance5 * ResponseStock[4]['dividend'] / 100
    let dividend = dividend1 + dividend2 + dividend3 + dividend4 + dividend5

    // 총 자산

    let totalBalance = balance + sale + dividend

    let result = {"sale": sale, "dividend": dividend, 'totalBalance': totalBalance}
    console.log(result)
    return result

}

function setBalance(balance) {
    let result = getBalance(ResponseWeight,balance)
    $("#outputSale").text(Math.round(result.sale) + "만원")
    $("#outputDividend").text(Math.round(result.dividend) + "만원")
    $("#outputTotalBalance").text(Math.round(result.totalBalance) + "만원")
}