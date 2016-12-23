'use strict';

// Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const isAbundantNum = (num) => {
  return (E.sumArray(E.factorsOf(num))) > num;
}

const allAbundantNums = (max) => {
  return E.createRange(2,max)
    .filter(isAbundantNum);
}

const solution = () => {

}

// Start the timer
const start = new Date().getTime();

const answer = allAbundantNums(100);
console.log(answer);
// =>

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time:    seconds
