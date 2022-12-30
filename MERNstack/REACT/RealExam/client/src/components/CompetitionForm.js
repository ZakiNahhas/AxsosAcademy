import React, { useState } from 'react'
import axios from 'axios';
import TextField from '@mui/material/TextField';
import { Link } from 'react-router-dom';


export default (props) => {
    const { initialQuestion, initialCountry1, initialCountry2, initialCountry3, onSubmitProp } = props;
    //keep track of what is being typed via useState hook
    const [question, setQuestion] = useState(initialQuestion); 
    const [country1, setCountry1] = useState(initialCountry1); 
    const [country2, setCountry2] = useState(initialCountry2);
    const [country3, setCountry3] = useState(initialCountry3);
    const [questionError, setQuestionError] = useState("");
    const [country1Error, setCountry1Error] = useState("");
    const [country2Error, setCountry2Error] = useState("");
    const [errors, setErrors] = useState([]);
    //handler when the form is submitted

    const onSubmitHandler = e => {
        e.preventDefault();
        onSubmitProp({question, country1, country2, country3});
    }

    const handleQuestion = (e) => {
        if(e.target.value.length < 10 && e.target.value.length > 0) {
            setQuestion(e.target.value);
            setQuestionError("Question must be at least 10 characters long");
        } else {
            setQuestion(e.target.value);
            setQuestionError("");
        }
    }

    const handleCountry1 = (e) => {
        if(e.target.value.length < 3 && e.target.value.length > 0) {
            setCountry1(e.target.value);
            setCountry1Error("Country must be at least 3 characters long");
        } else {
            setCountry1(e.target.value);
            setCountry1Error("");
        }
    }

    const handleCountry2 = (e) => {
        if(e.target.value.length < 3 && e.target.value.length > 0) {
            setCountry2(e.target.value);
            setCountry2Error("Country must be at least 3 characters long");
        } else {
            setCountry2(e.target.value);
            setCountry2Error("");
        }
    }

    //onChange to update firstName and lastName
    return (
        <form className="font-monospace" style={{width:'20%', margin:'0 auto'}} onSubmit={onSubmitHandler}>
            <br/>
            <p>
                <label className="badge bg-primary text-wrap 1">Question</label>
                <input className="form-control" 
                    value={question}
                    type="textarea" 
                    onChange={handleQuestion} />
            </p>
            <p style={{color:'red'}}>{questionError}</p>
            <p>
                <label class="badge bg-warning text-wrap">Country 1* :</label><br />
                <input class="form-control" 
                    value={country1}
                    type="text"  
                    onChange={handleCountry1} />
            </p>
            <p style={{color:'red'}}>{country1Error}</p>

            <p>
                <label class="badge bg-warning text-wrap">Country 2* :</label><br />
                <input class="form-control" 
                    value={country2}
                    type="text"  
                    onChange={handleCountry2} />
            </p>
            <p style={{color:'red'}}>{country2Error}</p>
            <p>
                <label class="badge bg-warning text-wrap">Country 3 :</label><br />
                <input class="form-control" 
                    type="text" />
            </p>
            <br/>
            <input className='btn btn-warning' type="submit" />

        </form>
    )
}

