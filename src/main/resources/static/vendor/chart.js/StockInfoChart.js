const chartConfig={
    data: data,
    ooptions:{}
}

const exposeChart=new Chart(
    document.getElementById(),
    chartConfig
);

let per = document.querySelectorAll('per');
let net = Number(document.getElementById('net').innerText);
let dividend = Number(document.getElementById('dividend').innerText);
let safety = Number(document.getElementById('safety').innerText);
let risk = Number(document.getElementById('risk').innerText);
let name= document.getElementById('stockName').innerText;


new Chart(document.getElementById('stockInfoChart'),{
    type:'radar',
    data: {labels: ['per', 'div', 'net', 'safety', 'high risk'],
        datasets:[
            {
                label: name,
                fill: true,
                backgroundColor: "rgba(179,181,198,0.2)",
                borderColor: "rgba(179,181,198,1)",
                pointBorderColor: "#fff",
                pointBackgroundColor: "rgba(179,181,198,1)",
                data:[per, net, dividend, safety, risk]
            }
        ]},
    options: {
        title:{
            display: true,
            text: name
        }
    }
});

/*
let per = Number(document.getElementById('per').innerText);
let net = Number(document.getElementById('net').innerText);
let dividend = Number(document.getElementById('dividend').innerText);
let safety = Number(document.getElementById('safety').innerText);
let risk = Number(document.getElementById('risk').innerText);
let name= document.getElementById('stockName').innerText;


new Chart(document.getElementById('stockInfoChart'),{
    type:'radar',
    data: {labels: ['per', 'div', 'net', 'safety', 'high risk'],
        datasets:[
            {
                label: name,
                fill: true,
                backgroundColor: "rgba(179,181,198,0.2)",
                borderColor: "rgba(179,181,198,1)",
                pointBorderColor: "#fff",
                pointBackgroundColor: "rgba(179,181,198,1)",
                data:[per, net, dividend, safety, risk]
            }
        ]},
    options: {
        title:{
            display: true,
            text: name
        }
    }
});
*/


