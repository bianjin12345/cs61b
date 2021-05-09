import java.util.ArrayList;
import java.util.List;

public class NBody{

	public static double readRadius(String path){
		if (path == null ||"".equals(path)){
			return 0.0;
		}
		In in = new In(path);

		/* Every time you call a read method from the In class,
		 * it reads the next thing from the file, assuming it is
		 * of the specified type. */

		/* Compare the calls below to the contents of BasicInDemo_input_file.txt */

		int planetsNum  = in.readInt();
		double radius = in.readDouble();
		in.close();
		return radius;
	}

	public static Planet[] readPlanets(String path){
		if (path == null || "".equals(path)){
			return null;
		}
		In in = new In(path);

		int planetsNum = in.readInt();
		double radius= in.readDouble();

		List<Planet> planets = new ArrayList<Planet>();
		while (!in.isEmpty()){
			Planet p = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
			planets.add(p);

			if (planets.size() == planetsNum){
				break;
			}
		}
		Planet[] ps = new Planet[planetsNum];
		for (int i = 0; i<planets.size(); i++){
			ps[i] = planets.get(i);
		}

		return ps;
	}

	public static void main(String[] args){
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		String imageToDraw = "images/starfield.jpg";
		StdDraw.enableDoubleBuffering(); 
		StdDraw.setScale(-radius,radius);
		StdDraw.clear(); 
		double time = 0;

		while (time <= T){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int i = 0; i<planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i<planets.length; i++){
			planets[i].update(dt, xForces[i],yForces[i]);
			}
			StdDraw.picture(0,0,imageToDraw);
			for (Planet p : planets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10); 
			time += dt;
		}
		
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}

	}	
} 