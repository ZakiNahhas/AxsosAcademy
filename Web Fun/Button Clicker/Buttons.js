var add = document.getElementById('add');
function hide(element) {
    element.style.display = "none";
    // or element.remove();
}
var elem = document.getElementById("btn");
function change(){
    if (this.value=="Login") elem.value = "Login";
    else this.value = "Logout";

}
function add1(element){
    
    if (element.innerText=="Login"){
        element.innerText="LogOut";
    }
    else
        element.innerText="Login";
}