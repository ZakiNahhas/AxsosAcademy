var text = "Mega Bish";
var element = document.querySelector("h2");
function func1() {
    
    element.innerText = text;
}
var count = 2;
var remove = document.getElementById('.icon');
function hide() {
    count--;
    document.getElementById("del").remove();
    
    document.getElementById("count1").innerText= count;
}
counter2=500;
function hide1() {
    count--;
    document.getElementById("del").remove();
    counter2+=1;
    document.getElementById("count22").innerText= counter2 + "+";
    document.getElementById("count1").innerText= count;
}