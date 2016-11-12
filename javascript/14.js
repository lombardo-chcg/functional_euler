'use strict';

// The following iterative sequence is defined for the set of positive integers:
//
// n → n/2 (n is even)
// n → 3n + 1 (n is odd)
//
// Using the rule above and starting with 13, we generate the following sequence:
//
// 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
// It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
// Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
// Which starting number, under one million, produces the longest chain?
//
// NOTE: Once the chain starts the terms are allowed to go above one million.


// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const isEven = num => num % 2 === 0;

function getSequence(num) {
  let steps = 0

  while (num !== 1) {
    if (isEven(num)) {
      num = num/2;
      steps += 1;
    } else {
      num = (num*3) + 1
      steps += 1;
    }
  }

  return steps + 1;
}

function solution(max) {
  let current = 5;
  let maxSteps = 0;
  let answer = 0;

  while (current < max) {
    let currentSteps = getSequence(current);

    if (currentSteps > maxSteps) {
      maxSteps = currentSteps;
      answer = current;
    }

    current += 1;
  }

  return answer;
}

// Start the timer
const start = new Date().getTime();

const answer = solution(1000000);
console.log(answer);
// => 837799

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time: 3.6790000000000003 seconds
