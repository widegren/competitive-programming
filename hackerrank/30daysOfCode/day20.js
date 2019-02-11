/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-sorting/problem} Day 20: Sorting
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */

process.stdin.resume()
process.stdin.setEncoding('ascii')

let inputStdin = ''
let inputStdinArray = ''
let inputCurrentline = 0

process.stdin.on('data', (data) => {
  inputStdin += data
})

process.stdin.on('end', () => {
  inputStdinArray = inputStdin.split('\n')
  main()
})

function readLine () {
  return inputStdinArray[inputCurrentline++]
}

// ///////////// ignore above this line ////////////////////

function main () {
  const n = parseInt(readLine())
  let array = readLine().split(' ')
  array = array.map(Number)

  // Write Your Code Here
  let totalNumberOfSwaps = 0
  for (let i = 0; i < n; i++) {
    // Track number of elements swapped during a single array traversal
    let numberOfSwaps = 0

    for (let j = 0; j < n - 1; j++) {
      // Swap adjacent elements if they are in decreasing order
      if (array[j] > array[j + 1]) {
        const tmp = array[j]
        array[j] = array[j + 1]
        array[j + 1] = tmp
        numberOfSwaps++
        totalNumberOfSwaps++
      }
    }

    // If no elements were swapped during a traversal, array is sorted
    if (numberOfSwaps === 0) {
      break
    }
  }
  console.log(`Array is sorted in ${totalNumberOfSwaps} swaps.`)
  console.log(`First Element: ${array[0]}`)
  console.log(`Last Element: ${array[n - 1]}`)
}
