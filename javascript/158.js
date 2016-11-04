'use strict';

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const alphabet = "abcdefghijklmnopqrstuvwxyz";

const transformStringToCharCode = (input) => {
  return input
    .split("")
    .map(letter => letter.charCodeAt(0))
}



const answer = transformStringToCharCode(alphabet);
console.log(answer);
