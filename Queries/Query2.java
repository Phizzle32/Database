import java.util.*;

public class Query2 {
  public static void main(String args[]) {
    Database db = new Database();
    db.initializeDatabase(args[0]);
    // For every project located in "Stafford", list the project number, the 
    // controlling department number, and the department manager's last name, address, 
    // and birth date.

    // project[pnumber,dnum,lname,address,bdate](
    //   (
    //    (select[plocation='Stafford'](projects) 
    //     join 
    //     rename[dname,dnum,ssn,mgrstartdate](department)
    //    )
    //    join employee
    //   )
    // );
    Relation employee = db.getRelation("EMPLOYEE");
    Relation projects = db.getRelation("PROJECTS");
    Relation department = db.getRelation("DEPARTMENT");
    Relation r1 = projects.select("col","PLOCATION","=","str","Stafford");
    ArrayList<String> cols = new ArrayList<String>(); 
    cols.add("DNAME");
    cols.add("DNUM");
    cols.add("SSN");
    cols.add("MGRSTARTDATE");
    Relation r2 = department.rename(cols);
    Relation r3 = r1.join(r2);
    Relation r4 = r3.join(employee);
    cols.clear();
    cols.add("PNUMBER");
    cols.add("DNUM");
    cols.add("LNAME");
    cols.add("ADDRESS");
    cols.add("BDATE");
    Relation r5 = r4.project(cols);
    r5.setName("ANSWER");
    System.out.println(r5);
  }
}
/*
ANSWER(PNUMBER:INTEGER,DNUM:INTEGER,LNAME:VARCHAR,ADDRESS:VARCHAR,BDATE:VARCHAR)
Number of tuples: 2

10:4:Wallace:291 Berry, Bellaire, TX:20-JUN-31:
30:4:Wallace:291 Berry, Bellaire, TX:20-JUN-31:
*/