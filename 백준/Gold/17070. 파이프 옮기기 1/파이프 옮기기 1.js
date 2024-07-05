const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const n = Number(input.shift());
let board = [];
const dx = [0, 1, 1];
const dy = [1, 1, 0];
let answer = 0;


function isOutOfBound(x, y) {
    return x < 0 || y < 0 || x >= n || y >= n;
}

function simulation(x, y, beforeDir) {
    if(x === n-1 && y === n-1) {
        answer++;
        return;
    }

    for(let dir = 0; dir < 3; dir++) {

        if(beforeDir === 0 && dir === 2) continue;
        if(beforeDir === 2 && dir === 0) continue;

        let nx = x + dx[dir];
        let ny = y + dy[dir];
        if(isOutOfBound(nx, ny) || board[nx][ny]) continue;

        if(dir === 1) {
            if(board[nx][y] || board[x][ny]) continue;
        }

        simulation(nx, ny, dir);
    }
}


for(let i = 0; i < n; i++) {
    let line = input.shift().split(" ").map(Number);
    board.push(line);
}


simulation(0, 1, 0);
console.log(answer);