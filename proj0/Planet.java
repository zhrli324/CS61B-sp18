public class Planet
{
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	public static double G = 6.67e-11;
	
	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img)
	{
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p)
	{
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet pla)
	{
		double dx = pla.xxPos - this.xxPos;
		double dy = pla.yyPos - this.yyPos;
		double distance = Math.sqrt(dx * dx + dy * dy);
		return distance;
	}
	
	public double calcForceExertedBy(Planet pla)
	{
		double force = (Planet.G * pla.mass * this.mass)/(this.calcDistance(pla) * this.calcDistance(pla)); 
		return force;
	}

	public double calcForceExertedByX(Planet pla)
	{
		double forceX = this.calcForceExertedBy(pla) * (pla.xxPos - this.xxPos) / this.calcDistance(pla);
		return forceX;
	}

	public double calcForceExertedByY(Planet pla)
	{
		double forceY = this.calcForceExertedBy(pla) * (pla.yyPos - this.yyPos) / this.calcDistance(pla);
		return forceY;
	}

	public double calcNetForceExertedByX(Planet[] plas)
	{
		double forceNetX = 0;
		for(int i = 0; i < plas.length; i = i+1)
		{
			if(this.equals(plas[i])) continue;
			forceNetX = forceNetX + this.calcForceExertedByX(plas[i]);
		}
		return forceNetX;
	}

	public double calcNetForceExertedByY(Planet[] plas)
	{
		double forceNetY = 0;
		for(int i = 0; i < plas.length; i = i+1)
		{
			if(this.equals(plas[i])) continue;
			forceNetY = forceNetY + this.calcForceExertedByY(plas[i]);
		}
		return forceNetY;
	}

	public void update(double dt, double fX, double fY)
	{
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		
		this.xxVel = this.xxVel + aX * dt;
		this.yyVel = this.yyVel + aY * dt;

		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}

	public void draw()
	{
		StdDraw.picture(xxPos, yyPos, "images/" +  imgFileName);
	}
}
