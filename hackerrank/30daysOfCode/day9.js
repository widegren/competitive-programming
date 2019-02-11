'use strict'

/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-recursion/problem} Day 9: Recursion 3
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */

const fs = require('fs')

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

function factorial (n) {
  if (n === 1) {
    return 1
  }
  return n * factorial(n - 1)
}

function main () {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH)

  const n = parseInt(readLine(), 10)

  let result = factorial(n)

  ws.write(result + '\n')

  ws.end()
}
