'use strict';

// problem details go here
// What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

// import my homemade 'Euler Utils' library & function timer
const E = require('./Euler-Utils.js');
const T = require('./Timer.js');

const bigInt = require("big-integer");

// fibObject = {
  // first: bigInt,
  // last: bigInt,
  // index: bigInt
// }

const nextFibSibs = (fibObject) => {
  return {
    first: fibObject.last,
    last: fibObject.first.plus(fibObject.last),
    index: fibObject.index + 1
  };
}

const solution = (minLength) => {
  let index = 1;
  let longest = 0;
  let fibObject = {
    first: bigInt(1),
    last: bigInt(1),
    index: index
  }

  while (longest < minLength) {
    fibObject = nextFibSibs(fibObject);
    longest = fibObject.first.toString().length;
  }

  return fibObject.index;
}

const output = T.executeAndTime(solution, [1000]);
console.log(output);
// { Solution: 4782, ExecutionTime: 0.162 }
