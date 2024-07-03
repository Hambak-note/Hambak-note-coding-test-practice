const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const A = input.shift();
const B = input.shift();
const C = input.shift();

const result1 = Number(A) + Number(B) - Number(C);

const aPlusB = A + B;
const result2= Number(aPlusB) - Number(C);

console.log(result1);
console.log(result2);