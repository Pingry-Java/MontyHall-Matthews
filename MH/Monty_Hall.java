/**
 *
 * This is a program to illustrate the monty hall problem
 * @author: Graham Matthews
 * @version. 0.1
 */
//package MH; this was for the MHI program
import java.util.Scanner;
public class Monty_Hall{
	public static void main(String[] args){
		int[] results = {0, 0};
		boolean result;
		int len=0;
		Scanner keyboard = new Scanner(System.in);
		if (args.length!=0){
			len=Integer.parseInt(args[0]);
		}
		for (int i=0; i<=len; i++){
			result=run(len, keyboard);
			if (result==true){
				results[0]+=1;
			}
			else{
				results[1]+=1;
			}
		}
		if (len!=0){
			System.out.println(round(results[0]*100.0/len) + "% switch");
			System.out.println(round(results[1]*100.0/len) + "% stay");
		}
	}
	public static boolean run(int len, Scanner keyboard){
		// initializing all the variables needed to run the simulation mode
		boolean door1=true;
		boolean door2=true;
		boolean door3=true;
		int userSwitch;
		int user;
		boolean stay;
		int[] values = {0, 0};
		int revealed;
		int usable;
		
		// This is assigning the doors values, two falses and a true
		door1= (rand(2)==1);
		if (door1==true){
			door2 = false;
			door3 = false;
		}
		else{
			door2=(rand(2)==1);
			door3=(door2==false);
		}
		
		boolean doors[] = {door1, door2, door3};
		
		//gets the user's door choice, if the program is in interactive mode
		if (len==0){
			user=getUserDoor(keyboard);
		}
		else{
			user=rand(3);
		}
		
		//eliminates a door, so the user can choose to switch
		values= elimDoor(doors, user, len);
		revealed=values[0];
		usable=values[1];
		
		// gets the user's choice, switch or not, if the program is in interactive mode
		if (len==0){
			stay=getUserSwitch(doors, user, usable, keyboard);
		}
		else{
			stay=false;
		}
		userSwitch=-1;
		if (stay==false){
			for (int i=0; i<3; i++){
				if (!(i==user || i==revealed)){
					userSwitch=i;
				}	
			}
		}
		else{
			userSwitch=user;
		}
		
		if (doors[userSwitch]==true){
			if (len==0){
				System.out.println("You won a car!");
			}
			return true;
		}
		else{
			if (len==0){
				System.out.println("You won a goat!");
			}
			return false;
		}
		//}
		/*
		if(len!=0){
			System.out.println((results[0]*100)/len + "% switch");
			System.out.println((results[1]*100)/len + "% stay");
		}
		*/
		//return false;
	}
	
	/**
	* initializes all variables
	*/
	/*
	public static void init(){
		Scanner keyboard = new Scanner(System.in);
		public boolean door1=(boolean)rand();
		if (door1==true){
			public boolean door2 = false;
			public boolean door3 = false;
		}
		else{
			public boolean door2=(boolean)rand();
		}
		public boolean door3=(!door2);
		
		public boolean[] doors={door1, door2, door3};
	}
	*/
	/**
	 * creates a random int, 0 or 1
	 * @param change the range of the random numbers, 0 to change-1
	 * @return a random int, 0 or 1
	 */
	 
	public static int rand(int change){
		double inter = Math.random()*change;
		return (int)inter;
	}
	/** 
	 * gets the user's door choice
	 * @return the user's choice
	 */
	 
	public static int getUserDoor(Scanner keyboard){
		System.out.println("What door do you want to choose? (1, 2, 3)");
		int inter = keyboard.nextInt();
		keyboard.nextLine();
		return inter-1;
	}
	/**
	 * eliminates a door that has a goat behind it
	 * @param doors an array of booleans that have the identities of the doors
	 * @param user the user's door choice
	 * @return the revealed door
	 */
	
	public static int[] elimDoor(boolean[] doors, int user, int len){
		for (int i=0; i<3; i++){
			if (doors[i]==false && i!=user){
				int usable=0;
				while (usable==user || usable==i){
					usable++;
				}
				if (len==0){
					System.out.println("Door " + (int)(i+1) + " had a goat behind it!");
				}
				int[] values={i, usable};
				return values;
			}
		}
		int [] values={-1,-1};
		return values;
	}
	/**
	 * gets the user's choice, switch or stay
	 * @ return the user' choice
	 */
	
	public static boolean getUserSwitch(boolean[] doors, int user, int usable, Scanner keyboard){
		System.out.println("You have Door " + (int)(user+1));
		System.out.println("Would you like to switch to Door " + (int)(usable+1) +"? (y/n)");
		String choice2=keyboard.nextLine();
		boolean stay=true;
		if (choice2.equals("y")){
			stay=false;
		}
		return stay;
	}
	
	/**
	 * rounds any numbers to the hundredths place
	 * @param numIn the number to round
	 * @return the rounded number
	 */
	 
	public static double round (double numIn){
		double inter=(numIn*100) + .5;
		return ((int)inter)/100.00;
	}
}