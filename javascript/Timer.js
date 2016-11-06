'use strict';

var exports = module.exports = {};

exports.timeOperation = timeOperation;

function timeOperation(func, args) {
  const start = new Date().getTime();

  // do work

  const end = new Date().getTime();
  const elapsed = (end - start) * .001;

  return 'Execution time: ' + elapsed + ' seconds';
}
