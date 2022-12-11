import React, { useState } from "react";

const Form = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [errorName, setErrorName] = useState("");
  const [errorEmail, setErrorEmail] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [errorConfirmPass, setErrorConfirmPass] = useState("");
  const [bool, setBool] = useState(false);

  const handleName = (e) => {
    console.log(e.target.value);
    if (e.target.value.length < 3 && e.target.value.length > 0) {
      setErrorName("Name should be at least 3 characters");
      // setName(e.target.value);
    } else {
      setName(e.target.value);
      setErrorName("");
    }
  };
  const handleEmail = (e) => {
    if (e.target.value.length < 2 && e.target.value.length > 0) {
      setErrorEmail("Email should be at least 2 characters");
      // setName(e.target.value);
    } else {
      setEmail(e.target.value);
      setErrorEmail("");
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setBool(true);
  };

  const handlePassword = (e) =>{
    setPassword(e.target.value)
    if (e.target.value.length<8 && e.target.value.length > 0){
    setPasswordError("Password should be at least 8 characters");
    }
    else{
    setPasswordError("")
    }}

const handleConfirmPass = (e)=>{
    setConfirmPassword(e.target.value);
    if(password !== e.target.value && e.target.value.length > 0){
      setErrorConfirmPass("Passwords do not match");

    }
    else{
      setErrorConfirmPass("")
    }
  }

  return (
    <>
      <form action="/blabla" onSubmit={handleSubmit}>
        <p>
          Name: <input type="text" onChange={handleName} />
        </p>
        <p className="error">{errorName}</p>
        <p>
          Email: <input type="email" onChange={handleEmail} />
        </p>
        <p className="error">{errorEmail}</p>
        <p>
          Password: <input type="password" onChange={handlePassword} />
        </p>
        <p className="error">{passwordError}</p>
        <p>
          confirm Password:{" "}
          <input type="password" onChange={handleConfirmPass} />
        </p>
        <p className="error">{errorConfirmPass}</p>
        <input type="submit" value="send" />
      </form>
      <hr />
      <p>Name is:{name}</p>
      <p>Email is:{email}</p>
      <p>Passowrd is: {password}</p>
      <p>Confirmed password is:{confirmPassword}</p>
      {bool ? <h1>Thank you baby</h1> : <h1>Please submit the form</h1>}
    </>
  );
};

export default Form;
