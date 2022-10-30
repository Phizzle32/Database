import java.io.*;
import java.util.*;

public class Relation {
  // Name of the relation.
  private String name;

  // Attribute names for the relation
  private ArrayList<String> attributes;

  // Domain classes or types of attributes; possible values: INTEGER, DECIMAL, VARCHAR
  private ArrayList<String> domains;

  // Actual data storage (list of tuples) for the relation.
  private ArrayList<Tuple> table= new ArrayList<Tuple>();

  // METHODS

  // Constructor; set instance variables
  public Relation (String name, ArrayList<String> attributes, ArrayList<String> dNames) {
	  this.name = name;
	  this.attributes = attributes;
	  domains = dNames;
  }

  // returns true if attribute with name aname exists in relation schema
  // false otherwise
  public boolean attributeExists(String aname) {
	  if(attributes.contains(aname)){
		  return true;
	  }
	  else {
		  return false;
	  }
  }

  // returns domain type of attribute aname; return null if not present
  public String attributeType(String aname) {
	  if(attributeExists(aname)) {
		  int x = attributes.indexOf(aname);
		  return domains.get(x);
	  }
	  else {
		  return null;
	  }
	  
  }

  // Print relational schema to screen.
  public void displaySchema() {
	  System.out.println();
  }

  // Set name of relation to rname
  public void setName(String rname) {
	  name = rname;
  }
  
  //returns name
  public String getName() {
	  return name;
  }
  
  //returns attributes
  public ArrayList<String> getAttributes(){
	  return attributes;
  }
  
  //returns domains
  public ArrayList<String> getDomains(){
	  return domains;
  }

  // Add tuple tup to relation; Duplicates are fine.
  public void addTuple(Tuple tup) {
	  table.add(tup);
  }
  
  //Remove duplicate tuples from this relation
  public void removeDuplicates() {
	  for(int i=0; i<table.size();i++) {
		  for(int x=i+1; x<table.size();x++) {
			  if(table.get(i).equals(table.get(x))) {
				  table.remove(x);
				  x--;
			  }
		  }
	  }
  }
  
  //returns true if tuple t is present in relation and false otherwise.
  private boolean member(Tuple t) {
	  if(table.contains(t)) {
		  return true;
	  }
	  else {
		  return false;
	  }
  }
  
  //returns the union of two relations
  public Relation union(Relation r2) {
	  Relation r = new Relation(null, this.attributes, this.domains);
	  for(int i=0; i<this.table.size(); i++) {
		  Tuple clone = this.table.get(i).clone(this.attributes);
		  r.addTuple(clone);
	  }
	  for(int i=0; i<r2.table.size(); i++) {
		  Tuple clone = r2.table.get(i).clone(r2.attributes);
		  r.addTuple(clone);
	  }
	  r.removeDuplicates();
	  return r;
  }
  
  //returns the intersection of two relations
  public Relation intersect(Relation r2) {
	  Relation r = new Relation(null, this.attributes, this.domains);
	  for(int i=0; i<this.table.size(); i++) {
		  for(int j=0; j<r2.table.size(); j++) {
			  if(this.table.get(i).equals(r2.table.get(j))) {
				  Tuple clone = this.table.get(i).clone(this.attributes);
				  r.addTuple(clone);
			  }
		  }
	  }
	  return r;
  }
  
  //returns the difference of two relations
  public Relation minus(Relation r2) {
	  Relation r = new Relation(null, this.attributes, this.domains);
	  for(int i=0; i<this.table.size(); i++) {
		  boolean add = true;
		  for(int j=0; j<r2.table.size(); j++) {
			  if(this.table.get(i).equals(r2.table.get(j))) {
				  add= false;
			  }
		  }
		  if(add) {
			  Tuple clone = this.table.get(i).clone(this.attributes);
			  r.addTuple(clone);
		  }
	  }
	  return r;
  }
  
  //rename the columns
  public Relation rename(ArrayList<String> cnames) {
	  ArrayList<String> attr = new ArrayList<String>();
	  ArrayList<String> dom = new ArrayList<String>();
	  //add attributes
	  for(int i=0; i<cnames.size(); i++) {
		  attr.add(cnames.get(i));
	  }
	  //add domains
	  for(int j=0; j<this.domains.size(); j++) {
		  dom.add(this.domains.get(j));
	  }
	  Relation rels = new Relation(null, attr, dom);
	  //adding tuples
	  for(int k=0; k<this.table.size(); k++) {
		  Tuple clone = this.table.get(k).clone(attr);
		  rels.addTuple(clone);
	  }
	  return rels;
  }
  
