'use strict';

var exports = module.exports = {};

exports.executeAndTime = executeAndTime;

function executeAndTime(functionToTime, [args]) {
  const start = new Date().getTime();

  const solution = functionToTime.call(null, [args]);

  const end = new Date().getTime();
  const elapsed = (end - start) * .001;

  return {
    Solution: solution,
    ExecutionTime: elapsed
  }
}
