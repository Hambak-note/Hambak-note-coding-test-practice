const fs = require('fs');
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, k] = input.shift().split(" ").map(Number);
const countries = [];
for(let i = 0; i < n; i++) {
    let line = input.shift().split(" ").map(Number);
    countries.push(line);
}

countries.sort((a, b) => {
    if(a[1] === b[1] && a[2] === b[2]) return b[3] - b[3];
    if(a[1] === b[1]) return b[2] - a[2];
    return b[1] - a[1];
});

let prev = [];
let rank = 0;
for (const country of countries) {

    let cur = country.slice(1);
    if(!arraysEqual(cur, prev)) rank++;
    prev = cur;
    if(country[0] === k) break;
}

console.log(rank);


function arraysEqual(arr1, arr2) {
    return arr1.every((value, index) => value === arr2[index]);
}