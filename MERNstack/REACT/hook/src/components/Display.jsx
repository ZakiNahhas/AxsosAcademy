import React from 'react'

const Display = (props) => {
    const style1 = {
        backgroundColor:props.data,
    }
  return (
    <div>
        <h3>Welcome to the display component</h3>
        <p style={style1}>{props.data}</p>
    </div>
  )
}

export default Display