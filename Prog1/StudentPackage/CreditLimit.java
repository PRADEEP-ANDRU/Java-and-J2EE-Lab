package StudentPackage;

public class CreditLimit extends Exception{
	int c;
	public CreditLimit(int c) {
		// TODO Auto-generated constructor stub
	this.c=c;
	}
	public String toString() {
		return "CreditLimit Exception-Credits Registered cannot be more than 30!";
	}
}
