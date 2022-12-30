import React, { useEffect, useState } from 'react';
import CompetitionForm from '../components/CompetitionForm';
import CompetitionList from '../components/CompetitionList';
import axios from 'axios';
import Detail from './Detail';
import { Link, useNavigate } from 'react-router-dom';

const CreateCompetition = () => {
    const [competitions, setCompetitions] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    const [errors, setErrors] = useState([]); 

    const removeFromDom = competitionId => {
        setCompetitions(competitions.filter(competition => competition._id != competitionId));
    }
    const createCompetition = competition => {
        axios.post('http://localhost:8000/api/competition/new', competition)
            .then(res=>{
                setCompetitions([...competitions, res.data]); 
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
        <Link style={{marginLeft:'60em'}} className='btn btn-secondary' to={"/"}>Home</Link>
        {errors.map((err, index) => <p key={index}>{err}</p>)}
        <CompetitionForm onSubmitProp={createCompetition} initialName="" initialCountry1="" initialCountry2="" initialCountry3="" errors={errors}/>
    </div>
  )
}

export default CreateCompetition