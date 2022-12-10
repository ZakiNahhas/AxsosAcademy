import "./App.css";
import Hala from "./components/Hala";

function App() {
  return (
    <div>
      <Hala name={"Zaki Nahhas"} age = {25} hairColor={"brown"}/>
      <Hala name={"Izz Malakh"} age = {23} hairColor={"black"}/>
      <Hala name={"Haninz Saymeh"} age = {25} hairColor={"red"}/>
      <Hala name={"Sponge Bob"} age = {155} hairColor={"yellow"}/> 
    </div>
  );
}

export default App;
