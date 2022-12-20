import React from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate} from "react-router-dom";  

export default props => {
    const navigate = useNavigate();
    const { productId, successCallback } = props;
    
    const deleteProduct = e => {
        axios.delete('http://localhost:8000/api/products/' + productId)
            .then(res=>{
                successCallback();
            })
    }
    
    return (
        <button onClick={deleteProduct}>
            Delete
        </button>
    )
}

