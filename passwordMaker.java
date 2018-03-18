package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/1759
public class passwordMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int passwordLen = sc.nextInt();
		int candidateLen = sc.nextInt();
		sc.nextLine();
		String line = sc.nextLine();
		String [] candidate = line.split(" ");
		passwordMaker pM = new passwordMaker();
		ArrayList<String> list = new ArrayList<String>();
		Arrays.sort(candidate);
		pM.makePassword(candidate,list,0, passwordLen, candidateLen);
		//System.out.println("("+nresult+")");
		sc.close();
	}
	public void  makePassword(String candidate[], ArrayList<String> list,int offset,int pwLen, int cdLen)
	{
		//4개 다채운경우 출력하고 멈춤
		if( list.size()==pwLen)
		{
			for(String str: list)
			{
				System.out.print(str);
			}
			System.out.println("");
			return;
		}
		//끝까지 온경우 멈춤
		if(offset == cdLen)
			return;
		//선택하고
		list.add(candidate[offset]);
		makePassword(candidate, list,offset+1,pwLen, cdLen);
		//선택안하고
		list.remove(list.size()-1);
		makePassword(candidate, list,offset+1,pwLen, cdLen);

		
	}

}
