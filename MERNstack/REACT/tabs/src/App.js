import './App.css';
import { useState } from 'react';
import TabGenerator from './components/TabGenerator';
import TabDisplay from './components/TabDisplay';

function App() {
  const [tab,setTab]=useState("")
  const tabToDisplay = (tabName)=>{
    setTab(tabName);
  }
  return (
    <div className="App">

    <TabGenerator tabName={tabToDisplay}/>
    <TabDisplay tabToShow = {tab}/>
    
    </div>
  );
}

export default App;