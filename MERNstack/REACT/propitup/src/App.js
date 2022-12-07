import logo from './logo.svg';
import './App.css';
import Propitup from './components/Propitup';

function App() {
  return (
    <div>
      <Propitup name={"Zaki Nahhas"} age = {25} hairColor={"brown"}/>
      <Propitup name={"Izz Malakh"} age = {23} hairColor={"black"}/>
      <Propitup name={"Haninz Saymeh"} age = {25} hairColor={"red"}/>
      <Propitup name={"Sponge Bob"} age = {155} hairColor={"yellow"}/>
    </div>
  );
}

export default App;
