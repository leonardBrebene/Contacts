import React from 'react'

class Experiment extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState({
      count: this.state.count + 1
    })
  }
  tick() {
    let a = new Date().toLocaleTimeString()
    return a
  }

  render() {

    function tick() {
      let a = new Date().toLocaleTimeString()
      return a
    }
    setInterval(tick, 1000);




    return (
      <div>

        <button onClick={this.handleClick}>
        <h1>{this.props.label}{this.state.count}</h1>
        </button>
          
          <h1>Hello, world!</h1>
          <h2>It is .</h2>
        
      </div>
    );
  }
 


}

export default Experiment;