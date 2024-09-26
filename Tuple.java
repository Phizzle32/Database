import java.util.*;

public class Tuple {

  private ArrayList<String> attributes;
  private ArrayList<String> domains;
  private ArrayList<Comparable> tuple = new ArrayList<Comparable>();

  // METHODS
  
  // Constructor; set instance variables
  public Tuple (ArrayList<String> attr, ArrayList<String> dom) {
	  attributes=attr;
	  domains=dom;
  }

  // Add String s at the end of the tuple
  public void addStringComponent(String s) {
	  tuple.add(s);
  }

  // Add Double d at the end of the tuple
  public void addDoubleComponent(Double d) {
	  tuple.add(d);
  }

  // Add Integer i at the end of the tuple
  public void addIntegerComponent(Integer i) {
	  tuple.add(i);
  }
  
  //Return true if this tuple is equal to compareTuple; false otherwise
  public boolean equals(Tuple compareTuple) {
	  return compareTuple.toString().equals(this.toString());
  }
  
  //Clone tuple object
  public Tuple clone(ArrayList<String> attr) {
	  //Checking if the attributes and domain sizes are the same
	  if(attr.size()==this.domains.size()) {
		  //Creating new domain ArrayList
		  ArrayList<String> d = new ArrayList<String>();
		  for(int x=0; x<this.domains.size(); x++) {
			  d.add(this.domains.get(x));
		  }
		  //Creating new tuple
		  Tuple clone = new Tuple(attr, d);
		  for(int i=0; i<this.tuple.size(); i++) {
			  //add integer
			  if(d.get(i).equalsIgnoreCase("Integer")) {
				  Integer in = (Integer) this.tuple.get(i);
				  clone.addIntegerComponent(in);
			  }
			  //add double
			  else if(d.get(i).equalsIgnoreCase("Decimal")){
				  Double dub = (Double) this.tuple.get(i);
				  clone.addDoubleComponent(dub);
			  }
			  //add string
			  else {
				  String str = new String((String) this.tuple.get(i));
				  clone.addStringComponent(str);
			  }
		  }
		  return clone;
	  }
	  //returns null if sizes of attributes and domains are not equal
	  else {
		  return null;
	  }
  }

//combines two tuples into one and assigns a new schema
  public Tuple concatenate(Tuple t, ArrayList<String> attrs, ArrayList<String> doms) {
	  Tuple tup = new Tuple(attrs,doms);
	  //this tuple
	  for(int i=0; i<this.tuple.size(); i++) {
		  //add integer
		  if(this.domains.get(i).equalsIgnoreCase("Integer")) {
			  Integer in = (Integer) this.tuple.get(i);
			  tup.addIntegerComponent(in);
			  
		  }
		  //add double
		  else if(this.domains.get(i).equalsIgnoreCase("Decimal")){
			  Double dub = (Double) this.tuple.get(i);
			  tup.addDoubleComponent(dub);
		  }
		  //add string
		  else {
			  String str = new String((String) this.tuple.get(i));
			  tup.addStringComponent(str);
		  }
	  }
	  //tuple t
	  for(int j=0; j<t.tuple.size(); j++) {
		//add integer
		  if(t.domains.get(j).equalsIgnoreCase("Integer")) {
			  Integer in = (Integer) t.tuple.get(j);
			  tup.addIntegerComponent(in);
			  
		  }
		  //add double
		  else if(t.domains.get(j).equalsIgnoreCase("Decimal")){
			  Double dub = (Double) t.tuple.get(j);
			  tup.addDoubleComponent(dub);
		  }
		  //add string
		  else {
			  String str = new String((String) t.tuple.get(j));
			  tup.addStringComponent(str);
		  }
	  }
	  return tup;
  }
  
