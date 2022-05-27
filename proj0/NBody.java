public class NBody {
    public static Planet[] readPlanets(String filepath) {
        In in = new In(filepath);
        int number_of_planets = in.readInt();
        Planet[] result = new Planet[number_of_planets];
        double radius = in.readDouble();
//        for (Planet planet : result) {
//            //why this column
////            planet1=new Planet();
//            planet = new Planet();
//            planet.xxPos = in.readDouble();
//            planet.yyPos = in.readDouble();
//            planet.xxVel = in.readDouble();
//            planet.yyVel = in.readDouble();
//            planet.mass = in.readDouble();
//            planet.imgFileName = in.readString();
//        }
        for (int i = 0; i < number_of_planets; i++) {
            double xp = in.readDouble();
            double yp = in.readDouble();
            double vx = in.readDouble();
            double vy = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            result[i] = new Planet(xp, yp, vx, vy, m, img);
        }
        return result;
    }

    public static double readRadius(String filepath) {
        In in = new In(filepath);
        in.readInt();//TODO:error先要把第一个读取掉
        return in.readDouble();
    }

    public static void main(String[] args) {
        double T= Double.parseDouble(args[0]),
                dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius("./data/planets.txt");
        Planet[] planets = readPlanets("./data/planets.txt");
        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        int num = planets.length;
        while(t <= T){
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for(int i = 0; i < num; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < num; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // draw the backgroud picture
            StdDraw.picture(0, 0, "images/starfield.jpg");

            // draw all the planets
            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (Planet planet : planets) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planet.xxPos, planet.yyPos, planet.xxVel,
                    planet.yyVel, planet.mass, planet.imgFileName);
        }
    }
}