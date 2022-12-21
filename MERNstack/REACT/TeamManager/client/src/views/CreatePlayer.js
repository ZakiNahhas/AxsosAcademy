import React, { useEffect, useState } from 'react';
import PlayerForm from '../components/PlayerForm';
import PlayerList from '../components/PlayerList';
import axios from 'axios';
import Detail from './Detail';
import { Link, useNavigate } from 'react-router-dom';

const CreatePlayer = () => {
    const [players, setPlayer] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    const [errors, setErrors] = useState([]); 

    const removeFromDom = playerId => {
        setPlayer(players.filter(player => player._id != playerId));
    }
    const createPlayer = player => {
        axios.post('http://localhost:8000/api/player/new', player)
            .then(res=>{
                setPlayer([...players, res.data]); 
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
        <Link className='btn btn-secondary' to={"/"}>Home</Link>
        <h1>Add a new Player:</h1>
        {errors.map((err, index) => <p key={index}>{err}</p>)}
        <PlayerForm onSubmitProp={createPlayer} initialName=""/>
    </div>
  )
}

export default CreatePlayer