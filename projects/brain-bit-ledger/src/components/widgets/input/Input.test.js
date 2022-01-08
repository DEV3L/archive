import React from 'react';
import { shallow } from 'enzyme';
import Input from './Input';

describe('<BrandLogo />', () => {
  it('renders BrandLogo', () => {
    const input = shallow(<Input value={'eulav'} />);
    expect(input.find('Input').length).toEqual(1);
    expect(input.prop('value')).toEqual('eulav');
  });
});
