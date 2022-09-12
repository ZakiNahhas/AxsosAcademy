// // Always Hungry

// function alwaysHungry(arr) {
//     var arr;
//     for(i = 0; i < arr.length; i++) {
//         if(arr[i] === "food") {
//             console.log("yummy");
//         } else {
//             console.log("I'm hungry");
//         }
//     } return arr;
// }
// var z = alwaysHungry([1244, "food", "pie", true, "food"]);
// console.log(z);

// HighPass filter

function highPass(arr, cutoff) {
    var filteredArr = [];
    for (i =0; i < arr.length; i++) {
        if(arr[i] > cutoff) {
            arr[i] += filteredArr;
        }
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // we expect back [6, 8, 10, 9]
