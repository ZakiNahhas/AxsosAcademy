import React, { useEffect, useState } from 'react';
import axios from 'axios';

const APIReq = props => {
  const [responseData, setResponseData] = useState(null); //or use an empty array => [] rather than null
  const [loaded, setLoaded] = useState(false);
  useEffect(()=>{
    axios.get("https://swapi.dev/api/people")
      .then(response=>{setResponseData(response.data.results);setLoaded(true)})
            .catch(err => console.log(err))
  }, []); //this is a dependancy // only renders when this is present   
  return(
    <div>
      {loaded && responseData.map(poke => <p>{poke.name}</p>)}
    </div>
  )
}
export default APIReq;


