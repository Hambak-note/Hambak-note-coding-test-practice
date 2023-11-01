

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 1. 두 재료의 번호합, 크기를 비교하므로 값을 정렬하면 문제를 좀 더 쉽게 풀 수 있음
 * 2. 보통 정렬 알고리즘의 시간 복잡도는 O(nlogn)이며 N의 최대 범위가 150,000이기 때문에 문제가 없을 것이다.
 * 3. 입력 받은 N개의 재료 값을 정렬한 다음 양쪽 끝의 위치를 투 포인터로 지정해서 문제를 해결
 * 4. 번호 인덱스는 small과 big이라는 변수에 저장해 둔다.
 * 5. 투포인터의 이동 방법
 *      5-1. A[small] + A[big] > M : big--; 번호의 합이 M보다 클 경우 big을 줄여준다.
 *      5-2. A[small] + A[big] < M : small++; 번호의 합이 M보다 작을 경우 small을 키워준다.
 *      5-3. A[small] + A[big] == M : small++, big--, count++; 같은 경우 count올려주고 small은 크게 big은 작게
 *      
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] nArr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
        
        int count = 0;
        int small = 0;
        int big = N-1;
        
        while(small < big) {
            
            if(nArr[small] + nArr[big] < M) {
                small++;
                continue;
            }
            
            if(nArr[small] + nArr[big] > M) {
                big--;
                continue;
            }
            
            count++;
            small++;
            big--;
        }

        System.out.println(count);
        bf.close();
    }
}
