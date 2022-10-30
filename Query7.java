import java.util.*;
public class Query7 {
	public static void main(String args[]) {
		Database db = new Database();
	    db.initializeDatabase(args[0]);
	    Relation employee = db.getRelation("EMPLOYEE");
	    Relation department = db.getRelation("DEPARTMENT");
	    Relation dependent = db.getRelation("DEPENDENT");
	    
	    Relation r1 = department.project(new ArrayList<String>(Arrays.asList("MGRSSN")))
	    		.rename(new ArrayList<String>(Arrays.asList("SSN")));
	    Relation r2 = dependent.project(new ArrayList<String>(Arrays.asList("ESSN")))
	    		.rename(new ArrayList<String>(Arrays.asList("SSN")));
	    Relation r3 = r1.join(r2).join(employee);
	    Relation r4 = r3.project(new ArrayList<String>(Arrays.asList("LNAME","FNAME")));
	    
	    r4.setName("ANSWER");
	    System.out.println(r4);

	}
}
/*
ANSWER(LNAME:VARCHAR,FNAME:VARCHAR)
Number of tuples: 3

Wong:Franklin:
Wallace:Jennifer:
Freed:Alex:
*/