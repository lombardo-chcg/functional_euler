// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
// Find the sum of all the primes below two million.

'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

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

////////////////////////////////////
const start = new Date().getTime();
////////////////////////////////////

const PRIMES =
[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97]

const answer = primeSieve(50000);
console.log(E.lastIn(answer));

// console.log(arraysIdentical(answer, PRIMES))

//9973
//Execution time: 31.031000000000002 seconds

// sieve starting with next actual number in array
//9973
//Execution time: 2.2 seconds

// get rid of the map
// 9973
// Execution time: 1.622 seconds
// YES!!!!

////////////////////////////////////
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
////////////////////////////////////


function arraysIdentical(a, b) {
    var i = a.length;
    if (i != b.length) return false;
    while (i--) {
        if (a[i] !== b[i]) return false;
    }
    return true;
};
