import java.util.Arrays;

public class distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] distance = { 10, 20, 25, 40 };
		int [] result = new int[5];
		
		int resultIndex = 0;
		Arrays.fill(result, 0);

		for(int offset= 0 ;offset< 5; offset++)
		{
			for( int i =0; i< 5; i++)
			{
				if(i  < offset )
				{
					for( int j = i ;j < offset; j++)
					{
						result[i]+=distance[j];
					}
					
				}
				else
				{
					for( int j = offset ;j < i; j++)
					{
						result[i]+=distance[j];
					}
				}
			}
		}
		int min  = result[0];
		
		for(int i= 0 ;i< 5; i++)
		{
			if( min > result[i])
				min = result[i];
			
		}
	
		for( int i = 0; i< 5; i++)
		{
			if( min == result[i])
			{
				resultIndex = i;
				break;
			}
		}
		System.out.println("index: "+resultIndex+" min: "+min );
		
		
	}

}
