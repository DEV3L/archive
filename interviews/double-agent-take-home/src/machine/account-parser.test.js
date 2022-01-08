const assert = require('assert');

const AccountParser = require('./account-parser');

describe('Parse Bank Account File Contents', function() {
  it('Parses the accounts', function() {
    const expectedNumberOfAccounts = 2;

    // prettier-ignore
    const fileContents =
      "    _  _     _  _  _  _  _ \n" +
      "  | _| _||_||_ |_   ||_||_|\n" +
      "  ||_  _|  | _||_|  ||_| _|\n" +
      "\n" +
      "    _  _     _  _  _  _  _ \n" +
      "  | _| _||_||_ |_   ||_||_|\n" +
      "  ||_  _|  | _||_|  ||_| _|\n" +
      "\n"

    const accountParser = new AccountParser();
    const accounts = accountParser.parse(fileContents);

    assert.equal(expectedNumberOfAccounts, accounts.length);
  });
});
