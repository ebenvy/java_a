package previous_test;

import java.util.Scanner;

public class phone_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][]pattern = {
				{"10","11","12"},
				{"20","21","22"},
				{"30","31","32"}
		};
		
		boolean isValidPattern = false;
		Scanner sc = new Scanner(System.in);
		String line="";
		do
		{
			System.out.println("���ڿ� �Է����ּ���");
			line = sc.next();
			phone_pattern pt = new phone_pattern();
			isValidPattern = pt.checkValidPattern(line);
			if(!isValidPattern)
				System.out.println("������ ���� ��Ģ�Դϴ�.");
			
		}while(!isValidPattern);
		System.out.println("���� ��Ģ�Դϴ�.");
	}
	public boolean checkValidPattern(String str)
	{
		
		return false;
	}

}
