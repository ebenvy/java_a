package backjoon;


/*
 * https://www.acmicpc.net/problem/14503
 * 1.���� ��ġ�� û���Ѵ�.
   2.���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�. 
     1.���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
     2.���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
     3.�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
     4.�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
                �κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.

*/
public class robotic_vacuum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int row =11;
		int calumn =10;
		int r= 7;
		int c =4;
		int dir = 0;
	
		
		int [][] arr = {
				{1 ,1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1 ,0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1 ,0, 0, 0, 1, 1, 1, 1, 0, 1},
				{1 ,0, 0, 1, 1, 0, 0, 0, 0, 1},
				{1 ,0, 1, 1, 0, 0, 0, 0, 0, 1},
				{1 ,0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1 ,0, 0, 0, 0, 0, 0, 1, 0, 1},
				{1 ,0, 0, 0, 0, 0, 1, 1, 0, 1},
				{1 ,0, 0, 0, 0, 0, 1, 1, 0, 1},
				{1 ,0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1 ,1, 1, 1, 1, 1, 1, 1, 1, 1}};
		int nCount  =0;
		boolean bExit =false;
		while(bExit ==false)
		{
			//1.��ĭ û��
			if(arr[r][c] == 0 )
			{
				arr[r][c] = 2;
				nCount++;
				
			}
			int i;
			//2.�������� ȸ��
			for(i = 0; i< 4; i++)
			{
				dir = changeDir(dir);
				//3.
				Direction dr= new Direction(r,c);
				if(MoveDir(arr,row,calumn,dir,dr)== true)
				{
					r= dr.r;
					c= dr.c;
					break;
				}
			}
			if( i ==4)
			{
				Direction dr= new Direction(r,c);
				if(MoveBack(arr,row,calumn,dir,dr)==true)
				{
					r= dr.r;
					c= dr.c;
					continue;
				}
				break;
			}
		}
		for(int i = 0 ;i <row; i++)
		{
			for(int j = 0; j< calumn; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
		//System.out.println(arr);
		System.out.println("clean room count:"+nCount);
		
		

	}

	private static boolean MoveDir(int[][] arr,int row, int calumn, int dir,Direction dr)
	{
		int r = dr.r;
		int c = dr.c;
		switch(dir)
		{
		case 0:
			r--;
			break;
		case 1:
			c++;
			break;
		case 2:
			r++;
			break;
		case 3:
			c--;
			break;
		}
		if(r <0 || r >=row)
			return false;
		if(c <0 || c >= calumn)
			return false;
		
		if( arr[r][c] == 1 ||arr[r][c] == 2)
			return false;
		dr.r= r;
		dr.c =c;
	
		return true;
	}
	private static boolean MoveBack(int[][] arr,int row, int calumn, int dir,Direction dr)
	{
		int r = dr.r;
		int c = dr.c;
		switch(dir)
		{
		case 0:
			r++;
			break;
		case 1:
			c--;
			break;
		case 2:
			r--;
			break;
		case 3:
			c++;
			break;
		}
		if(r <0 || r >=row)
			return false;
		if(c <0 || c >= calumn)
			return false;
		
		if( arr[r][c] == 1 )
			return false;
		dr.r= r;
		dr.c =c;
	
		return true;
	}
	private static int changeDir(int dir)
	{
		int fixDir;
		//0->3->2->1
		if(dir ==0 )
			fixDir = 3;
		else
			fixDir = dir -1;
			
		return fixDir;
	}


}
