package edu.greenriver.it.equals;

public class TestEquals
{
	public static void main(String[] args)
	{
		CampusBuilding grTechnologyCenter = new CampusBuilding("Green River College", 
				                     "Technology Center", 20000, 
				                     new String[] {"TC 120", "TC 116"});
		
		CampusBuilding uwTechnologyCenter = new CampusBuilding("University of Washington", 
                "Technology Center", 50000, 
                new String[] {"UWTC 100", "UWTC 101"});
		
		CampusBuilding tccTechnologyCenter = new CampusBuilding("Tacoma Community College", 
                "Technology Center", 20000, 
                new String[] {"TCC 200", "TCC 202"});
		
		if (grTechnologyCenter.equals(uwTechnologyCenter))
		{
			System.out.println("Objects are equal");
		}
		else
		{
			System.out.println("Objects are not equal");
		}
		
		//reflexive
		System.out.println("Reflexive: " + grTechnologyCenter.equals(grTechnologyCenter));
		
		//symmetric
		System.out.println("Symmetric: a->b " + 
		        grTechnologyCenter.equals(uwTechnologyCenter) + 
				" b->a " + uwTechnologyCenter.equals(grTechnologyCenter));
		
		//transitive
		System.out.println("Transitive: a->b " + 
		        grTechnologyCenter.equals(uwTechnologyCenter) + 
				" b->c " + uwTechnologyCenter.equals(tccTechnologyCenter) + 
				" a->c " + grTechnologyCenter.equals(tccTechnologyCenter));
	}
}
