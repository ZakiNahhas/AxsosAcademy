import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Navigate, useParams } from "react-router-dom";
import { Link } from 'react-router-dom';
import { useNavigate } from "react-router-dom";

const VoteDetails = (props) => {
    const [competition, setCompetition] = useState({})
    const { id } = useParams();
    useEffect(() => {
        axios.get('http://localhost:8000/api/competition/' +id)
            .then(res => setCompetition(res.data))
            .catch(err => console.error(err));
            

    }, []);
  return (
    <div style={{padding:"30px"}}>
        <div>
            </div>
            <p>
          <Link to={"/"}>
          <button style={{backgroundColor:"blue",marginLeft:"1350px", borderRadius:'4px'}}>Back to Home</button>
          </Link>
      </p>
            <h1> {competition.question}</h1>
            <hr>
            </hr>
            <div style={{display:"flex"}}>
            <div style={{flex:1, textAlign:"center"}}>
            <h2> {competition.country1}</h2>
            <h1> {competition.vote1}</h1>
            </div>
            <div style={{flex:1, textAlign:"center"}}>
            <h2 style={{flex:1}}> {competition.country2}</h2>
            <h1> {competition.vote2}</h1>
            </div>
            <div style={{flex:1, textAlign:"center"}}>
            <h2 style={{flex:1}}> {competition.country3}</h2>
            {competition.country3?
            <h1> {competition.vote3}</h1>:<p></p>
            }
            </div>
            </div>
            

    </div>
  )
}

export default VoteDetails