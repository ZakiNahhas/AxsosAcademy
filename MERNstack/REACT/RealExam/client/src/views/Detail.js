import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Navigate, useParams } from "react-router-dom";
import { Link } from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import DeleteButton from '../components/DeleteButton';
const Detail = (props) => {
    const [competition, setCompetition] = useState({})
    const { id } = useParams();
    
    const navigate = useNavigate();
    const deletePerson = (competitionId) => {
        axios.delete('http://localhost:8000/api/competition/' + competitionId)
            .then(res => {
                navigate("/");
            })
            .catch(err => console.error(err));
    }
    useEffect(() => {
        axios.get('http://localhost:8000/api/competition/' +id)
            .then(res => setCompetition(res.data))
            .catch(err => console.error(err));
            

    }, []);
    const voteCountry1 = (id,cVote1) =>{
        const response = axios.put('http://localhost:8000/api/competition/update/' + id, {vote1:cVote1+1})
        navigate("/votes/" + id)

        
    }
    const voteCountry2 = (id,cVote2) =>{
        const response = axios.put('http://localhost:8000/api/competition/update/' + id, {vote2:cVote2+1})
        navigate("/votes/" + id)

        
    }
    const voteCountry3 = (id,cVote3) =>{
        const response = axios.put('http://localhost:8000/api/competition/update/' + id, {vote3:cVote3+1})
        navigate("/votes/" + id)

        
    }
    return (
        
        <div>
            <p>
          <Link to={"/"}>
            Home
          </Link>
      </p>
            <h1> {competition.question}</h1>
            <hr>
            </hr>
            <div style={{height:'6em',display:"flex", backgroundColor:"gold", width:"40%",margin:'0 auto',textAlign:"center"}}>
            <h3 style={{flex:1}}> {competition.country1}</h3>
            <br></br>
            <button onClick={()=>voteCountry1(competition._id,competition.vote1)}>Vote {competition.country1}</button>
            <h3 style={{flex:1}}> {competition.country2}</h3>
            <button onClick={()=>voteCountry2(competition._id,competition.vote2)}>Vote {competition.country2}</button>
            <h3 style={{flex:1}}> {competition.country3}</h3>
            {competition.country3?
            
            <button onClick={()=>voteCountry3(competition._id,competition.vote3)}>Vote {competition.country3}</button>:<p></p>}
            {competition.vote1}
            {competition.vote2}

            </div>
       
        </div>
        
    )
}
    
export default Detail;