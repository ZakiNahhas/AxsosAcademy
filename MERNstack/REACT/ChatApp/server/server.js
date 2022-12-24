const express = require ('express');
const app = express();

const server =app.listen(8000 , () => console.log("The Server is All fired up on port 8000"));

const io = require('socket.io')(server,{cors:true})

io.on ("connection" ,socket => {
    console.log(socket.id);
    socket.on("Chat",data =>{
        io.emit("Chat",data);
    });
});