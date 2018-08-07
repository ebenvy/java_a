package diskcleaner;

public class diskcleaner {

	static private String disk[][]= {{"A","H","L","BB","","Z","K","","L"},
									 {"B","","A","","N","NN","K","F",""},
									 {"","CC","","D","","G","","","J"},
									 {"KK","","","","","D","DD","",""},
									 {"","B","","J","P","","G","","P"}};
	private static class Index{
		Index(int row, int cal)
		{
			this.row = row;
			this.cal = cal;
		}
		int row;
		int cal;
	}
	static private Index findSameFile(int row,int cal)
	{
		int i= row;
		int j = cal+1;
		for(;i< disk.length;i++)
		{
			for(; j< disk[i].length; j++)
			{
				if( disk[row][cal].equals(disk[i][j]))
					return new Index(i,j);
				else if( disk[i][j].startsWith(disk[row][cal]))
					return null;
			}
			j= 0;
		}
		return null;
	}
	static private void printCleanedDisk(String arr[][])
	{
		for(int i= 0;i< disk.length;i++)
		{
			for(int j = 0 ; j< disk[i].length; j++)
			{
				System.out.print("["+arr[i][j]+"] ");
			}
			System.out.println();
		}
		
	}
	static private void printArrangedDisk(String arr[][])
	{
		int count = 0;
		for(int i= 0;i< disk.length;i++)
		{
			for(int j = 0 ; j< disk[i].length; j++)
			{
				if( arr[i][j].length()==2)
				{
					System.out.print("["+arr[i][j]+"] ");
					if((++count)%disk[i].length ==0) 
						System.out.println();
				}
			}
		}
		for(int i= 0;i< disk.length;i++)
		{
			for(int j = 0 ; j< disk[i].length; j++)
			{
				if( arr[i][j].length()==1)
				{
					System.out.print("["+arr[i][j]+"] ");
					if((++count)%disk[i].length ==0) 
						System.out.println();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cleanedDisk[][]= new String[disk.length][disk[0].length];
		for(int i= 0;i< disk.length;i++)
		{
			for(int j = 0 ; j< disk[i].length; j++)
			{
				if( disk[i][j].length() == 1 )
				{
					Index idx = findSameFile(i,j);
					if(idx != null)
					{
						cleanedDisk[i][j]= disk[i][j]+disk[i][j];
						cleanedDisk[idx.row][idx.cal]="";
						continue;
					}
				}
				if(cleanedDisk[i][j] ==null)
					cleanedDisk[i][j] = disk[i][j];
				
			}
		}
		System.out.println("-----------------------------------------");
		printCleanedDisk(cleanedDisk);
		System.out.println("-----------------------------------------");
		printArrangedDisk(cleanedDisk);
			
	}
	

}
