// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
// var myPieChart = new Chart(ctx)

config2 = {
    type: 'pie',
    data: {
        labels: ["삼성전자", "Sk 하이닉스", "CJ 제일제당", "LG 전자", "효성 화학"],
        datasets: [{
            data: [25, 10, 15, 30, 20],
            backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#02DE84', '#0AAAF5'],
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
                precision: 2
            }

        }
    }
}


myPieChart = new Chart(ctx, config2)