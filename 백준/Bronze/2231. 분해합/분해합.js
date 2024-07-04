const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const n = Number(input.shift());
let answer = 0;
for(let i = 0; i < n; i++) {

    let sum = i;
    let iStr = i.toString();

    for(j = 0; j < iStr.length; j++) {
        sum += Number(iStr[j]);
    }

    if(sum === n) {
        answer = i;
        break;
    }
}

console.log(answer);