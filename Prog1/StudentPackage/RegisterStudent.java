package StudentPackage;
import java.util.*;
public class RegisterStudent {
	String name,branch;
	public int credits[][]=new int[4][4];
	public int marks[][]=new int[4][4];
	float sgpa[]=new float[4];
	float cgpa;
	Scanner inp=new Scanner(System.in);
	
	public RegisterStudent(String n,String b) throws CreditLimit {
		// TODO Auto-generated constructor stub
		this.name=n;
		this.branch=b;
		this.getCredits();
		this.getMarks();
	}
	void getCredits() throws CreditLimit {
		for(int i=0;i<4;i++) {
			int total=0;
			System.out.println("Enter Credits in Sem "+(i+1));
			for(int j=0;j<4;j++) {
				System.out.print("Enter Credits in Subject "+(j+1));
				credits[i][j]=inp.nextInt();
				total+=credits[i][j];
			}
			if(total>30) throw new CreditLimit(total);
		}
	}
	void getMarks() {
		for(int i=0;i<4;i++) {
			System.out.println("Enter Marks in Sem "+(i+1));
			for(int j=0;j<4;j++) {
				System.out.println("Enter Marks in Subject "+(j+1));
				marks[i][j]=inp.nextInt();
			}
		}
	}
	public void setSGPA(float s[]) {
		for(int i=0;i<4;i++) sgpa[i]=s[i];
	}
	public void setCGPA(float c) {
		cgpa=c;
	}
	void display() {
		System.out.println("Name:"+name+"\nBranche:"+branch);
		for(int i=0;i<4;i++) System.out.println("Sem "+(i+1)+" SGPA: "+sgpa[i]);
		System.out.println("CGPA: "+cgpa);
	}
	
}
