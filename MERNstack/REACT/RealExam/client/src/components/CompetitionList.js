import React from 'react'
import { Link } from 'react-router-dom';
import axios from 'axios';
import DeleteButton from './DeleteButton';
import { Button } from 'reactstrap';


const CompetitionList = (props) => {
    const { removeFromDom } = props;
 
    return (
        <div class="font-monospace" style={{width:'80%', marginLeft:'40px'}}>
<table class="table table-dark table-striped" style={{width:"650px"}}>
            <thead>
              <tr>
                <th scope="col">Question</th>
                <th scope="col">Country 1</th>
                <th scope="col">Country 2</th>
                <th scope="col">Country 3</th>
                
              </tr>
            </thead>
            {props.competitions.map( (c, i) =>
            
            <tbody>
              <tr>
                <td><Link to={"/competition/" + c._id}>
                {c.question}
            </Link></td>
            <td>{c.country1} {c.vote1}</td>
            <td>{c.country2} {c.vote2}</td>
            <td>{c.country3} {c.vote3}</td>
             </tr>
            </tbody>
            )}
            </table>
        </div>
    )
}
    
export default CompetitionList;

