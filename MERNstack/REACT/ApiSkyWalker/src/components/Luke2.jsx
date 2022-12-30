import { React, useEffect, useState } from "react";
import axios from "axios";

const Luke2 = (props) => {
  const [responseData, setResponseData] = useState([]);
  const [loaded, setLoaded] = useState(false);
  const [error, setError] = useState("");
  useEffect(() => {
    axios
      .get("https://swapi.dev/api/" + props.opt + "/" + props.id)
      .then((response) => {
        console.log(response);
        setResponseData(response.data);
        setLoaded(true);
        setError("")
        console.log("zzzzakiii")
      })
      .catch((err) => setError("error"));
  }, [props.id, props.opt]);


  if(error =="error" || props.id <= 0) {
    return (
      <>
        <p>Sumting went wong</p>
        <img src="https://31.media.tumblr.com/52ca9d7381b01741df7a7c99d737d9eb/tumblr_mnox0uDbqN1qljb38o1_500.gif"/>
      </>
    )
    
  }
  else if (props.opt == "people") {
    return (
      <div>
        {" "}
        <h3>Name: {responseData.name}</h3>
        <p>Height: {responseData.height}</p>
        <p>Mass: {responseData.mass}</p>
        <p>Skin Color: {responseData.skin_color}</p>
        <p>Eye Color: {responseData.eye_color}</p>
      </div>
    );
   
  } else if(props.opt == "planets") {
    return (
      <div>
          {" "}
          <h3>Name: {responseData.name}</h3>
          <p>Climate: {responseData.climate}</p>
          <p>Terrain: {responseData.terrain}</p>
          <p>Surface Water: {responseData.surface_water}</p>
          <p>Population: {responseData.population}</p>
        </div>
    )
  } else {
    return(
<div>
          {" "}
          <h3>Name: {responseData.name}</h3>
          <p>Model: {responseData.model}</p>
          <p>Manufacturer: {responseData.manufacturer}</p>
          <p>Length: {responseData.length}</p>
          <p>Passengers: {responseData.passengers}</p>
        </div>
    )
    
  }
 
};

export default Luke2;
