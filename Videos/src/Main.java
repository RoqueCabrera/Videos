import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

//1:19:02;
public class Main 
{

	public static void main(String[] args) 
	{
		//CREATING A SCANNER TO READ AND SAVE THE VARIABLES
		Scanner sc = new Scanner(System.in);
		//-------------------------------------------------
		
		//CREATING A LIST OF USERS
		List <User> userList = new ArrayList<User>();
		//------------------------
		
		//CREATE EMPTY USER
		User loggedUser = null;
		//-----------------
		
		//Do/While CONFIRMATION VALUE
		boolean value = true;
		//---------------------------
		
		//SWITCH CASE COFNFIRMATION VALUE
		boolean loggedUserLoop = true;
		//---------------------------
		
		//IN LIST CONFIRMATION VALUE
		//boolean inList = false;
		
		
		//COMMON VARIABLES
		String name;
		String surname;
		String password;
		User   inList;
		String keyword; 
		//----------------
		
		//ARRAYLIST OF ALL THE VIDEOS WITH SAME KEYWORDS
		List<Video> foundVideos;
		//----------------------------------------------
		
		
		
	
		
		//INITIAL WELCOME PAGE		
		System.out.println("RoqueTube, An image is worth way less than a video!");
		System.out.println("===================================================");
		//--------------------
		
		
		//CHOOSING IF WE WANT TO REGISTER, LOGIN OR EXIT
		do 
		{
			System.out.println("Choose an option: Login/Register/EXIT");
			String option = sc.next();
			
			switch (option.toLowerCase()) 
			{
			//LOGGING INTO AN ACCOUNT
			case "login":
				System.out.println("You are about to log in.");
				System.out.println("*****-----LOGIN-----*******");	
				System.out.println("Insert you name");
				name = sc.next();
				System.out.println("Insert your surname");
				surname = sc.next();
				System.out.println("Insert your password");
				password = sc.next();				
				
					//MAKING THE EXCEPTION FROM USER LOGIN METHOD WORK
					try 
					{
						inList = Login(name, surname, password, userList);
						System.out.println("Welcome: " + inList.getName());
						loggedUser = inList;
					} 
					catch (Exception e) 
					{
						System.out.println(e.getMessage());
					}
					//------------------------------------------------
					
					//ONCE LOGGED IN-->MENU INSIDE DE PROGRAM
					do 
					{
						System.out.println("Choose an option: ");
						System.out.println("1) Create a video ");
						System.out.println("2) Show list of videos ");
						System.out.println("3) Search a video ");
						System.out.println("4) Logout ");

						int choice = sc.nextInt();
						
						switch (choice) 
						{
						case 1:
							//VIDEO GENERATOR WELCOME PAGE
							System.out.println("Welcome to the video generator!");
							System.out.println("===============================");
							
							
							//CREATING A NEW VIDEO AND ADDING IT TO THE LIST
							System.out.println("Insert a title");
							String title = sc.next();
							System.out.println("Insert a URL");
							String URL = sc.next();
							System.out.println("Insert tags, to exit write EXIT.");
							List<String> newTagList = new ArrayList<String>();
							
							//setting the tags in the tagList.
							String newTag ="";
							do 
							{
								System.out.println("Insert a tag.");
								newTag = sc.next();
								if(!newTag.equals("EXIT"))
									newTagList.add(newTag);
							} 
							while (!newTag.equals("EXIT"));
							//-------------------------------
							
							Video newVideo = new Video(title, URL, newTagList);
							loggedUser.addVideo(newVideo);
							System.out.println(newVideo);
							loggedUserLoop = true;
							break;
							//___________________________
							
						case 2:
							//VIDEO SHOWER WELCOME PAGE
							System.out.println("Welcome to the video shower!");
							System.out.println("===============================");
							
							for (Video video : loggedUser.getVideoList()) 
							{
								System.out.println(video.toString());
							}
							
							loggedUserLoop = true;
							break;
							
						case 3:
							
							//TO AVOID ERASING THE LIST WE CREATE THE LIST OUTSIDE THE LOOPS
							//NOT AT THE TOP, TO ERASE THE PREVIOUS LISTS
							foundVideos = new ArrayList<Video>();
							//-------------------------------------------
							//---------------------------------------------------------------
							
							//VIDEO SEARCHER WELCOME PAGE
							System.out.println("Welcome to the video searcher!");
							System.out.println("===============================");
							System.out.println("Look for your video using a keyword");
							keyword = sc.next();
							for (Video video : loggedUser.getVideoList()) 
							{
								if (video.getTitle().contains(keyword))
								{
									foundVideos.add(video);
								}
								else 
								{
									for (String tag : video.getTags()) 
									{
										if(tag.equals(keyword))
										{
											foundVideos.add(video);
											break;
										}										
									}
								}
								
							}
							System.out.println("The selected videos are:");
							for (Video foundVideoObject : foundVideos) 
							{
								System.out.println(foundVideoObject.toString());
							}
							break;
							//___________________________
							
						case 4:
							System.out.println("See you soon " + loggedUser.getName());
							loggedUserLoop = false;	
							break;
							
						default:
							System.out.println("Please, insert an option from 1-4.");
							loggedUserLoop = true;	
							break;
						}
					} while (value);
					//---------------------------------------
					
					
				value = true;
				break;
			//-----------------------
				
			//REGISTERING A NEW ACCOUNT
			case "register":
				System.out.println("Welcome to the registration area.");
				System.out.println("******------REGISTER------*******");				
				//CREATING A NEW PROFILE AND ADDING IT TO THE LIST
				System.out.println("Insert you name");
				name = sc.next();
				System.out.println("Insert your surname");
				surname = sc.next();
				System.out.println("Insert your password");
				password = sc.next();				
				
				User newUser = null;
				try 
				{
					newUser = new User(name.toUpperCase(), surname.toUpperCase(), password);
					System.out.println("The new user is: " + newUser.toString());	
					userList.add(newUser);
				} catch (Exception e) {
					System.out.println("Try register again. ");
				}
				
							
				value = true;
				//------------------------------------------------
				break;
			//-------------------------
				
			//EXITING THE PROGRAM
			case "exit":
				System.out.println("You have exited correctly.");
				value = false;
				break;
			//-------------------
			
			default:
				System.out.println("Choose one of the described options.");
				value = true;
				break;
			
			}
		}
		//-------------------------------------------------------------
		while (value == true);
		
		
		//PRINTING THE RESULT
		System.out.println(userList);
	}
	
	//LOGIN STATIC METHOD
	public static User Login(String name, String surname, String password,List<User> userList) throws Exception
	{
		User output = null;
		for (User user : userList) {
			if(user.getName().equals(name.toUpperCase()) && user.getSurname().equals(surname.toUpperCase()) && user.confirmPassword(password))
			{
				output = user;
				break;
			}
		}
		if (output == null)
		{
			throw new Exception ("You´re not on the guest list.");
			
		}
		return output;
	}
	//------------------
	
}
