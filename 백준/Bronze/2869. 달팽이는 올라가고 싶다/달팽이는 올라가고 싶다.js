const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

let [a, b, v] = input.shift().split(" ").map(Number);

if (v < a) {
    console.log(1);
} 
else{
    if((v-a) % (a-b) == 0 ){
        console.log(Math.floor((v - a) / (a-b))+1);
    }
    else {
        console.log(Math.floor((v - a) / (a-b))+2);
    }
}
    