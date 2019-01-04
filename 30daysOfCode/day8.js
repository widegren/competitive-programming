function processData (input) {
  input = input.split('\n')
  let T = input[0]
  let phoneBook = []
  for (let i = 1; i <= T; i++) {
    let [name, phoneNumber] = input[i].split(' ')
    phoneBook[name] = phoneNumber
  }
  for (let j = ++T; j < input.length; j++) {
    if (phoneBook[input[j]] !== undefined) {
      console.log(input[j] + '=' + phoneBook[input[j]])
    } else {
      console.log('Not found')
    }
  }
}

process.stdin.resume()
process.stdin.setEncoding('ascii')
_input = ''
process.stdin.on('data', function (input) {
  _input += input
})

process.stdin.on('end', function () {
  processData(_input)
})
