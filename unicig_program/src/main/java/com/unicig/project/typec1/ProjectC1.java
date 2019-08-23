package com.unicig.project.typec1;

import com.unicig.project.Project;

public class ProjectC1  {
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
	//Second pipe
	public double canal[][];
	public double canalRoug;
	public double canalCondTerm;
	
	
	public ProjectC1() {
		super();
		conduct=new double[MAX_FLOORS+2][10];
		canal=new double[MAX_FLOORS+2][10];
		for(int ir=0;ir<conduct.length;ir++) {
			for(int am=0;am<conduct[ir].length;am++) {
				conduct[ir][am]=0.0;
				canal[ir][am]=0.0;
			}
		}
	}
	
	
	
}
