import React, { Component } from 'react'

export default class Propitup extends Component {
    constructor(props) {
        super(props);
        this.state = {
          counter: this.props.age,
        };
    }
    fun1 = ()=> {
        this.setState({counter:this.state.counter+1})
    }
    fun2 = ()=>{
        this.setState({counter:this.props.age})
    }
  render() {
    return (
        
      <div className='margin'>
        <h1>{this.props.name}</h1>
        <p>Age: {this.state.counter}</p>
        <p>Hair color: {this.props.hairColor}</p>
        <button id="b" className='btn btn-success' onClick={this.fun1}>Birthday button for {this.props.name}</button>
        <button className='btn btn-danger'  onClick={this.fun2}>Reset</button>
      </div>
    )
  }
}
