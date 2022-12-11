
import './App.css';
import BoxGenerator from './components/BoxGenerator';
import { useState } from 'react';
import Display from './components/Display';

function App() {
  const [color, setColor] = useState("");

  return (
    <div className="App">
      <BoxGenerator myFun={setColor}/>
      <Display data={color} />
    </div>
  );
}

export default App;
