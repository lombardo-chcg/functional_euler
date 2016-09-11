// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

function hasConsecutiveFactorsUpTo(number) {
  let candidate = number;
  let counter = number;

  while (counter >= 1) {
    if (E.isFactor(counter, candidate)) {
      counter -= 1;
    } else {
      counter = number;
      candidate += number;
    }
  }

  return candidate;
}

const answer = hasConsecutiveFactorsUpTo(20);
console.log(answer);
