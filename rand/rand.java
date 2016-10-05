package rand;
public class rand{
	public static int randInt(int size){
		double a = Math.random()*size+1;
		return (int)a;
	}
}