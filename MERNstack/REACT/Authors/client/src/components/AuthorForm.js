import React, { useState } from 'react'
import axios from 'axios';
import TextField from '@mui/material/TextField';

export default (props) => {
    const { initialName, onSubmitProp } = props;
    //keep track of what is being typed via useState hook
    const [name, setName] = useState(initialName); 
    const [errors, setErrors] = useState()
    //handler when the form is submitted
    const onSubmitHandler = e => {
        e.preventDefault();
        onSubmitProp({name});
        setName("");
    }
    //onChange to update firstName and lastName
    return (
        <form style={{width:'20%', margin:'0 auto'}} onSubmit={onSubmitHandler}>
            
            <p>
                <label>Name</label><br />
                <input 
                    type="text" 
                    value={name} 
                    onChange={(e) => { setName(e.target.value) }} />
            </p>

            <input type="submit" />

        </form>
    )
}

