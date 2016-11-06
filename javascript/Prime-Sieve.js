'use strict';

const E = require('./Euler-Utils.js');

// import my homemade 'Euler Utils' library
var exports = module.exports = {};

exports.primeSieve = primeSieve;

const numsFrom = (input) => {
  let number = input;

  return function() {
    return number += 1;
  }
}

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
