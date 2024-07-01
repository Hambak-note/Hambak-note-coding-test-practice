const fs = require('fs');
const filePath = "/dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split('\n');

let n = Number(input.shift());
let board = [];
let isFind = false;
let heart;
for(let i = 0; i < n; i++) {
    let line = input.shift();
    board.push(line);

    if(!isFind && line.indexOf('*') != -1) {
        isFind = true;
        heart = [i+1, line.indexOf('*')];
    }
}

let leftHandSize = getLeftHandSize(heart);
let rightHandSize = getRightHandSize(heart);
let waistSize = getWaistSize(heart);
let leftLegSize = getLeftLegSize(heart, waistSize);
let rightLegSize = getRightLegSize(heart, waistSize);
console.log((heart[0]+1) + " " + (heart[1]+1));
console.log(leftHandSize + " "+ rightHandSize + " " + waistSize + " " + leftLegSize + " " + rightLegSize);


function isOutOfBounds(x, y) {
    if(x < 0 || x >= n || y < 0 || y >= n) return true;
    return false;
}

function getLeftHandSize(heart) {

    let size = 0;
    let cx = heart[0];
    let cy = heart[1];
    while(true) {
        let nx = cx;
        let ny = cy - 1;

        if(isOutOfBounds(nx, ny)) break;
        if(board[nx][ny] !== '*') break;

        cx = nx;
        cy = ny;
        size++;
    }

    return size;
}

function getRightHandSize(heart) {
    let size = 0;
    let cx = heart[0];
    let cy = heart[1];
    while(true) {
        let nx = cx;
        let ny = cy + 1;

        if(isOutOfBounds(nx, ny)) break;
        if(board[nx][ny] !== '*') break;

        cx = nx;
        cy = ny;
        size++;
    }

    return size;
}

function getWaistSize(heart) {

    let size = 0;
    let cx = heart[0];
    let cy = heart[1];
    while(true) {
        let nx = cx+1;
        let ny = cy;

        if(isOutOfBounds(nx, ny)) break;
        if(board[nx][ny] !== '*') break;

        cx = nx;
        cy = ny;
        size++;
    }

    return size;
}

function getLeftLegSize(heart, waistSize) {

    let size = 0;
    let cx = heart[0] + waistSize;
    let cy = heart[1] -1;
    while(true) {
        let nx = cx+1;
        let ny = cy;

        if(isOutOfBounds(nx, ny)) break;
        if(board[nx][ny] !== '*') break;

        cx = nx;
        cy = ny;
        size++;
    }

    return size;
}

function getRightLegSize(heart, waistSize) {
    let size = 0;
    let cx = heart[0] + waistSize;
    let cy = heart[1] +1;
    while(true) {
        let nx = cx+1;
        let ny = cy;

        if(isOutOfBounds(nx, ny)) break;
        if(board[nx][ny] !== '*') break;

        cx = nx;
        cy = ny;
        size++;
    }

    return size;
}