import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate} from "react-router-dom";
import DeleteButton from '../components/DeleteButton';
    
const Detail = (props) => {
    
    const [product, setProduct] = useState({})
    const { id } = useParams();
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' +id)
            .then(res => setProduct(res.data))
            .catch(err => console.error(err));
    }, []);

    // function handleDelete(id) {
    //     axios.delete('http://localhost:8000/api/products/' + id)
    //     .then(() => navigate("/")
    //     )
    // }
    
    return (
        <div style={{width:'20%', margin:'0 auto'}}>
            <p>Title: {product.title}</p>
            <p>Price: {product.price}</p>
            <p>Description: {product.description}</p>
            <p><Link to={"/products/" + product._id + "/edit"}>
    Edit
</Link></p>
<p>
<DeleteButton productId={product._id} successCallback={() => navigate("/")} /></p>
        </div>
    )
}
    
export default Detail;

