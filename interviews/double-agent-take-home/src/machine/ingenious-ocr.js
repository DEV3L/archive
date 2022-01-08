const range = require('range');

const parseCharacter = require('../characters/parse-character');

class IngeniousOCR {
  read(accountLines) {
    const chunkedAccountCharacters = this._chunkAccountCharacters(accountLines);
    const account = this._parseAccount(chunkedAccountCharacters);
    // TODO: checksum account (story 2)
    return account;
  }

  _chunkAccountCharacters(accountLines) {
    return range.range(0, 9).map(index => {
      const window = index * 3;
      const characterLength = 3;

      return range.range(0, 3).map(index => {
        return accountLines[index].slice(window, window + characterLength);
      });
    });
  }

  _parseAccount(chunkedAccountCharacters) {
    return chunkedAccountCharacters.reduce((account, character) => {
      return parseCharacter(account, character);
    }, '');
  }
}

module.exports = IngeniousOCR;
