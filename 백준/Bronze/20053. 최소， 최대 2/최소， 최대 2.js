const fs = require("fs");
const input = fs.readFileSync("dev/stdin").toString().trim().split("\n");

let testCase = parseInt(input[0]);

let inputIdx = 1;
while(testCase--) {

    const numberCnt = parseInt(input[inputIdx++]);
    const numberArr = input[inputIdx++]
                        .split(" ")
                        .map(Number);

    const sortedNumberArr = numberArr.sort(function(a, b) {
        return a-b;
    })
    
    console.log(sortedNumberArr[0] + " " + sortedNumberArr[sortedNumberArr.length-1]);
}