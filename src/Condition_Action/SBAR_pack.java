package Condition_Action;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SBAR_pack {
public static void main(String args[]) {
//reading file line by line in Java using BufferedReader
FileInputStream fis = null;
BufferedReader reader = null;
BufferedWriter out=null;
Matcher matcher, matcherif;
int if1c=0;
int if2c=0;
int space=0;
int when2c=0;
int ind=0;
int start=0;
int end = 0;
try {
fis = new FileInputStream("JNC_H/JNC_possible_parse");
reader = new BufferedReader(new InputStreamReader(fis));
out = new BufferedWriter(new FileWriter("JNC_H/1"));
//System.out.println("Reading File line by line using BufferedReader");
String line = reader.readLine();
String storage = "";
String condition = "";
String temp = "";
Pattern pattern = Pattern.compile("\\((\\S+) (\\S+)\\)");
Pattern pattern1 = Pattern.compile("[\\)|\\(]");
Pattern pattern3 = Pattern.compile("\\s+");
Pattern pattern2 = Pattern.compile("\\s");
Pattern patternIN = Pattern.compile("\\((SBAR|PP) \\(IN");
Pattern patternWH = Pattern.compile("\\(SBAR \\(WHADVP ");
Pattern patternTO = Pattern.compile("\\(PP \\(TO");

Pattern patternp = Pattern.compile("\\)+");

while(line != null){
	matcherif = patternIN.matcher(line);
while(matcherif.find()){
	ind=matcherif.start();
	start =1;
	end=0;
	int i;;
	for(i=ind+1;start!=end && i<line.length();i++)
	{
		if (line.charAt(i)=='(')
			start++;
		else if(line.charAt(i)==')')
			end++;
	}
	System.out.println(ind+":"+i);
	condition=line.substring(ind, i);
	
	//matcher = pattern3.matcher(condition);
	//condition=matcher.replaceAll(" ");
	matcher = pattern.matcher(condition);
	condition=matcher.replaceAll("$1");
	matcher = pattern1.matcher(condition);
	condition=matcher.replaceAll("");
	space=0;
	matcher = pattern2.matcher(condition);
	
	while (matcher.find())
		space++;
	System.out.println(if1c+"::"+ind+"::"+space);
	for(int combination=1;combination<=space+1;combination++){
	start=0;
	for(int o=1;o<=space-combination+1;o++)
	{
		matcher = pattern2.matcher(condition);
		
		for(int p=1;p<o+combination;p++){
			matcher.find();
		}
		end=matcher.start();
		temp=condition.substring(start,  end);
		matcher = pattern2.matcher(temp);
		temp=matcher.replaceAll("");
		out.write(temp+ " ");
		matcher = pattern2.matcher(condition);
		for(int p=0;p<o;p++){
			matcher.find();
		}
		start=matcher.start();
	}
	end=condition.length();
	temp=condition.substring(start,  end);
	matcher = pattern2.matcher(temp);
	temp=matcher.replaceAll("");
	out.write(temp+ " ");
	
	
	}
	
	
	
	/*ind=matcherif.start();
	System.out.println(ind);
	start =1;
	end=0;
	int i;;
	for(i=ind+1;start!=end && i<line.length();i++)
	{
		if (line.charAt(i)=='(')
			start++;
		else if(line.charAt(i)==')')
			end++;
	}
	condition=line.substring(ind, i);
	matcher = pattern.matcher(condition);
	condition=matcher.replaceAll("$1");
	matcher = pattern1.matcher(condition);
	condition=matcher.replaceAll("");
	matcher = pattern2.matcher(condition);
	condition=matcher.replaceAll("");
	out.write(condition+ " ");
*/	
}

matcherif = patternWH.matcher(line);
while(matcherif.find()){	ind=matcherif.start();
start =1;
end=0;
int i;;
for(i=ind+1;start!=end && i<line.length();i++)
{
	if (line.charAt(i)=='(')
		start++;
	else if(line.charAt(i)==')')
		end++;
}
System.out.println(ind+":"+i);
condition=line.substring(ind, i);

//matcher = pattern3.matcher(condition);
//condition=matcher.replaceAll(" ");
matcher = pattern.matcher(condition);
condition=matcher.replaceAll("$1");
matcher = pattern1.matcher(condition);
condition=matcher.replaceAll("");
space=0;
matcher = pattern2.matcher(condition);

while (matcher.find())
	space++;
System.out.println(if1c+"::"+ind+"::"+space);
for(int combination=1;combination<=space+1;combination++){
start=0;
for(int o=1;o<=space-combination+1;o++)
{
	matcher = pattern2.matcher(condition);
	
	for(int p=1;p<o+combination;p++){
		matcher.find();
	}
	end=matcher.start();
	temp=condition.substring(start,  end);
	matcher = pattern2.matcher(temp);
	temp=matcher.replaceAll("");
	out.write(temp+ " ");
	matcher = pattern2.matcher(condition);
	for(int p=0;p<o;p++){
		matcher.find();
	}
	start=matcher.start();
}
end=condition.length();
temp=condition.substring(start,  end);
matcher = pattern2.matcher(temp);
temp=matcher.replaceAll("");
out.write(temp+ " ");


	}
}

matcherif = patternTO.matcher(line);
while(matcherif.find()){	ind=matcherif.start();
start =1;
end=0;
int i;;
for(i=ind+1;start!=end && i<line.length();i++)
{
	if (line.charAt(i)=='(')
		start++;
	else if(line.charAt(i)==')')
		end++;
}
System.out.println(ind+":"+i);
condition=line.substring(ind, i);

//matcher = pattern3.matcher(condition);
//condition=matcher.replaceAll(" ");
matcher = pattern.matcher(condition);
condition=matcher.replaceAll("$1");
matcher = pattern1.matcher(condition);
condition=matcher.replaceAll("");
space=0;
matcher = pattern2.matcher(condition);

while (matcher.find())
	space++;
System.out.println(if1c+"::"+ind+"::"+space);
for(int combination=1;combination<=space+1;combination++){
start=0;
for(int o=1;o<=space-combination+1;o++)
{
	matcher = pattern2.matcher(condition);
	
	for(int p=1;p<o+combination;p++){
		matcher.find();
	}
	end=matcher.start();
	temp=condition.substring(start,  end);
	matcher = pattern2.matcher(temp);
	temp=matcher.replaceAll("");
	out.write(temp+ " ");
	matcher = pattern2.matcher(condition);
	for(int p=0;p<o;p++){
		matcher.find();
	}
	start=matcher.start();
}
end=condition.length();
temp=condition.substring(start,  end);
matcher = pattern2.matcher(temp);
temp=matcher.replaceAll("");
out.write(temp+ " ");
	}
}
condition="";
out.newLine();
if1c++;
line = reader.readLine();
}
out.close();
System.out.println("Done ");
} catch (FileNotFoundException ex) {
Logger.getLogger(BufferedReader.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
Logger.getLogger(BufferedReader.class.getName()).log(Level.SEVERE, null, ex);
} finally {
try {
reader.close();
fis.close();
} catch (IOException ex) {
Logger.getLogger(BufferedReader.class.getName()).log(Level.SEVERE, null, ex);
}
}
}
}