  //returns the cartesian product of two relations
  public Relation times(Relation r2) {
	  ArrayList<String> attr = new ArrayList<String>();
	  ArrayList<String> dom = new ArrayList<String>();
	  
	  //this relation
	  for(int i=0; i<this.attributes.size(); i++) {
		  if(r2.attributeExists(this.attributes.get(i))) {
			  String dup = this.name + "." + this.attributes.get(i);
			  attr.add(dup);
		  }
		  else {
			  attr.add(this.attributes.get(i));
		  }
		  dom.add(this.domains.get(i));
	  }
	  //r2 relation
	  for(int j=0; j<r2.attributes.size(); j++) {
		  if(this.attributeExists(r2.attributes.get(j))) {
			  String dup = r2.name + "." + r2.attributes.get(j);
			  attr.add(dup);
		  }
		  else {
			  attr.add(r2.attributes.get(j));
		  }
		  dom.add(r2.domains.get(j));
	  }  
	  Relation rel = new Relation(null, attr, dom);
	  
	  //adding tuples
	  for(int i=0; i<this.table.size(); i++) {
		  Tuple t1 = this.table.get(i);
		  for(int j=0; j<r2.table.size(); j++) {
			  Tuple t2 = r2.table.get(j);
			  Tuple t3 = t1.concatenate(t2, attr, dom);
			  rel.addTuple(t3);
		  }
	  }
	  return rel;
  }
  
  //returns a relation whose tuples are formed by projecting the columns from cnames
  public Relation project(ArrayList<String> cnames) {
	  //creating domain based on cnames
	  ArrayList<String> doms = new ArrayList<String>();
	  ArrayList<String> attr = new ArrayList<String>();
	  for(int i=0; i<cnames.size(); i++) {
		  int index = this.attributes.indexOf(cnames.get(i));
		  doms.add(this.domains.get(index));
	  }
	  for(String s: cnames) {
		  attr.add(s);
	  }
	  Relation rel = new Relation(null, attr, doms);
	  for(int i=0; i<this.table.size(); i++) {
		  Tuple tup = this.table.get(i).project(cnames);
		  rel.addTuple(tup);
	  }
	  rel.removeDuplicates();
	  return rel;
  }
  
  //returns a new relation that contains only those tuples that satisfies the comparison condition.
  public Relation select(String lopType, String lopValue, String comparison,
          String ropType, String ropValue) {
	  Relation rel = new Relation(null, this.attributes, this.domains);
	  for(int i=0; i<table.size();i++) {
		  if(table.get(i).select(lopType, lopValue, comparison, ropType, ropValue)) {
			  rel.addTuple(table.get(i));
		  }
	  }
	  return rel;
  }
  
  //combines two relations into one based on common columns
  public Relation join(Relation r2) {
	ArrayList<String> attr = new ArrayList<String>();
	ArrayList<String> dom = new ArrayList<String>();
	//this attributes
	for(String s: this.attributes) {
		attr.add(s);
	}
	//this domains
	for(String s: this.domains) {
		dom.add(s);
	}
	//r2 attributes and domains
	for(int i=0; i<r2.attributes.size();i++) {
		if(!(attr.contains(r2.attributes.get(i)))) {
			attr.add(r2.attributes.get(i));
			dom.add(r2.domains.get(i));
		}
	}
	Relation rel = new Relation(null,attr,dom);
	for(int i=0; i<this.table.size(); i++) {
		Tuple t1 = this.table.get(i).clone(this.attributes);
		for(int j=0; j<r2.table.size(); j++) {
			Tuple t2 = r2.table.get(j).clone(r2.attributes);
			Tuple result = t1.join(t2, attr, dom);
			if(result!=null) {
				rel.addTuple(result);
			}
		}
	}
	return rel;
  }

  // Print relation to screen (see output of run for formatting)
  public void displayRelation() {
	  String s="(";
	  for(int i=0; i<domains.size();i++) {
		  s += attributes.get(i) + ":"+ domains.get(i);
		  if(i<domains.size()-1) {
			  s+=",";
		  }
	  }
	  s+=")";
	  System.out.println(name+s);
	  System.out.println("Number of tuples: " + table.size() + "\n");
	  for(int i=0; i<table.size();i++) {
		  System.out.println(table.get(i));
	  }
	  System.out.println();
  }

  // Return String version of relation; See output of run for format.
  public String toString() {
	  String s=name+"(";
	  for(int i=0; i<domains.size();i++) {
		  s += attributes.get(i) + ":"+ domains.get(i);
		  if(i<domains.size()-1) {
			  s+=",";
		  }
	  }
	  s+=")" + "\n" + "Number of tuples: " + table.size() + "\n" + "\n";
	  for(int i=0; i<table.size();i++) {
		  s+=table.get(i)+"\n";
	  }
	  s+="\n";
	  return s;
  }

}