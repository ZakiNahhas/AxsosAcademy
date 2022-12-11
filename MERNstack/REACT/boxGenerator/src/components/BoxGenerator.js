import React, { useState } from 'react'

const BoxGenerator = (props) => {
    //1- Send a prop from parent to child(Should be a function)
    //2- The only way the child can send data to parent is to pass this data as a function argument
    const [boxes, setBoxes] = useState([]);
    const handleSubmit = (e) => {
        e.preventDefault();
        props.myFun(boxes);
        const color = props.data;
        setBoxes([...boxes, { color }]);
    }

  return (
    <div>
        <form onSubmit={handleSubmit}>
        <h3>Welcome Baby! Generate new boxes:</h3>
        <p>Choose a color: &nbsp;<input type="text" onChange={e=>setBoxes(e.target.value)}/></p>
        <p><input type="submit" value="Create" /></p>
        </form>
    </div>
  )
}

export default BoxGenerator;