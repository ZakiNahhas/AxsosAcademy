import React, { useEffect, useState } from 'react';
import PlayerForm from '../components/PlayerForm';
import PlayerList from '../components/PlayerList';
import axios from 'axios';
import Detail from './Detail';
import { Link } from 'react-router-dom';


export default () => {
    const [players, setPlayer] = useState([]);
    const [loaded, setLoaded] = useState(false);


    useEffect(()=>{
        axios.get('http://localhost:8000/api/players')
            .then(res=>{
                setPlayer(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);

    const removeFromDom = playerId => {
        setPlayer(players.filter(player => player._id != playerId));
    }

    return (
        <div className='App'>
            <h1>All Players</h1>
           <Link className='btn btn-secondary' to={"/player/new"}>
            Add a player
           </Link>
           <hr/>
           {loaded && <PlayerList players={players} removeFromDom={removeFromDom}/>}
        </div>
    )
}



