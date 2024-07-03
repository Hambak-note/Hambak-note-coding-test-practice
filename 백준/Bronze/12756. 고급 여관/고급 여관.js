const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const playerA = input.shift().split(" ").map(Number);
const playerB = input.shift().split(" ").map(Number);


while(true) {

    playerA[1] -= playerB[0];
    playerB[1] -= playerA[0];


    if(playerA[1] <= 0 && playerB[1] <= 0) {
        console.log("DRAW");
        break;
    }

    if(playerA[1] <= 0) {
        console.log("PLAYER B");
        break;
    }

    if(playerB[1] <= 0) {
        console.log("PLAYER A");
        break;
    }
}