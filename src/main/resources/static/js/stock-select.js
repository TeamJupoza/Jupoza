const form = document.querySelector('form');
const button = document.querySelector('button');
const selected = document.getElementById('selectedStock');
const N = 5;
/** items라는 키값을 가진 로컬스토리지가 있는지 확인하고 localstorage에 넣을 배열 itemArray 생성**/
let itemsArray = localStorage.getItem('items')?JSON.parse(localStorage.getItem('items')): [];

localStorage.setItem('items', JSON.stringify(itemsArray)); //아이템이라는 키를가진 로컬스토리지에 itemArray값 넣기
const data = JSON.parse(localStorage.getItem('items')); //items라는 로컬스토리지 json parser해서 data값에 저장


/**담기를 눌렀을때 장바구니에 주식 버튼을 만드는 함수**/
const buttonMaker = (stock) => {
    const button = document.createElement('input'); //input태그 요소인 button 변수 생성
    button.type = 'button'; //input 태그에 type=button
    button.id = stock.id; //id=id
    button.value = stock.name; //value=name
    button.className = 'btn btn-primary'; //class=btn btn-primary

    //태그를 누르면 만든 button태그가 없어지고, itemArray에도 삭제되는 함수
    button.addEventListener('click', function (){ //input태그인 button에 onclick이벤트 설정
        this.remove(); //만든 태그 없어짐

        //localstorage는 value값들을 만질수있는 함수는 없기 때문에 value값에 해당하는 itemArray배열에서 해당하는 값을 찾아 삭제 후 나머지 것들로 새로운 itemArray를 만들어야됨
        itemsArray = itemsArray.filter((b) => b.id !== this.id); //itemArray에 해당하는 값이 있는지 확인하고 해당하는값만 제외시킴
        localStorage.setItem('items', JSON.stringify(itemsArray)); //제외된후 나머지 배열 localStorage에 저장

        //this.removeChild(this);
    });
    selected.appendChild(button); //selected 태그 밑에 만든 button변수 child로 추가

};
/** 해당하는 button 눌렀을때 장바구니에 담는 함수**/
function button_click(stockId, name){
    itemsArray.push({id:stockId, name:name}); //stockId, name값 객체로 itemArray배열에 넣음
    console.log(itemsArray);
    localStorage.setItem('items', JSON.stringify(itemsArray)); //itemArray값 localStorage에 넣음
    buttonMaker({id:stockId, name:name}); //button을 눌렀을때 장바구니칸에 보여주기 위한 buttonMaker함수 호출
};

data.forEach(item => {
    buttonMaker(item);
});
//무슨함수였는지 까먹었음..


function portfolio(){
            alert("등록 성공");
            location.replace("/portfolio")

}


function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
var str = getParameterByName('category');
var categoryN = document.getElementById('categoryN');
str = str.replace('net', '성장률');
str = str.replace('score', '안정성');
str = str.replace('std', '고위험');
str = str.replace('dividend', '배당금');
str = str.replace('per', '저평가');
categoryN.innerText=str;
document.write(categoryN.innerText);
/*stockId.addEventListener('click', function (e){
    e.preventDefault();
    itemsArray.push(stock.value);
    localStorage.setItem('items', JSON.stringify(itemsArray));
    buttonMaker(stock.value);
});*/