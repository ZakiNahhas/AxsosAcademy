import React from 'react'
// isNaN(props.name)?<h2>the word is: {props.name}</h2>:<h2>the number is: {props.name}</h2>
const Comp = (props) => {
    if(props.name=="home"){
        return(
            <div>
                <h2>Welcome</h2>
            </div>
        )
    }
    else if(isNaN(props.name)){
        return(
            <div>
                <h2>The word is: {props.name}</h2>
            </div>
        )
    }else{
        return(
            <div>
                <h2>The number is: {props.name}</h2>
            </div>
        )
    }
  
}

export default Comp