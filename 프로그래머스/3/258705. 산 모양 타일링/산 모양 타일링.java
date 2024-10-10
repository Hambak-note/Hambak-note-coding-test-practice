public class Solution {

    private final int MODULUS = 10007;
    
    public int solution(int n, int[] tops) {
        int answer = 0;

        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        a[0] = 0;
        b[0] = 1;

        for (int k = 1; k <= n; k++) {

            a[k] = a[k-1] + b[k-1] % MODULUS;
            if(tops[k-1] == 1) {
                b[k] = (2 * a[k-1] + 3 * b[k-1]) % MODULUS;
            }
            else {
                b[k] = (a[k - 1] + 2 * b[k - 1]) % MODULUS;
            }
        }

        answer = (a[n] + b[n]) % MODULUS;
        return answer;
    }
}