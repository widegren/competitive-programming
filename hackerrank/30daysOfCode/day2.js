'use strict'

/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-operators/problem} Day 2: Operators
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

// Complete the solve function below.
function solve (mealCost, tipPercent, taxPercent) {
  const tip = tipPercent * mealCost * 0.01
  const tax = taxPercent * mealCost * 0.01
  console.log(Math.round(+tip + tax))
}

function main () {
  const mealCost = parseFloat(readLine())

  const tipPercent = parseInt(readLine(), 10)

  const taxPercent = parseInt(readLine(), 10)

  solve(mealCost, tipPercent, taxPercent)
}
