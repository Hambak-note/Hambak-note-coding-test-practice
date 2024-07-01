const fs = require('fs');
const filePath = "/dev/stdin";
const input = fs.readFileSync(filePath).toString().trim().split('\n');

for (const inputElement of input) {
    
    if(inputElement === 'end') break;

    if(!hasAeiou(inputElement)) {
        console.log(`<${inputElement}> is not acceptable.`);
        continue;
    }

    if(hasThreeConsecutiveCharacters(inputElement)) {
        console.log(`<${inputElement}> is not acceptable.`);
        continue;
    }


    if(hasTwoConsecutiveCharactersWithoutTwoCase(inputElement)) {
        console.log(`<${inputElement}> is not acceptable.`);
        continue;
    }

    console.log(`<${inputElement}> is acceptable.`);
    continue;

}

function hasAeiou(input) {
    if(input.includes('a')) return true;
    if(input.includes('e')) return true;
    if(input.includes('i')) return true;
    if(input.includes('o')) return true;
    if(input.includes('u')) return true;
    return false;
}

function hasThreeConsecutiveCharacters(input) {

    for(let i = 0; i < input.length-2; i++) {
        let firstIsAeiou = hasAeiou(input[i]);
        let secondIsAeiou = hasAeiou(input[i+1]);
        let thirdIsAeiou = hasAeiou(input[i+2]);

        if(firstIsAeiou === secondIsAeiou && firstIsAeiou === thirdIsAeiou) return true;
    }

    return false;
}

function hasTwoConsecutiveCharactersWithoutTwoCase(input) {

    for(let i = 0; i < input.length-1; i++) {
        if(input[i] === input[i+1] && input[i] !== 'e' && input[i] !== 'o') {
            return true;
        }
    }

    return false;
}