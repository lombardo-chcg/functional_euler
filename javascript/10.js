// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
// Find the sum of all the primes below two million.

'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

function primeSieve(max) {
  let range = E.createRange(2, max);

  let newRange = range
    .filter( (number) => number % 2 != 0)
    .filter( (number) => number % 3 != 0)
    .filter( (number) => number % 5 != 0)
    .filter( (number) => number % 7 != 0)

  newRange.unshift(7)
  newRange.unshift(5)
  newRange.unshift(3)
  newRange.unshift(2)
  return newRange
}

console.log(primeSieve(2000000).length)
console.log(E.createRange(2,2000000).length)


const answer = E.sumArray(E.primesIn(primeSieve(2000000)));
console.log(answer);
