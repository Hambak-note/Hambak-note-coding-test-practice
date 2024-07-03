const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n").map(Number);


let maxIdx = 0;
let maxNumber = 0;
for(let i = 0; i < input.length; i++) {
    if(maxNumber < input[i]) {
        maxIdx = i;
        maxNumber = input[i];
    }
}

console.log(maxNumber);
console.log(maxIdx+1);
