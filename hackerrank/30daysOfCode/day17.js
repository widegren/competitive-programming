/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-more-exceptions/problem} Day 17: More Exceptions
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

class Calculator {
  power (n, p) {
    if (n < 0 || p < 0) {
      return 'n and p should be non-negative'
    } else return n ** p
  }
}

function main () {
  var myCalculator = new Calculator()
  var T = parseInt(readLine())
  while (T-- > 0) {
    var num = (readLine().split(' '))
    try {
      var n = parseInt(num[0])
      var p = parseInt(num[1])
      var ans = myCalculator.power(n, p)
      console.log(ans)
    } catch (e) {
      console.log(e)
    }
  }
}
