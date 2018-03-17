package backjoon;

import java.util.Scanner;
//https://www.acmicpc.net/problem/1018
public class chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    System.out.println("행과 열을 입력하시오 ");
	   /* int cal= sc.nextInt();
	    int row= sc.nextInt();
	    String [][] array = new String[cal][row];
	    sc.nextLine();
	    for(int i =0 ;i< cal; i++)
	    {
	    	for( int j= 0 ;j< row; j++)
	    	{
	    		array[i][j] = sc.next();
	    	}
	    }
	    
	    for(int i =0 ;i< cal; i++)
	    {
	    	for( int j= 0 ;j< row; j++)
	    	{
	    		System.out.print(array[i][j]+"");
	    	}
	    	System.out.println("");
	    }*/
	    int cal = 10;
	    int row = 13; 
	    
	    int wCount;
	    int bCount; 
	    int min = 0;
	    
	   /* String [][] array = {
	    		{"W","B","W","B","W","B","W","B"},
	    		{"B","W","B","W","B","W","B","W"},
	    		{"W","B","W","B","W","B","W","B"},
	    		{"B","W","B","B","B","W","B","W"},
	    		{"W","B","W","B","W","B","W","B"},
	    		{"B","W","B","W","B","W","B","W"},
	    		{"W","B","W","B","W","B","W","B"},
	    		{"B","W","B","W","B","W","B","W"}};*/
	    
	    String [][] array = {
	    		{"B","B","B","B","B","B","B","B","W","B","W","B","W"},
	    		{"B","B","B","B","B","B","B","B","B","W","B","W","B"},
	    		{"B","B","B","B","B","B","B","B","W","B","W","B","W"},
	    		{"B","B","B","B","B","B","B","B","B","W","B","W","B"},
	    		{"B","B","B","B","B","B","B","B","W","B","W","B","W"},
	    		{"B","B","B","B","B","B","B","B","B","W","B","W","B"},
	    		{"B","B","B","B","B","B","B","B","W","B","W","B","W"},
	    		{"B","B","B","B","B","B","B","B","B","W","B","W","B"},
	    		{"W","W","W","W","W","W","W","W","W","W","B","W","B"},
	    		{"W","W","W","W","W","W","W","W","W","W","B","W","B"}};

	    for( int i = 0; i< cal ;i++)
	    {
	    	if(i > cal-8)
    			break;
	    	for (int j = 0; j< row; j++)
	    	{
	    		if(j > row-8)
	    			break;
	    		wCount = Check(array, i, j, "W");
	    		bCount =Check(array, i, j, "B");
	    		 System.out.print("wCount: "+wCount+"bCount: "+bCount);
	    		if( min == 0)
	    			min = Math.min(wCount, bCount);
	    		else
	    			min = Math.min(Math.min(wCount, bCount), min);
	    		
	    	    System.out.println("min: "+min);
	    	
	    	}
	    }
	    System.out.println("final min: "+min);
	  
	}
	private static int Check(String [][]arr, int cal, int row,String start)
	{
		//8*8 크기 검사 
		String prev;
		int nCount  =0;
		prev = reverse(start);
		//w로 시작할때
	
		for( int i = cal; i< cal+8 ;i++)
		{
			for( int j =row; j< row+8; j++)
			{
				if( prev == arr[i][j])
				{
					nCount++;
				}
				prev = reverse(prev);
			}
			prev =reverse(prev);
		}
		return nCount;
	}
	private static String reverse(String str)
	{
		if( str == "W")
		{
			return  "B";
		}
		else
		{
			return "W";
		}
	}

}
