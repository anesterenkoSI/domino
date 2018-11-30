package com.si.entity;

public class Domino {

	private int side1;
	private int side2;
	boolean flipped = false;
	
	public Domino(int side1, int side2){
		if(side1 > 6 || side1 < 0 || side2 > 6 || side2 < 0) {
			throw new IllegalArgumentException("Invalid: sides must be between 0 and 6.");
		}
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public void reverse(){
		int tmp;
        tmp = side1;
        side1 = side2;
        side2  = tmp;
        flipped = true;
	}
	
	public int getSide1() {
		return side1;
	}

	public void setSide1(int side1) {
		this.side1 = side1;
	}

	public int getSide2() {
		return side2;
	}

	public void setSide2(int side2) {
		this.side2 = side2;
	}

	@Override
	public boolean equals(Object o) {
		Domino domino = (Domino) o;
		return (this.side1 == domino.getSide1() && this.side2 == domino.getSide2()) || (this.side1 == domino.getSide2() && this.side2 == domino.getSide1());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = this.side1;
		result = prime * result + this.side2;
		return result;
	}

	@Override
	public String toString() {
		return "[ "+this.side1 + " | "+this.side2 +" ]";
	}

}
