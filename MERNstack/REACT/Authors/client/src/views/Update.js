import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, useNavigate } from "react-router-dom";
import AuthorForm from '../components/AuthorForm';
import DeleteButton from '../components/DeleteButton';
    
const Update = (props) => {
    const { id } = useParams();
    const [author, setAuthor] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    const [errors, setErrors] = useState([]); 
    const [isLoading, setIsLoading] = useState(true)

    
    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + id)
            .then(res => {
                setAuthor(res.data);
                setLoaded(true);
                setIsLoading(false);
            }).catch(res => {
                
            })
    }, []);
    const updateAuthor = author => {
        axios.put('http://localhost:8000/api/author/update/' + id, author)
        .then(res => {console.log(res)
            navigate('/')
        })
        .catch(err=>{
            const errorResponse = err.response.data.errors; // Get the errors from err.response.data
            const errorArr = []; // Define a temp error array to push the messages in
            for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                errorArr.push(errorResponse[key].message)
            }
            // Set Errors
            setErrors(errorArr);
        })   
              
    }

    if(isLoading) return 'Loading...!';

    return (
        <div>
        
        {errors.map((err, index) => <p key={index}>{err}</p>)}
            {loaded && (
    <AuthorForm
        onSubmitProp={updateAuthor}
        initialName={author.name}
        errors={errors}
    />
)}
<DeleteButton authorId={author._id} successCallback={() => navigate("/")} />

        </div>
    )
}
    
export default Update;

