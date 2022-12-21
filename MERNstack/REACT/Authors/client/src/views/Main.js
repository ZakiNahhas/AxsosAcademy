import React, { useEffect, useState } from 'react';
import AuthorForm from '../components/AuthorForm';
import AuthorList from '../components/AuthorList';
import axios from 'axios';
import Detail from './Detail';
import { Link } from 'react-router-dom';


export default () => {
    const [authors, setAuthor] = useState([]);
    const [loaded, setLoaded] = useState(false);


    useEffect(()=>{
        axios.get('http://localhost:8000/api/authors')
            .then(res=>{
                setAuthor(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);

    const removeFromDom = authorId => {
        setAuthor(authors.filter(author => author._id != authorId));
    }

    return (
        <div className='App'>
            <h1>Favorite Authors</h1>
           <Link to={"/author/new"}>
            Add an author
           </Link>
           <h3>We have quotes by:</h3>
           <hr/>
           {loaded && <AuthorList authors={authors} removeFromDom={removeFromDom}/>}
        </div>
    )
}



