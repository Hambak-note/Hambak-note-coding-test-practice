const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

let targetNumber = 0;
for(let i = 2; i >= 0; i--) {

    let mapToNumber = Number(input[i]);
    if(isNaN(mapToNumber)) continue;
    
    targetNumber = mapToNumber + 3 - i;
    break;
}

let three = (targetNumber % 3) === 0 ? true : false;
let five = (targetNumber % 5) === 0 ? true : false;

if(three && five) console.log("FizzBuzz");
if(three && !five) console.log("Fizz");
if(!three && five) console.log("Buzz");
if(!three && !five) console.log(targetNumber);

