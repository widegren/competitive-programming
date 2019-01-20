/**
 * Javascript (Node.js) solution for {@link https://www.hackerrank.com/challenges/30-binary-search-trees/problem Day 22: Binary Search Trees}
 * @author Emelie Widegren <emeliewide@gmail.com>
 */

function Node (data) {
  this.data = data
  this.left = null
  this.right = null
};

function BinarySearchTree () {
  this.insert = function (root, data) {
    if (root === null) {
      this.root = new Node(data)

      return this.root
    }

    if (data <= root.data) {
      if (root.left) {
        this.insert(root.left, data)
      } else {
        root.left = new Node(data)
      }
    } else {
      if (root.right) {
        this.insert(root.right, data)
      } else {
        root.right = new Node(data)
      }
    }

    return this.root
  }

  this.getHeight = function (root) {
    if (root == null) {
      return 0
    }
    if (root.right == null && root.left == null) {
      return 0
    } else {
      return Math.max(this.getHeight(root.right), this.getHeight(root.left)) + 1
    }
  }
};

process.stdin.resume()
process.stdin.setEncoding('ascii')

var _input = ''

process.stdin.on('data', function (data) {
  _input += data
})

process.stdin.on('end', function () {
  var tree = new BinarySearchTree()
  var root = null

  var values = _input.split('\n').map(Number)

  for (var i = 1; i < values.length; i++) {
    root = tree.insert(root, values[i])
  }

  console.log(tree.getHeight(root))
})
