import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RANode{
  public RANode lchild;
  public RANode rchild;  // will be null for unary operators: select, project, rename
  public String rnodetype; // select, project, rename, etc
  public String relationName; // used to name interior nodes with tempN; relation name at leaf
  public ArrayList<String> attributes; // used with project and rename
  public ArrayList<Condition> conditions; // used with select 
  public ArrayList<String> joinColumns; // used to remember JOIN columns
  public ArrayList<String> schemaColumns;
  public ArrayList<String> schemaDataTypes;

  public RANode() {
    lchild = null;
    rchild = null;
    rnodetype = "";
    relationName = "";
    attributes = new ArrayList<String>();
    conditions = new ArrayList<Condition>();
    schemaColumns = new ArrayList<String>();
    schemaDataTypes = new ArrayList<String>();
    joinColumns = new ArrayList<String>();
  }

  public ArrayList<String> getAttributes() {
    return attributes;
  }

  public ArrayList<String> getJoinColumns() {
    return joinColumns;
  }

  public RANode getLchild() {
    return lchild;
  }

  public RANode getRchild() {
    return rchild;
  }

  public String getRelationName() {
    return relationName;
  }

  public String getRnodetype() {
    return rnodetype;
  }

  public ArrayList<Condition> getConditions() {
    return conditions;
  }

  public ArrayList<String> getSchema() {
    return schemaColumns;
  }

  public ArrayList<String> getDataTypes() {
    return schemaDataTypes;
  }

  public void setAttributes(ArrayList<String> vector) {
    attributes = vector;
  }

  public void setLchild(RANode node) {
    lchild = node;
  }

  public void setRchild(RANode node) {
    rchild = node;
  }

  public void setRelationName(String string) {
    relationName = string;
  }

  public void setRnodetype(String string) {
    rnodetype = string;
  }

  public void setConditions(ArrayList<Condition> c) {
    conditions = c;
  }

  public void setSchema(ArrayList<String> a) {
    schemaColumns = a;
  }

  public void setDataTypes(ArrayList<String> a) {
    schemaDataTypes = a;
  }

  public void setJoinColumns(ArrayList<String> a) {
    joinColumns = a;
  }

  public int sizeOfTree() {
    if ((lchild==null) && (rchild==null))
      return 1;
    else if (rchild==null)
      return (1+lchild.sizeOfTree());
    else
      return (1+lchild.sizeOfTree()+rchild.sizeOfTree());
  }

  public void printTree() {
    if ((lchild == null) && (rchild == null)) {
      System.out.println("NODE TYPE: " + rnodetype + "  ");
      System.out.println("Relation Name is : " + relationName);
      System.out.println("Schema is : " + schemaColumns);
      System.out.println("Datatypes is : " + schemaDataTypes+"\n");
    }
    else if (rchild == null) { // project or rename or select
      if (rnodetype.equals("project") || rnodetype.equals("rename")) {
        System.out.println("NODE TYPE: " + rnodetype + "  ");
        System.out.println("Atributes are : "+attributes);
        System.out.println("Relation Name is : " + relationName);
        System.out.println("Schema is : " + schemaColumns);
        System.out.println("Datatypes is : " + schemaDataTypes+"\n");
        lchild.printTree();
      } else { // must be select: if (rnodetype.equals("select")) {
          System.out.println("NODE TYPE: " + rnodetype + "  ");
          for (int i=0; i<conditions.size(); i++) {
            System.out.print(conditions.get(i).getLeftOperand());
            System.out.print("--");
            System.out.print(conditions.get(i).getLeftDataType());
            System.out.print("--");
            System.out.print(conditions.get(i).getOperator());
            System.out.print("--");
            System.out.print(conditions.get(i).getRightOperand());
            System.out.print("--");
            System.out.println(conditions.get(i).getRightDataType());
          }
          System.out.println("Relation Name is : " + relationName);
          System.out.println("Schema is : " + schemaColumns);
          System.out.println("Datatypes is : " + schemaDataTypes+"\n");
          lchild.printTree();
      }
    } else {// union, minus, join, times, intersect
        if (rnodetype.equals("union") || rnodetype.equals("minus") || 
            rnodetype.equals("join")  || rnodetype.equals("intersect") || 
            rnodetype.equals("times")) {
          System.out.println("NODE TYPE: "+rnodetype+"  ");
          System.out.println("Relation Name is : " + relationName);
          System.out.println("Schema is : " + schemaColumns);
          System.out.println("Datatypes is : " + schemaDataTypes+"\n");
          lchild.printTree();
          rchild.printTree();
        }
      }
  }

  public String semanticCheckAndSetSchemaAndDataTypes(Database db) {
    // Task 1: check for semantic errors; if error return error message
    //         otherwise return "OK"
    // Task 2: set values for the following three variables:
    //           public ArrayList joinColumns; // used to remember JOIN columns
    //           public ArrayList<String> schemaColumns;
    //           public ArrayList<String> schemaDataTypes;
	  //relation
	  if(rnodetype.equals("relation")) {
		  if(db.relationExists(relationName)) {
			  Relation r = db.getRelation(relationName);
			  this.setSchema(r.getAttributes());
			  this.setDataTypes(r.getDomains());
			  return "OK"; 
		  }
		  else {
			  return "Relation not in database";
		  }
	  }
	  //union minus intersect
	  else if(rnodetype.equals("union") ||
	            rnodetype.equals("minus") ||
	            rnodetype.equals("intersect")){
		  //semantic checks for lchild and rchild
		  String result = lchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  result = rchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  //semantic check for attributes
		  if(lchild.schemaColumns.size() != rchild.schemaColumns.size()) 
			  return "The two relations have different number of attributes";
		  //semantic check for data types
		  ArrayList<String> ldata = lchild.getDataTypes();
		  ArrayList<String> rdata = rchild.getDataTypes();
		  for(int i=0; i<ldata.size(); i++) {
			  if(!(ldata.get(i).equals(rdata.get(i)))) {
				  return "The two relations have mismatched attribute datatypes";
			  }
		  }
		  //setting schema data columns
		  this.setSchema(lchild.getSchema());
		  //setting data types
		  this.setDataTypes(lchild.getDataTypes());
		  return "OK";
	  }
	  //times
	  else if(rnodetype.equals("times")){
		  //semantic checks for lchild and rchild
		  String result = lchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  result = rchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  ArrayList<String> ta = new ArrayList<String>();
		  ArrayList<String> td = new ArrayList<String>();
		  //adding lchild schema and data
		  for(int i=0; i<lchild.schemaColumns.size();i++) {
			  if(rchild.schemaColumns.contains(lchild.schemaColumns.get(i))) {
				  ta.add(lchild.relationName+"."+lchild.schemaColumns.get(i));
			  }
			  else {
				  ta.add(lchild.schemaColumns.get(i));
			  }
			  td.add(lchild.schemaDataTypes.get(i));
		  }
		  //adding rchild schema and data
		  for(int i=0; i<rchild.schemaColumns.size();i++) {
			  if(lchild.schemaColumns.contains(rchild.schemaColumns.get(i))) {
				  ta.add(rchild.relationName+"."+rchild.schemaColumns.get(i));
			  }
			  else {
				  ta.add(rchild.schemaColumns.get(i));
			  }
			  td.add(rchild.schemaDataTypes.get(i));
		  }
		  this.setSchema(ta);
		  this.setDataTypes(td);
		  return "OK";
	  }
	  //join
	  else if(rnodetype.equals("join")){
		  //semantic checks for lchild and rchild
		  String result = lchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  result = rchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  ArrayList<String> schem = new ArrayList<String>();
		  ArrayList<String> dat = new ArrayList<String>();
		  ArrayList<String> join = new ArrayList<String>();
		  //adding lchild schema columns and data types
		  for(String s: lchild.schemaColumns) {
			  schem.add(s);
		  }
		  for(String s: lchild.schemaDataTypes) {
			  dat.add(s);
		  }
		  //adding rchild schema columns and data types
		  for(int i=0; i<rchild.schemaColumns.size();i++) {
			  if(!schem.contains(rchild.schemaColumns.get(i))) {
				  schem.add(rchild.schemaColumns.get(i));
				  dat.add(rchild.schemaDataTypes.get(i));
			  }
		  }
		  //setting join columns
		  for(int i=0; i<lchild.schemaColumns.size();i++) {
			  for(int j=0; j<rchild.schemaColumns.size();j++) {
				  if(lchild.schemaColumns.get(i).equals(rchild.schemaColumns.get(j)))
					  join.add(lchild.schemaColumns.get(i));
			  }
		  }
		  this.setSchema(schem);
		  this.setDataTypes(dat);
		  this.setJoinColumns(join);
	      return "OK";
	  }
	  //rename
	  else if(rnodetype.equals("rename")){
		  //semantic checks for lchild
		  String result = lchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  //semantic check for attributes
		  if(this.attributes.size()!=lchild.schemaColumns.size())
			  return "Not a valid number of attributes";
		  ArrayList<String> rschem = new ArrayList<String>();
		  ArrayList<String> rdata = new ArrayList<String>();
		  //setting schema columns
		  for(String s: this.attributes) {
			  rschem.add(s);
		  }
		  //setting data types
		  for(String s: lchild.schemaDataTypes) {
			rdata.add(s);  
		  }
		  this.setSchema(rschem);
		  this.setDataTypes(rdata);
	      return "OK";
	  }
	  //project
	  else if(rnodetype.equals("project")){
		  //semantic checks for lchild
		  String result = lchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  //semantic check for attributes
		  for(int i=0; i<this.attributes.size(); i++) {
			 if(!lchild.schemaColumns.contains(this.attributes.get(i)))
				 return "Not a valid attribute";
		  }
		  //projecting
		  ArrayList<String> pschem = new ArrayList<String>();
		  ArrayList<String> pdata = new ArrayList<String>();
		  for(int i=0; i<this.attributes.size(); i++) {
			  int index = lchild.schemaColumns.indexOf(this.attributes.get(i));
			  pschem.add(lchild.schemaColumns.get(index));
			  pdata.add(lchild.schemaDataTypes.get(index));
		  }
		  this.setSchema(pschem);
		  this.setDataTypes(pdata);
	      return "OK";
	  }
	  //select
	  else if(rnodetype.equals("select")){
		  //semantic checks for lchild 
		  String result = lchild.semanticCheckAndSetSchemaAndDataTypes(db);
		  if(!result.equals("OK")) 
			  return result;
		  
		  //semantic check for left operand and right operand
		  for(int i=0; i<conditions.size(); i++) {
			  Condition c = conditions.get(i);
			  String ltype = c.getLeftDataType();
			  String rtype = c.getRightDataType();
			  //left operand check
			  if(ltype.equals("col")) {
				  String cname = c.getLeftOperand();
				  if(!lchild.schemaColumns.contains(cname)) {
					  return "Left Operand is not a valid operand";
				  }
				  int index = lchild.schemaColumns.indexOf(cname);
				  if(lchild.getDataTypes().get(index).equals("VARCHAR")) {
					  ltype="str";
				  }
				  else {
					  ltype="num";
				  }			  
			  }
			  //right operand check
			  if(rtype.equals("col")) {
				  String cname = c.getRightOperand();
				  if(!lchild.schemaColumns.contains(cname)) {
					  return "Right Operand is not a valid operand";
				  }
				  int index = lchild.schemaColumns.indexOf(cname);
				  if(lchild.getDataTypes().get(index).equals("VARCHAR")) {
					  rtype="str";
				  }
				  else {
					  rtype="num";
				  }
			  }

			  if(!ltype.equals(rtype)) {
				  return "Data types do not match in comparison";
			  }
			  
		  }
		  this.setSchema(lchild.schemaColumns);
		  this.setDataTypes(lchild.schemaDataTypes);
	      return "OK";
	  }
	  //invalid node type
	  else {
	      return "SOMETHING STRANGE TOOK PLACE!";
	  }
  }

  public void setRelationNames(AtomicInteger globalInt) {
	  // set unique relation names for every interior node in the tree
	  //   public String relationName; // used to name interior nodes with tempN; relation name at leaf
	  if (rnodetype.equals("union")|| rnodetype.equals("join") || rnodetype.equals("minus")
			  ||rnodetype.equals("intersect") || rnodetype.equals("times")) {
		  lchild.setRelationNames(globalInt);
		  rchild.setRelationNames(globalInt);
		  relationName="temp"+globalInt.get();
		  globalInt.set(globalInt.get()+1);
	  }
	  else if (rnodetype.equals("rename") || rnodetype.equals("project") || rnodetype.equals("select")) {
		  lchild.setRelationNames(globalInt);
		  relationName="temp"+globalInt.get();
		  globalInt.set(globalInt.get()+1);
	  }
	  else {
		  return;
	  }
  }

  public Relation evaluate(Database db) {
    // evaluate and return relation object for node
	  //relation
	  if(rnodetype.equals("relation")) {
		  Relation r = db.getRelation(relationName);
		  r.setName(relationName);
		  return r;
	  }
	  //union
	  else if(rnodetype.equals("union")) {
		  Relation r1 = lchild.evaluate(db);
		  Relation r2 = rchild.evaluate(db);
		  Relation r3 = r1.union(r2);
		  r3.setName(relationName);
		  return r3;
	  }
	  //intersect
	  else if(rnodetype.equals("intersect")) {
		  Relation r1 = lchild.evaluate(db);
		  Relation r2 = rchild.evaluate(db);
		  Relation r3 = r1.intersect(r2);
		  r3.setName(relationName);
		  return r3;
	  }
	  //minus
	  else if(rnodetype.equals("minus")) {
		  Relation r1 = lchild.evaluate(db);
		  Relation r2 = rchild.evaluate(db);
		  Relation r3 = r1.minus(r2);
		  r3.setName(relationName);
		  return r3;
	  }
	  //rename
	  else if(rnodetype.equals("rename")) {
		  Relation r1 = lchild.evaluate(db);
		  Relation r2 = r1.rename(attributes);
		  r2.setName(relationName);
		  return r2;
	  }
	  //project
	  else if(rnodetype.equals("project")) {
		  Relation r1 = lchild.evaluate(db);
		  Relation r2 = r1.project(attributes);
		  r2.setName(relationName);
		  return r2;
	  }
	  //select
	  else if(rnodetype.equals("select")) {
		  Relation r1 = lchild.evaluate(db);
		  for(int i=0; i<conditions.size(); i++) {
			  Condition c = conditions.get(i);
			  r1 = r1.select(c.getLeftDataType(), c.getLeftOperand(),
					  c.getOperator(), c.getRightDataType(), c.getRightOperand());  
		  }
		  r1.setName(relationName);
		  return r1;
	  }
	  //times
	  else if(rnodetype.equals("times")) {
		  Relation r1 = lchild.evaluate(db);
		  Relation r2 = rchild.evaluate(db);
		  Relation r3 = r1.times(r2);
		  r3.setName(relationName);
		  return r3;
	  }
	  //join
	  else if(rnodetype.equals("join")) {
		  Relation r1 = lchild.evaluate(db);
		  Relation r2 = rchild.evaluate(db);
		  Relation r3 = r1.join(r2);
		  r3.setName(relationName);
		  return r3;
	  }
	  else {
		  System.out.println("SOMETHING SERIOUSLY WENT WRONG!");
	  }
	
	  return null;
  }

}