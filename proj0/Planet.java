import static java.lang.Math.pow;

public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    private static final double G = 6.67e-11;
    public Planet(){}
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet planet) {
        double dx = planet.xxPos - this.xxPos;
        double dy = planet.yyPos - this.yyPos;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double calcForceExertedBy(Planet planet) {
        double r = calcDistance(planet);
        return G * this.mass * planet.mass / pow(r, 2);
    }

    public double calcForceExertedByX(Planet planet) {
        double dx = planet.xxPos - this.xxPos;
        double Force = calcForceExertedBy(planet);
        double r = calcDistance(planet);
        return Force * dx / r;
    }

    public double calcForceExertedByY(Planet planet) {
        double dy = planet.yyPos - this.yyPos;
        double Force = calcForceExertedBy(planet);
        double r = calcDistance(planet);
        return Force * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double total = 0;
        for (Planet planet : planets) {
            if (equals(planet)) continue;
            total += calcForceExertedByX(planet);
        }
        return total;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double total = 0;
        for (Planet planet : planets) {
            if (equals(planet)) continue;
            total += calcForceExertedByY(planet);
        }
        return total;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += dt * aX;
        yyVel += dt * aY;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
