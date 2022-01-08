const ocrCharacterMap = require('./ocr-character-map');

const parseCharacter = (account, character) => {
  account += Object.keys(ocrCharacterMap).reduce((value, ocrValue) => {
    const ocrCharacter = ocrCharacterMap[ocrValue];
    if (compare(character, ocrCharacter)) {
      return ocrValue;
    }
    return value;
  }, 0);
  return account;
};

const compare = (character, expected) => {
  const isSame = character.reduce((isSame, characterLine, index) => {
    isSame = isSame && characterLine === expected[index];
    return isSame;
  }, true);
  return isSame;
};

module.exports = parseCharacter;
