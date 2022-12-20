import React, { useEffect, useState } from 'react';
import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';
import axios from 'axios';
import Detail from './Detail';


export default () => {
    const [product, setProduct] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(()=>{
        axios.get('http://localhost:8000/api/products')
            .then(res=>{
                setProduct(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[product]);

    const removeFromDom = productId => {
        setProduct(product.filter(product => product._id != productId));
    }
    const createProduct = product => {
        axios.post('http://localhost:8000/api/products/new', product)
            .then(res=>{
                setProduct([...product, res.data]);   
            })
    }
    return (
        <div className='App'>
           <ProductForm onSubmitProp={createProduct} initialTitle="" initialPrice="" initialDescription =""/>
           <hr/>
           {loaded && < ProductList products={product} removeFromDom={removeFromDom}/>}
        </div>
    )
}



