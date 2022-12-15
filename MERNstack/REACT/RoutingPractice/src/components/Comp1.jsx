import React from 'react'

const Comp1 = (props) => {
    const spongStyle={
        backgroundColor:props.color,
        color:props.color2,
        border:"2px solid black",
        width:"500px",
        height:"80px",
        margin:"0 auto",
        marginTop:"20px",
        
    }
  return (
    <div>
      <div style={spongStyle}>
      {isNaN(props.name)?<h2>the word is: {props.word}</h2>:<h2>the number is: {props.word}</h2>}
      </div>
    </div>
  )
}

export default Comp1