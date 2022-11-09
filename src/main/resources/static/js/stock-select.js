const form = document.querySelector('form');
const button = document.querySelector('button');
//const stockId = document.getElementById('selectStock');
const selected = document.getElementById('selectedStock');
//const stock = document.getElementsByName('stock');
let itemsArray = localStorage.getItem('items')?JSON.parse(localStorage.getItem('items')): [];

localStorage.setItem('items', JSON.stringify(itemsArray));
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





/*stockId.addEventListener('click', function (e){
    e.preventDefault();
    itemsArray.push(stock.value);
    localStorage.setItem('items', JSON.stringify(itemsArray));
    buttonMaker(stock.value);
});*/

