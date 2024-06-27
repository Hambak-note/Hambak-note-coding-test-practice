const fs = require('fs');
// const filePath = 'input.txt';
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, m] = input.shift().split(' ').map(Number);
const city = input.map(line => line.split(' ').map(Number));

const BLANK = 0;
const HOUSE = 1;
const C_HOUSE = 2;

function generateChickenHouseMap() {
    let key = 1;
    let cHouseMap = new Map();
    for (let i = 0; i < city.length; i++) {
        for (let j = 0; j < city[i].length; j++) {
            if (city[i][j] === C_HOUSE) {
                cHouseMap.set(key, [i, j]);
                key++;
            }
        }
    }
    return cHouseMap;
}

function generateHouseList() {

    let houseList = [];
    for (let i = 0; i < city.length; i++) {
        for (let j = 0; j < city[i].length; j++) {
            if (city[i][j] === HOUSE) {
                houseList.push([i, j]);
            }
        }
    }

    return houseList;
}

function generateCombinations(cHouseNumbers, m) {
    let result = [];

    function backtrack(temp, start) {
        if(temp.length === m) {
            result.push([...temp]);
            return;
        }

        for(let i = start; i < cHouseNumbers.length; i++) {
            temp.push(cHouseNumbers[i]);
            backtrack(temp, i + 1);
            temp.pop();
        }
    }

    backtrack([], 0);

    return result;
}

function calAllMinChickenDistInCity(houses, cHouseMap, combinations) {

    let minCDistInCity = Infinity;

    for (const combination of combinations) {
        let sum = 0;
        for (const house of houses) {
            let minDist = calMinChickenDist(house, cHouseMap, combination);
            sum += minDist;
        }
        minCDistInCity = Math.min(minCDistInCity, sum);
    }

    return minCDistInCity;
}

function calMinChickenDist(house, cHouseMap, combination){

    let minCDist = Infinity;
    for (const key of combination) {
        let cHouse = cHouseMap.get(key);
        let dist = calDistBetweenTowPoint(house, cHouse);
        minCDist = Math.min(minCDist, dist);
    }

    return minCDist;
}

function calDistBetweenTowPoint(point1, point2) {
    return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
}

let houses = generateHouseList();
let cHouseMap = generateChickenHouseMap();
let cHouseNumbers = Array.from(cHouseMap.keys());
let combinations = generateCombinations(cHouseNumbers, m);
let result = calAllMinChickenDistInCity(houses, cHouseMap, combinations);
console.log(result);
