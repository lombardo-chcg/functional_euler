'use strict';

var exports = module.exports = {};

// alphabetical order
exports.arraysIdentical = arraysIdentical;

exports.cleanResult = cleanResult;
exports.combineArrays = combineArrays;
exports.convertsArgsToArray = convertsArgsToArray;
exports.createRange = createRange;

exports.evenNumsInArray = evenNumsInArray;

exports.factorsToSquareRootOf = factorsToSquareRootOf;
exports.factorsOf = factorsOf;

exports.getFibSequence = getFibSequence;
exports.getMultiplesBelow = getMultiplesBelow;

exports.multiplyArray = multiplyArray;

exports.isFactor = isFactor;
exports.isPalindrome = isPalindrome;
exports.isPrime = isPrime;
exports.isPythagoreanTriple = isPythagoreanTriple;

exports.lastIn = lastIn;
exports.nextToLastIn = nextToLastIn;

exports.primesIn = primesIn;

exports.sumArray = sumArray;
exports.sumArrayNumsSquared = sumArrayNumsSquared;
exports.sumOfArrays = sumOfArrays;

exports.squared = squared;

exports.uniqueNumbersOnly = uniqueNumbersOnly;


// returns an array holding a range.
// OPTIONS: provide a single argument, it uses 1 as the starting point
// OPTIONS: provide two arguemtns, it uses the first as the starting point and 2nd as the ending point
function createRange(args) {

  if (arguments.length === 1) {
    return generateRange(1, arguments[0]);
  }

  return generateRange(arguments[0], arguments[1])
}

// private
function generateRange(start, end) {
  let result = [];

  for (let current = start; current <= end; current += 1) {
    result.push(current)
    }

  return result;
}

// takes a collection and returns the sum of the collection when every number in the collection is squared
function sumArrayNumsSquared(array) {
  return array.reduce((accumulator, current) => accumulator += squared(current))
}

// returns a number squared
function squared(number) {
  return number * number;
}

// returns boolean
function isPrime(primeCandidate) {
  if (primeCandidate > 2 && primeCandidate % 2 === 0 ) { return false }

  if (factorsOf(primeCandidate).length == 1) {
    return true;
  }

  return false;
}

// returns boolean check on 3 digits for Pythagorean truth (a** + b** = c**)
function isPythagoreanTriple(a,b,c) {
  return squared(a) + squared(b) === squared(c)
}

// returns an array of factors for a number, up to that number's square root
function factorsToSquareRootOf(number) {
  let possibleFactors = createRange(Math.sqrt(number));
  return possibleFactors.filter((possibleFactor) => number % possibleFactor == 0);
}

// returns an array of factors for a number
function factorsOf(number) {
  let possibleFactors = createRange(number/2);
  return possibleFactors.filter((possibleFactor) => number % possibleFactor == 0);
}

// filters an array, returns a new array containing only primes
function primesIn(array) {
  return array.filter((number) => isPrime(number));
}

// returns the last item in an array
function lastIn(array){
  if (array.length === 0) {return 0};

  return array[array.length - 1];
}

// returns next to last item in an array
function nextToLastIn(array) {
  return array[array.length - 2];
}

// returns an array containing only even numbers
function evenNumsInArray(array) {
  return array.filter((number) => number % 2 == 0 )
}

// returns an array all Fib numbers below the max
function getFibSequence(max) {
  let fibSequence = [0,1];

  while (lastIn(fibSequence) <= max) {
    fibSequence.push(lastIn(fibSequence) + nextToLastIn(fibSequence))
  }

  return cleanResult(max, fibSequence)
}

// if the final number(s) in an array are greater than the supplied max,
// returns the array without the final numbers
function cleanResult(max, array) {
  if (lastIn(array) >= max) {
    array.pop();
    cleanResult(max, array)
  }

  return array;
}

// returns an array formatted version of a JavaScript arguments object
function convertsArgsToArray(args) {
  let result = [];

  for (let x = 0; x < args.length; x += 1) {
    result.push(args[x])
  }

  return result;
}

// returns the sum of all numbers in an array
function sumArray(array) {
  return array.reduce((accumulator, current) => accumulator + current )
}

function multiplyArray(array) {
  return array.reduce((accumulator, current) => accumulator * current )
}

// returns an array containing only unique elements (a set)
function uniqueNumbersOnly(array) {
  let map = {};
  let result = [];

  array.forEach((number) => {
    if (!map[number]) {
      map[number] = true;
      result.push(number)
    }
  })

  return result;
}

// takes any number of arrays and returns a single array containing all the single elements (aka flatten)
function combineArrays(putSomeArraysHere) {
  let result = [];

  convertsArgsToArray(arguments)
    .forEach((array) => Array.prototype.push.apply(result, array));

  return result;
}

// takes any numbers of arrays and returns a sum of all their elements
function sumOfArrays(putSomeArraysHere) {
  let result = 0;

  convertsArgsToArray(arguments)
    .forEach((array) => result += sumArray(array))

  return result;
}


// returns an array of all the multiples of a number from 1 to the provided max
function getMultiplesBelow(multiple, max) {
  let result = [multiple];
  let n = 2;

  while (lastIn(result) < max) {
    result.push(multiple * n);
    n += 1;
  }

  return cleanResult(max, result);
}

// returns boolean after checking for palindrome (checks input as string)
function isPalindrome(input) {
  let word = input.toString();

  if (word == word.split('').reverse().join('')) {
    return true;
  }

  return false;
}


// returns boolean based on if divisor is cleanly divisible by possible factor
function isFactor(possibleFactor, number) {
  if (number % possibleFactor === 0) {
    return true;
  }

  return false;
}

// compares 2 arrays to see if their contents are identical
function arraysIdentical(a, b) {
    var i = a.length;
    if (i != b.length) return false;
    while (i--) {
        if (a[i] !== b[i]) return false;
    }
    return true;
};
