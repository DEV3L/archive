import React from 'react';
// nodejs library that concatenates classes
import classNames from 'classnames';
// nodejs library to set properties for components
import PropTypes from 'prop-types';
// @material-ui/core components
import withStyles from '@material-ui/core/styles/withStyles';
// @material-ui/icons

// core components
import cardFooterStyle from '../material-kit-react/components/cardFooterStyle';

function CardFooter({ ...props }) {
  const { classes, className, children, ...rest } = props;
  const cardFooterClasses = classNames({
    [classes.cardFooter]: true,
    [className]: className !== undefined,
  });
  return (
    <div className={cardFooterClasses} {...rest}>
      {children}
    </div>
  );
}

CardFooter.propTypes = {
  classes: PropTypes.object.isRequired,
  className: PropTypes.string,
};

export default withStyles(cardFooterStyle)(CardFooter);
