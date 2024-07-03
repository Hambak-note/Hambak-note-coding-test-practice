/**
* skill : 선행 스킬 순서
* skill_trees: 유저들이 만든 스킬트리
* return 가능한 스킬 트리의 개수
*/
function solution(skill, skill_trees) {
    
    let answer = skill_trees.length;
    
    skill_trees.forEach((skill_tree) => {
        const stack = [...skill];
        for(let i = 0; i < skill_tree.length; i++) {
            if(!skill.includes(skill_tree[i])) continue;
            if(stack.shift() !== skill_tree[i]) {
                answer -= 1;
                break;
            }
        }
    });
    
    return answer;
}