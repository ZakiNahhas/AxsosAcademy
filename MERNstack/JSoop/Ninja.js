class Ninja {
  constructor(ninjaName) {
    this.name = ninjaName;
    this.health = 100;
    this.speed = 3;
    this.strength = 3;
    console.log("this is new object");
  }
  sayName() {
    console.log(this.name);
  }
  showStats() {
    console.log(this.name, this.health, this.speed, this.strength);
  }
  drinkSake() {
    this.health += 10;
    console.log(this.health);
  }
}

class Sensei extends Ninja {
  constructor(superNinja) {
    super(superNinja);
    this.health = health;
    this.speed = 10;
    this.strength = 10;
    this.wisdom = 10;
  }
  speakWisdom() {
    super.drinkSake();
    console.log("Flow like water");
  }
  showStats() {
    super.showStats();
  }
}
const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();

console.log("*************************");
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();
