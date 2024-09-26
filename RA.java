import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RA {
  public static void main(String[] args) throws Exception {
    Database db = new Database();
    db.initializeDatabase(args[0]);
    AtomicInteger globalInt = new AtomicInteger(1);
    System.out.print("RA> ");
    do {
      String input = readInput().trim();
      if (input.equals("exit;")) 
        break;
      if (input.equals("schema;")) {
        db.displaySchema();
        continue;
      }
      try {
        CharStream in = CharStreams.fromString(input);
        RALexer lexer = new RALexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RAParser parser = new RAParser(tokens);
        RANode tree = parser.query().value;
        tree.setRelationNames(globalInt);
        //tree.printTree();
        String result = tree.semanticCheckAndSetSchemaAndDataTypes(db);
        if (result.equals("OK")) {
          //tree.printTree();
          Relation answer = tree.evaluate(db);
          answer.setName("ANSWER");
          System.out.println("\n"+answer);
        }
        else
          System.out.println(result);
      } catch (Exception e) {
          System.out.println("\nSYNTAX ERROR\n");
          e.printStackTrace();
        }
    } while (true);
  }

  static String readInput() {
     try {
       StringBuffer buffer = new StringBuffer();
       System.out.flush();
       int c = System.in.read();
       while(c != ';' && c != -1) {
         if (c != '\n') 
           buffer.append((char)c);
         else {
           buffer.append(" ");
           System.out.print("RA> ");
           System.out.flush();
         }
         c = System.in.read();
       }
       buffer.append(";");
       return buffer.toString().trim();
     } catch (IOException e) {
         return "";
       }
   }
}