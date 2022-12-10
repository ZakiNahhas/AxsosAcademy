import "./App.css";
import Index from "./components/Index";
import Counter from "./components/Counter";
import Form from "./components/Form";

function App() {
  return (
    <div className="App">
      <Index fname={"Zaki"} age={25}>
        <h1>sfgdgdggdgdgd</h1>
      </Index>
      <Index fname={"Izz"} age={23} />
      <Counter age={25} />
      <Form/>
    </div>
  );
}

export default App;
