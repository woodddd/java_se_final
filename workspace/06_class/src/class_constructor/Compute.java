package class_constructor;

public class Compute {
private int x;
private int y;
private int sum;
private int sub;
private int mul;
private double div;

public Compute(int x, int y) {
	this.x = x;
	this.y = y;
}
public void calc() {
	this.sum = x + y;
	this.sub = x - y;
	this.mul = x * y;
	this.div = Double.parseDouble(String.format("%.2f",(double)x / y));
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public int getSum() {
	return sum;
}

public int getSub() {
	return sub;
}

public int getMul() {
	return mul;
}

public double getDiv() {
	return div;
}

}
