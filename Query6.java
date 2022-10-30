import java.util.*;

public class Query6 {
  public static void main(String args[]) {
    Database db = new Database();
    db.initializeDatabase(args[0]);
    // Retrieve the names of employees who have no dependents.
    //
    // project[lname,fname](
    //  ( ( project[ssn](employee) 
    //       minus project[essn](dependent)
    //    ) 
    //    join 
    //    employee
    //  )
    // );
    
    Relation employee = db.getRelation("EMPLOYEE");
    Relation dependent = db.getRelation("DEPENDENT");
    ArrayList<String> cols = new ArrayList<String>();
    cols.add("SSN");
    Relation r1 = employee.project(cols);
    cols.clear();
    cols.add("ESSN");
    Relation r2 = dependent.project(cols);
    Relation r3 = r1.minus(r2);
    Relation r4 = r3.join(employee);
    cols.clear();
    cols.add("LNAME"); 
    cols.add("FNAME"); 
    Relation r5 = r4.project(cols);
    r5.setName("ANSWER");
    System.out.println(r5);;
  }
}
/*
ANSWER(LNAME:VARCHAR,FNAME:VARCHAR)
Number of tuples: 34

Borg:James:
Zelaya:Alicia:
Narayan:Ramesh:
English:Joyce:
Jabbar:Ahmad:
James:Jared:
James:John:
Jones:Jon:
Mark:Justin:
Knight:Brad:
Wallis:Evan:
Zell:Josh:
Vile:Andy:
Brand:Tom:
Vos:Jenny:
Carter:Chris:
Grace:Kim:
Chase:Jeff:
Snedden:Sam:
Ball:Nandita:
Bender:Bob:
Jarvis:Jill:
King:Kate:
Leslie:Lyle:
King:Billie:
Kramer:Jon:
King:Ray:
Small:Gerald:
Head:Arnold:
Pataki:Helga:
Drew:Naveen:
Reedy:Carl:
Hall:Sammy:
Bacher:Red:
*/