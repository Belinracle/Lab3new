document.addEventListener("DOMContentLoaded",draw);
document.querySelector("form").addEventListener("submit",draw);
let pointPlace = document.querySelector(".pointPlace");
let map = new Map();
map.set("1","one")
map.set("2","two")
map.set("3","three")
map.set("4","four")
map.set("5","five")
function draw() {
    let tableRows = document.querySelectorAll("tbody tr");
    for (let i = 0; i < tableRows.length; i++) {
        let params = tableRows[i].childNodes;
        console.log(params[0].innerHTML)
        addPoint(computeX(params[0].innerHTML, params[2].innerHTML), computeY(params[1].innerHTML, params[2].innerHTML),map.get(params[2].innerHTML.replace(".0","")),params[5].innerHTML)
    }
}
function addPoint(x,y,r,result){
    let str ='<circle color="white" class="'+result+" "+r+'" r="3" cx="'+x+'" cy="'+y+'">';
    pointPlace.insertAdjacentHTML("afterbegin",str)
}
function computeX(x,r){
    return 250 + x / r * 200;
}
function computeY(y,r){
    return 250 - y / r * 200;
}