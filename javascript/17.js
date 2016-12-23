'use strict';

// problem details go here

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const numberToWordMap = {
  singleDigits: ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"],
  teens: ["ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"],
  doubleDigits: ["twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"],
}

const convertIntToWords = (int) => {

  if (int < 10) {
    return convertOnesColumn(int)
  }

  if (int >= 10 && int < 20 ) {
    return convertTeen(int);
  }

  if (int >= 20 && int < 100 ) {
    return convertTensColumn(int)
      .concat(convertOnesColumn(int.toString()[1]));
  }

  if (int >= 100 && int < 1000) {
    let hundredsColumn  = Number(int.toString()[0]);
    let tensColumn      = Number(int.toString()[1]);
    let onesColumn      = Number(int.toString()[2]);

    let lastTwoDigits = convertIntToWords(Number([tensColumn, onesColumn].join('')));

    return [
        convertOnesColumn(hundredsColumn),
        "hundredand",
        lastTwoDigits
      ]
      .join('')
      .replace(/and$/, "");
  }

  if (int === 1000) {
    return "onethousand"
  }
}

const convertOnesColumn = (int) => numberToWordMap.singleDigits[int];

const convertTeen = (int) => {
  let secondDigit = Number(int.toString()[1]);

  return numberToWordMap.teens[secondDigit];
}

const convertTensColumn = (int) => {
  let tensColumn = Number(int.toString()[0]);

  return numberToWordMap.doubleDigits[tensColumn-2];
}

const solution = (max) => {
  let counter = 1;
  let charCount = 0;

  while (counter <= max) {
    charCount += convertIntToWords(counter).length;
    counter += 1;
  }

  return charCount;
}

// Start the timer
const start = new Date().getTime();

const answer = solution(1000);
console.log(answer);
// => 21124

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time:  0.088 seconds
