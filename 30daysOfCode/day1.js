/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-data-types/problem Day 1: Data Types}
 * @author Emelie Widegren <emeliewide@gmail.com>
 */

process.stdin.resume()
process.stdin.setEncoding('ascii')

var inputStdin = ''
var inputStdinArray = ''
var inputCurrentline = 0

process.stdin.on('data', function (data) {
  inputStdin += data
})

process.stdin.on('end', function () {
  inputStdinArray = inputStdin.split('\n')
  main()
})

// Reads complete line from STDIN
function readLine () {
  return inputStdinArray[inputCurrentline++]
}

function main () {
  var i = 4
  var d = 4.0
  var s = 'HackerRank '

  // Declare second integer, double, and String variables.
  // Read and save an integer, double, and String to your variables.
  var secondInteger = parseInt(readLine())
  var secondDouble = parseFloat(readLine())
  var secondStr = readLine()

  // Print the sum of both integer variables on a new line.
  console.log(i + secondInteger)

  // Print the sum of the double variables on a new line.
  console.log((d + secondDouble).toFixed(1))

  // Concatenate and print the String variables on a new line
  // The 's' variable above should be printed first.
  console.log(s + secondStr)
}
