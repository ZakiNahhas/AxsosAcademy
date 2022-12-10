import React, { useState } from 'react'

const Form = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [age, setAge] = useState(0);
  const [error, setError] = useState("");
  const [bool, setBool] = useState(false);

  const fun=(e)=> {
    console.log(e.target.value);
    if(e.target.value.length < 3) {
      setError("Name should be at least 3 characters")
    } else {
      setName(e.target.value);
      setError("");
    }
    
  }
  const fun2=(e)=> {
    e.preventDefault();
    setBool(true);
  }

  return (
    <div>
        <Form action="/blabla" onSubmit={fun2}>
            <p>Name: <input type="text" onChange={fun} value={name} /></p>
            <p>{error}</p>
            <p>Email: <input type="text" onChange={(e)=>setEmail(e.target.value)}/></p>
            <p>Age: <input type="text" onChange={(e)=>setAge(e.target.value)} /></p>
            <input type="submit" value="send"/>
        </Form>
        <hr/>
        <p>Name is:{name}</p>
        <p>Email is:{email}</p>
        <p>Age is:{age}</p>
        {bool?<h1>Thank you baby</h1>:<h1>Please submit the form</h1>}
    </div>
  )
}

export default Form;