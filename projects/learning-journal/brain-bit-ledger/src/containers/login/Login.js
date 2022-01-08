import React, { Component } from 'react';
import withFirebaseAuth from 'react-auth-firebase';
import { Redirect } from 'react-router-dom';

import FadeInDownContainer from '../../components/animations/fade-in-down-container/FadeInDownContainer';
import LoginForm from '../../components/forms/login-form/LoginForm';

import firebase, { authConfig } from '../../daos/firebase';

import './Login.css';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      login: '',
      redirect: false,
    };
  }

  render() {
    const {
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
    } = this.props;

    const { from } = this.props.location.state || { from: { pathname: '/' } };
    console.log('>>>>>> FROM: ');
    console.log(from);

    console.log('<<<<<<<<<< USER');
    console.log(user);
    if (!!user) {
      return <Redirect to={from} />;
    }

    return (
      <FadeInDownContainer
        component={() => (
          <LoginForm signInWithGoogle={signInWithGoogle} login={this.state.login} password={this.state.password} />
        )}
      />
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

export default withFirebaseAuth(Login, firebase, authConfig);
