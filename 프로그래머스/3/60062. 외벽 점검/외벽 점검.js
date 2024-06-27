function solution(n, weak, dist) {

    let straightWeak = makeCircleToStraight(weak, n);
    let permutations = getPermutations(dist, dist.length);
    let minFriendCnt = Infinity;
    for (const permutation of permutations) {

        for(let startIdx = 0; startIdx <= weak.length; startIdx++) {

            let targetArr = straightWeak.slice(startIdx, startIdx + weak.length);
            let friendCnt = 0;
            for(const friend of permutation) {
                friendCnt++;
                let startPointAddFriend = targetArr[0] + friend;
                while(targetArr.length > 0) {
                    if(startPointAddFriend >= targetArr[0]) {
                        targetArr.shift();
                        continue;
                    }

                    break;
                }

                if(targetArr.length === 0) {
                    minFriendCnt = Math.min(minFriendCnt, friendCnt);
                    break;
                }
            }
        }
    }

    if(minFriendCnt === Infinity) return -1;
    return minFriendCnt;
}

function makeCircleToStraight(weak, n) {

    let straightWeak = [...weak];
    for (const weakElement of weak) {
        straightWeak.push(weakElement + n);
    }

    return straightWeak;
}

function getPermutations(arr, selectNumber) {
    const results = [];
    if(selectNumber === 1) return arr.map((value) => [value]);

    arr.forEach((currentValue, index, origin) => {
        const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
        const permutations = getPermutations(rest, selectNumber - 1);
        const attached = permutations.map((permutation) => [currentValue, ...permutation]);
        results.push(...attached);
    });

    return results;
}