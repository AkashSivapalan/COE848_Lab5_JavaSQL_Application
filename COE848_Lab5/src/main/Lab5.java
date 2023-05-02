package main;
import java.sql.*;
import java.util.Scanner;

public class Lab5 {

	
	public static void DeleteTables() {
		Connection c = null;  
		Statement stmt = null;
		try {
			try {       
				Class.forName("org.sqlite.JDBC");       
				c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 

		    } catch ( Exception e ) 	{      
			 System.err.println("Problem Encountered");     
		    } 
			
			stmt = c.createStatement();
		    String sql = "DROP TABLE Users;"; 
		    stmt.executeUpdate(sql);
		    sql = "DROP TABLE Brand;"; 
		    stmt.executeUpdate(sql);
		    sql = "DROP TABLE Clothing_Style;"; 
		    stmt.executeUpdate(sql);
		    sql = "DROP TABLE clothing;"; 
		    stmt.executeUpdate(sql);
		    sql = "DROP TABLE Purchase_History;"; 
		    stmt.executeUpdate(sql);
		    stmt.close();
		    c.close();	
		    
		}catch(Exception e ){
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
		System.out.println("Table Dropped successfully");
		
	}
	
	public static void GetMaleUsers() {
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT email FROM Users WHERE gender='M';" );
			
			while ( rs.next() ) {
				String email = rs.getString("email");
				System.out.println(email);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 



	}
	
	public static void LoadTables() {
		Connection c = null;  
		Statement stmt = null;
		try {
			try {       
				Class.forName("org.sqlite.JDBC");       
				c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 

		    } catch ( Exception e ) 	{      
			 System.err.println("Problem Encountered");     
		    }
			stmt = c.createStatement();
		    String sql = "CREATE TABLE Users (email TEXT PRIMARY KEY, name VARCHAR(255) NOT NULL, gender VARCHAR(255) NOT NULL, PurchasesNumber INT NOT NULL, Receipts VARCHAR(255) NOT NULL);"; 
		    stmt.executeUpdate(sql);

		    sql = "CREATE TABLE Brand(brand VARCHAR(255) PRIMARY KEY,styles_offered VARCHAR(255) NOT NULL, store_type VARCHAR(255)NOT NULL);"; 
		    stmt.executeUpdate(sql);
		    
		    sql = "CREATE TABLE Clothing_Style(clothing_Style_Name VARCHAR(255) PRIMARY KEY, material VARCHAR(255) NOT NULL);"; 
		    stmt.executeUpdate(sql);	
		    
		    sql = "CREATE TABLE clothing(clothing_id INT PRIMARY KEY,cost INT NOT NULL,brand VARCHAR(255) NOT NULL,clothing_type VARCHAR(255) NOT NULL, clothing_style VARCHAR(255) NOT NULL,CONSTRAINT fk_Brand FOREIGN KEY (brand) REFERENCES Brand(brand),CONSTRAINT fk_style FOREIGN KEY (clothing_style) REFERENCES Clothing_Style(Clothing_Style_Name));"; 
		    stmt.executeUpdate(sql);
		    
			sql = "CREATE TABLE Purchase_History(Receipt_no INT PRIMARY KEY,clothing_id INT NOT NULL, purchase_date VARCHAR(255), rating INT NOT NULL,email VARCHAR(255) NOT NULL, CONSTRAINT fk_clothing_id FOREIGN KEY (clothing_id) REFERENCES clothing(clothing_id), CONSTRAINT fk_email FOREIGN KEY (email) REFERENCES Users(email));"; 
		    stmt.executeUpdate(sql);
		    
			try {
				stmt = c.createStatement();
			    sql = "INSERT INTO Users VALUES('akash@gmail.com','Akash Sivapalan','M',5,'1,2,3,4,5');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Siva@gmail.com','Siva Siva','M',2,'6,7');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Bob@gmail.com','Bob','M',0,'');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Mary@gmail.com','Mary','F',0,'8');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Dilan@gmail.com','Dilan','M',1,'9');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Tom@gmail.com','Tom','M',1,'10');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Ross@gmail.com','Ross','M',1,'11');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Yusei@gmail.com','Yusei','M',1,'12');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Ichigo@gmail.com','Ichigo','M',1,'13');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Users VALUES('Gin@gmail.com','Gin','M',1,'14');"; 
			    stmt.executeUpdate(sql);
			    
			    
			    sql = "INSERT INTO Brand VALUES('UNIQLO','Oversized, airism, fitted','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('ASOS','Oversized, distressed, regular, fitted','online');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('H&M','regular,fitted,sweats','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('Zara','regular,fitted,sweats,performance','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('Nike','fitted,sweats,performance','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('ADIDAS','fitted,sweats,performance','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('UNDER_Armor','fitted,sweats,performance','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('Levis','fitted,oversized,workwear','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('Marks','fitted,oversized,workwear','physical');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Brand VALUES('Old Navy','fitted, oversized, sweats','physical');"; 
			    stmt.executeUpdate(sql);		    
			    	    
			    
			    sql = "INSERT INTO Clothing_Style VALUES('oversized','cotton');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('regular','cotton');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('airsism','cotton, jersey');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('performance','jersey');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('fitted','cotton');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('workwear','denim');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('sweats','fleece');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('distressed','denim');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('heattech','polyester');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Clothing_Style VALUES('loungewear','fleece');"; 
			    stmt.executeUpdate(sql);
	
			    
			    sql = "INSERT INTO clothing VALUES(1,20,'UNIQLO','shirt','airsism');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(2,40,'UNIQLO','sweater','sweats');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(3,100,'Nike','sweater','performance');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(4,70,'Adidas','sweater','sweats');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(5,10,'H&M','shirt','cotton');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(6,15,'Zara','shirt','cotton');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(7,80,'Levis','pants','workwear');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(8,100,'Nike','pants','performance');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(9,8,'Old Navy','shirt','cotton');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO clothing VALUES(10,60,'UNDER_Armor','sweater','performance');"; 
			    stmt.executeUpdate(sql);
			  
			    
			    sql = "INSERT INTO Purchase_History VALUES(1,1,'2023',4,'akash@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(2,2,'2023',5,'akash@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(3,3,'2023',4,'akash@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(4,4,'2023',3,'akash@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(5,5,'2023',2,'akash@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(6,1,'2023',5,'Siva@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(7,3,'2023',5,'Siva@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(8,1,'2023',5,'Mary@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(9,7,'2023',4,'Dilan@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    sql = "INSERT INTO Purchase_History VALUES(10,1,'2023',4,'Tom@gmail.com');"; 
			    stmt.executeUpdate(sql);
			    
			    stmt.close();
			    c.close();
			}catch(Exception e) {
				System.out.println("Data exists");
			}
		    
		}catch(Exception e ){
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
		System.out.println("Table created successfully");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LoadTables();
		
		String inp = "";
		System.out.println("Enter commands to query. Enter q to quit");
		System.out.println("1: Get purchases 4 stars or higher");
		System.out.println("2: Get clothing styles made with cotton");
		System.out.println("3: Get sweater items");
		System.out.println("4: Get purchases made by specified user");
		System.out.println("5: Get clothing that was rated 3 stars or higher");
		System.out.println("6: Get Users that have made purchases");
		System.out.println("7: Get users that purchased from UNIQLO");
		System.out.println("8: Get brands that sell online");
		System.out.println("9: Get male users");
		System.out.println("10: Get brands that sell performance clothing");
		while(!inp.equals("q")) {
			Scanner in = new Scanner(System.in);
			inp = in.nextLine();
			if (inp.equals("1")) {
				System.out.println("Printing purchases rate 4 stars or higher...");
				Get4StarPurchase();
			}else if(inp.equals("2")) {
				System.out.println("Printing cotton clothing...");
				GetCottonClothing();
			}else if(inp.equals("3")) {
				System.out.println("Printing sweaters...");
				GetSweaters();
			}else if(inp.equals("4")) {
				System.out.println("Enter a user by email");
				
				in = new Scanner(System.in);
				inp = in.nextLine();
				System.out.println("Printing purchases by " + inp);
				GetUserPurchase(inp);
			}else if(inp.equals("5")) {
				System.out.println("Printing clothing ids of clothes rated 3 or higher...");
				Get3StarClothes();
			}else if(inp.equals("6")) {
				System.out.println("Printing users that have made purchases...");
				GetPurchaseUsers();
			}else if(inp.equals("7")) {
				System.out.println("Printing users that purchased from UNIQLO...");
				GetBrandPurchases();
			}else if(inp.equals("8")) {
				System.out.println("Printing online store brands...");
				GetOnlineBrands();
			}else if(inp.equals("9")) {
				System.out.println("Printing male users...");
				GetMaleUsers();
			}else if(inp.equals("10")) {
				System.out.println("Printing brands that sell performance clothes...");
				GetPerformanceBrands();
			}
		}
		System.out.println("Ending Program");
		
		
//		DeleteTables();
		
	}

	private static void GetOnlineBrands() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Brand WHERE store_type='online';" );
			
			while ( rs.next() ) {
				String brand = rs.getString("brand");
				String styles_offered = rs.getString("styles_offered");
				String store_type = rs.getString("store_type");
				System.out.println(brand + ", " + styles_offered+", " + store_type );
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 			
	}

	private static void GetBrandPurchases() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT user.email FROM Purchase_History purchase, Users user, clothing clothes WHERE clothes.brand='UNIQLO' AND clothes.clothing_id=purchase.clothing_id AND purchase.email=user.email;" );
			
			while ( rs.next() ) {
				String email = rs.getString("email");
				System.out.println(email);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 			
	}

	private static void GetPurchaseUsers() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT user.email FROM Purchase_History purchase,Users user WHERE purchase.email=user.email;" );
			
			while ( rs.next() ) {
				String email = rs.getString("email");
				System.out.println(email);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 		
	}

	private static void Get3StarClothes() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM clothing WHERE clothing_type='sweater';" );
			
			while ( rs.next() ) {
				String clothing_id = rs.getString("clothing_id");
				System.out.println(clothing_id);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 	
	}

	private static void GetSweaters() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM clothing WHERE clothing_type='sweater';" );
			
			while ( rs.next() ) {
				String clothing_id = rs.getString("clothing_id");
				String cost = rs.getString("cost");
				String brand = rs.getString("brand");
				String  clothing_type = rs.getString("clothing_type");
				String  clothing_style= rs.getString("clothing_style");
				System.out.println(clothing_id + ", " + cost +", " + brand +", " + clothing_type + ", " + clothing_style);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 			
	}

	private static void GetUserPurchase(String user) {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			String statementStr = "SELECT * FROM Purchase_History WHERE email='" +user + "';";
			ResultSet rs = stmt.executeQuery( statementStr );
			
			while ( rs.next() ) {
				String receipt_no = rs.getString("Receipt_no");
				String clothing_id = rs.getString("clothing_id");
				String  purchase_date = rs.getString("purchase_date");
				String  rating= rs.getString("rating");
				String email  = rs.getString("email");
				System.out.println(receipt_no + ", " + clothing_id +", " + purchase_date +", " + rating + ", " + email);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 		
	}

	private static void GetCottonClothing() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Clothing_Style WHERE material LIKE '%cotton%';" );
			
			while ( rs.next() ) {
				String clothing_style = rs.getString("clothing_Style_Name");
				String  material = rs.getString("material");
				System.out.println(clothing_style + ", " + material);
					
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 
		
	}

	private static void Get4StarPurchase() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Purchase_History WHERE rating>=4;" );
			
			while ( rs.next() ) {
				String receipt_no = rs.getString("Receipt_no");
				String clothing_id = rs.getString("clothing_id");
				String  purchase_date = rs.getString("purchase_date");
				String  rating= rs.getString("rating");
				String email  = rs.getString("email");
				System.out.println(receipt_no + ", " + clothing_id +", " + purchase_date +", " + rating + ", " + email);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 

	}

	private static void GetPerformanceBrands() {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		try {       
			Class.forName("org.sqlite.JDBC");       
			c = DriverManager.getConnection("jdbc:sqlite:COE848Lab5.db"); 
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT brand FROM Brand WHERE styles_offered LIKE '%performance%';" );
			
			while ( rs.next() ) {
				String email = rs.getString("brand");
				System.out.println(email);
				//code to access rows goes here
	
			}
	    } catch ( Exception e ) 	{      
		 System.err.println("Problem Encountered");     
	    } 

	}

}
