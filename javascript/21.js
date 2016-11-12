'use strict';

// problem details go here

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const sumOfDivisors = (num) => {
  let factors = E.factorsOf(num);

  if (factors.length >= 1) {
    return E.sumArray(factors);
  }

  return 0;
}

const isPartOfAmicablePair = (a) => {
  let b = sumOfDivisors(a);
  let c = sumOfDivisors(b);

  if (a !== b && a === c) {
    return true;
  }

  return false;
}

const solution = (num) => {

  return E.createRange(num-1)
    .filter(isPartOfAmicablePair)
    .reduce((acc, cur) => acc + cur)
}

// Start the timer
const start = new Date().getTime();

const answer = solution(10000);
console.log(answer);
// => 31626

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time: 7.414000000000001 seconds
