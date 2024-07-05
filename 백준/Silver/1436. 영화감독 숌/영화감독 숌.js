const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const n = Number(input.shift());
let num = 666;
let answer = 1;

while(n !== answer) {

    num++;
    if(String(num).includes("666")) answer++;
}

console.log(num);