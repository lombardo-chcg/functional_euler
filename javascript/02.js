// Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

// By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const answer = E.sumArray(E.evenNumsInArray(E.getFibSequence(4000000)));
console.log(answer);