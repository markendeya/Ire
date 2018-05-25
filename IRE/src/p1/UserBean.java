package p1;

public class UserBean 
{
	String UserName , roles;

	public String getUserName() 
	{
		return UserName;
	}

	public void setUserName(String userName) 
	{
		UserName = userName;
	}

	public String getRoles() 
	{
		return roles;
	}

	public void setRoles(String roles) 
	{
		this.roles = roles;
	}

	public boolean equalsIgnoreCase(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
