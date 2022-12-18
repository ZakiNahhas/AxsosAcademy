import React from 'react'
import { Link, navigate } from '@reach/router';

const ReachRouting = () => {
    const handleClick = () => {
        console.log("hiiii baby");
        navigate("/");
    }
  return (
    <div>
        <Link to="/">Home page</Link>
        <br />
        <br />
        <button onClick={handleClick}>Click Me!</button>
        <br />
        <br />
    <h3>This is the about us component</h3>
    </div>
  )
}

export default ReachRouting