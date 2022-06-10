import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputTextToOutputFile {
  
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
  
while(true)
{
System.out.println("What is the name of your output file?");
String fileName = sc.nextLine().trim();
String prompt;
  
do
{
prompt = sc.nextLine().trim();
if(prompt.equals("STOP"))
{
writeData(fileName, prompt);
System.exit(0);
}
  
writeData(fileName, prompt);
}while(!prompt.equals("STOP"));
}
}
  
private static void writeData(String filename, String s)
{
FileWriter fw;
PrintWriter pw;
try {
fw = new FileWriter(new File(filename), true); 
pw = new PrintWriter(fw);
  
fw.write(s + System.lineSeparator());
  
pw.flush();
fw.close();
pw.close();
} catch (IOException ex) {
System.out.println("Error in writing to file " + filename);
System.exit(0);
}
}
}