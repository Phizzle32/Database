import java.util.*;

public class Driver3 {
  public static void main(String args[]) {
    Database db = new Database();
    ArrayList<String> attr1 = new ArrayList<String>();
    attr1.add("COL1");
    attr1.add("COL2");
    ArrayList<String> dom1 = new ArrayList<String>();
    dom1.add("INTEGER");
    dom1.add("VARCHAR");
    Relation r1 = new Relation("REL1",attr1,dom1);
    Tuple t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1111);
    t.addStringComponent("Robert Adams");
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1112);
    t.addStringComponent("Charles Bailey");
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1114);
    t.addStringComponent("Richard Johnson");
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1115);
    t.addStringComponent("Graham Gooch");
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1116);
    t.addStringComponent("John Miller");
    r1.addTuple(t);
    db.addRelation("REL1",r1);

    ArrayList<String> attr2 = new ArrayList<String>();
    attr2.add("COL1");
    attr2.add("COL2");
    ArrayList<String> dom2 = new ArrayList<String>();
    dom2.add("INTEGER");
    dom2.add("VARCHAR");
    Relation r2 = new Relation("REL2",attr2,dom2);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1113);
    t.addStringComponent("John Smith");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1112);
    t.addStringComponent("Charles Bailey");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1115);
    t.addStringComponent("Graham Gooch");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1116);
    t.addStringComponent("John Miller");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1117);
    t.addStringComponent("Hugh Howell");
    r2.addTuple(t);
    db.addRelation("REL2",r2);

    Relation r3 = r1.union(r2);
    r3.setName("REL1_UNION_REL2");
    Relation r4 = r1.intersect(r2);
    r4.setName("REL1_INTERSECT_REL2");
    Relation r5 = r1.minus(r2);
    r5.setName("REL1_MINUS_REL2");

    r1.displayRelation();
    r2.displayRelation();
    r3.displayRelation();
    r4.displayRelation();
    r5.displayRelation();;
  }
}
/*
REL1(COL1:INTEGER,COL2:VARCHAR)
Number of tuples: 5

1111:Robert Adams:
1112:Charles Bailey:
1114:Richard Johnson:
1115:Graham Gooch:
1116:John Miller:

REL2(COL1:INTEGER,COL2:VARCHAR)
Number of tuples: 5

1113:John Smith:
1112:Charles Bailey:
1115:Graham Gooch:
1116:John Miller:
1117:Hugh Howell:

REL1_UNION_REL2(COL1:INTEGER,COL2:VARCHAR)
Number of tuples: 7

1111:Robert Adams:
1112:Charles Bailey:
1114:Richard Johnson:
1115:Graham Gooch:
1116:John Miller:
1113:John Smith:
1117:Hugh Howell:

REL1_INTERSECT_REL2(COL1:INTEGER,COL2:VARCHAR)
Number of tuples: 3

1112:Charles Bailey:
1115:Graham Gooch:
1116:John Miller:

REL1_MINUS_REL2(COL1:INTEGER,COL2:VARCHAR)
Number of tuples: 2

1111:Robert Adams:
1114:Richard Johnson:
*/