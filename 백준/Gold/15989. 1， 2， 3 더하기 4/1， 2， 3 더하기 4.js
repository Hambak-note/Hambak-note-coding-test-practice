const { log } = require("console");
const fs = require("fs");
const filePath = "dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const testCase = Number(input.shift());
let dp = Array.from({length: 10001}, () => Array.from({length: 4}, () => 0));
dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

for(let i = 0; i < testCase; i++) {

    let n = Number(input.shift());
    solve(n, 3);
    log(dp[n][1] + dp[n][2] + dp[n][3]);
}

function solve(n ,k) {

    if(dp[n][k] !== 0) return dp[n][k];

    for(let i = 4; i <= n; i++) {
        for(let j = 1; j <=3; j++) {

            let sum = 0;
            if(j === 1) {
                dp[i][j] = 1;
                continue;
            }
            
            for(let m = 1; m <= j; m++) {
                sum += dp[i-j][m];
            }
            dp[i][j] = sum;
        }
    }

    return dp[n][k];
}

