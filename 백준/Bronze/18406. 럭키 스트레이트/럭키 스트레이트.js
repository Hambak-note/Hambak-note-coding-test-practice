const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('').map(Number);

let mid = Math.floor(input.length / 2);
let left = input.slice(0, mid);
let right = input.slice(mid);

let leftSum = 0;
let rightSum = 0;
for (let i = 0; i < mid; i++) {

    leftSum += left[i];
    rightSum += right[i];
}

if(leftSum === rightSum) console.log('LUCKY');
else console.log('READY');