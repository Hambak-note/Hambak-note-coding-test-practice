const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");


const n = Number(input.shift());

let mul5 = Math.floor(n / 5);
let mul25 = Math.floor(n / 25);
let mul125 = Math.floor(n / 125);

console.log(mul5 + mul25 + mul125);