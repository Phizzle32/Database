import java.util.*;

public class Drivera {
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

    ArrayList<String> attr2 = new ArrayList<String>();
    attr2.add("SID");
    attr2.add("COURSE");
    attr2.add("GRADE");
    ArrayList<String> dom2 = new ArrayList<String>();
    dom2.add("INTEGER");
    dom2.add("VARCHAR");
    dom2.add("VARCHAR");
    Relation r2 = new Relation("REL2",attr2,dom2);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1111);
    t.addStringComponent("Database Systems");
    t.addStringComponent("A");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1114);
    t.addStringComponent("Database Systems");
    t.addStringComponent("B");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1114);
    t.addStringComponent("Java Programming");
    t.addStringComponent("A");
    r2.addTuple(t);

    db.addRelation("ENROLL",r1);

    r1.displayRelation();
    r2.displayRelation();

    Relation r3 = r1.join(r2);
    r3.setName("STUDENT_JOIN_ENROLL");
    r3.displayRelation();
  }
}
/*
ENROLL(SID:INTEGER,SNAME:VARCHAR,PHONE:INTEGER,MAJOR:VARCHAR,GPA:DECIMAL)
Number of tuples: 4

1111:Robert Adams:1234:Computer Science:4.0:
1112:Charles Bailey:5656:Computer Science:3.5:
1113:David Beatle:1212:Mathematics:3.5:
1114:Graham Gooch:5678:Computer Science:3.5:

REL2(SID:INTEGER,COURSE:VARCHAR,GRADE:VARCHAR)
Number of tuples: 3

1111:Database Systems:A:
1114:Database Systems:B:
1114:Java Programming:A:

STUDENT_JOIN_ENROLL(SID:INTEGER,SNAME:VARCHAR,PHONE:INTEGER,MAJOR:VARCHAR,GPA:DECIMAL,COURSE:VARCHAR,GRADE:VARCHAR)
Number of tuples: 3

1111:Robert Adams:1234:Computer Science:4.0:Database Systems:A:
1114:Graham Gooch:5678:Computer Science:3.5:Database Systems:B:
1114:Graham Gooch:5678:Computer Science:3.5:Java Programming:A:
*/