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
  let counter = 1;
  let amicableNums = [];

  while (counter < 10000) {
    if (isPartOfAmicablePair(counter)) {
      amicableNums.push(counter)
    }

    counter += 1;
  }

  console.log(amicableNums)
  // => [ 220, 284, 1184, 1210, 2620, 2924, 5020, 5564, 6232, 6368 ]

  return E.sumArray(amicableNums)
}

// Start the timer
const start = new Date().getTime();

const answer = solution(284);
console.log(answer);
// => 31626

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time: 7.582 seconds
