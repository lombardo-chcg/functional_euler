'use strict';

// problem details go here

// import my homemade 'Euler Utils' library & function timer
const E = require('./Euler-Utils.js');
const T = require('./Timer.js');

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

const output = T.executeAndTime(solution, []);
console.log(output);
// { Solution: 871198282, ExecutionTime: 0.037 }
