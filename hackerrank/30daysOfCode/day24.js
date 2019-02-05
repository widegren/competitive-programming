/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-linked-list-deletion/problem Day 24: More Linked Lists}
 * @author Emelie Widegren <emeliewide@gmail.com>
 */

process.stdin.resume()
process.stdin.setEncoding('ascii')

let inputStdin = ''
let inputStdinArray = ''
let inputCurrentline = 0

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

function Node (data) {
  this.data = data
  this.next = null
}

function Solution () {
  this.removeDuplicates = function (head) {
    let current = head
    while (current !== null && current.next !== null) {
      let node = current
      while (node.next !== null) {
        if (node.next.data === current.data) {
          let tmp = node.next
          node.next = tmp.next
        } else {
          node = node.next
        }
      }
      current = current.next
    }
    return head
  }

  this.insert = function (head, data) {
    let p = new Node(data)
    if (head == null) {
      head = p
    } else if (head.next == null) {
      head.next = p
    } else {
      let start = head
      while (start.next != null) {
        start = start.next
      }
      start.next = p
    }
    return head
  }

  this.display = function (head) {
    let start = head
    while (start) {
      process.stdout.write(start.data + ' ')
      start = start.next
    }
  }
}

function main () {
  let T = parseInt(readLine())
  let head = null
  let mylist = new Solution()
  for (let i = 0; i < T; i++) {
    let data = parseInt(readLine())
    head = mylist.insert(head, data)
  }
  head = mylist.removeDuplicates(head)
  mylist.display(head)
}
