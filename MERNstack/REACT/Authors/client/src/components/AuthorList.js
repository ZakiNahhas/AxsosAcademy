import React from 'react'
import { Link } from 'react-router-dom';
import axios from 'axios';
import DeleteButton from './DeleteButton';

const AuthorList = (props) => {
    const { removeFromDom } = props;
    
    // const deleteAuthor = (authorId) => {
    //     axios.delete('http://localhost:8000/api/authors/' + authorId)
    //         .then(res => {
    //             removeFromDom(authorId)
    //         })
    //         .catch(err => console.error(err));
    // }
    return (
        <div style={{width:'20%', margin:'0 auto'}}>
<table class="table table-dark table-striped" style={{width:"400px"}}>
            <thead>
              <tr>
                <th scope="col">Author</th>
                <th scope="col">Actions</th>
                <th></th>
              </tr>
            </thead>
            {props.authors.map( (p, i) =>
            
            <tbody>
              <tr>
                <td><Link to={"/author/" + p._id}>
                {p.name}
            </Link></td>
                <td><DeleteButton authorId={p._id} successCallback={()=>removeFromDom(p._id)}/></td>
                <td><Link to={"/author/" + p._id + "/edit"}>
    Edit
</Link></td>
             </tr>
            </tbody>
          




            )}
            </table>

        </div>
    )
}
    
export default AuthorList;

