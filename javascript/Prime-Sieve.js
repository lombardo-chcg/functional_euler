'use strict';

const E = require('./Euler-Utils.js');

// import my homemade 'Euler Utils' library
var exports = module.exports = {};

exports.primeSieve = primeSieve;


//PRIVATE
// functional incremental output
const numsFrom = (input) => {
  let number = input;

  return function() {
    return number += 1;
  }
}

//PRIVATE
// returns an array containing numbers that are not a multipe of the input provided,
// within the range specifed by 2nd param
function sieveMultiplesOf(multiple, max) {
  let output = [];
  let iterator = numsFrom(multiple);

  while (E.lastIn(output) < max) {
    let cur = iterator();

    if (cur % multiple != 0) {
      output.push(cur)
    } else {
      output.push(false)
    }
  }

  return E.cleanResult(max, output);
}

//PRIVATE
// takes an array and sieves out multiples of first param
function reSieve(multiple, array) {

  let funVariable = multiple + multiple;

  let max = array.length+2;

  while (funVariable < max) {
    let position = array.indexOf(funVariable);
    array[position] = false;
    funVariable = funVariable + multiple;
  }

  return array;

  // return array.map(num => {
  //   if (num <= multiple || num % multiple !== 0) {
  //     return num;
  //   } else {
  //     return false;
  //   }
  // });
}

// in an array of numbers and booleans, for example,
// finds the next number in the array given a starting number
function findNextNumberInArray(number, array) {
  let index = array.indexOf(number) + 1;
  let nextNum;
  let flag = false;

  while (!flag) {
    if (typeof(array[index]) === 'number') {
      nextNum = array[index];
      flag = true;
    }

    index ++;
  }

  return nextNum;
}

// PUBLIC
// returns an array of all prime numbers below the max
function primeSieve(max) {
  let output = sieveMultiplesOf(2, max)
  let counter = 3;
  let baseMultipes = [2,3]

  while (counter*2 < max) {
    output = reSieve(counter, output);
    counter = findNextNumberInArray(counter, output)
  }

  output.unshift(2);

  return output
    .filter(item => item !== false);
}
