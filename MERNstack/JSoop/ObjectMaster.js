const pokémon = Object.freeze([
  { id: 1, name: "Bulbasaur", types: ["poison", "grass"] },
  { id: 5, name: "Charmeleon", types: ["fire"] },
  { id: 9, name: "Blastoise", types: ["water"] },
  { id: 12, name: "Butterfree", types: ["bug", "flying"] },
  { id: 16, name: "Pidgey", types: ["normal", "flying"] },
  { id: 23, name: "Ekans", types: ["poison"] },
  { id: 24, name: "Arbok", types: ["poison"] },
  { id: 25, name: "Pikachu", types: ["electric"] },
  { id: 37, name: "Vulpix", types: ["fire"] },
  { id: 52, name: "Meowth", types: ["normal"] },
  { id: 63, name: "Abra", types: ["psychic"] },
  { id: 67, name: "Machamp", types: ["fighting"] },
  { id: 72, name: "Tentacool", types: ["water", "poison"] },
  { id: 74, name: "Geodude", types: ["rock", "ground"] },
  { id: 87, name: "Dewgong", types: ["water", "ice"] },
  { id: 98, name: "Krabby", types: ["water"] },
  { id: 115, name: "Kangaskhan", types: ["normal"] },
  { id: 122, name: "Mr. Mime", types: ["psychic"] },
  { id: 133, name: "Eevee", types: ["normal"] },
  { id: 144, name: "Articuno", types: ["ice", "flying"] },
  { id: 145, name: "Zapdos", types: ["electric", "flying"] },
  { id: 146, name: "Moltres", types: ["fire", "flying"] },
  { id: 148, name: "Dragonair", types: ["dragon"] },
]);

const firePkmn = pokémon
  .filter((p) => p.types[0] === "fire" && p.types[1] === "fire")
  .map((x) => x.name);

const pkmnIdsMod3 = pokémon.filter((p) => p.id % 3 == 0);

const fireListPkmn = pokémon.filter((p) => p.types[0] === "fire");

const typeList = pokémon.filter((p) => p.types.length >= 2);

const namesList = pokémon.map((p) => p.name);

const namesListWithId99 = pokémon.filter((p) => p.id > 99).map((p) => p.name);

const startsWithLetters = pokémon.filter((p) => p.types[0].startsWith("fi")).map((p) => p.types[0]);

const startsWithPoison = pokémon.filter((p) => p.types == "poison");

const secondTypeFlying = pokémon
  .filter((p) => p.types[1] == "flying")
  .map((p) => p.types[0]);

const countNormal = pokémon
  .filter((p) => p.types[0].includes("normal"))
  .map((p) => p.types);

const startsWithLettersFlat = pokémon.map((p) => p.types).flat().filter((p) => p.startsWith("fi"));

const lengthOfTypesBiggerThan = pokémon.filter(p=> p.types.join('').length>10).map(p=>p.id);

// console.log(pkmnIdsMod3);
// console.log(fireListPkmn);
// console.log(typeList);
// console.log(startsWithLetters);
// console.log(namesList);
// console.log(namesListWithId99);
// console.log(startsWithPoison);
// console.log(secondTypeFlying);
// console.log(countNormal.length);
console.log(startsWithLettersFlat);
