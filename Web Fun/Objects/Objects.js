function Human(name1, age1, language1, inter) { //كأنو Class // bluebrint
    var person = {}
    person.name = name1;
    person.age = age1;
    person.language = language1;
    person.interests = inter;
    person.talk=function () {
        console.log("My Name is: " + person.name + " " + "My age is: " + person.age + " " + "My language is: " + person.language +  " " + person.interests)
    }

    return person;
}

var x = Human("Zaki", 25, "French", ["flying", " walking"]);
console.log(x.talk());

// var a = Human("Hello", 5, "German");
// console.log(a.age);
