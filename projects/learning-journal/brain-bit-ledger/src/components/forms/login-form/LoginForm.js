import React from 'react';

import { Col, Row } from 'reactstrap';

import BrandLogo from '../../../components/widgets/brand-logo/BrandLogo';
import Input from '../../../components/widgets/input/Input';

import facebook_auth_icon from '../../../static/facebook_auth_icon.svg';
import github_auth_icon from '../../../static/github_auth_icon.svg';
import google_auth_icon from '../../../static/google_auth_icon.svg';
import twitter_auth_icon from '../../../static/twitter_auth_icon.svg';

class LoginForm extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      login: '',
      password: '',
    };
  }

  render = () => {
    const { login, signInWithGoogle } = this.props;
    return (
      <div id="formContent">
        <BrandLogo className="my-3 fadeIn first" />
        <Col md={10} className="container-fluid">
          <Input
            id="login"
            type="text"
            value={this.props.login}
            className="mb-3 px-4 py-3 rounded border-0 fadeIn second"
            placeholder="login"
            onChange={login => {
              this.setState({ login });
            }}
          />
          <Input
            id="password"
            type="password"
            value={this.props.password}
            className="mb-3 px-4 py-3 rounded border-0 fadeIn third"
            placeholder="password"
            onChange={password => {
              this.setState({ password });
            }}
          />
          <input type="submit" className="rounded fadeIn fourth pointer" value="Log In" />
        </Col>
        <div className="m-0 px-4 pt-2 pb-0 container-fluid fadeIn fifth">
          <hr className="mp-0" />
        </div>
        <Row className="mx-0 mb-3 mt-2 p-0 fadeIn fifth">
          <Row className="m-auto p-0">
            <div className="mx-2 my-0 p-2 border rounded-circle shadow pointer Login-icon-animation">
              <img className="m-auto" src={facebook_auth_icon} style={{ width: 35 }} />
            </div>
            <div className="mx-2 my-0 p-2 border rounded-circle shadow pointer Login-icon-animation">
              <img className="m-auto" src={github_auth_icon} style={{ width: 35 }} />
            </div>
            <div className="mx-2 my-0 p-2 border rounded-circle shadow pointer Login-icon-animation">
              <img onClick={signInWithGoogle} className="m-auto" src={google_auth_icon} style={{ width: 35 }} />
            </div>
            <div className="mx-2 my-0 p-2 border rounded-circle shadow pointer Login-icon-animation">
              <img className="m-auto" src={twitter_auth_icon} style={{ width: 35 }} />
            </div>
          </Row>
        </Row>
        <div id="formFooter" className="fadeIn fifth">
          <a className="m-2 underlineHover" href="#">
            Create Account
          </a>
          <span className="mx-4">/</span>
          <a className="m-2 underlineHover" href="#">
            Forgot Password
          </a>
        </div>
      </div>
    );
  };
}

export default LoginForm;
