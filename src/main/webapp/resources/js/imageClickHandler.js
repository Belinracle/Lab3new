let svg = document.querySelector("svg");
let X = document.querySelector(".invX");
let Y = document.querySelector(".invY");
let R = document.querySelector(".invR");
let invForm = document.querySelector(".invisForm")
let sendButt = document.querySelector(".invSendButt")
document.querySelector(".image").addEventListener("click", function (event) {
    let pt = svg.createSVGPoint();
    pt.x = event.clientX;
    pt.y = event.clientY;
    let gp = pt.matrixTransform(svg.getScreenCTM().inverse())
    X.value = (gp.x - 250)/200*R.value;
    Y.value = (gp.y - 250)/(-200)*R.value;
    sendButt.click()
})
document.addEventListener("DOMContentLoaded", function() {
    document.querySelector("head").insertAdjacentHTML("beforeend", "<style></style>")
})
function setR(a){
    R.value=a;
    let b = String(a).replace(".0","")
    document.querySelector("head style").innerHTML = "circle:not(."+map.get(b)+"){display:none;}"
}
//<style></style>