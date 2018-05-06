package Demo;




import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.io.File;



/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ObjectMaps.Objects;
import Resources.base;



public class practiceTest extends base
{
	@Test
	public void basePageNavigation() throws IOException
	{
	
		driver=initializeDriver();
        String baseurl = "https://www.imdb.com";      
        driver.get(baseurl);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Objects a=new Objects(driver);
        a.TopRatedMovies.click();
        
            String movieNames[]=new String[250];
            String movieyear[]=new String[250];
            String movieyearnew[]=new String[250];
            String movieratings[]=new String[250];
            for(int i=0;i<250;i++)
            {
            
            	movieNames[i]=a.li.get(i).getText();
            	System.out.println(movieNames[i]);
            	
            	movieyear[i]=a.li1.get(i).getText();
            	movieyearnew[i]=movieyear[i].replaceAll("[()]", "");
            	System.out.println(movieyearnew[i]);
            	
            	movieratings[i]=a.li2.get(i).getText();
            	System.out.println(movieratings[i]);
          
        }   
            
            try{  
            	Class.forName("com.mysql.jdbc.Driver");  
            	Connection con=DriverManager.getConnection(  
            	"jdbc:mysql://127.0.0.1:3306/practice1","root","root");  
            	//here sonoo is database name, root is username and password  
            	
            	System.out.println("connection established");
            	Statement stmt=con.createStatement();  
            	
            
            	stmt.executeQuery("use practice2"); 
            	ResultSet rs=stmt.executeQuery("select * from Moviesinfo"); 
            	for(int i=0; i<250; i++)

            	{
            	String query = "insert into moviesinfo(name,year,ratings) values(?,?,?)";
            	PreparedStatement stmt1=con.prepareStatement(query);
            	stmt1.setString(1, movieNames [i]);
            	stmt1.setString(2, movieyearnew [i]);
            	stmt1.setString(3, movieratings[i]);
            	int j=stmt1.executeUpdate();
            	System.out.println(j+" records inserted");
            	}
            	
            	String query = "use practice2";
             	stmt.executeQuery(query); 
            	String query1 = "select * from moviesinfo";
            	ResultSet rs1=stmt.executeQuery(query1);
            
            	while(rs1.next())
            	{
            	System.out.println(rs1.getString("name"));
            	System.out.println(rs1.getString("year"));
            	System.out.println(rs1.getString("ratings"));
            	}
            	con.close();  
           
            }
            catch(Exception e){
            	System.out.println(e);}  
            	  
            	
            	System.out.println("done");
            	  driver.close();
            }
        
         

}