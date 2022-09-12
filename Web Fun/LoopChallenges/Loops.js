//Print odds 1-20:

for (i = 1; i<=20; i++) {
    if (i % 2 !=0) {
        console.log(i);
    }
}

//Decreasing Multiples of 3:

for (i = 0; i <= 100; i++) {
    if (i % 3 == 0) {
        console.log(i);
    }
}

//Print the Sequence:

var arr1=[];
for (i = 4; i>=-4; i-=1.5) {
    console.log(i)
}
//Sigma:

function factorial(num) {
    var x =1;
    for(var i=1; i<=num; i++) {
        if(i >= i) {
            x*=i;
        }
    }
    return x;
}
var z = factorial(5);
console.log(z);

//Factorial: 

function sigma(sum) {
    var val = 0;
    for(var i = 1; i <=sum; i++) {
        if(i >=1) {
            val+=i;
        }
    } 
    return val;
}
var z = sigma(3);
console.log(z);