// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
// Find the sum of all the primes below two million.

'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

// import my homemade 'Prime Sieve' library
const P = require ('./Prime-Sieve.js')


// Start the timer
const start = new Date().getTime();


const answer = E.sumArray(P.primeSieve(2000000));
console.log(answer); //=> 142913828922


// Stop the timer 
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time: 84105.303 seconds / 23.3625841667 hours
