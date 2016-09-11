// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

// Find the sum of all the multiples of 3 or 5 below 1000.
'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const answer = E.sumArray(E.uniqueNumbersOnly(E.combineArrays(E.getMultiplesBelow(3,1000), E.getMultiplesBelow(5,1000))))
console.log(answer);

