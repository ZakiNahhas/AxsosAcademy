import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate} from "react-router-dom";
import DeleteButton from '../components/DeleteButton';

const Detail = (props) => {
    
    const [player, setPlayer] = useState({})
    const { id } = useParams();
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/player/' +id)
            .then(res => setPlayer(res.data))
            .catch(err => console.error(err));
    }, []);

    // function handleDelete(id) {
    //     axios.delete('http://localhost:8000/api/players/' + id)
    //     .then(() => navigate("/")
    //     )
    // }
    
    return (
        <div style={{width:'20%', margin:'0 auto'}}>
            <p>Name: {player.name}</p>
            <p>Position: {player.position}</p>
            <p><Link className='btn btn-success' to={"/player/" + player._id + "/edit"}>
    Edit
</Link></p>
<p>
<DeleteButton playerId={player._id} successCallback={() => navigate("/")} /></p>
        </div>
    )
}
    
export default Detail;

