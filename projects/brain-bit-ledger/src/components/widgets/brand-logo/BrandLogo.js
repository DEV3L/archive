import React, { Component } from 'react';

import brainBitLogo from '../../../static/brain_bit_logo.png';

import './BrandLogo.css';

class BrandLogo extends Component {
  render() {
    const { className } = this.props;

    return (
      <div className={className}>
        <img src={brainBitLogo} id="icon" alt="brand icon" />
      </div>
    );
  }
}

export default BrandLogo;
