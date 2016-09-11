// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
// What is the 10 001st prime number?

'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

function nthPrime(n) {
  let primes = [];
  let index = 2;

  while (primes.length < n) {
    if (E.isPrime(index)) {
      primes.push(index);
      index += 1;
    } else {
      index += 1;
    }
    console.log(primes.length)
  }

  return E.lastIn(primes);
}

var start = new Date().getTime();

const answer = nthPrime(10001);
console.log(answer);

var end = new Date().getTime();
var time = (end - start) * .001;
console.log('Execution seconds: ' + time);

// TO DO - implement a better algorithm such as https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.  as is, Execution seconds: 233.473
