import {useEffect, useState} from "react";
import axios from "axios";
import { Link, navigate } from '@reach/router';

const Luke = () => {
  const [id, setId] = useState("");
  const [opt, setOpt] = useState("people");
  
  const handleSelect = (e) => {
    setOpt(e.target.value);
    console.log(opt);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    navigate("/" + opt + "/" +id)  
  };
  return (
    <div>
      <form style={{marginTop:'10px'}} onSubmit={handleSubmit}>
      <label style={{marginRight:'10px'}}> Select a category :</label>
        <select style={{backgroundColor:'lightgray', borderRadius:'3px', width:'150px', marginRight:'20px'}} value={opt} onChange={handleSelect}>
          <option selected="select">select an option</option>
          <option value="people">People</option>
          <option value="planets">Planets</option>
          <option value="starships">Star ships</option>
        </select>
        <label style={{marginRight:'10px'}}> ID:</label>
        <input required style={{backgroundColor:'lightgray', borderRadius:'3px', width:'50px'}} type="number" onChange={(e) => setId(e.target.value)} />
        <button style={{marginLeft:'15px', backgroundColor:'lightgray', borderRadius:'3px'}}> Search </button>
      </form>
    </div>
  );
};

export default Luke;
