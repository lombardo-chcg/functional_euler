'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

// push a number into the array
// sum the array
// count factors of the sum


function numsFrom(input) {
  let number = input;

  return function() {
    return number += 1;
  }
}

function makeNthTriangleNumber(nth) {
	let iterator = numsFrom(0);
	let output = 0;
	let counter = 0

	while (counter < nth) {
		output += iterator();
		counter ++;
	}

	return output;
}

function getFactors(num) {
	let factors = [];
	let iterator = numsFrom(0);

	let cur = iterator();

	while (cur <= num/2) {
		if (E.isFactor(cur, num)) {
			factors.push(cur)
		}

		cur = iterator();
	}

	factors.push(num);

	return factors;
}


function solution(numDivisors) {
		let getNextNaturalNumber = numsFrom(0);
		let triangleNumber = 0;
		let factorCount = 0;

		while (factorCount < numDivisors ) {
			triangleNumber += getNextNaturalNumber();
			factorCount = getFactors(triangleNumber).length;
		}

		return {
			factorCount: factorCount,
			triangleNumber: triangleNumber
		}
}

// Start the timer
const start = new Date().getTime();

const answer = solution(500);
console.log(answer);
//=> { factorCount: 576, triangleNumber: 76576500 }


// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');

//=> Execution time: 3684.09 seconds  // 61.4015 minutes
