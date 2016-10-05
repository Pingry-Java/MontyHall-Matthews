/**
 *
 * This is a program to illustrate the monty hall problem
 * @author: Graham Matthews
 * @version. 0.1
 */
package MH;
import java.util.Scanner;
public class Monty_Hall{
	public static boolean run(int user, boolean stay){
		//init();
		boolean door2;
		boolean door3;
		Scanner keyboard = new Scanner(System.in);
		boolean door1= (rand()==1);
		if (door1==true){
			door2 = false;
			door3 = false;
		}
		else{
			door2=(rand()==1);
			door3=(door2==false);
		}
		
		boolean[] doors={door1, door2, door3};
		//int user=getUserDoor(keyboard);
		int[] values= elimDoor(doors, user);
		int revealed=values[0];
		int usable=values[1];
		
		/*
		if (door1==false && door1!=user){
			System.out.println("Door 1 had a goat behind it!");
			int doorUsed=1;
		}
		else if (door2==false && door2!=user){
			System.out.println("Door 2 had a goat behind it!");
			int doorUsed=2;
		}
		else{
			System.out.println("Door 3 had a goat behind it!");
			int doorUsed=3;
		}
		
		*/
		
		//boolean stay=getUserSwitch(doors, user, usable, keyboard);
		int userSwitch=-1;
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
			//System.out.println("You won a car!");
			return true;
		}
		else{
			//System.out.println("You won a goat!");
			return false;
		}
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
	 * @return a random int, 0 or 1
	 */
	 
	public static int rand(){
		double inter = Math.random()*2;
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
	
	public static int[] elimDoor(boolean[] doors, int user){
		for (int i=0; i<3; i++){
			if (doors[i]==false && i!=user){
				int usable=0;
				while (usable==user || usable==i){
					usable++;
				}
				//System.out.println("Door " + (int)(i+1) + " had a goat behind it!");
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
}