const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [n, m] = input.shift().split(" ").map(Number);
const baskets = Array.from({length: n+1}, () => 0);

for(let i = 0; i < m; i++) {

    let line = input.shift().split(" ").map(Number);
    let ball = line[2];
    for(let j = line[0]; j <= line[1]; j++) {
        baskets[j] = ball;
    }
}

baskets.shift();
console.log(baskets.join(" "));