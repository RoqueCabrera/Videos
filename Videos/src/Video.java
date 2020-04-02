import java.util.List;

public class Video 
{
	private static int COUNTER = 1;
	
	int id;
	String Title;
	String URL;
	List<String> tags;
	
	public Video(String title, String URL, List<String> tags) //throws Exception 
	{
		//IF THE FIELDS ARE EMPTY THROW EXCEPTION
		/*if(title.equals("") || URL.equals("") || tags.equals(""))
		{
			throw new Exception ("You must fill all the options.");
		}*/
				
		//START GIVING AN ID TO EACH USER AND EACH TIME YOU ADD 1 NUMBER TO ID
		id = COUNTER;
		COUNTER++;
		
		this.setTitle(title);
		this.setURL(URL);
		this.setTags(tags);	}
	
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getTitle() 
	{
		return Title;
	}
	public void setTitle(String title) 
	{
		Title = title;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) 
	{
		URL = uRL;
	}
	public List<String> getTags() 
	{
		return tags;
	}
	public void setTags(List<String> tags) 
	{
		this.tags = tags;
	}


	@Override
	public String toString() {
		return "Video [id=" +this.getId() + ", Title=" + this.getTitle() + ", URL=" + this.getURL() + ", tags=" + this.getTags() + "]";
	}
	
	
}
