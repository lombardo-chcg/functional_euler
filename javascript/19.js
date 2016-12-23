'use strict';

// How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

// 1 Jan 1901 = Tuesday 

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const isLeapYear = (year) => {
  if (year % 100 === 0) {
    if (year % 400 === 0 && year % 4 === 0 ){

      return true;
    }

    return false;
  }

  if (year % 4 === 0) {
    return true;
  }

  return false;
}

const solution = () => {

}

// Start the timer
const start = new Date().getTime();

const answer = isLeapYear(1900);
console.log(answer);
// =>

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time:    seconds
