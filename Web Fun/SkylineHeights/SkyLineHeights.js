function SkyLine(arr) {
    newArr=[]=0;
    // if( arr[0] > 0){
    //     newArr.push(arr[0]);
    // }
    // else {
    //     newArr.pop(arr[0]);
    // }
    
    for(i = 0; i <arr.length; i++) {
        if(arr[i] > newArr[newArr.length-1]) {
            newArr.push(arr[i])
        }
    } return newArr;
}
var z = SkyLine([-1, 1, -2, 5, 7]);
newArr.splice(0,1);
console.log(z)