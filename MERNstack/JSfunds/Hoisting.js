// console.log(example);
// let example = "I'm the example!";
// Cannot access 'example' before initialization 

/////////////////////////////////////////////////////////////////////////////

console.log(hello);
var hello = 'world';
// it will print undefined

//////////////////////////////////////////////////////////////////////////////

var needle = 'haystack';
test();
function test(){
    var needle = 'magnet';
    console.log(needle);
}
console.log(needle);

// It will print "magnet" then "haystack"

//////////////////////////////////////////////////////////////////////////////

var brendan = 'super cool';
function print(){
    brendan = 'only okay';
    console.log(brendan);
}
console.log(brendan);
// it will print out "super cool"

var food = 'chicken';
console.log(food);
eat();
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}
// It will print chicken and half chicken

///////////////////////////////////////////////////////////////////////

// mean();
// console.log(food);
// var mean = function() {
//     food = "chicken";
//     console.log(food);
//     var food = "fish";
//     console.log(food);
// }
// console.log(food);
// mean is not a function

//////////////////////////////////////////////////


console.log(genre);
var genre = "disco";
rewind();
function rewind() {
    genre = "rock";
    console.log(genre);
    var genre = "r&b";
    console.log(genre);
}
console.log(genre);

// it will print rock r&b disco

/////////////////////////////////////////////////////////////

dojo = "san jose";
console.log(dojo);
learn();
function learn() {
    dojo = "seattle";
    console.log(dojo);
    var dojo = "burbank";
    console.log(dojo);
}
console.log(dojo);

// it will print san jose seattle burbank and then san jose

/////////////////////////////////////////////////////////////

console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students){
    const dojo = {};
    dojo.name = name;
    dojo.students = students;
    if(dojo.students > 50){
        dojo.hiring = true;
    }
    else if(dojo.students <= 0){
        dojo = "closed for now";
    }
    return dojo;
}
// Dojo is read-only