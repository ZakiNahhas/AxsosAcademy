function removeNegatives(x) {
    const z = [];
    for (i = 0; i < x.length; i++) {
        if(x[i] > 0) {
            z.push(x[i]);
        }
    } 
    return z;
}
var o = removeNegatives([-2, 5, 4,-1]);
console.log(o);



console.log("without using looooooooooooooooooooooooops:");
var c= [-4, 9, 5, -2,-2,7,12,-4]; 

function positive(pos){
    return pos>0;
}
const result = c.filter(positive);
console.log(result);