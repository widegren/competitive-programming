'use strict'

/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-loops/problem} Day 5: Loops
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */

process.stdin.resume()
process.stdin.setEncoding('utf-8')

let inputString = ''
let currentLine = 0

process.stdin.on('data', inputStdin => {
  inputString += inputStdin
})

process.stdin.on('end', _ => {
  inputString = inputString.replace(/\s*$/, '')
    .split('\n')
    .map(str => str.replace(/\s*$/, ''))

  main()
})

function readLine () {
  return inputString[currentLine++]
}

function main () {
  const n = parseInt(readLine(), 10)
  for (var i = 1; i < 11; i++) {
    console.log(n + ' x ' + i + ' = ' + n * i)
  }
}
