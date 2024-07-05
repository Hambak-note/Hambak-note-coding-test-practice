const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const n = Number(input.shift());
let answer = 0;
for(let i = 0; i < n; i++) {

    let word = input.shift();

    let isGroup = true;
    let set = new Set();
    let prev = word[0];
    set.add(prev);
    let idx = 1;

    while(idx < word.length) {

        let cur = word[idx];
        
        if(cur === prev) {
            prev = cur;
            idx++;
            continue;
        }

        if(set.has(cur)) {
            isGroup = false;
            break;
        }

        set.add(cur);
        prev = cur;
        idx++;
    }

    if(isGroup) answer++;
}

console.log(answer);