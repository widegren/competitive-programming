'use strict'

/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-inheritance/problem} Day 12: Inheritance
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */

var _input = ''
var _index = 0
process.stdin.on('data', (data) => { _input += data })
process.stdin.on('end', () => {
  _input = _input.split(new RegExp('[ \n]+'))
  main()
})
function read () { return _input[_index++] }

/** ** Ignore above this line. ****/

class Person {
  constructor (firstName, lastName, identification) {
    this.firstName = firstName
    this.lastName = lastName
    this.idNumber = identification
  }

  printPerson () {
    console.log(
      'Name: ' + this.lastName + ', ' + this.firstName +
            '\nID: ' + this.idNumber
    )
  }
}

class Student extends Person {
  constructor (firstName, lastName, id, scores) {
    super(firstName, lastName, id)
    this.scores = scores
  }

  calculate () {
    let sum = 0

    for (let i = 0; i < this.scores.length; i++) {
      sum += this.scores[i]
    }

    let average = sum / this.scores.length

    if (average < 40) {
      return 'T'
    } else if (average < 55) {
      return 'D'
    } else if (average < 70) {
      return 'P'
    } else if (average < 80) {
      return 'A'
    } else if (average < 90) {
      return 'E'
    } else if (average <= 100) {
      return 'O'
    }
  }
}

function main () {
  let firstName = read()
  let lastName = read()
  let id = +read()
  let numScores = +read()
  let testScores = new Array(numScores)

  for (var i = 0; i < numScores; i++) {
    testScores[i] = +read()
  }

  let s = new Student(firstName, lastName, id, testScores)
  s.printPerson()
  s.calculate()
  console.log('Grade: ' + s.calculate())
}
