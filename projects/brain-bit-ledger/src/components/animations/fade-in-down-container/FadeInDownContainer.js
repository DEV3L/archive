import React, { Component } from 'react';

import './FadeInDownContainer.css';

class SlideDown extends React.Component {
  render() {
    const { component: Component, children, ...rest } = this.props;

    return (
      <div className="container-fluid height-full wrapper FadeInDownContainer-fadeInDown">
        <Component {...rest}>{children}</Component>
      </div>
    );
  }
}

export default SlideDown;
