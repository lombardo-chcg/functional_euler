'use strict';

// problem details go here

// import my homemade 'Euler Utils' library
const E = require('./Euler-Utils.js');

const fs = require('fs');  // node's File I/O library

const getNameScore = (string) => {

  return string
    .split('')
    .map(letter => (letter.charCodeAt(0) - 64))
    .reduce((acc, cur) => acc + cur);
}

const solution = () => {

  return fs.readFileSync('./p022_names.txt', 'utf8')
    .replace(/"/g, "")
    .split(/,/)
    .sort()
    .map((name, index) => (getNameScore(name) * (index+1)))
    .reduce((acc, cur) => acc + cur);
}

// Start the timer
const start = new Date().getTime();

const answer = solution();
console.log(answer);
// => 871198282

// Stop the timer
const end = new Date().getTime();
const elapsed = (end - start) * .001;

console.log('Execution time: ' + elapsed + ' seconds');
//=> Execution time: Execution time: 0.063 seconds
