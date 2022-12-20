import React from 'react'
import { Link } from 'react-router-dom';
import axios from 'axios';
import DeleteButton from './DeleteButton';

const ProductList = (props) => {
    const { removeFromDom } = props;
    
    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/products/' + productId)
            .then(res => {
                removeFromDom(productId)
            })
            .catch(err => console.error(err));
    }
    return (
        <div style={{width:'20%', margin:'0 auto'}}>
            {props.products.map( (p, i) =>
                <p key={i}>
            <Link to={"/products/" + p._id}>
                {p.title}
            </Link>, {p.price}, {p.description}
            
            <p> <DeleteButton productId={p._id} successCallback={()=>removeFromDom(p._id)}/></p>
            </p>
            
            )}
            
        </div>
    )
}
    
export default ProductList;

