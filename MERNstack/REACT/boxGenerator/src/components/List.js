import axios from 'axios';
import React, { useState } from 'react';
 
import useList from './useList';
 
export default () => {
    const [val, setVal] = useState('');
    const { list, add, remove } = useList([]);
 
    function handleSubmit() {
        add(val);
        setVal('');
    }

    function handleDelete() {
        remove(0);
    }
 
    return (
        <>
<br/>
            <div style={{display:'flex', justifyContent:'center'}}>
            <button style={{marginRight:'10px'}} onClick={handleSubmit}>Add</button>
            <input onClick={handleDelete} type="submit" value="Remove Box"/>
            </div>
                  <div><input
                onChange={e => setVal(e.target.value)}
                value={val}
            />
</div>
            {list.map((item, i) => <div style={{width:'100px', height:'100px', backgroundColor:item, display:'inline-block', flexDirection:'column', margin:'10px'}} key={i}></div>)}
        </>
    );
}    
