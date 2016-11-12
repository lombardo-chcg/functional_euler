'use strict';

//2**15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

// What is the sum of the digits of the number 2**1000?

var bigInt = require("big-integer");

const solution = (exponent) => {

  return bigInt(2)
    .pow(exponent)
    .toString()
    .split("")
    .map(i =>  Number(i))
    .reduce((acc, cur) => acc + cur);
}

// Start the timer
const start = new Date().getTime();

const answer = solution(1000);
console.log(answer);
// => 1366

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time: 0.029 seconds
