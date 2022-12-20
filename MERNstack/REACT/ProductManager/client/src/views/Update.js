import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, useNavigate } from "react-router-dom";
import ProductForm from '../components/ProductForm';
    
const Update = (props) => {
    const { id } = useParams();
    const [product, setProduct] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' + id)
            .then(res => {
                setProduct(res.data);
                setLoaded(true);
            })
    }, []);
    const updateProduct = product => {
        axios.put('http://localhost:8000/api/products/update/' + id, product)
        .then(res => console.log(res));
        navigate('/')
    }

    return (
        <div>
            {loaded && (
    <ProductForm
        onSubmitProp={updateProduct}
        initialTitle={product.title}
        initialPrice={product.price}
        initialDescription={product.description}
    />
)}
        </div>
    )
}
    
export default Update;

