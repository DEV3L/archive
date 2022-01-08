const fs = require('fs');

class AccountReader {
  read(fileName) {
    return fs.readFileSync(`./data/${fileName}`, 'utf8');
  }
}

module.exports = AccountReader;
