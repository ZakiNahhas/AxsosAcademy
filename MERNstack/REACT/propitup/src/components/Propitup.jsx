import React, { Component } from 'react'

export default class Propitup extends Component {
  render(props) {
    return (
      <div className='margin'>
        <h1>{this.props.name}</h1>
        <p>Age: {this.props.age}</p>
        <p>Hair color: {this.props.hairColor}</p>
      </div>
    )
  }
}
