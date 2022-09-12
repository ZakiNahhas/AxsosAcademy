
var x=document.getElementById("count").innerText;
var z=parseInt(x);

var countElement = document.querySelector("#count");
console.log(countElement);
function add1() {
    z++
    countElement.innerText = z + " like(s)";
    console.log(z);
}