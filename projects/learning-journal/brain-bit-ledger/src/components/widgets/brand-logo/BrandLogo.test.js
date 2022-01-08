import React from 'react';
import { shallow } from 'enzyme';
import BrandLogo from './BrandLogo';

describe('<BrandLogo />', () => {
  it('renders BrandLogo', () => {
    const input = shallow(<BrandLogo value={'eulav'} />);
    expect(input.find('img').length).toEqual(1);
  });
});
