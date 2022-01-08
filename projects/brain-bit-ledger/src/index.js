import React from 'react';
import ReactDOM from 'react-dom';

import App from './app/App';
import registerServiceWorker from './registerServiceWorker';

import 'bootstrap/dist/css/bootstrap.css';
import 'font-awesome/css/font-awesome.css';
import './assets/css/index.css';
import './assets/css/material-kit-react.css?v=1.3.0';

ReactDOM.render(<App />, document.getElementById('root'));

registerServiceWorker();
