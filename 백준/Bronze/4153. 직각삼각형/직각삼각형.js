const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

input.pop();
for(let i = 0; i < input.length; i++) {

    let line = input[i].split(" ").map(Number).sort((a, b) => a - b);

    let ab = (line[0] * line[0]) + (line[1] * line[1]);
    let c = line[2] * line[2];
    if(ab === c) console.log("right");
    else console.log("wrong");
}