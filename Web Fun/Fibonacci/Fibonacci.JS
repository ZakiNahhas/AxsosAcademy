function fibo(num) {

    var sum = [0, 1];

    for (i = 2; i <= num; i++) {
        sum.push(sum[i - 2] + sum[i - 1]);
}
    console.log(sum[sum.length - 1]);
        return sum;
}
    var z = fibo(20);
    console.log(z);