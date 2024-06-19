const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(' ').map(Number);

input.sort(function(a, b){
    return a - b;
});

let result = "";
for(const val of input) {
    result += val + " "
}
console.log(result);