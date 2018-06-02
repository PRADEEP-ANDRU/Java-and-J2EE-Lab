package ResultPackage;

public class InvalidSGPA extends Exception {

	public String toString() {
		return "InvalidSGPA: SGPA cannot exceed 10";
	}
}
