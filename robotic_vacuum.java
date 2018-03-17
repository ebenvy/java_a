package backjoon;


/*
 * https://www.acmicpc.net/problem/14503
 * 1.현재 위치를 청소한다.
   2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다. 
     1.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
     2.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
     3.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
     4.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

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
			//1.내칸 청소
			if(arr[r][c] == 0 )
			{
				arr[r][c] = 2;
				nCount++;
				
			}
			int i;
			//2.왼쪽으로 회전
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
