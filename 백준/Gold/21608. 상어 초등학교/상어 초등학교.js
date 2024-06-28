const fs = require('fs');
const filePath = '/dev/stdin';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const EMPTY = 0;
const dr = [0, 0, 1, -1];
const dc = [1, -1, 0, 0];

class Student {
    constructor(number, favorites) {
        this.number = number;
        this.favorites = favorites;
    }
}

class SeatArrangement {

    constructor(classroom, students) {
        this.classroom = classroom;
        this.students = students;
    }


    run() {

        for (const student of students) {

            let favoriteSeats = this.searchManyFavoriteStudentSeatInEmptySeat(student);
            if(favoriteSeats.length === 1) {
                let seat = favoriteSeats[0];
                classroom[seat[0]][seat[1]] = student.number;
                continue;
            }

            let emptySeats = this.searchManyEmptySeat(student, favoriteSeats);
            if(emptySeats.length === 1) {
                let seat = emptySeats[0];
                classroom[seat[0]][seat[1]] = student.number;
                continue;
            }

            this.searchMinRAndMinC(student, emptySeats);
        }

        return this.calculateSatisfaction();
    }

    searchManyFavoriteStudentSeatInEmptySeat(student) {

        let maxFavoriteCnt = 0;
        let favorites = student.favorites;
        let favoriteMap = new Map();
        for(let r = 0; r < this.classroom.length; r++) {
            for(let c = 0; c < this.classroom[r].length; c++) {
                if(classroom[r][c] !== EMPTY) continue;
                let favoriteCnt = 0;
                for(let i = 0; i < 4; i++) {
                    let nextR = r + dr[i];
                    let nextC = c + dc[i];
                    if(this.isOutOfRange(nextR, nextC)) continue;
                    if(favorites.includes(classroom[nextR][nextC])) favoriteCnt++;
                }

                if(favoriteMap.get(favoriteCnt) === undefined) {
                    favoriteMap.set(favoriteCnt, [[r, c]]);
                } else {
                    let points = favoriteMap.get(favoriteCnt);
                    points.push([r, c]);
                    favoriteMap.set(favoriteCnt, points);
                }
                maxFavoriteCnt = Math.max(favoriteCnt, maxFavoriteCnt);
            }
        }

        return favoriteMap.get(maxFavoriteCnt);
    }

    searchManyEmptySeat(student, favoriteSeats) {

        let maxEmptyCnt = 0;
        let emptyMap = new Map();

        for (const favoriteSeat of favoriteSeats) {
            let r = favoriteSeat[0];
            let c = favoriteSeat[1];

            let emptyCnt = 0;
            if (classroom[r][c] !== EMPTY) continue;
            for(let i = 0; i < 4; i++) {
                let nextR = r + dr[i];
                let nextC = c + dc[i];
                if(this.isOutOfRange(nextR, nextC)) continue;
                if(classroom[nextR][nextC] === EMPTY) emptyCnt++;
            }

            if(emptyMap.get(emptyCnt) === undefined) {
                emptyMap.set(emptyCnt, [[r, c]]);
            } else {
                let points = emptyMap.get(emptyCnt);
                points.push([r, c]);
                emptyMap.set(emptyCnt, points);
            }
            maxEmptyCnt = Math.max(emptyCnt, maxEmptyCnt);
        }
        return emptyMap.get(maxEmptyCnt);
    }

    searchMinRAndMinC(student, emptySeats) {

        emptySeats.sort((a, b) => {
            if(a[0] !== b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        let target = emptySeats[0];
        classroom[target[0]][target[1]] = student.number;
    }

    calculateSatisfaction() {

        let satisfaction = 0;
        for(let r = 0; r < this.classroom.length; r++) {
            for(let c = 0; c < this.classroom[r].length; c++) {
                let favoriteCnt = 0;
                let favorites;
                for (const student of students) {
                    if(student.number === classroom[r][c]) {
                        favorites = student.favorites;
                        break;
                    }
                }

                for(let i = 0; i < 4; i++) {
                    let nextR = r + dr[i];
                    let nextC = c + dc[i];

                    if(this.isOutOfRange(nextR, nextC)) continue;
                    if(favorites.includes(classroom[nextR][nextC])) favoriteCnt++;
                }

                if(favoriteCnt === 2) favoriteCnt = 10;
                else if(favoriteCnt === 3) favoriteCnt = 100;
                else if(favoriteCnt === 4) favoriteCnt = 1000;

                satisfaction += favoriteCnt
            }
        }

        return satisfaction;
    }

    isOutOfRange(r, c) {
        if(r < 0 || c < 0 || r >= classroom.length || c >= classroom.length) return true;
        return false;
    }


}


const n = Number(input.shift());
let classroom = Array.from({length: n}, () => Array(n).fill(EMPTY));
let students = [];
for(let i = 0; i < input.length; i++) {
    const line = input[i].split(' ').map(Number);
    const number = line[0];
    const favorites = line.slice(1);
    students.push(new Student(number, favorites));
}
let seatArrangement = new SeatArrangement(classroom, students);
console.log(seatArrangement.run());

