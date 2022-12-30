import React, { useEffect, useState } from 'react';
import CompetitionForm from '../components/CompetitionForm';
import CompetitionList from '../components/CompetitionList';


import axios from 'axios';
import Detail from './Detail';
import { Link } from 'react-router-dom';


export default () => {
    const [competitions, setCompetitions] = useState([]);
    const [topThree, setTopThree] = useState([]);
    const [loaded, setLoaded] = useState(false);


    useEffect(()=>{
        axios.get('http://localhost:8000/api/competitions')
            .then(res=>{
                setCompetitions(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);

    useEffect(()=>{
        axios.get('http://localhost:8000/api/topThree')
            .then(res=>{
                setTopThree(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);

    const removeFromDom = competitionId => {
        setCompetitions(competitions.filter(competition => competition._id != competitionId));
    }

    return (
        <div className='App'>
            <Link style={{marginLeft:'8em'}} className='btn btn-secondary' to={"/competition/new"}>
            Create your own competition
           </Link>
           <div style={{display:'flex', justifyContent:'space-around'}}>
           <h1 >Top Three</h1>
            <h1 >All Competitions</h1>
            </div>
           <hr/>
           <div style={{display:'flex'}}>
           
           
           {loaded && <CompetitionList competitions={topThree} removeFromDom={removeFromDom}/>}

           {loaded && <CompetitionList competitions={competitions} removeFromDom={removeFromDom}/>}
           </div>
        </div>
    )
}



