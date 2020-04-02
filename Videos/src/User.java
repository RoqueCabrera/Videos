import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User 
{
	private static int COUNTER = 1;
	
	int id;
	String Name;
	String Surname;
	String Password;
	Date RegisterDate;
	private List<Video> videoList;
	
	
	public User(String name, String surname, String password) throws Exception
	{
		//IF THE FIELDS ARE EMPTY THROW EXCEPTION
		if(name.equals("") || surname.equals("") || password.equals(""))
		{
			throw new Exception ("You must fill all the options.");
		}
		
		//START GIVING AN ID TO EACH USER AND EACH TIME YOU ADD 1 NUMBER TO ID
		id = COUNTER;
		COUNTER++;
		
		this.setName(name);
		this.setSurname(surname);
		this.setPassword(password);
		this.setRegisterDate(new Date());
		
		this.videoList = new ArrayList<Video>();
	}



	public List<Video> getVideoList() 
	{
		return videoList;
	}



	public void setVideoList(List<Video> videoList) 
	{
		this.videoList = videoList;
	}

	
	
	public void addVideo(Video newVideo)
	{
		this.getVideoList().add(newVideo);
	}
	
	
	
	public void addVideos(List<Video> newVideo)
	{
		for (Video video : newVideo)
		{
			this.getVideoList().add(video);
		}
	}

	

	public int getId() 
	{
		return id;
	}



	public void setId(int id) 
	{
		this.id = id;
	}



	public String getName() 
	{
		return Name;
	}



	public void setName(String name) 
	{
		Name = name;
	}



	public String getSurname() 
	{
		return Surname;
	}



	public void setSurname(String surname) 
	{
		Surname = surname;
	}



	public String getPassword() 
	{
		String hiddenPassword = "";
		
		for (int i = 0; i < Password.length(); i++) 
		{
			hiddenPassword += "*";
		}
		hiddenPassword += "***";
		return hiddenPassword;
	}



	public void setPassword(String password) 
	{
		Password = password;
	}



	public Date getRegisterDate() 
	{
		return RegisterDate;
	}



	public void setRegisterDate(Date registerDate) 
	{
		RegisterDate = registerDate;
	}


	//METHOD TO CHECK IF PASSWORD IS CORRECT(USING BOOLEAN)
	public boolean confirmPassword(String realPassword)
	{		
		return (realPassword.equals(this.Password));
	}

	@Override
	public String toString() {
		return "User [id=" + this.getId() + ", Name=" + this.getName() + ", Surname=" + this.getSurname() + ", Password=" + this.getPassword()
				+ ", RegisterDate=" + this.getRegisterDate() + ", Videos: " + this.getVideoList().toString() + "]";
	}
	
	
	

}
