/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-class-vs-instance/problem} Day 4: Class vs. Instance
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */

process.stdin.resume()
process.stdin.setEncoding('ascii')

var inputStdin = ''
var inputStdinArray = ''
var inputCurrentLine = 0

process.stdin.on('data', function (data) {
  inputStdin += data
})

process.stdin.on('end', function () {
  inputStdinArray = inputStdin.split('\n')
  main()
})

function readLine () {
  return inputStdinArray[inputCurrentLine++]
}

function Person (initialAge) {
  var age = initialAge
  if (initialAge < 0) {
    age = 0
    console.log('Age is not valid, setting age to 0.')
  }
  this.amIOld = function () {
    if (age < 13) {
      console.log('You are young.')
    } else if (age >= 18) {
      console.log('You are old.')
    } else {
      console.log('You are a teenager.')
    }
  }
  this.yearPasses = function () {
    age++
  }
}

function main () {
  const T = parseInt(readLine())
  var i = 0
  while (++i < T) {
    var age = parseInt(readLine())
    var p = new Person(age)
    p.amIOld()
    for (var j = 0; j < 3; j++) {
      p.yearPasses()
    }
    p.amIOld()
    console.log('')
  }
}
