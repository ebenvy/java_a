package backjoon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
//¹®Á¦: https://www.acmicpc.net/problem/9248
public class suffix_array {

	public static void main(String [] args)
	{
		String str ="abracadabra";
		//String str ="banana";
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		ArrayList<String> result = new ArrayList<String>();
		for(int i= 0; i <str.length(); i++)
		{
			map.put(str.substring(i),i+1);
		}
		String prevStr="";
        for( String key : map.keySet() ){
            System.out.print( map.get(key)+" ");
        }
        System.out.println("");
        int nLen;
        int idx;
        for( String key : map.keySet() ){
        	if(key.length()> prevStr.length())
        	{
        		nLen = prevStr.length();
        	}
        	else
        	{
        		nLen = key.length();
        	}
    		for(idx=0; idx<nLen;idx++)
    		{
    			if(key.charAt(idx) != prevStr.charAt(idx))
    			{
    				break;
    			}
    		}
    		prevStr = key;
    		if(nLen == 0 )
    			System.out.print("x ");
    		else
    			System.out.print(idx+ " ");
        	
        }
        

	  

	}
}
