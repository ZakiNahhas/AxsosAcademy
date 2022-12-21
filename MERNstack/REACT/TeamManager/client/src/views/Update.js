import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, useNavigate } from "react-router-dom";
import PlayerForm from '../components/PlayerForm';
import DeleteButton from '../components/DeleteButton';
    
const Update = (props) => {
    const { id } = useParams();
    const [player, setPlayer] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    const [errors, setErrors] = useState([]); 
    const [isLoading, setIsLoading] = useState(true)

    
    useEffect(() => {
        axios.get('http://localhost:8000/api/player/' + id)
            .then(res => {
                setPlayer(res.data);
                setLoaded(true);
                setIsLoading(false);
            }).catch(res => {
                
            })
    }, []);
    const updatePlayer = player => {
        axios.put('http://localhost:8000/api/player/update/' + id, player)
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
    <PlayerForm
        onSubmitProp={updatePlayer}
        initialName={player.name}
        initialPosition={player.position}
        errors={errors}
    />
)}
<DeleteButton playerId={player._id} successCallback={() => navigate("/")} />

        </div>
    )
}
    
export default Update;

