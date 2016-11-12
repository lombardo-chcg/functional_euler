'use strict';

// problem details go here

const bigInt = require("big-integer");

// type of n must be bigInt
const factorial = (n) => {
  if (n.equals(1)) {
    return 1;
  }

  return n.times( factorial(n.minus(1)) );
}

const solution = (n) => {

  return factorial(n)
    .toString()
    .split('')
    .map(i => Number(i))
    .reduce((acc, cur) => acc + cur);
}

const answer = solution(bigInt(100));

// Start the timer
const start = new Date().getTime();

console.log(answer);
// => 648

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time: 0.029 seconds
