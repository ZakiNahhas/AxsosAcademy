import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate} from "react-router-dom";
import DeleteButton from '../components/DeleteButton';
    
const Detail = (props) => {
    
    const [author, setAuthor] = useState({})
    const { id } = useParams();
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' +id)
            .then(res => setAuthor(res.data))
            .catch(err => console.error(err));
    }, []);

    // function handleDelete(id) {
    //     axios.delete('http://localhost:8000/api/authors/' + id)
    //     .then(() => navigate("/")
    //     )
    // }
    
    return (
        <div style={{width:'20%', margin:'0 auto'}}>
            <p>Name: {author.name}</p>
            <p><Link to={"/author/" + author._id + "/edit"}>
    Edit
</Link></p>
<p>
<DeleteButton authorId={author._id} successCallback={() => navigate("/")} /></p>
        </div>
    )
}
    
export default Detail;

