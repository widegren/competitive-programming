process.stdin.resume();
process.stdin.setEncoding('ascii');

let inputStdin = '';
let inputStdinArray = '';
let inputCurrentline = 0;

function readLine() {
  return inputStdinArray[inputCurrentline++];
}

function Solution() {
  let stack = [];
  let queue = [];
  this.pushCharacter = function pushCharacter(c) {
    stack.unshift(c);
  };
  this.enqueueCharacter = function enqueueCharacter(c) {
    queue.push(c);
  };
  this.popCharacter = function popCharacter() {
    const c = stack[0];
    stack = stack.slice(1);
    return c;
  };
  this.dequeueCharacter = function dequeueCharacter() {
    const c = queue[0];
    queue = queue.slice(1);
    return c;
  };
}

function main() {
  // read the string s
  const s = readLine();
  const len = s.length;
  // create the Solution class object p
  const obj = new Solution();
  // push/enqueue all the characters of string s to stack
  for (let i = 0; i < len; i++) {
    obj.pushCharacter(s.charAt(i));
    obj.enqueueCharacter(s.charAt(i));
  }

  let isPalindrome = true;
  /*
    pop the top character from stack
    dequeue the first character from queue
    compare both the characters */

  for (let i = 0; i < len / 2; i++) {
    if (obj.popCharacter() !== obj.dequeueCharacter()) {
      isPalindrome = false;
      break;
    }
  }
  // finally print whether string s is palindrome or not

  if (isPalindrome) console.log(`The word, ${s}, is a palindrome.`);
  else console.log(`The word, ${s}, is not a palindrome.`);
}

process.stdin.on('data', (data) => {
  inputStdin += data;
});

process.stdin.on('end', () => {
  inputStdinArray = inputStdin.split('\n');
  main();
});
