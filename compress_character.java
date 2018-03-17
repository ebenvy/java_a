package backjoon;

import java.util.Scanner;

public class compress_character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		str = compress(str);
		System.out.println(str);
		sc.close();
	}
	private static String compress(String str)
	{
		String result= str;
		int nCount=0;
		for( int i = 0; i< result.length(); i++)
		{
			for(int unit =1; unit<= result.length()/2;unit++)
			{
				if((nCount=checkMatchWord(result,i, unit))>1)
				{
					//System.out.println(result.substring(i, i+unit*nCount));
					result =result.replace(result.substring(i, i+unit*nCount), nCount+"("+result.substring(i,i+unit)+")");
					//System.out.println(result);
				
					i=0;
					break;
				}
			}
		}
		//result = str;
		return result;
		

	}
	private static int checkMatchWord(String str, int offset,int unit)
	{
		int count =1; 
		for( int i = offset; i< str.length()-unit; i+=unit)
		{
			//System.out.println(i+"_"+unit);
			if(i+unit*2>str.length())
				break;
			if(str.charAt(i)=='('||str.charAt(i)==')')
				break;
			if( str.substring(i, i+unit).equals(str.substring(i+unit, i+unit*2)))
			{
				count ++;
				continue;
			}
			break;
			
					
		}
		return count;
	
		
	}

}
