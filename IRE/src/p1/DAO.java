
package p1;
import java.sql.*;
public class DAO {

	public static UserBean isUser(String userID,String password) throws SQLException
	{
		UserBean details = new UserBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mark","bittu");
		
		if(con != null)
		{	
		Statement stm = con.createStatement();
		String query = "select role,username from underwriter where userID= '" + userID + "' and password = ' "+password+ "'";
		ResultSet rs = stm.executeQuery(query);
		while(rs.next())
		{
			 details.setRoles(rs.getString(1));
			 details.setUserName(rs.getString(1));
			 
			}
		}
		else
		{
			System.out.println("Login Failed");
		}
		return details;
		
	}
}
