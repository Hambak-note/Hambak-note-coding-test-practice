const fs = require('fs');
const filePath = "/dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split('\n');
const n = Number(input);


let visitCnt = 1;
let max = 1;
let add = 6;

while(true) {

    if(n <= max) break;

    max += add;
    add += 6;
    ++visitCnt;
}

console.log(visitCnt);
