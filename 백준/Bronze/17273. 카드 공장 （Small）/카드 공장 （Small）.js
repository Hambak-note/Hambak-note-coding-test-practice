const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [n, m] = input.shift().split(" ").map(Number);

const fronts = [];
const backs = [];
const status = [];

const FRONT = true;
const BACK = false;

for(let i = 0; i < n; i++) {
    let [front, back] = input.shift().split(" ").map(Number);
    fronts.push(front);
    backs.push(back);
    status.push(FRONT);
}


for(let i = 0; i < m; i++) {

    let op = Number(input.shift());

    for(let j = 0; j < n; j++) {

        let cur;
        if(status[j] === FRONT) {
            cur = fronts[j];
        } else cur = backs[j];

        if(cur <= op) status[j] = !status[j];
    }
}

let sum = 0;
for(let j = 0; j < n; j++) {

    let cur;
    if(status[j] === FRONT) {
        cur = fronts[j];
    } else cur = backs[j];

    sum += cur;
}

console.log(sum);
