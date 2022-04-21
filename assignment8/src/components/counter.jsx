import React, { Component } from "react";

class Counter extends Component {
  state = {
    // Object that includes any data that this component needs
    count: 0,
    imgUrl: "https://picsum.photos/200",
  };

  render() {
    return (
      //Divs without a div in hierarchy
      <React.Fragment>
        <img src={this.state.imgUrl} alt="" />
        <span className="badge badge-primary">{this.formatCount()}</span>
        <button>Increment</button>
      </React.Fragment>
    );
  }

  formatCount() {
    const { count } = this.state;
    return count === 0 ? <h1>Zero</h1> : count;
  }
}

export default Counter;
