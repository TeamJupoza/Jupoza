const form = document.querySelector('form');
const button = document.querySelector('button');
const selected = document.getElementById('selectedStock');
const N = 5;
/** 로컬스토리지가 있는지 확인하고 생성**/
let itemsArray = localStorage.getItem('items')?JSON.parse(localStorage.getItem('items')): Array.apply(null, new Array(5)).map(Number.prototype.valueOf,0);

localStorage.setItem('items', JSON.stringify(itemsArray)); //아이템이라는 로컬스토리지에
const data = JSON.parse(localStorage.getItem('items'));

const buttonMaker = (stock) => {
    const button = document.createElement('input');
    button.type = 'button';
    button.id = stock.id;
    button.value = stock.name;
    button.className = 'btn btn-primary';
    //button.onclick= rowDel(this);
    button.addEventListener('click', function (){
        this.remove();

        itemsArray = itemsArray.filter((b) => b.id !== this.id);
        localStorage.setItem('items', JSON.stringify(itemsArray));

        //this.removeChild(this);
    });
    selected.appendChild(button);

};

function button_click(stockId, name){
    //e.preventDefault();
    itemsArray.push({id:stockId, name:name});
    console.log(itemsArray);
    localStorage.setItem('items', JSON.stringify(itemsArray));
    buttonMaker({id:stockId, name:name});
};

data.forEach(item => {
    buttonMaker(item);
});

function portfolio(){
    $.ajax({
        url: "portfolio",
        type: "POST",
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(itemsArray),
        success: function(data) {
            if (data == 1) {
                alert("등록 성공");
            } else {
                alert("등록 실패!");
            }
        }
    });
}





/*stockId.addEventListener('click', function (e){
    e.preventDefault();
    itemsArray.push(stock.value);
    localStorage.setItem('items', JSON.stringify(itemsArray));
    buttonMaker(stock.value);
});*/

