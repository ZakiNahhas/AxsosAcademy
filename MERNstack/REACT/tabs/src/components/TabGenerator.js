import React from 'react'

const TabGenerator = (props) => {
    const tabArray=["Tab 1","Tab 2","Tab 3"]
    const tabHandler= (e,tab)=>{
        props.tabName(tab);
    }

  return (
    <div>

        {tabArray.map((tab,i)=>
            <button id="labelId"  key={i} onClick={(e)=>{tabHandler(e,tab)}}>{tab}</button>)}
    </div>
  )
}

export default TabGenerator