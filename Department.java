import java.util.ArrayList;
import java.util.Scanner;

public class Department {

	static String depInfo[][]= {{"M","B"},
								{"M","C"},
								{"M","F"},
								{"B","S"},
								{"B","T"},
								{"S","A"},
								{"S","D"},
								{"T","N"},
								{"T","O"},
								{"C","P"},
								{"F","K"},
								{"F","Q"},
								{"K","L"},
								{"Q","W"},
								{"Q","E"}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5-1  �ΰ��� �μ��� ���� �Է��Ͻÿ�");
		String deps[] = sc.nextLine().split(" ");
		
		Department dep =new Department();
		
		//5-1
		//���� ���� �μ� ã�� 
		ArrayList<String> strList ;
		ArrayList<String> strList2 ;
		
		strList = dep.getUpperDepartments(deps[0]);
		strList2 = dep.getUpperDepartments(deps[1]);
		//���� �μ� ã��
		System.out.println(dep.getSameDepartment(strList,strList2));
		
		//5-2
		//���� �μ��� ���� �μ� ã�� 
		System.out.println("5-2  �μ��� �Է��Ͻÿ� ");
		String line = sc.nextLine();
		String upperDep = dep.getUpperDepartments(line).get(1);
		System.out.println(dep.getLowerDepartments(upperDep).size()-1);
		sc.close();
		

	}
	public ArrayList<String> getUpperDepartments(String depart)
	{
		ArrayList<String> strList = new ArrayList<String>();
		
		//���� ã�� 
		strList.add(depart);
	
		for(int i = 0; i< depInfo.length; i++)
		{
			String str =depInfo[i][1];
			if(str.equals(strList.get(strList.size()-1)))
			{
				strList.add(depInfo[i][0]);
				i =-1;		
				continue;
			}
		}
		return strList;
	}
	
	public String getSameDepartment(ArrayList<String> list1, ArrayList<String> list2)
	{
		for(String d1 : list1 )
		{
			for(String d2: list2)
			{
				if(d1.equals(d2))
					return d1;
			}
		}
		return null;
	}
	public ArrayList<String> getLowerDepartments(String depart)
	{
		ArrayList<String> strList = new ArrayList<String>();
		int idx =0; 
	
		strList.add(depart);
		
		while( idx < strList.size())
		{
			for(int i = 0; i< depInfo.length; i++)
			{
				if(depInfo[i][0].equals(strList.get(idx)))
				{
					strList.add(depInfo[i][1]);
					
				}
			}
			idx ++;
		}
		
		return strList;
	}

}
