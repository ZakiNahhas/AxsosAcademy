import React from 'react'

const TabDisplay = (props) => {
  return (
    <div>

        <textarea value={props.tabToShow===""?"":"This is "+props.tabToShow}></textarea>
    </div>
  )
}

export default TabDisplay