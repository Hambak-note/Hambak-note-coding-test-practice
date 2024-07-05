const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const r = 31;
const m = 1234567891;
const L = Number(input.shift());
const str = input.shift().split("");

let result = 0;
for(let i = 0; i < str.length; i++) {

    result += ((str[i].charCodeAt(0) - 96) * (r ** i)) % m;
}

console.log(result);
