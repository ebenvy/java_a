package previous_test;

public class PatternCheck {
	final static int MinUnit =2;
	public boolean checkValidPattern(String str)
	{
		String [] num = str.split(",");
		
		//연속 패턴
		for( int i = 0; i< num.length; i++)
		{
			if(isSerialPattern(num, i))
				return false;
		}
		return true;
		
	}
	private boolean isSerialPattern(String [] num, int offset)
	{
		int i , unit;
		for( unit = MinUnit; unit<= num.length/2 ; unit++)
		{
			if( offset+unit*2> num.length)
				return false;
			for( i = offset; i< offset+unit; i++)
			{
				if( num[i].equals(num[i+unit]) ==false)
				{
					break;
				}
				
			}
			if( i == offset+unit)
				return true;
		
		}
		return false;
	}

}
