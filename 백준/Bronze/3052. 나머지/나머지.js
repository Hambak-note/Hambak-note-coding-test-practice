const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const set = new Set();
for(let i = 0; i < input.length; i++) {

    const remain = Number(input[i]) % 42;
    set.add(remain);
}

console.log(set.size);