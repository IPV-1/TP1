package utils;

import java.awt.geom.Point2D;

public class UnitVector2D {
	
	protected Point2D.Double point;

	public UnitVector2D(double x, double y) {
		this.point = new Point2D.Double();
		this.set(x, y);
	}

	public void sum(UnitVector2D uV2D) {
		this.set(this.getX() + uV2D.getX(), this.getY() + uV2D.getY());
	}
	
	public void invertX() {
		this.getPoint().setLocation(- this.getX(), this.getY());
	}
	
	public void invertY() {
		this.setLocation(this.getX(), - this.getY());
	}
	
	public void invert() {
		this.setLocation(- this.getX(), - this.getY());
	}
	
	protected void set(double x, double y){
		double module = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		this.setLocation(x / module, y / module);
	}


	@Override
	public String toString() {
		return "("+ this.getX() + "," + this.getY() + ")";
	}
	
	public double getX() {
		return this.getPoint().getX();
	}
	
	public double getY() {
		return this.getPoint().getY();
	}
	
	protected Point2D.Double getPoint() {
		return this.point;
	}

    protected void setLocation(double x, double y){
        this.getPoint().setLocation(x, y);
    }

}
