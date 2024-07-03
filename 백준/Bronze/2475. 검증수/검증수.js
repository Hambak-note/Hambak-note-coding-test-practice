const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

let numbers = input.shift().split(" ").map(Number);

let sum = 0;
for(let i = 0; i < numbers.length; i++) {
    sum += (numbers[i] * numbers[i]);
}

console.log(sum % 10);