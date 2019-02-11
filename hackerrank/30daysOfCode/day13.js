/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-abstract-classes/problem} Day 13: Abstract Classes
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */

let _input = ''
let _index = 0
process.stdin.on('data', (data) => { _input += data })
process.stdin.on('end', () => {
  _input = _input.split(new RegExp('\n'))
  main()
})
function readLine () { return _input[_index++] }

class Book {
  constructor (title, author) {
    if (this.constructor === Book) {
      throw new TypeError('Do not attempt to directly instantiate an abstract class.')
    } else {
      this.title = title
      this.author = author
    }
  }

  display () {
    console.log('Implement the \'display\' method!')
  }
}

class MyBook extends Book {
  constructor (title, author, price) {
    super(title, author)
    this.price = price
  }

  display () {
    console.log(`Title: ${this.title}\nAuthor: ${this.author}\nPrice: ${this.price}`)
  }
}
function main () {
  const title = readLine()
  const author = readLine()
  const price = +readLine()

  const book = new MyBook(title, author, price)
  book.display()
}
