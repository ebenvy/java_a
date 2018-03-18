package backjoon;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String str2 = sc.nextLine();
		int nCount = 0;

		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		nCount = lcs.findSequence(str, str2);

		System.out.println(nCount);
		sc.close();
	}
	public int findSequence(String str, String str2)
	{
		int nCount=0;
		int nIndex=0;
		int maxCount =0;
		
		for (int i = 0; i< str.length();i++)
		{
			//nCount = 0;
			for( int j =nIndex; j < str2.length(); j++)
			{
				if(str.charAt(i) ==  str2.charAt(j))
				{
					nIndex = j;
					nCount++;
				}
			}
			//if( maxCount < nCount)
				maxCount = nCount;
		}
		
		return maxCount ;
	}

}
