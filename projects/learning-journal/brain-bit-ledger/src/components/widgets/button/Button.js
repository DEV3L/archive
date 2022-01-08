import React, { Component } from 'react';
import { Button as BootstrapButton } from 'reactstrap';
import './Button.css';

class Button extends Component {
  render() {
    return <BootstrapButton {...this.props}>{this.props.text}</BootstrapButton>;
  }
}

export default Button;
