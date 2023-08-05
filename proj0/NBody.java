public class NBody
{
	public static double readRadius(String file)
	{
		In in = new In(file);
		int plaNum = in.readInt();
		double plaRadius = in.readDouble();
		return plaRadius;
	}

	public static Planet[] readPlanets(String file)
	{	
		In in = new In(file);
		int plaNum = in.readInt();
		double plaRadius = in.readDouble();
		
		Planet[] plas = new Planet[plaNum];

		for(int i = 0; i < plaNum; i = i + 1)
		{
			double plaxxPos = in.readDouble();
			double playyPos = in.readDouble();
			double plaxxVel = in.readDouble();
			double playyVel = in.readDouble();
			double plaMass = in.readDouble();
			String plaImg = in.readString();

			plas[i] = new Planet(plaxxPos, playyPos, plaxxVel,
								 playyVel, plaMass, plaImg);
		}	
		
		return plas;
	}

	public static void main(String[] args)
	{
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setXscale(-radius, radius);
		StdDraw.setYscale(-radius, radius);
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.0, 0.0, "images/starfield.jpg");
		
		double time = 0;			
		while(time <= T)
		{
			double xForces[] = new double[planets.length];
			double yForces[] = new double[planets.length];

			for(int i = 0; i < planets.length; i = i + 1)
			{
				planets[i].draw();

				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < planets.length; i = i + 1)
			{
				planets[i].update(dt, xForces[i], yForces[i]);	
			}
			
			StdDraw.picture(0.0, 0.0, "images/starfield.jpg");

			for(int i = 0; i < planets.length; i = i + 1)
			{
				planets[i].draw();
			}
			
			StdDraw.show();
			StdDraw.pause(10);

			time = time + dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e", radius);
		for(int i = 0; i < planets.length; i += 1)
		{
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				 planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,	
				 planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}		

	}

		
}
