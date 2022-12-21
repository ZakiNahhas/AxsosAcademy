import React, { useState } from 'react'
import axios from 'axios';
import TextField from '@mui/material/TextField';

export default (props) => {
    const { initialName, initialPosition, onSubmitProp } = props;
    //keep track of what is being typed via useState hook
    const [name, setName] = useState(initialName); 
    const [position, setPosition] = useState(initialPosition); 
    const [nameError, setNameError] = useState("");
    const [positionError, setPositionError] = useState("");
    const [errors, setErrors] = useState([]);
    //handler when the form is submitted

    const onSubmitHandler = e => {
        e.preventDefault();
        onSubmitProp({name, position});
    }

    const handleName = (e) => {
        if(e.target.value.length < 3 && e.target.value.length > 0) {
            setName(e.target.value);
            setNameError("Name must be at least 3 characters long");
        } else {
            setName(e.target.value);
            setNameError("");
        }
    }

    const handlePosition = (e) => {
        if(e.target.value.length < 3 && e.target.value.length > 0) {
            setPosition(e.target.value);
            setPositionError("Positiom must be at least 3 characters long");
        } else {
            setPosition(e.target.value);
            setPositionError("");
        }
    }

    //onChange to update firstName and lastName
    return (
        <form className="font-monospace" style={{width:'20%', margin:'0 auto'}} onSubmit={onSubmitHandler}>
            
            <p>
                <label className="badge bg-primary text-wrap 1">Name</label>
                <input className="form-control" 
                    value={name}
                    type="text" 
                    onChange={handleName} />
            </p>
            <p style={{color:'red'}}>{nameError}</p>
            <p>
                <label class="badge bg-warning text-wrap">Position</label><br />
                <input class="form-control" 
                    value={position}
                    type="text"  
                    onChange={handlePosition} />
            </p>
            <p style={{color:'red'}}>{positionError}</p>
            <br/>
            <input className='btn btn-warning' type="submit" />

        </form>
    )
}

