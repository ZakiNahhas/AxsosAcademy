import React from 'react'
import { Link } from 'react-router-dom';
import axios from 'axios';
import DeleteButton from './DeleteButton';
import { Button } from 'reactstrap';


const PlayerList = (props) => {
    const { removeFromDom } = props;
    
    // const deletePlayer = (playerId) => {
    //     axios.delete('http://localhost:8000/api/players/' + playerId)
    //         .then(res => {
    //             removeFromDom(playerId)
    //         })
    //         .catch(err => console.error(err));
    // }
    return (
        <div class="font-monospace" style={{width:'20%', margin:'0 auto'}}>
<table class="table table-dark table-striped" style={{width:"400px"}}>
            <thead>
              <tr>
                <th scope="col">Player</th>
                <th scope="col">Position</th>
                <th scope="col">Actions</th>
                <th></th>
              </tr>
            </thead>
            {props.players.map( (p, i) =>
            
            <tbody>
              <tr>
                <td><Link to={"/player/" + p._id}>
                {p.name}
            </Link></td>
            <td>{p.position}</td>
                <td><DeleteButton className='btn btn-danger' playerId={p._id} successCallback={()=>removeFromDom(p._id)}/></td>
                <td><Link className='btn btn-success' to={"/player/" + p._id + "/edit"}>
    Edit
</Link></td>
             </tr>
            </tbody>
          




            )}
            </table>

        </div>
    )
}
    
export default PlayerList;

