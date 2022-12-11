import { useState } from "react";
import "./App.css";
import Display from "./components/Display";
import Form from "./components/Form";
import LiftingForm from "./components/LiftingForm";
import MyMap from "./components/MyMap";
import OtherInputs from "./components/OtherInputs";
function App() {
  const [txt, setTxt] = useState("");

  return (
    <>
      {/* <LiftingForm myFun={setTxt} />
      <Display data={txt}/> */}
      <Form/>
      {/* <MyMap/>
      <OtherInputs/> */}
    </>
  );
}

export default App;
