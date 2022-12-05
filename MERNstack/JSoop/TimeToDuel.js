class Card{
    constructor(cardName, cost){
        this.cardName=cardName;
        this.cost=cost;
    }
}

class Unit extends Card{
    constructor(cardName, cost, power, resilience){
        super(cardName, cost);
        this.power=power;
        this.resilience=resilience;

    }

    atack( target ) {
        if( target instanceof Unit ) {
            // implement card text here
            target.resilience-=this.power;
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

class Effect extends Card{
    constructor(cardName, cost, text, stat, magnitude){
        super(cardName, cost);
        this.text=text;w
        this.stat=stat;
        this.magnitude=magnitude;
    }

    play( target ) {
        if( target instanceof Unit ) {
            // implement card text here
            if(this.stat=="resilience"){
                target.resilience+=this.magnitude;
            }
            else{
                target.power+=this.magnitude;
            }

        } else {
            throw new Error("Target must be a unit!");
        }
    }
}
// turn	action
// 1	Make an instance of "Red Belt Ninja"
// 1	Make an instance of "Hard Algorithm" and play it on "Red Belt Ninja"
// 2	Make an instance "Black Belt Ninja"
// 2	Make an instance of "Unhandled Promise Rejection" and play it on "Red Belt Ninja"
// 3	Make an instance of "Pair Programming" and play it on "Red Belt Ninja"
// 3	"Red Belt Ninja" uses the attack method on "Black Belt Ninja"

const RedBeltNinja= new Unit("Red Belt Ninja",3,3,4);
const BlackBeltNinja= new Unit("Black Belt Ninja",4,5,4);
const HardAlgorithm= new Effect("Hard Algorithm",2,"increase target's resilience by 3","resilience",3);
const UnhandledPromiseRejection= new Effect("Unhandled Promise Rejection",1,"reduce target's resilience by 2","resilience",-2);
const PairProgramming= new Effect("Pair Programming",3,"increase target's power by 2","power",+2);

console.log(BlackBeltNinja);
RedBeltNinja.atack(BlackBeltNinja);
console.log(RedBeltNinja);
console.log(BlackBeltNinja);
console.log("--------------");
console.log(RedBeltNinja);
HardAlgorithm.play(RedBeltNinja);
console.log(RedBeltNinja);
console.log("--------------");
console.log(RedBeltNinja);
UnhandledPromiseRejection.play(RedBeltNinja);
console.log(RedBeltNinja);
console.log("--------------");
console.log(RedBeltNinja);
PairProgramming.play(RedBeltNinja);
console.log(RedBeltNinja);