  //returns a new tuple with only those components that correspond to the column names in cnames
  public Tuple project(ArrayList<String> cnames) {
	  //creating domain based on cnames
	  ArrayList<String> doms = new ArrayList<String>();
	  for(int i=0; i<cnames.size(); i++) {
		  int index = this.attributes.indexOf(cnames.get(i));
		  doms.add(this.domains.get(index));
	  }
	  //adding components of tuple based on if they are in cnames column
	  Tuple tup = new Tuple(cnames, doms);
	  for(int j=0; j<cnames.size(); j++) {
		  int index = this.attributes.indexOf(cnames.get(j));
		  if(tup.domains.get(j).equalsIgnoreCase("Decimal")) {
			  Double dub = (Double)this.tuple.get(index);
			  tup.addDoubleComponent(dub);
		  }
		  else if(tup.domains.get(j).equalsIgnoreCase("Integer")) {
			  Integer in = (Integer) this.tuple.get(index);
			  tup.addIntegerComponent(in);
		  }
		  else {
			  String str = new String((String) this.tuple.get(index));
			  tup.addStringComponent(str);
		  }
	  }
	  return tup;
  }
  
  //takes a comparison condition in the 5 parameters returns true if the tuple satisfies the condition
  public boolean select(String lopType, String lopValue, String comparison,
          String ropType, String ropValue) {
	  Boolean bool = false;
	  //num and num
	  if(lopType.equals("num")&&ropType.equals("num")) {
		  double d1 = Double.parseDouble(lopValue);
		  double d2 = Double.parseDouble(ropValue);
		  if(comparison.equals("=")) {
			  bool = d1==d2;
		  }
		  else if(comparison.equals(">=")) {
			  bool = d1>=d2;
		  }
		  else if(comparison.equals("<=")) {
			  bool = d1<=d2;
		  }
		  else if(comparison.equals(">")) {
			  bool = d1>d2;
		  }
		  else if(comparison.equals("<")) {
			  bool = d1<d2;
		  }
		  else if(comparison.equals("<>")) {
			  bool = d1!=d2;
		  }
	  }
	  //str and str
	  else if(lopType.equals("str")&&ropType.equals("str")) {
		  int com = lopValue.compareTo(ropValue);
		  if(comparison.equals("=")) {
			  bool = com==0;
		  }
		  else if(comparison.equals(">=")) {
			  bool = com>=0;
		  }
		  else if(comparison.equals("<=")) {
			  bool = com<=0;
		  }
		  else if(comparison.equals(">")) {
			  bool = com<0;
		  }
		  else if(comparison.equals("<")) {
			  bool = com>0;
		  }
		  else if(comparison.equals("<>")) {
			  bool = lopValue!=ropValue;
		  }
	  }
	  //col and num
	  else if(lopType.equals("col")&&ropType.equals("num")) {
		  int index = this.attributes.indexOf(lopValue);
		  String dom = this.domains.get(index);
		  double i;
		  double i2;
		  if(dom.equalsIgnoreCase("integer")) {
			  i = (Integer) this.tuple.get(index);
			  i2 = Integer.parseInt(ropValue);
		  }
		  else {
			  i = (Double) this.tuple.get(index);
			  i2 = Double.parseDouble(ropValue);
		  }
		  //compare
		  if(comparison.equals("=")) {
			  bool = i==i2;
		  }
		  else if(comparison.equals(">=")) {
			  bool = i>=i2;
		  }
		  else if(comparison.equals("<=")) {
			  bool = i<=i2;
		  }
		  else if(comparison.equals(">")) {
			  bool = i<i2;
		  }
		  else if(comparison.equals("<")) {
			  bool = i>i2;
		  }
		  else if(comparison.equals("<>")) {
			  bool = i!=i2;
		  }
	  }
	  //col and str
	  else if(lopType.equals("col")&&ropType.equals("str")) {
		  int index = this.attributes.indexOf(lopValue);
		  String str = new String((String) this.tuple.get(index));
		  int com = str.compareTo(ropValue);
		  if(comparison.equals("=")) {
			  bool = com==0;
		  }
		  else if(comparison.equals(">=")) {
			  bool = com>=0;
		  }
		  else if(comparison.equals("<=")) {
			  bool = com<=0;
		  }
		  else if(comparison.equals(">")) {
			  bool = com<0;
		  }
		  else if(comparison.equals("<")) {
			  bool = com>0;
		  }
		  else if(comparison.equals("<>")) {
			  bool = com!=0;
		  }
	  }
	  //nums and col
	  else if(lopType.equals("num")&&ropType.equals("col")) {
		  int index = this.attributes.indexOf(lopValue);
		  String dom = this.domains.get(index);
		  double i;
		  double i2;
		  //retrieve values
		  if(dom.equalsIgnoreCase("integer")) {
			  i = (Integer) this.tuple.get(index);
			  i2 = Integer.parseInt(ropValue);
		  }
		  else {
			  i = (Double) this.tuple.get(index);
			  i2 = Double.parseDouble(ropValue);
		  }
		  //compare
		  if(comparison.equals("=")) {
			  bool = i2==i;
		  }
		  else if(comparison.equals(">=")) {
			  bool = i2>=i;
		  }
		  else if(comparison.equals("<=")) {
			  bool = i2<=i;
		  }
		  else if(comparison.equals(">")) {
			  bool = i2<i;
		  }
		  else if(comparison.equals("<")) {
			  bool = i2>i;
		  }
		  else if(comparison.equals("<>")) {
			  bool = i2!=i;
		  }
	  }
	  //str and col
	  else if(lopType.equals("str")&&ropType.equals("col")) {
		  int index = this.attributes.indexOf(lopValue);
		  String str = new String((String) this.tuple.get(index));
		  int com = ropValue.compareTo(str);
		  if(comparison.equals("=")) {
			  bool = com==0;
		  }
		  else if(comparison.equals(">=")) {
			  bool = com>=0;
		  }
		  else if(comparison.equals("<=")) {
			  bool = com<=0;
		  }
		  else if(comparison.equals(">")) {
			  bool = com<0;
		  }
		  else if(comparison.equals("<")) {
			  bool = com>0;
		  }
		  else if(comparison.equals("<>")) {
			  bool = com!=0;
		  }
	  }
	  //col and col
	  else if(lopType.equals("col")&&ropType.equals("col")) {
		  int index = this.attributes.indexOf(lopValue);
		  String dom = this.domains.get(index);
		  int index2 = this.attributes.indexOf(ropValue);
		  if(dom.equalsIgnoreCase("Decimal")) {
			  Double i = (Double) this.tuple.get(index);
			  Double i2 = i = (Double) this.tuple.get(index2);
			  if(comparison.equals("=")) {
				  bool = i==i2;
			  }
			  else if(comparison.equals(">=")) {
				  bool = i>=i2;
			  }
			  else if(comparison.equals("<=")) {
				  bool = i<=i2;
			  }
			  else if(comparison.equals(">")) {
				  bool = i<i2;
			  }
			  else if(comparison.equals("<")) {
				  bool = i>i2;
			  }
			  else if(comparison.equals("<>")) {
				  bool = i!=i2;
			  }
		  }
		  else if(dom.equalsIgnoreCase("Integer")) {
			  Integer i = (Integer) this.tuple.get(index);
			  Integer i2 = (Integer) this.tuple.get(index2);
			  if(comparison.equals("=")) {
				  bool = i==i2;
			  }
			  else if(comparison.equals(">=")) {
				  bool = i>=i2;
			  }
			  else if(comparison.equals("<=")) {
				  bool = i<=i2;
			  }
			  else if(comparison.equals(">")) {
				  bool = i<i2;
			  }
			  else if(comparison.equals("<")) {
				  bool = i>i2;
			  }
			  else if(comparison.equals("<>")) {
				  bool = i!=i2;
			  }
		  }
		  else {
			  String i = new String((String) this.tuple.get(index));
			  String i2 = new String((String) this.tuple.get(index2));
			  int com = i.compareTo(i2);
			  if(comparison.equals("=")) {
				  bool = com==0;
			  }
			  else if(comparison.equals(">=")) {
				  bool = com>=0;
			  }
			  else if(comparison.equals("<=")) {
				  bool = com<=0;
			  }
			  else if(comparison.equals(">")) {
				  bool = com<0;
			  }
			  else if(comparison.equals("<")) {
				  bool = com>0;
			  }
			  else if(comparison.equals("<>")) {
				  bool = com!=0;
			  }
		  }
	  }
	  return bool;
  }
  
