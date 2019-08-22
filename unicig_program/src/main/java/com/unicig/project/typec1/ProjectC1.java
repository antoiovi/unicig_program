package com.unicig.project.typec1;

public class ProjectC1 {
	static final int HEIGHT=0;
	static final int DIAM=1;
	static final int SIDEA=2;
	static final int SIDEB=3;
	static final int TICK=4;
	static final int CURVRED=5;
	static final int CONTACT=6;
	
	static final int MAX_FLOORS=6;
	
	int N_Floors;
	//Main Conduct
	public double conduct[][];
	public double condRoug;
	public double condCondTerm;
	
	
	public ProjectC1() {
		super();
		conduct=new double[MAX_FLOORS][7];
		
	}
	
	
	
}
