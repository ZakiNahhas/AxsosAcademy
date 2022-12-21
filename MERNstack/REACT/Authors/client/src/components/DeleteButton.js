import React from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate} from "react-router-dom";  

export default props => {
    const navigate = useNavigate();
    const { authorId, successCallback } = props;
    
    const deleteAuthor = e => {
        axios.delete('http://localhost:8000/api/author/' + authorId)
            .then(res=>{
                successCallback();
            })
    }
    
    return (
        <button onClick={deleteAuthor}>
            Delete
        </button>
    )
}

