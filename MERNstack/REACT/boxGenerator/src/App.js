
import './App.css';
import BoxGenerator from './components/BoxGenerator';
import { useState } from 'react';
import Display from './components/Display';
import List from './components/List';
import useList from './components/useList';

function App() {
  const [color, setColor] = useState("");

  return (
    <div className="App">
      {/* <BoxGenerator myFun={setColor}/>
      <Display data={color} /> */}
      <List/>
    </div>
  );
}

export default App;
