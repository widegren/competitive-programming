'use strict'

/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-binary-numbers/problem} Day 10: Binary Numbers
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
  const n = parseInt(readLine(), 10).toString(2)
  let splits = n.split('0')
  console.log(splits.map(function (elem) { return elem.length }).reduce(function (a, b) {
    if (a > b) return a; else return b
  }))
}
