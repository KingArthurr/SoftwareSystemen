package ss.week2;


public class Rectangle {
	//@ private invariant length > 0;
	private int length;
	//@ private invariant width > 0;
	private int width;	
	
	//@ requires length > 0;
	//@ requires width > 0;
	
	//@ ensures length() == length;
	//@ ensures width() == width;
	public Rectangle (int length, int width){
		assert length() == length;
		assert width() == width;
		this.length = length;
		this.width = width;
	}
	
	//@ ensures \result > 0;
	/*@ pure */ public int length(){
		assert length > 0;
		return this.length;
	}
	
	//@ ensures \result > 0;
	/*@ pure */ public int width(){
		assert width > 0;
		return this.width;	
	}
	
	//@ ensures \result > 0 && \result <= width() * length();
	public int area(){
		int area = this.length*this.width;
		assert area > 0 && area <= width() * length();
		return area;
	}
	
	//@ ensures \result > 0;
	public int perimeter(){
		int perimeter = 2*(this.length+this.width);
		assert perimeter > 0;
		return perimeter;
	}

}