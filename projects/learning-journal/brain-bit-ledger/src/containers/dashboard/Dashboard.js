import React, { Component } from 'react';
import classNames from 'classnames';
import withFirebaseAuth from 'react-auth-firebase';
import withStyles from '@material-ui/core/styles/withStyles';
import { Col, Row } from 'reactstrap';
import { Redirect } from 'react-router-dom';

import Parallax from '../../components/parallax/Parallax';
import Header from '../../components/header/Header';
import HeaderLinks from '../../components/header/HeaderLinks';

import Badge from '../../components/material-kit/Badge/Badge';
import GridContainer from '../../components/material-kit/Grid/GridContainer';
import GridItem from '../../components/material-kit/Grid/GridItem';

import firebase, { authConfig } from '../../daos/firebase';
import componentsStyle from '../../components/material-kit/material-kit-react/views/components.js';

import './Dashboard.css';

import brain_nodes from '../../assets/img/brain_nodes.png';

class Dashboard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      login: '',
      redirect: false,
    };
  }

  render() {
    const {
      classes,
      signInWithEmail,
      signUpWithEmail,
      signInWithGoogle,
      signInWithFacebook,
      signInWithGithub,
      signInWithTwitter,
      facebookAccessToken,
      githubAccessToken,
      twitterAccessToken,
      twitterSecret,
      user,
      error,
      signOut,
      ...rest
    } = this.props;
    console.log(user);

    return (
      <div style={{ background: 'linear-gradient(to bottom, #222222, #56baf2)' }}>
        <Header height={100} color="dark" brand="Brain Bit Ledger" rightLinks={<HeaderLinks />} fixed {...rest} />
        <Header height={100} color="dark" brand="Brain Bit Ledger" rightLinks={<HeaderLinks />} fixed {...rest} />
        <Parallax image={brain_nodes}>
          <div className={classes.container}>
            <GridContainer>
              <GridItem>
                <div className={classes.brand}>
                  <h3 className={classes.title}>
                    Brain Bit <span className="small">- Professional Knowledge Tracking</span>
                  </h3>
                  <h5 className={classes.subtitle}>A hub to track the various forms of your professioal growth.</h5>
                </div>
              </GridItem>
            </GridContainer>
          </div>
        </Parallax>

        <div className={classNames(classes.main, classes.mainRaised)}>
          <div className={classes.title}>
            <h3>Badges</h3>
          </div>
          <Badge>default</Badge>
          <Badge color="primary">primary</Badge>
          <Badge color="info">info</Badge>
          <Badge color="success">success</Badge>
          <Badge color="warning">warning</Badge>
          <Badge color="danger">danger</Badge>
          <Badge color="rose">rose</Badge>
          <h1 style={{ height: 900 }}>Here!</h1>
        </div>
      </div>
    );
  }
}

class IconAdder extends React.Component {
  render() {
    const { tag, onClick, children, ...rest } = this.props;
    const Tag = tag;

    return (
      <Tag onClick={onClick} {...rest}>
        {' '}
        {children}
      </Tag>
    );
  }
}

export default withStyles(componentsStyle)(withFirebaseAuth(Dashboard, firebase, authConfig));
