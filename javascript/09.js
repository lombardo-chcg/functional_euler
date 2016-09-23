'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

function pythagoreanTripleWithSum(sum) {
  let a = 1;
  let b;

  for (a; a < sum; a += 1) {
    for (b = a+1; b < sum; b += 1 ) {
      let c = sum - a - b;

      if (E.isPythagoreanTriple(a,b,c)) {
        return E.multiplyArray([a,b,c]);
      }
    }
  }
  return 0;
}

const answer = pythagoreanTripleWithSum(1000);
console.log(answer);
