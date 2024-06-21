import java.util.*;

public class Driver4 {
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

    ArrayList<String> newColNames = new ArrayList<String>();
    newColNames.add("NEWCOL1");
    newColNames.add("NEWCOL2");
    Relation r3 = r1.rename(newColNames);
    r3.setName("RENAMECOLS");

    r1.displayRelation();
    r3.displayRelation();

    r1.displayRelation();
    r2.displayRelation();
    Relation r4 = r1.times(r2);
    r4.setName("R1TIMESR2");
    r4.displayRelation();
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

RENAMECOLS(NEWCOL1:INTEGER,NEWCOL2:VARCHAR)
Number of tuples: 5

1111:Robert Adams:
1112:Charles Bailey:
1114:Richard Johnson:
1115:Graham Gooch:
1116:John Miller:

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

R1TIMESR2(REL1.COL1:INTEGER,REL1.COL2:VARCHAR,REL2.COL1:INTEGER,REL2.COL2:VARCHAR)
Number of tuples: 25

1111:Robert Adams:1113:John Smith:
1111:Robert Adams:1112:Charles Bailey:
1111:Robert Adams:1115:Graham Gooch:
1111:Robert Adams:1116:John Miller:
1111:Robert Adams:1117:Hugh Howell:
1112:Charles Bailey:1113:John Smith:
1112:Charles Bailey:1112:Charles Bailey:
1112:Charles Bailey:1115:Graham Gooch:
1112:Charles Bailey:1116:John Miller:
1112:Charles Bailey:1117:Hugh Howell:
1114:Richard Johnson:1113:John Smith:
1114:Richard Johnson:1112:Charles Bailey:
1114:Richard Johnson:1115:Graham Gooch:
1114:Richard Johnson:1116:John Miller:
1114:Richard Johnson:1117:Hugh Howell:
1115:Graham Gooch:1113:John Smith:
1115:Graham Gooch:1112:Charles Bailey:
1115:Graham Gooch:1115:Graham Gooch:
1115:Graham Gooch:1116:John Miller:
1115:Graham Gooch:1117:Hugh Howell:
1116:John Miller:1113:John Smith:
1116:John Miller:1112:Charles Bailey:
1116:John Miller:1115:Graham Gooch:
1116:John Miller:1116:John Miller:
1116:John Miller:1117:Hugh Howell:
*/