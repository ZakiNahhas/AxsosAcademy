import React, { useState } from 'react'
import axios from 'axios';
import TextField from '@mui/material/TextField';

export default (props) => {
    const { initialTitle, initialPrice, initialDescription, onSubmitProp } = props;
    //keep track of what is being typed via useState hook
    const [title, setTitle] = useState(initialTitle); 
    const [price, setPrice] = useState(initialPrice);
    const [description, setDescription] = useState(initialDescription);
    const [errors, setErrors] = useState()
    //handler when the form is submitted
    const onSubmitHandler = e => {
        //prevent default behavior of the submit
        e.preventDefault();
        onSubmitProp({title, price, description});
        setPrice("");
        setTitle("");
        setDescription("");
    }
    //onChange to update firstName and lastName
    return (
        <form style={{width:'20%', margin:'0 auto'}} onSubmit={onSubmitHandler}>
            
            <p>
                <label>Title</label><br />
                <input 
                    type="text" 
                    value={title} 
                    onChange={(e) => { setTitle(e.target.value) }} />
            </p>
            <p>
                <label>Price</label><br />
                <input 
                    type="number" 
                    value={price} 
                    onChange={(e) => { setPrice(e.target.value) }} />
            </p>

            <p>
                <label>Description</label><br />
                <input 
                    type="text" 
                    value={description} 
                    onChange={(e) => { setDescription(e.target.value) }} />
            </p>

            <input type="submit" />

        </form>
    )
}

