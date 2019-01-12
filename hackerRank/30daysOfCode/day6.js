function processData (input) {
  input = input.split('\n')
  var T = input[0]
  for (var j = 1; j <= T; j++) {
    var even = ''
    var odd = ''
    const str = input[j]
    for (var i = 0; i < str.length; i++) {
      if (i % 2 === 0) {
        even += str[i]
      } else {
        odd += str[i]
      }
    }
    console.log(even + ' ' + odd)
  }
}

process.stdin.resume()
process.stdin.setEncoding('ascii')
var _input = ''
process.stdin.on('data', function (input) {
  _input += input
})

process.stdin.on('end', function () {
  processData(_input)
})
