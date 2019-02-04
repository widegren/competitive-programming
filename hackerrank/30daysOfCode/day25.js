/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem Day 25: Running Time and Complexity}
 * @author Emelie Widegren <emeliewide@gmail.com>
 */

function processData (input) {
  let inputArray = input.split('\n')
  for (let i = 1; i < inputArray.length; i++) {
    if (isPrime(parseInt(inputArray[i]))) {
      console.log('Prime')
    } else {
      console.log('Not prime')
    }
  }
}

function isPrime (input) {
  if (input === 1) {
    return false
  }
  if (input === 2 || input === 3) {
    return true
  }
  if (input % 2 === 0 || input % 3 === 0) {
    return false
  }

  let i = 5
  let w = 2

  while (i * i <= input) {
    if (input % i === 0) {
      return false
    }
    i += w
    w = 6 - w
  }
  return true
}

process.stdin.resume()
process.stdin.setEncoding('ascii')
let _input = ''
process.stdin.on('data', function (input) {
  _input += input
})

process.stdin.on('end', function () {
  processData(_input)
})
