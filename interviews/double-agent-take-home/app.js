const AccountParser = require('./src/machine/account-parser');
const AccountReader = require('./src/machine/account-reader');
const IngeniousOCR = require('./src/machine/ingenious-ocr');

const FILE_NAME = 'bank-numbers.txt';

const accountReader = new AccountReader();
const fileContents = accountReader.read(FILE_NAME);

const accountParser = new AccountParser();
const accounts = accountParser.parse(fileContents);

accounts.forEach(account => {
  const ocrMachine = new IngeniousOCR();
  const accountNumber = ocrMachine.read(account);
  console.log(accountNumber);
});
