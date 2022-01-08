import React, { Component } from 'react';
import withFirebaseAuth from 'react-auth-firebase';

import { Col, Row } from 'reactstrap';

import firebase, { authConfig } from '../../daos/firebase';

import './Feed.css';

class Feed extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <Col md={10} className="container-fluid">
        <h1>Feed!</h1>
        <button onClick={this.props.signOut}>Sign Out</button>
      </Col>
    );
  }
}

export default withFirebaseAuth(Feed, firebase, authConfig);
