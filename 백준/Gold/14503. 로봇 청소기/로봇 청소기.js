const fs = require('fs');
const filePath = '/dev/stdin';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, m] = input.shift().split(' ').map(Number);
let [r, c, d] = input.shift().split(' ').map(Number);
let room = input.map((line) => line.split(' ').map(Number));

const CLEAN = -1;
const NOT_CLEAN = 0;
const WALL = 1;
const NORTH = 0;
const EAST = 1;
const SOUTH = 2;
const WEST = 3;

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

let cleanSpotCnt = 0;
while(true) {

    //1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
    if(room[r][c] == NOT_CLEAN) {
        room[r][c] = CLEAN;
        cleanSpotCnt++;
    }

    //2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
    if(!hasNotCleanSpotAround(r, c)) {

        //바라보는 방향에서 한 칸 후진할 수 있다면 후진하고 1번으로 아니면 작동을 멈춘다.
        if(isPossibleMoveBack(r, c, d)) {
            moveBack();
            continue;
        }
        break;
    }
    //3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
    else {

        for(let i = 0; i < 4; i++) {
            rotateCounterClockwise90Degree();
            if(isForwardSpotNotClean()) {
                moveForward();
                break;
            }
        }
    }
}

console.log(cleanSpotCnt);

function moveForward() {
    if(d == NORTH) r -= 1;
    else if(d == EAST) c += 1;
    else if(d == SOUTH) r += 1;
    else c -= 1;
}

function rotateCounterClockwise90Degree() {
    if(d == NORTH) d = WEST;
    else if(d == EAST) d = NORTH;
    else if(d == SOUTH) d = EAST;
    else d = SOUTH;
}

function isForwardSpotNotClean() {
    let nextR = r;
    let nextC = c;

    if(d == NORTH) nextR -= 1;
    else if(d == EAST) nextC += 1;
    else if(d == SOUTH) nextR += 1;
    else nextC -= 1;

    if(isOutOfRange(nextR, nextC)) return false;
    if(room[nextR][nextC] === NOT_CLEAN) return true;
    return false;
}

function moveBack() {
    if(d == NORTH) r += 1;
    else if(d == EAST) c -= 1;
    else if(d == SOUTH) r -= 1;
    else c += 1;
}
function hasNotCleanSpotAround(r, c) {

    for(let i = 0; i < 4; i++) {
        let nextR = r + dx[i];
        let nextC = c + dy[i];

        if(isOutOfRange(nextR, nextC)) continue;
        if(room[nextR][nextC] !== NOT_CLEAN) continue;

        return true;
    }
    return false;
}

function isPossibleMoveBack(r, c, d) {

    let nextR = r;
    let nextC = c;
    if(d == NORTH) nextR += 1;
    else if(d == EAST) nextC -= 1;
    else if(d == SOUTH) nextR -= 1;
    else nextC += 1;

    if(isOutOfRange(nextR, nextC)) return false;
    if(room[nextR][nextC] === WALL) return false;
    return true;
}

function isOutOfRange(r, c) {
    if(r < 0 || c < 0 || r >= n || c >= m) return true;
    return false;
}