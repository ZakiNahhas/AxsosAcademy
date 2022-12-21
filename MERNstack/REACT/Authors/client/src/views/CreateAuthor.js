import React, { useEffect, useState } from 'react';
import AuthorForm from '../components/AuthorForm';
import AuthorList from '../components/AuthorList';
import axios from 'axios';
import Detail from './Detail';
import { Link, useNavigate } from 'react-router-dom';

const CreateAuthor = () => {
    const [authors, setAuthor] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    const [errors, setErrors] = useState([]); 

    const removeFromDom = authorId => {
        setAuthor(authors.filter(author => author._id != authorId));
    }
    const createAuthor = author => {
        axios.post('http://localhost:8000/api/author/new', author)
            .then(res=>{
                setAuthor([...authors, res.data]); 
                navigate('/')  
            }).catch(err=>{
                const errorResponse = err.response.data.errors; // Get the errors from err.response.data
                const errorArr = []; // Define a temp error array to push the messages in
                for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                    errorArr.push(errorResponse[key].message)
                }
                // Set Errors
                setErrors(errorArr);
            })            
            
    }
  return (
    <div>
        <Link to={"/"}>Home</Link>
        <h1>Add a new Author:</h1>
        {errors.map((err, index) => <p key={index}>{err}</p>)}
        <AuthorForm onSubmitProp={createAuthor} initialName=""/>
    </div>
  )
}

export default CreateAuthor