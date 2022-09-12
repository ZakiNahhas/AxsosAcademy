function myTrim(str) {
    var newStr = "";
    for(i = 0; i < str.length; i++) {
        if(str[i]!= " " && str[i]!="," && str[i]!=".") {
            newStr += str[i];
        }
    } return newStr;
}
console.log(myTrim(" spongebob.   ,"))