import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReadAndPrintFile {

   public static void main(String[] args) throws Exception{
       Scanner sc = new Scanner(System.in);
       BufferedReader br =null;
       String fileName ="";
       while(true) {
           try{
               System.out.println("What is the name of your file?");
               fileName= sc.nextLine();
               br= new BufferedReader(new FileReader(new File(fileName)));
               break;
           }catch(Exception ee) {
               System.out.println("File Not Found "+fileName);
           }
       }
       String line = br.readLine();
       while (line != null) {
           System.out.println(line);
           line=br.readLine();
       }
   }
}