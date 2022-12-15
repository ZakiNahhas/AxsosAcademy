import React from 'react'
import { Router,Link } from '@reach/router';

const Reach3 = (props) => {
  return (
    <div>
        <h3>{isNaN(props.name)?<p>You entered a word</p>:<p>You entered a number</p>}Welcome to the candy shop3 {props.name}</h3>
    </div>
  )
}

export default Reach3