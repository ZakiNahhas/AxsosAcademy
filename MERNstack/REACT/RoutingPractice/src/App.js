import logo from './logo.svg';
import './App.css';
import APIReq from './components/APIReq';
import ReachRouting from './components/ReachRouting';
import Reach2 from './components/Reach2';
import { Router,Link } from '@reach/router';
import Reach3 from './components/Reach3';
import Comp from './components/Comp';
import Comp1 from './components/Comp1';
function App() {
  return (
    <div className="App">
     {/* <APIReq/> */}
     {/* <Link to="/">Home page</Link>
     <br/>
     <Link to="/about">About page</Link> */}
     <Router>
     {/* <ReachRouting path="/about"/>
     <Reach2 path="/"/>
     <Reach3 path="/hello/:name"/>  */}
     <Comp path=":name"/>
     <Comp1 path=":word/:color/:color2"/>
     </Router>
    </div>
  );
}

export default App;
