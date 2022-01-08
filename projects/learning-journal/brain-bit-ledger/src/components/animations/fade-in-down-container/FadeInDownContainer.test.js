import React from 'react';
import ReactDOM from 'react-dom';
import FadeInDownContainer from './FadeInDownContainer';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<FadeInDownContainer component={() => <div />} />, div);
  ReactDOM.unmountComponentAtNode(div);
});
