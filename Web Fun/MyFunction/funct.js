var fruits = ["Banana", "Orange", "Apple", "Mango"] 
function addFirst(arr, variable) {
    var newArr =[];
    newArr[0]=variable;
    for(i = 0; i < fruits.length; i++) {
       newArr[i+1]=fruits[i];
        // fruits[0] = newArr;
    } return newArr;
}
var z = addFirst(fruits, "kiwi");
console.log(z);

// -----------------------

function removeAt(arr, position) {
    temp=arr[position];
    arr[position] = arr[arr.length -1];
    arr[arr.length -1] = temp;
    arr.pop();
    return arr;
}
console.log(removeAt(fruits, 0));