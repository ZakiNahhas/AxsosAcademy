import React from 'react'

const Index = (props) => {
  return (
    <div>
        <h1>{props.fname} - {props.age}</h1>
        {props.children}
    </div>
  )
}

export default Index

// rafce functional component
// rcc class component
