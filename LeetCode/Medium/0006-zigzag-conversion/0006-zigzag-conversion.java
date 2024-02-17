import java.util.ArrayList;
public class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
    	
        for(int i=0; i<numRows; i++) 
        	list.add(new ArrayList<Character>());
        
        int row = 0;
        int zig = numRows-2;
        int zigIdx = 1;
        
        for(int i=0; i<s.length(); i++) {
        	char temp = s.charAt(i);
        	
        	if(row>=numRows && zig<=0) {
        		row = 0;
        		zig = numRows-2;
        		zigIdx = 1;
        	}
        	
        	if(row<numRows) {
        		list.get(row).add(temp);
        		row++;
        		continue;
        	}
        	
        	
        	if(zig>0) {
	        	list.get(row-zigIdx-1).add(temp);
	        	zig--;
	        	zigIdx++;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
        	for(int j=0; j<list.get(i).size(); j++) {
        		sb.append(list.get(i).get(j));
        	}
        }
        
    	return sb.toString();
    }
}