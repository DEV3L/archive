import React, { Component } from 'react';
import Analytics from 'react-router-ga';
import withFirebaseAuth from 'react-auth-firebase';
import { BrowserRouter, Route } from 'react-router-dom';

import Login from '../containers/login/Login';
import AuthenticatedRoute from '../components/authenticated-route/AuthenticatedRoute';

import GoogleAnalytics from '../analytics/googleAnalytics';
import Hotjar from '../analytics/hotjar';

import firebase, { authConfig } from '../daos/firebase';

import './App.css';

import Dashboard from '../containers/dashboard/Dashboard';
import Feed from '../containers/feed/Feed';

class App extends Component {
  constructor() {
    super();
    this.hotjar = new Hotjar();
    this.googleAnalytics = new GoogleAnalytics();
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

    const isAuthenticated = !!user;

    console.log('>>>>>>>>>>>>>>> HERE IN APP !!!!' + user + ' - ' + isAuthenticated);

    return (
      <BrowserRouter>
        <Analytics id={this.googleAnalytics.gaTrackingNumber} debug>
          <div>
            <Route
              exact
              path="/login"
              render={props => {
                return <Login {...props} />;
              }}
            />
            <AuthenticatedRoute exact path="/" authenticated={isAuthenticated} component={Dashboard} />
            <AuthenticatedRoute exact path="/there" authenticated={isAuthenticated} component={Dashboard} />
            <AuthenticatedRoute exact path="/feed" authenticated={isAuthenticated} component={Feed} />
          </div>
        </Analytics>
      </BrowserRouter>
    );
  }
}

export default withFirebaseAuth(App, firebase, authConfig);
