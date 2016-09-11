// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

// Find the largest palindrome made from the product of two 3-digit numbers.

'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

function isPalindrome(input) {
  let word = input.toString();

  if (word == word.split('').reverse().join('')) {
    return true;
  }

  return false;
}

function getThreeDigitFactors(number) {
  return E.factorsOf(number).filter( (factor) => factor.toString().length === 3);
}

function checkFactorsForProduct(array, product) {
  let solved = false;
  let highToLow = array.reverse();
  let pair = [];


    highToLow.forEach( (number) => {
      let index = 0;
      // console.log(number * array[index]);

      for (index; index < array.length-1; index += 1)
        if (number * array[index] === product) {
          pair = [number, array[index]]
        }
    })


  return pair;
}

function palindromeNumFinder() {
  let solved = false;
  let max = 999 * 999;
  let result;

  for (max; max > 0; max -= 1) {
    if (isPalindrome(max)) {
      let factors = getThreeDigitFactors(max);

      if (checkFactorsForProduct(factors, max).length == 2) {
        solved = true;
        return checkFactorsForProduct(factors, max)
      }
    }
  }

  return result;
}


const answer = E.multiplyArray(palindromeNumFinder());
console.log(answer);