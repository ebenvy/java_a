
public class AnyPangReq {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [][] = { {1,2,3,4,5,6},
				          {1,1,1,4,5,6},
				          {2,3,2,5,5,7},
				          {1,3,2,5,5,7},
				          {1,3,2,5,5,8}};
		arr =removeDup(arr);
		for(int i = 0 ;i< arr.length;i++)
		{
			for(int j = 0 ;j <arr[i].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
	static private int [][] removeDup(int arr[][])
	{
		int newArray [][] = new int [arr.length][arr[0].length];
		int count = 0;
		for(int i = 0 ;i< arr.length; i++)
		{
			for( int j= 0; j< arr[i].length;j++)
			{
				newArray[i][j] =arr[i][j];
			}
		}	
		for(int i = 0 ;i< arr.length; i++)
		{
			for( int j= 0; j< arr[i].length;j++)
			{
				count =checkArray(arr,newArray,i,j,1);
			}
		}
		return newArray;
	}
	static private int checkArray(int arr[][], int newArr[][],int row, int cal, int count)
	{

		if(row >= arr.length || cal >= arr[0].length )
			return count;
	
		boolean searchRight = false;
		boolean searchDown = false;
		
		// 오른쪽
		if((cal+1 <  arr[0].length) &&(arr[row][cal] == arr[row][cal+1]))
		{
			count = checkArray(arr,newArr,row,cal+1, count+1);
			searchRight = true;
			
		}
		//아래쪽
		if((row+1 <  arr.length)&&(arr[row][cal] == arr[row+1][cal]))
		{
			count= checkArray(arr,newArr,row+1,cal, count+1);
			searchDown = true;
		}
		
		if(count >=3)
		{
			newArr[row][cal] =0;
			if(searchRight)
				newArr[row][cal+1] =0;
			if(searchDown)
				newArr[row+1][cal] =0;
		}
		
		return count;
	
				
	}

}
