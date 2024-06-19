const fs = require("fs");
const input = fs.readFileSync("dev/stdin").toString().trim().split("\n").map(Number);

const sortedInput = input.sort((function(a, b) {
    return a-b;
}));

let index = 0;
for(let i = 1; i <= 30; i++) {

    if(sortedInput[index] === i) {
        index++;
        continue;
    }

    console.log(i);
}