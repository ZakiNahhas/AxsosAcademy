import React, { useState, useEffect } from 'react';
import io from 'socket.io-client';


function Chat(props) {

  const [socket] = useState(() => io(':8000'));
  const [message,setMessage] = useState("");
  const [messages,setMessages]= useState([]);

  useEffect(() => {
    socket.on("Chat", data => console.log(data));
    socket.on("Chat", data => setMessages([...messages,data]))

  });

const onSubmitHandler = e =>{
  e.preventDefault()
  socket.emit("Chat",props.username+" : "+message)
  setMessage("")
}
  return (
    <div className="App">
      <form onSubmit={onSubmitHandler}> 
      <input type="Message" value={message} onChange={e => setMessage(e.target.value)}/>
      <input type="submit" value="send" />
      </form>
      {messages.map((mes,i)=><p key={i}> --->  {mes}</p>)}
    </div>
    
);
}

export default Chat;