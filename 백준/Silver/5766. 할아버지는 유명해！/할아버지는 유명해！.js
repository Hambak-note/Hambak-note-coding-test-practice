const fs = require("fs");
const input = fs.readFileSync("dev/stdin").toString().trim().split("\n");



let inputIdx = 0;
while(true) {

    const firstLine = input[inputIdx++].split(" ").map(Number);
    const numberOfWeek = firstLine[0];
    const numbersPerWeek = firstLine[1];

    if(numberOfWeek === 0 && numbersPerWeek === 0) break;
    
    let map = new Map();
    for(let i = 0; i < numberOfWeek; i++) {
 
        const week = input[inputIdx++].split(" ").map(Number);
        for(const val of week) {
            if(map.has(val)) {
                const count = map.get(val) + 1;
                map.set(val, count);
                continue;
            }
            map.set(val, 1);
        }
    }

    let mapToArray = Array.from(map.values());
    let uniquieValues = [...new Set(mapToArray)].sort((a, b) => b - a);
    let secondLargeValue = uniquieValues[1];

    let keysWithSecondLargeValue = [];
    for(let [key, value] of map) {
        if(value === secondLargeValue) keysWithSecondLargeValue.push(key); 
    }

    let sortedKeys = keysWithSecondLargeValue.sort((a, b) => a-b);
    let result = "";
    for(const key of sortedKeys) {
        result += (key + " ");
    }
    console.log(result);
}