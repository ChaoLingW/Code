package com.hpe.java5;

public class Manager extends Employee{
	
	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public Manager() {
		super();
	}

	public Manager(String name, String id, double salary) {
		super(name, id, salary);
	}

	public Manager(double bonus) {
		super();
		this.bonus = bonus;
	}

	public Manager(String name, String id, double salary, double bonus) {
		super(name, id, salary);
		this.bonus = bonus;
	}

	@Override
	public void work() {
		System.out.println("Manager work");
	}

}
