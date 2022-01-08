const assert = require('assert');

const AccountReader = require('./account-reader');

describe('Bank Account File Reader', function() {
  it('Reads the Bank File', function() {
    // prettier-ignore
    const expectedFileContents =
      "    _  _     _  _  _  _  _ \n" +
      "  | _| _||_||_ |_   ||_||_|\n" +
      "  ||_  _|  | _||_|  ||_| _|\n"

    const accountReader = new AccountReader();
    const fileContents = accountReader.read('bank-small.txt');

    assert.equal(expectedFileContents, fileContents);
  });
});
