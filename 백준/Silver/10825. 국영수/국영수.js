const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

const N = input.shift();
const students = input.map((item) => item.split(" "));

const sortStudents = students.sort((a, b) => {
    if (+a[1] !== +b[1]) {
        return b[1] - a[1];
    } else if (+a[1] === +b[1] && +a[2] !== +b[2]) {
        return a[2] - b[2];
    } else if (+a[1] === +b[1] && +a[2] === +b[2] && +a[3] !== +b[3]) {
        return b[3] - a[3];
    } else {
        for (let i = 0; i < 10; i++) {
            if (a[0].charCodeAt(i) === b[0].charCodeAt(i)) {
                continue;
            } else {
                return a[0].charCodeAt(i) - b[0].charCodeAt(i);
            }
        }
    }
});


const name = sortStudents.map((student) => {
    return student[0];
});

console.log(name.join("\n"));