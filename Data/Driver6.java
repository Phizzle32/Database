import java.util.*;

public class Driver6 {
  public static void main(String args[]) {
    Database db = new Database();
    ArrayList<String> attr1 = new ArrayList<String>();
    attr1.add("SID");
    attr1.add("SNAME");
    attr1.add("PHONE");
    attr1.add("MAJOR");
    attr1.add("GPA");
    ArrayList<String> dom1 = new ArrayList<String>();
    dom1.add("INTEGER");
    dom1.add("VARCHAR");
    dom1.add("INTEGER");
    dom1.add("VARCHAR");
    dom1.add("DECIMAL");
    Relation r1 = new Relation("REL1",attr1,dom1);
    Tuple t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1111);
    t.addStringComponent("Robert Adams");
    t.addIntegerComponent(1234);
    t.addStringComponent("Computer Science");
    t.addDoubleComponent(4.0);
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1112);
    t.addStringComponent("Charles Bailey");
    t.addIntegerComponent(5656);
    t.addStringComponent("Computer Science");
    t.addDoubleComponent(3.5);
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1113);
    t.addStringComponent("David Beatle");
    t.addIntegerComponent(1212);
    t.addStringComponent("Mathematics");
    t.addDoubleComponent(3.5);
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1114);
    t.addStringComponent("Graham Gooch");
    t.addIntegerComponent(5678);
    t.addStringComponent("Computer Science");
    t.addDoubleComponent(3.5);
    r1.addTuple(t);

    db.addRelation("STUDENT",r1);

    r1.displayRelation();

    Relation r2 = r1.select("col","SID","=","num","1114");
    r2.setName("SELECT_SID_=_1114");
    r2.displayRelation();

    Relation r3 = r1.select("col","GPA",">=","num","3.5");
    r3.setName("SELECT_GPA_>=_3.5");
    r3.displayRelation();

    Relation r4 = r1.select("col","MAJOR","=","str","Computer Science");
    r4.setName("SELECT_MAJOR_=_Computer Science");
    r4.displayRelation();
  }
}
/*
STUDENT(SID:INTEGER,SNAME:VARCHAR,PHONE:INTEGER,MAJOR:VARCHAR,GPA:DECIMAL)
Number of tuples: 4

1111:Robert Adams:1234:Computer Science:4.0:
1112:Charles Bailey:5656:Computer Science:3.5:
1113:David Beatle:1212:Mathematics:3.5:
1114:Graham Gooch:5678:Computer Science:3.5:

SELECT_SID_=_1114(SID:INTEGER,SNAME:VARCHAR,PHONE:INTEGER,MAJOR:VARCHAR,GPA:DECIMAL)
Number of tuples: 1

1114:Graham Gooch:5678:Computer Science:3.5:

SELECT_GPA_>=_3.5(SID:INTEGER,SNAME:VARCHAR,PHONE:INTEGER,MAJOR:VARCHAR,GPA:DECIMAL)
Number of tuples: 4

1111:Robert Adams:1234:Computer Science:4.0:
1112:Charles Bailey:5656:Computer Science:3.5:
1113:David Beatle:1212:Mathematics:3.5:
1114:Graham Gooch:5678:Computer Science:3.5:

SELECT_MAJOR_=_Computer Science(SID:INTEGER,SNAME:VARCHAR,PHONE:INTEGER,MAJOR:VARCHAR,GPA:DECIMAL)
Number of tuples: 3

1111:Robert Adams:1234:Computer Science:4.0:
1112:Charles Bailey:5656:Computer Science:3.5:
1114:Graham Gooch:5678:Computer Science:3.5:
*/