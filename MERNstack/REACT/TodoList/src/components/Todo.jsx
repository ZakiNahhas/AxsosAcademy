import React, { useState } from 'react'

const Todo = () => {
    const [val, setVal] = useState("");
    const [todo, setTodo] = useState([])

    function add(str) {
        setTodo([...todo, {name:str, isDone:false}]);
            }
         
    function remove(index) {
        setTodo([
            ...todo.slice(0, index),
            ...todo.slice(index + 1)
        ]);
    }
   function handleSubmit() {
            add(val);
            setVal('');
        }
     
    const handleToggleTodo = (index) =>{
        const updateTodo = todo.map((name,i)=>{
          if(index==i){
            name.isDone=!name.isDone;
          }
          return name;
        })
        setTodo(updateTodo);
      }

  return (
     <>
<br/>
            <div style={{display:'flex', justifyContent:'center'}}>
            <button style={{marginRight:'10px'}} onClick={handleSubmit}>Add</button>
            </div>
                  <div><input
                onChange={e => setVal(e.target.value)}
                value={val}
            />
</div>
            {todo.map((item ,index) => {
          return(
            <div key={index} style={{display:"flex" ,margin:"0 auto",width:"500px",backgroundColor:"gray", borderRadius:'3px', padding:'10px'}}>
            <input onChange={()=>{
              handleToggleTodo(index)
            }

            } checked={item.isDone} type="checkbox"/>
            <p style={{textDecoration: item.isDone? 'line-through':'none'}}> {item.name} </p>
            <button style={{marginLeft:"15px"}}onClick={()=>{
              remove(index)
            }}>Delete</button>
            </div>

          )
        })}
        </>
  )
}

export default Todo