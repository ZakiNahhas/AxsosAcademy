function reverseString(str) {
    var newStr = "";
    for(i = str.length-1; i >= 0; i--) {
        newStr += str[i]
    }
    return newStr;
}
str = "creature"
console.log(reverseString(str));