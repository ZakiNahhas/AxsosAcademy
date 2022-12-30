import React from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate} from "react-router-dom";
import { yellow } from '@mui/material/colors';
import { withStyles } from '@material-ui/styles';
import { withTheme } from '@material-ui/core';
import { style } from '@mui/system';



export default props => {
    const navigate = useNavigate();
    const { competitionId, successCallback } = props;
    
    const deleteCompetition = e => {
        var result=window.confirm("Are you sure you want to delete this competition")
        if (result===true){
        axios.delete('http://localhost:8000/api/competition/' + competitionId)
            .then(res=>{
                successCallback();
            })}
    }
    
    return (
        <button className='btn btn-danger' onClick={deleteCompetition}>
            Delete
        </button>
    )
}

