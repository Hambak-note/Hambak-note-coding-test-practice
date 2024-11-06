import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine()), max=Integer.MIN_VALUE;
		long total=0;
		int [][] coms = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				coms[i][j]=Integer.parseInt(st.nextToken());;
				total+=coms[i][j];
				max = Math.max(max, coms[i][j]);
			}
		}
		long l=0, r=max;
		while(l<r) {
			long m=(l+r)/2, temp=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++)
					temp+=Math.min(m, coms[i][j]);
			}
			if(temp*2>=total)
				r=m;
			else
				l=m+1;
		}
		System.out.println(r);
	}
}