import React, { Component } from "react";

class Counter extends Component {
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
      <fieldset>
                        <p>Your age is: {this.state.counter}</p>
                        <button onClick={this.fun1}>increase age</button>
                        <button onClick={this.fun2}>Reset</button>
                    
      </fieldset>
    );
  }
}

export default Counter;
