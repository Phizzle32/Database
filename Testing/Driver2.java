import java.util.*;

public class Driver2 {
  public static void main(String args[]) {
    
	Database db = new Database();
    db.initializeDatabase(args[0]);
    db.displaySchema();
    Relation r1 = db.getRelation("BAR");
    r1.displayRelation();
    Relation r2 = db.getRelation("DRINKER");
    r2.displayRelation();;
    Relation r3 = db.getRelation("SELLS");
    r3.displayRelation();
    
    
  }
}
/*
Database Schema
-------- ------

SERVES(BNAME:VARCHAR,RNAME:VARCHAR)
BAR(BNAME:VARCHAR)
SELLS(BAR:VARCHAR,BEER:VARCHAR,PRICE:INTEGER)
DRINKER(DNAME:VARCHAR)
LIKES(DNAME:VARCHAR,RNAME:VARCHAR)
FREQUENTS(DNAME:VARCHAR,BNAME:VARCHAR)
BARS(NAME:VARCHAR,ADDR:VARCHAR)
BEER(RNAME:VARCHAR,PRICE:INTEGER)

BAR(BNAME:VARCHAR)
Number of tuples: 4

Jillians:
Dugans:
ESPN Zone:
Charlies:

DRINKER(DNAME:VARCHAR)
Number of tuples: 5

John:
Peter:
Donald:
Jeremy:
Clark:

SELLS(BAR:VARCHAR,BEER:VARCHAR,PRICE:INTEGER)
Number of tuples: 9

Jillians:Bud:6:
Jillians:Michelob:6:
Jillians:Heineken:8:
Dugans:Bud:9:
Dugans:Michelob:10:
Dugans:Fosters:12:
ESPN Zone:Fosters:9:
Charlies:Heineken:10:
Charlies:Foster:10:
 */