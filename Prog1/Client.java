import ResultPackage.*;
import StudentPackage.*;
public class Client {

	public static void main(String[] args) throws CreditLimit, NumberFormatException,InvalidSGPA{
		// TODO Auto-generated method stub
			RegisterStudent rs=new RegisterStudent("PRADEEP", "ISE");
			Result r1=new Result(rs);
			rs.setSGPA(r1.getSGPA());
			rs.setCGPA(r1.getCGPA());
	
		

	}

}
