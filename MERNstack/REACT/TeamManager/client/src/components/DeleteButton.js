import React from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate} from "react-router-dom";



export default props => {
    const navigate = useNavigate();
    const { playerId, successCallback } = props;
    
    const deletePlayer = e => {
        var result=window.confirm("Are you sure you want to delete this player")
        if (result===true){
        axios.delete('http://localhost:8000/api/player/' + playerId)
            .then(res=>{
                successCallback();
            })}
    }
    
    return (
        <button className='btn btn-danger' onClick={deletePlayer}>
            Delete
        </button>
    )
}

