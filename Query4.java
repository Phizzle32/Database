import java.util.*;
public class Query4 {
  public static void main(String args[]) {
    Database db = new Database();
    db.initializeDatabase(args[0]);
    Relation employee = db.getRelation("EMPLOYEE");
    Relation department = db.getRelation("DEPARTMENT");
    Relation project = db.getRelation("PROJECTS");
    Relation workson = db.getRelation("WORKS_ON");
    
    //second part
    Relation r1 = department.rename(new ArrayList<String>(Arrays.asList("DNAME","DNUMBER","SSN","MGRSTARTDATE"))); 
    Relation r2 = employee.select("col","LNAME","=","str","Smith");
    Relation r3 = r2.project(new ArrayList<String>(Arrays.asList("DNO")))
    		.rename(new ArrayList<String>(Arrays.asList("DNUMBER")));
    Relation r4 = r3.join(r1)
    		.project(new ArrayList<String>(Arrays.asList("DNUMBER")))
    		.rename(new ArrayList<String>(Arrays.asList("DNUM")));
    Relation r5 = r4.join(project)
    		.project(new ArrayList<String>(Arrays.asList("PNUMBER")));
    
    //first part
    Relation r6 = employee.select("col","LNAME","=","str","Smith")
    		.project(new ArrayList<String>(Arrays.asList("SSN")))
    		.rename(new ArrayList<String>(Arrays.asList("ESSN")));
    Relation r7 = r6.join(workson)
    		.project(new ArrayList<String>(Arrays.asList("PNO")));
    //union
    Relation r8 = r7.union(r5);
    r8.setName("ANSWER");
    System.out.println(r8);
    

    
    /*	Make a list of project numbers for projects that involve an employee whose 
		last name is "Smith", either as a worker or as a manager of the department that 
		controls the project
		( project[pno](
   			(rename[essn](project[ssn](select[lname='Smith'](employee))) 
    		join 
    		works_on
   			)
  		)
 		union
  			project[pnumber](
   				( rename[dnum](project[dnumber](select[lname='Smith'](
       				(employee 
        			join   
        			rename[dname,dnumber,ssn,mgrstartdate](department)
       				)
       				)
       				)
     			) 
     			join 
     			projects
    			)
  			)
		);
    */
  }
}
/*
ANSWER(PNO:INTEGER)
Number of tuples: 3

1:
2:
3:
*/