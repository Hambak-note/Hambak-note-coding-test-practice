const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const movePossible = 0;
const apple = 1;
const snakeBody = 2;
const left = 'L';
const right = 'D';

const n = Number(input[0]); //보드의 크기
const k = Number(input[1]); //사과의 개수
const l = Number(input[1+k+1])//뱀의 방향 변환 횟수

let board = Array.from({length: n}, () => Array(n).fill(movePossible));
for(let i = 2; i < 2+k; i++) {
    const line = input[i].split(' ').map(Number);
    board[line[0] - 1][line[1] - 1] = apple;
}

let dirInfo = new Map();
for(let i = 3+k; i < input.length; i++) {
    const line = input[i].split(' ');
    dirInfo.set(Number(line[0]), line[1]);
}


class Snake {
    constructor(positions, dir) {
        this.positions = positions;
        this.dir = dir;
    }

    rotateLeft() {
        if(this.dir === 'R') this.dir = 'U';
        else if(this.dir === 'L') this.dir = 'D';
        else if(this.dir === 'U') this.dir = 'L';
        else this.dir = 'R';
    }

    rotateRight() {
        if(this.dir === 'R') this.dir = 'D';
        else if(this.dir === 'L') this.dir = 'U';
        else if(this.dir === 'U') this.dir = 'R';
        else this.dir = 'L';
    }

    moveHead() {
        const cPos = this.positions[this.positions.length - 1];
        const cx = cPos[0];
        const cy = cPos[1];

        let nx = cx;
        let ny = cy;

        if(this.dir === 'R') ny += 1;
        else if(this.dir === 'L') ny -= 1;
        else if(this.dir === 'U') nx -= 1;
        else this.dir = nx += 1;

        this.positions.push([nx, ny]);
    }

}

let snake = new Snake([[0, 0]], 'R');
let curTime = 0;
board[0][0] = snakeBody;

while(true) {

    if(dirInfo.has(curTime)) {
        let dir = dirInfo.get(curTime);
        if(dir === left) snake.rotateLeft();
        else snake.rotateRight();
    }

    snake.moveHead();
    let positions = snake.positions;
    let head = positions[positions.length - 1];
    let headX = head[0];
    let headY = head[1];

    if(headX < 0 || headY < 0 || headX >= n || headY >= n) break;
    if(board[headX][headY] === snakeBody) break;

    curTime++;
    if(board[headX][headY] === apple) {
        board[headX][headY] = snakeBody;
        continue;
    }

    board[headX][headY] = snakeBody;
    let cur = positions.shift();
    board[cur[0]][cur[1]] = movePossible;
}

curTime++;
console.log(curTime);