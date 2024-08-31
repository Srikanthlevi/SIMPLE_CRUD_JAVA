package dbConnect;
import java.sql.*;
import java.util.Scanner;

public class dbJava {
	public static void main(String []args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/myfile?";
		String username="root";
		String password="****";
		Connection con=DriverManager.getConnection(url,username,password); 
		
		Statement stmt=con.createStatement();
		ResultSet rs;
		PreparedStatement st;
		String qry="";
		
		int id,age,choice;
		String name,city;
		Scanner in= new Scanner(System.in);
		Scanner str= new Scanner(System.in);
		
		
		while(true) {
			System.out.println("SQL java CRUD");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Select");
			System.out.println("5.Exit");
			System.out.println(" ");
			System.out.println("---------------------------------------");
			System.out.println("Enter Choice : ");
			choice=in.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Name : ");
				name=str.nextLine();
				System.out.println("Enter Age : ");
				age=in.nextInt();
				System.out.println("Enter City : ");
				city=str.nextLine();
				
				qry="insert into users (name,age,city) values (?,?,?);";
				st=con.prepareStatement(qry);
			
				st.setString(1,name);
				st.setInt(2,age);
				st.setString(3,city);
				st.executeUpdate();
				
				System.out.println("Successfully Inserted ! ");
				
				break;
			case 2:
				
				System.out.println("Enter Id : ");
				id=in.nextInt();
				System.out.println("Enter Name : ");
				name=str.nextLine();
				System.out.println("Enter Age : ");
				age=in.nextInt();
				System.out.println("Enter City : ");
				city=str.nextLine();
				
				qry="update users set name=?,age=?,city=? where id=? ;";
				st=con.prepareStatement(qry);
				
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, city);
				st.setInt(4, id);
				st.executeUpdate();
				
				System.out.println("Updated Successfully !");
				
				break;
			case 3:
				System.out.println("Enter Id");
				id=in.nextInt();
				qry="delete from users where id=?";
				st=con.prepareStatement(qry);
				
				st.setInt(1, id);
				st.executeUpdate();
				
				System.out.println("id = "+id+" Deleted Successfully !");
				
				break;
			case 4:
				qry="select id,name,age,city from users";
				rs=stmt.executeQuery(qry);
				while(rs.next())
				{
					id=rs.getInt("id");
					name=rs.getString("name");
					age=rs.getInt("age");
					city=rs.getString("city");
					
					System.out.print("ID : "+id);
					System.out.print(" NAME : "+name);
					System.out.print(" Age : "+age);
					System.out.println(" City : "+city);
					System.out.println("-------------------------------------------");
					
					
				}
				break;
			case 5:
				System.out.println("thank you");
				System.exit(0);
				
				break;
			default:
				System.out.println("Invalid Selection");
				break;	
			}
			System.out.println("--------------------------------");
		}
	}

}
