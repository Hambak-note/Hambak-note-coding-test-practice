function solution(money) {
    
    const ICE_AMERICANO = 5500;
    let answer = [];
    let numberOfIceAmericano = parseInt(money / ICE_AMERICANO);
    let remain = money % ICE_AMERICANO;
    
    answer.push(numberOfIceAmericano);
    answer.push(remain);
    
    return answer;
}