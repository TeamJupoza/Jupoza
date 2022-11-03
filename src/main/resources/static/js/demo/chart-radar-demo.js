// Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
// Chart.defaults.global.defaultFontColor = '#858796';

var ctx = document.getElementById('radarChart')
const data = {
    labels: [
        'Eating',
        'Drinking',
        'Sleeping',
        'Designing',
        'Coding',
        'Cycling',
        'Running'
    ],
    datasets: [{
        label: 'My First Dataset',
        data: [65, 59, 90, 81, 56, 55, 40],
        fill: true,
        backgroundColor: 'rgba(255, 99, 132, 0.2)',
        borderColor: 'rgb(255, 99, 132)',
        pointBackgroundColor: 'rgb(255, 99, 132)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgb(255, 99, 132)'
    }, {
        label: 'My Second Dataset',
        data: [28, 48, 40, 19, 96, 27, 100],
        fill: true,
        backgroundColor: 'rgba(54, 162, 235, 0.2)',
        borderColor: 'rgb(54, 162, 235)',
        pointBackgroundColor: 'rgb(54, 162, 235)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgb(54, 162, 235)'
    }]
};


const config3 = {
    type: 'radar',
    data: data,
    options: {
        scales: {
            r: {
                suggestedMin: 0,
                suggestedMax: 100,
                stepSize: 10,
                grid: {
                    color: 'white',
                    lineWidth: context => context.index == 9 ? "3" : "1"
                },
                ticks: {
                    beginAtZero: true,
                    color: 'white',
                    showLabelBackdrop: false // hide square behind text // 이부분이 숫자 label의 배경 부분.
                },
                angleLines: {
                    color: 'white' // 중심에서 라벨까지 줄 색상
                },
                pointLabels: {
                    color: 'white', // 라벨의 글씨 색상
                }
            },
        },
        plugins:{
            legend:{
                display:false // 최상단 라벨의 카테고리 안보이기.
            }
        }
    },
};

myRadarChart = new Chart(ctx, config3)