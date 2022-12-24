import React, { useState } from 'react'
import Chat from '../components/Chat'
import ChatForm from '../components/ChatForm'

const Main = () => {
const [username,setUsername]=useState("")

  return (
    <div>
        
    {!username?<ChatForm Name={(name)=>setUsername(name)}/>:
    <Chat username={username}/>}

    </div>
  )
}

export default Main