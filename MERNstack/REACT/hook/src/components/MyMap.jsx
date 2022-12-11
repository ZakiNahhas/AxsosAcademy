import React from 'react'

const MyMap = () => {
    const arr = ["Zaki", "Amin", "Izz", "Yousef"]
    const fun1 =(x)=> {
      alert(x)
    }
  return (
    <div>
        <ul>
        {arr.map((item, idx)=><li onClick={e=>fun1(item)} key={idx}>{item}</li>)}
        </ul>
    </div>
  )
}

export default MyMap