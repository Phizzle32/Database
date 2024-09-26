import java.io.*;
import java.util.*;

public class Database {

  private Map<String,Relation> relations;

  // METHODS

  // Constructor; creates the empty HashMap object
  public Database() {
	  relations = new HashMap<String, Relation>();
  }

  // Add relation r with name rname to HashMap
  // if relation does not already exists.
  // Make sure to set the name within r to rname.
  // return true on successful add; false otherwise
  public boolean addRelation(String rname, Relation r) {
	  if(!relations.containsValue(r)){
		 relations.put(rname,r);
		 return true; 
	  }
	  return false;
  }

  // Delete relation with name rname from HashMap
  // if relation exists. return true on successful delete; false otherwise
  public boolean deleteRelation(String rname) {
	  if(relations.containsKey(rname)){
		  relations.remove(rname);
		  return true;
	  }
	  return false;
  }

  // Return true if relation with name rname exists in HashMap
  // false otherwise
  public boolean relationExists(String rname) {
	  return relations.containsKey(rname);
  }

  // Retrieve and return relation with name rname from HashMap;
  // return null if it does not exist.
  public Relation getRelation (String rname) {
	  if(relations.containsKey(rname)){
			 return relations.get(rname); 
	  }
	  return null;
  }

  // Print database schema to screen.
  public void displaySchema() {
	  Iterator<String> iterator=relations.keySet().iterator();
	  while(iterator.hasNext()) {
		  String key = iterator.next(); 
		  System.out.print(key);
		  System.out.println(relations.get(key));
	  }
	  System.out.println();
  }
  
  //Create the database object by reading data from several files in directory dir
  public void initializeDatabase(String dir) {
	  FileInputStream fin1 = null;
	  BufferedReader infile1 = null;
	  try {
	    fin1 = new FileInputStream(dir+"/catalog.dat");
	    infile1 = new BufferedReader(new InputStreamReader(fin1));
	    //read how many relations
	    int numRelations = Integer.parseInt(infile1.readLine());
	    //for each relation
	    for (int i=0; i<numRelations; i++) {
		    ArrayList<String> attr = new ArrayList<String>();
			ArrayList<String> dom = new ArrayList<String>();
			String s = infile1.readLine();
			//for every attribute
			int attrNum = Integer.parseInt(infile1.readLine());
			for(int x=0;x<attrNum;x++) {
				String attribute = infile1.readLine();
				String domain = infile1.readLine();
				attr.add(attribute);
				dom.add(domain);
			}
			Relation r = new Relation(s,attr,dom);
			FileInputStream fin2 = new FileInputStream(dir+"/"+s+".dat");
			BufferedReader infile2 = new BufferedReader(new InputStreamReader(fin2));
			int tups = Integer.parseInt(infile2.readLine());
			for(int x=0;x<tups;x++) {
				Tuple t = new Tuple(attr,dom);
				for(int n=0;n<attr.size();n++) {
					//add integer component
					if(dom.get(n).equalsIgnoreCase("Integer")) {
						Integer in = Integer.parseInt(infile2.readLine());
						t.addIntegerComponent(in);
					}
					//add double component
					else if(dom.get(n).equalsIgnoreCase("Decimal")) {
						Double dub = Double.parseDouble(infile2.readLine());
						t.addDoubleComponent(dub);
					}
					//add string component
					else {
						t.addStringComponent(infile2.readLine());
					}
				}
				r.addTuple(t);
			}
			fin2.close();
			this.addRelation(s,r);
	    }
	    fin1.close();
	  } 
	  catch (IOException e) {
		  System.out.println("Error reading file");
	  }
  }

}