'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

// push a number into the array
// sum the array
// count factors of the sum


function solution(numDivisors) {
	let naturalNumsArray = [1];
	let triangleNumberArray = []
	let divisorCount = triangleNumberArray.length;

	while (divisorCount < numDivisors) {

		let currentTriangleNum = E.lastIn(triangleNumberArray);
		let factors = E.factorsOf(currentTriangleNum)
		factors.push(currentTriangleNum)
		divisorCount = factors.length;
		
		console.log(divisorCount)

		if (divisorCount < numDivisors) {
			triangleNumberArray.push(E.sumArray(naturalNumsArray))
			naturalNumsArray.push(E.lastIn(naturalNumsArray) + 1)
		}

	}

	return E.lastIn(triangleNumberArray);
}

const answer = solution(45);
console.log(answer);