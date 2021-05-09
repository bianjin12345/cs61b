public class TestPlanet{
	public static void main(String[] args){
		Planet a = new Planet(0,0,1,1,1,"ABd");
		Planet b = new Planet(1,2,2,1,1,"ABdd");
		System.out.println(a.calcForceExertedByX(b));
		System.out.println(b.calcForceExertedByX(a));
	}
	
}