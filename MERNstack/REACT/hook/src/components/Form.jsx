import React, { useState } from 'react'

const Form = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [errorName, setErrorName] = useState("");
  const [errorEmail, setErrorEmail] = useState("");
  const [errorPassword, setErrorPassword] = useState("");
  const [errorConfirmPass, setErrorConfirmPass] = useState("");
  const [bool, setBool] = useState(false);

  const fun=(e)=> {
    console.log(e.target.value);
    if(e.target.value.length < 3 && e.target.value.length > 0) {
      setErrorName("Name should be at least 3 characters");
      // setName(e.target.value);

    } else {
      setName(e.target.value);
      setErrorName("");
    }
  }
    const fun3 =(e)=> {
      if(e.target.value.length < 2 && e.target.value.length > 0) {
        setErrorEmail("Email should be at least 2 characters");
        // setName(e.target.value);
  
      } else {
        setEmail(e.target.value);
        setErrorEmail("");
      }
    }
    
  
  const fun2=(e)=> {
    e.preventDefault();
    setBool(true);
  }

  const fun4 =(e)=> {
    if(e.target.value.length < 8 && e.target.value.length > 0) {
      setErrorPassword("Password should be at least 8 characters");
      // setName(e.target.value);
    } else {
      setPassword(e.target.value);
      setErrorPassword("");
    }
  }

  const fun5 =(e)=> {
    if(e.target.value.length < 8 && e.target.value.length > 0) {
      setErrorConfirmPass("Password should be at least 8 characters");
      setErrorConfirmPass("Passwords must match");
      // setName(e.target.value);

      } else if(e.target.value != password && e.target.value > 0 && e.target.value > password.length){
        setErrorConfirmPass("Passwords must match");
  
    } else {
      setConfirmPassword(e.target.value);
      setErrorConfirmPass("");
    }
  }

  return (
    <>
        <form action="/blabla" onSubmit={fun2}>
            <p>Name: <input type="text" onChange={fun}/></p>
            <p className='red'>{errorName}</p>
            <p>Email: <input type="text" onChange={fun3}/></p>
            <p className='red'>{errorEmail}</p>
            <p>Password: <input type="password" onChange={fun4} /></p>
            <p className='red'>{errorPassword}</p>
            <p>Confirm Password: <input type="password" onChange={fun5} /></p>
            <p className='red'>{errorConfirmPass}</p>
            <input type="submit" value="send"/>
        </form>
        <hr/>
        <p>Name is:{name}</p>
        <p>Email is:{email}</p>
        <p>Passowrd is: {password}</p>
        <p>Confirmed password is:{confirmPassword}</p>
        {bool?<h1>Thank you baby</h1>:<h1>Please submit the form</h1>}
    </>
  );

}

export default Form;