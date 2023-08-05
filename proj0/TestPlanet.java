public class TestPlanet
{
	public static void main(String[] args)
	{
		Planet p1 = new Planet(0.0, 0.0, 5.0, 3.0, 1.0, );
		Planet p2 = new Planet(4.3, 2.5, 2.6, 7.3, 4.9, );

		double f1 = p1.calcForceExertedBy(p2);	
		double f2 = p2.calcForceExertedBy(p1);

		System.out.println(f1);
		System.out.println(f2);
	}
}
