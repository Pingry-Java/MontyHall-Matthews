import rand.rand;
import MH.Monty_Hall;
public class MHI{
	public static void main(String[] args){
		double a=0;
		boolean win;
		int[] results={0, 0};
		for (int i=0; i<10000000; i++){
			win=Monty_Hall.run(rand.randInt(3)-1, false);
			//System.out.print(win);
			if (win==true){
				results[0]+=1;
			}
			else{
				results[1]+=1;
			}
		}
		System.out.println(results[0]/100000 +"%" + " switch");
		System.out.println(results[1]/100000 +"%" + " stay");
	}
}