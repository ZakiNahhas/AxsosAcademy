import React from 'react'

const Hala = (props) => {
  return (
    <div className='margin'>
        <h1>{props.name}</h1>
        <p>Age: {props.age}</p>
        <p>Hair color: {props.hairColor}</p>
    </div>
  )
}

export default Hala