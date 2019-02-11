/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-linked-list/problem} Day 15: Linked List
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
function Node (data) {
  this.data = data
  this.next = null
}
function Solution () {
  this.insert = function (head, data) {
    if (head === null) {
      head = new Node(data)
    } else {
      head.next = this.insert(head.next, data)
    }
    return head
  }

  this.display = function (head) {
    let start = head
    while (start) {
      process.stdout.write(`${start.data} `)
      start = start.next
    }
  }
}
function main () {
  const T = parseInt(readLine())
  let head = null
  const mylist = new Solution()
  for (let i = 0; i < T; i++) {
    const data = parseInt(readLine())
    head = mylist.insert(head, data)
  }
  mylist.display(head)
}
