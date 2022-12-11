import React, { useState } from 'react'

const LiftingForm = (props) => {
    //1- Send a prop from parent to child(Should be a function)
    //2- The only way the child can send data to parent is to pass this data as a function argument
    const [msg, setMsg] = useState("");
    const handleSubmit = (e) => {
        e.preventDefault();
        props.myFun(msg);
    }
  return (
    <div>
        <form onSubmit={handleSubmit}>
        <h3>Welcome Baby wooo</h3>
        <p><input type="text" onChange={e=>setMsg(e.target.value)}/></p>
        <p><input type="submit" value="send" /></p>
        </form>

    </div>
  )
}

export default LiftingForm