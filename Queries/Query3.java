import java.util.*;

public class Query3 {
  public static void main(String args[]) {
    Database db = new Database();
    db.initializeDatabase(args[0]);

    // Find the names of employees who work on all the projects controlled by 
    // department number 4.

    // project[lname,fname](
    //  (employee
    //   join
    //   (project[ssn](employee)
    //    minus
    //    project[ssn](
    //     (
    //       (project[ssn](employee) 
    //        times  
    //        project[pnumber](select[dnum=4](projects))
    //       )
    //       minus
    //       rename[ssn,pnumber](project[essn,pno](works_on))
    //     )
    //    )
    //   )
    //  )
    // );
    
    Relation employee = db.getRelation("EMPLOYEE");
    Relation projects = db.getRelation("PROJECTS");
    Relation workson = db.getRelation("WORKS_ON");
    
    Relation r1 = projects.select("col","DNUM","=","num","5")
                          .project(new ArrayList<String>(Arrays.asList("PNUMBER")));
    Relation r2 = employee.project(new ArrayList<String>(Arrays.asList("SSN"))).times(r1);
    Relation r3 = workson.project(new ArrayList<String>(Arrays.asList("ESSN","PNO")))
                         .rename(new ArrayList<String>(Arrays.asList("SSN","PNUMBER")));
    Relation r4 = r2.minus(r3).project(new ArrayList<String>(Arrays.asList("SSN")));
    Relation r5 = employee.project(new ArrayList<String>(Arrays.asList("SSN")))
                          .minus(r4);
    Relation answer = employee.join(r5).project(new ArrayList<String>(Arrays.asList("LNAME","FNAME")));
    answer.setName("ANSWER");
   
    System.out.println(answer);
  }
}
/*
ANSWER(LNAME:VARCHAR,FNAME:VARCHAR)
Number of tuples: 2

Zelaya:Alicia:
Jabbar:Ahmad:
*/