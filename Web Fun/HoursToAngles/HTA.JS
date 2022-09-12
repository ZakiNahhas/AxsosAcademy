function clockHandAngles(seconds) {
    var secs = 0;
    var mins = 0;
    var hours = 0;
hours = Math.floor(seconds/3600);
mins=Math.floor((seconds-hours*3600) /60);
secs=seconds-hours*3600-mins*60
console.log(hours, mins, secs);
console.log("hours angle=", hours*30);
console.log("minutes angle=", mins*6);
console.log("seconds angle=", secs*6);
}

clockHandAngles(4444);

var x = 0;
for(var i=1; i<5; i++) {
    x += i;
}
for (var i = 1; i < 101; i++) {
    if (i % 15 == 0) console.log("FizzBuzz");
    else if (i % 3 == 0) console.log("Fizz");
    else if (i % 5 == 0) console.log("Buzz");
    else console.log(i);
}
