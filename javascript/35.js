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

// const answer = primeSieve(1000000);
// console.log(answer);
//
// const canoniacalNumsArray = canoniacalNums(answer);
// console.log(canoniacalNumsArray)

function canoniacalNums(array) {
  let collection = []

  array.forEach(number => {
    let canonicalNum =
      (number)
      .toString()
      .split('')
      .sort((a, b) => a - b )
      .join('');

      collection.push(
        {
          number: number,
          canonicalNum: Number(canonicalNum)
        }
      );
  });

  return collection;
}

function groupBy(array, property) {

  return array.reduce((outputObject, currentValue) => {
    (outputObject[currentValue[property]] =
      outputObject[currentValue[property]] || [])
      .push(currentValue);

    return outputObject;
  }, {});
}

function isMirrorNumber(numberString) {

  /*
  *
  * // TO DO:
  * FIX THIS JANK ASS SHIT
  * THIS IS A PALINDROME CHECK
  * NOT THE RIGHT TOOL FOR THIS JOB
  *
  */

  let asArray =
    numberString
    .split('')

  let asReversedArray =
    numberString
    .split('')
    .reverse()

  return arraysIdentical(asArray, asReversedArray)
}

function findGroupsWhereKeyLengthEqualsArrayLength(groupedCollection) {
  let keys = Object.keys(groupedCollection);

  return keys.filter(key => {
    return (
      isMirrorNumber(key)
      ||
      key.length === groupedCollection[key].length
    )
  })
  .map(key => groupedCollection[key])
}

function flatten(array) {

  return array.reduce((outputArray, current) => {
    return outputArray.concat(current);
  }, []);
}

// const x = groupBy(canoniacalNumsArray, 'canonicalNum');
// const y = findGroupsWhereKeyLengthEqualsArrayLength(x)
// console.log(flatten(y).length)


function arraysIdentical(a, b) {
    var i = a.length;
    if (i != b.length) return false;
    while (i--) {
        if (a[i] !== b[i]) return false;
    }
    return true;
};
