class AccountReader {
  parse(fileContents) {
    const fileLines = fileContents.split('\n');

    return fileLines.reduce((fileInformation, fileLine, index) => {
      let lines = fileInformation.lines || [];
      const accounts = fileInformation.accounts || [];

      if (fileLine === '' && lines.length > 0) {
        accounts.push(lines);
        lines = [];
      } else {
        lines.push(fileLine);
      }

      fileInformation.accounts = accounts;
      fileInformation.lines = lines;

      return fileInformation;
    }, {}).accounts;
  }
}

module.exports = AccountReader;
