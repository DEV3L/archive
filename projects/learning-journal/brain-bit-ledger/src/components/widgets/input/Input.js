import React, { Component } from 'react';
import { Input as BootstrapInput } from 'reactstrap';

import './Input.css';

class Input extends Component {
  constructor(props) {
    super(props);
    this.state = {
      value: this.props.value || '',
    };
  }

  render() {
    const { value: propsValue, onChange, ...rest } = this.props;
    const { value } = this.state;

    return <BootstrapInput onChange={this.onChange} value={value} {...rest} />;
  }

  onChange = e => {
    const value = e.target.value;
    this.setState({ value });
    this.props.onChange(value);
  };
}

export default Input;
