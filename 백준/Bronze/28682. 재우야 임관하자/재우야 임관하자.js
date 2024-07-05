const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});


rl.on('line', (input) => {

    if(isNaN(Number(input))) {
        const result = input.split(" ").map((v) => {
            if(v == "swimming") return "soccer";
            else return "swimming";
        });
        console.log(result.join(' '));
        process.exit();
    } else {
        let n = Number(input);
        console.log(Array(n).fill("bowling").join(" "));
        readline.cursorTo(process.stdout, 0, 0);
        readline.clearScreenDown(process.stdout);
    }

}).on('close', () => {
    process.exit;
});
