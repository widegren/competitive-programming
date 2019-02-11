'use strict'

/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-arrays/problem} Day 7: Arrays
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

  const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10))

  for (var i = n - 1; i >= 0; i--) {
    process.stdout.write(arr[i] + ' ')
  }
}
