const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

let n = Number(input.shift());

if(n % 5 === 0) console.log(Math.floor(n / 5));
else {

    let p = 0;
    while(n > 0) {

        n -= 3;
        p += 1;

        if(n % 5 === 0) {
            p += Math.floor(n / 5);
            console.log(p);
            break;
        }
        else if(n === 1 || n === 2) {
            console.log(-1);
            break;
        }
        else if(n === 0) {
            console.log(p);
            break;
        }
    }
}