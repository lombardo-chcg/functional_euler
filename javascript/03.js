// The prime factors of 13195 are 5, 7, 13 and 29.

// What is the largest prime factor of the number 600851475143 ?

'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const answer = E.lastIn(E.primesIn(E.factorsToSquareRootOf(600851475143)));
console.log(answer);