  //join two tuples if they can be joined. Return null otherwise
  public Tuple join(Tuple t2, ArrayList<String> attr, ArrayList<String> dom) {
	  ArrayList<String> leftJoinColumns = new ArrayList<String>();
	  ArrayList<String> leftJoinDomains = new ArrayList<String>();
	  ArrayList<String> rightJoinColumns = new ArrayList<String>();
	  ArrayList<String> rightJoinDomains = new ArrayList<String>();
	  ArrayList<Integer> sameValues = new ArrayList<Integer>();
	  //check to make sure t2 is not null
	  if(t2==null)
		  return null;
	  //leftJoinColumns
	  for(String s: this.attributes) {
		  leftJoinColumns.add(s);
	  }
	  //leftJoinDomains
	  for(String s: this.domains) {
		  leftJoinDomains.add(s);
	  }
	  //rightJoinColumns
	  for(String s: t2.attributes) {
		  rightJoinColumns.add(s);
	  }
	  //rightJoinDomains
	  for(String s: t2.domains) {
		  rightJoinDomains.add(s);
	  }
	  //checking for the same columns + values
	  int nCommon=0;
	  for(int i=0; i<leftJoinColumns.size(); i++) {
		  for(int j=0; j<rightJoinColumns.size(); j++) {
			  if(leftJoinColumns.get(i).equals(rightJoinColumns.get(j))) {
				  nCommon++;
				  if(this.tuple.get(i).equals(t2.tuple.get(j))) {
					  sameValues.add(j);
				  }
			  }
		  }
	  }
	  //creating new array with no duplicates
	  ArrayList<String> a = new ArrayList<String>();
	  ArrayList<String> d = new ArrayList<String>();
	  for(String s: this.attributes) {
		  a.add(s);
	  }
	  for(String s: this.domains) {
		  d.add(s);
	  }
	  for(int i=0; i<t2.attributes.size(); i++) {
		  if(!(sameValues.contains(i))) {
			  a.add(t2.attributes.get(i));
			  d.add(t2.domains.get(i));
		  }
	  }
	  //creating the tuple
	  if(sameValues.size()==nCommon){
		  Tuple t = new Tuple(a,d);
		  //first tuple
		  for(int i=0; i<this.attributes.size();i++) {
			  if(this.domains.get(i).equalsIgnoreCase("Integer")) {
				  Integer in = (Integer) this.tuple.get(i);
				  t.addIntegerComponent(in);
			  }
			  else if(this.domains.get(i).equalsIgnoreCase("Decimal")) {
				  Double dub = (Double) this.tuple.get(i);
				  t.addDoubleComponent(dub);
			  }
			  else {
				  String str = new String((String) this.tuple.get(i));
				  t.addStringComponent(str);
			  }
		  }
		  //second tuple
		  for(int i=0;i<t2.attributes.size(); i++) {
			  if(!(sameValues.contains(i))) {
				  if(t2.domains.get(i).equalsIgnoreCase("Integer")) {
					  Integer in = (Integer) t2.tuple.get(i);
					  t.addIntegerComponent(in);
				  }
				  else if(t2.domains.get(i).equalsIgnoreCase("Decimal")) {
					  Double dub = (Double) t2.tuple.get(i);
					  t.addDoubleComponent(dub);
				  }
				  else {
					  String str = new String((String) t2.tuple.get(i));
					  t.addStringComponent(str);
				  }
			  }
		  }
		  return t;
	  }
	  else {
		  return null;
	  }
  }

  // return String representation of tuple; See output of run for format.
  public String toString() {
	  String output="";
	  for(Comparable<String> i: tuple) {
		  output+=i+":";
	  }
	  return output;
  }
}