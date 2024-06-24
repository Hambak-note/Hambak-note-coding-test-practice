function solution(array) {
    let answer = 0;
    
    array.sort((a, b) => a - b);
    const middlePoint = parseInt(array.length / 2);
    answer = array[middlePoint];
    
    return answer;
}