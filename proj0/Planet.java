public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67*Math.pow(0.1,11);
	
	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;	
	}

	public double calcDistance(Planet p1){
		return Math.sqrt((this.xxPos-p1.xxPos)*(this.xxPos-p1.xxPos)
			   +(this.yyPos-p1.yyPos)*(this.yyPos-p1.yyPos));
	}
	public double calcForceExertedBy(Planet p2){
		return G*(this.mass)*(p2.mass)/(this.calcDistance(p2)*this.calcDistance(p2));
	}
	public double calcForceExertedByX(Planet p3){
		return calcForceExertedBy(p3)*(p3.xxPos-this.xxPos)/calcDistance(p3);
	}
	public double calcForceExertedByY(Planet p4){
		return calcForceExertedBy(p4)*(p4.yyPos-this.yyPos)/calcDistance(p4);
	}
	public double calcNetForceExertedByX(Planet[] p5){
		double sum = 0;
		for (int i = 0; i < p5.length; i++){
			if (this.equals(p5[i])){
				continue;
			}
			sum = sum + this.calcForceExertedByX(p5[i]);
		}		
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] p6){
		double sum = 0;
		for (int i = 0; i < p6.length; i++){
			if (this.equals(p6[i])){
				continue;
			}
			sum = sum + this.calcForceExertedByY(p6[i]);
		}
		return sum;
	}
	public void update(double dt, double fX, double fY){
		this.xxVel = this.xxVel + dt*fX/this.mass;
		this.yyVel = this.yyVel + dt*fY/this.mass;
		this.xxPos = this.xxPos + dt*xxVel;
		this.yyPos = this.yyPos + dt*yyVel;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}
	
}
