function addShadow(element) {
    element.classList.add("shadow");
}
function removeShadow(element) {
    element.classList.remove("shadow");
}

function changeme(elem) {
    elem.src="bulbOn.png"
}
function myFunc(elem) {
    elem.src="bulbonOff.png"
}
function func1(el) {
    el.style.textDecoration="line-through";   
}

var paragraph = document.querySelector("h2")
var counter = 0;
function funct1 () {
    counter++;
    paragraph.innerText=counter;
    paragraph.style.border="1px solid black"
    paragraph.style.fontSize=counter+"px"
}
function funct2 () {
    counter--;
    paragraph.innerText=counter;
    paragraph.style.border="1px solid black"
    paragraph.style.fontSize=counter+"px"
}