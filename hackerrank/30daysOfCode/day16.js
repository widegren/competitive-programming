/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem} Day 16: Exceptions - String to Integer
 * @author Emelie Widegren <widegren.emelie@gmail.com>
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

function readLine () {
  return inputStdinArray[inputCurrentline++]
}

function main () {
  const S = readLine()
  try {
    console.log(parseInt(S).toString().replace('NaN', 'Bad String'))
  } catch (err) {
    console.log('Bad String')
  }
}
