const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [hour, minutes] = input.shift().split(' ').map(Number);

let totalMinutes = hour * 60 + minutes;
let newTotalMinutes = totalMinutes - 45;


let newHour = Math.floor(newTotalMinutes / 60);
let newMinutes = newTotalMinutes % 60;

if(newHour < 0) {
    newHour = 24 + newHour;
}

if(newMinutes < 0) {
    newMinutes = 60 + newMinutes;
}

console.log(newHour, newMinutes);