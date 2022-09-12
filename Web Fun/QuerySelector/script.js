function setActive(element) {
    console.log(element.classList);
    if(element.classList.contains("dark-mode")) {
        element.innerText = "Switch to dark mode";
        element.classList.remove("dark-mode");
    } else {
        console.log(element);
        element.innerText = "Switch to light mode";
        element.classList.add("dark-mode");
    }
}


var count = 1;
var countElement = document.querySelector("#count");
console.log(countElement);
function add1() {
    count++;
    countElement.innerText = "The count is: " + count;
    console.log(count);
}

function subtract1() {
    count--;
    countElement.innerText = "The count is: " + count;
    console.log(count);
}

