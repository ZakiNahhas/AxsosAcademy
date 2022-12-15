import React from 'react'

const Display = (props) => {
    const boxStyle = {
        backgroundColor:props.data,
        width:'100px',
        height:'100px',
        margin:'25px',
    }
    
  return (
    <div>
        <h3>Here are your colored boxes:</h3>
        <div style={boxStyle}></div>
    </div>
  )
}

export default Display