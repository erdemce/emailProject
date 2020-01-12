package email;
import java.util.Scanner;

public class Email {
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private String[] departments = { "none", "Development", "Accounting", "Sales" };
	private String department;
	private String companyname = "erdem";
	private int mailboxCapacity=512;
	private String alternateEmail;

	public Email(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = askDepartment();
		this.email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + "."
				+ companyname.toLowerCase() + ".com";
		System.out.println(this.email);
		this.password = setRandompassword();
		System.out.println(this.password);
	}

	private String setRandompassword() {
		String pass = "";
		String allChar = "ABCDEFGHIJKLMNOQPRSTUWXYZabcdefghijklmnoqprstuwxyz0123456789#.:,;!?-_";
		char[] charArray = allChar.toCharArray();
		for (int i = 0; i < 10; i++) {
			int random = (int) (Math.random() * charArray.length);
			pass = pass + charArray[random];
		}
		return pass;
	}

	public String askDepartment() {
		System.out.println("Select your department");
		for (int i = 0; i < departments.length; i++) {
			System.out.println(i + 1 + "for " + departments[i]);
		}
		Scanner scan = new Scanner(System.in);

		int departmentsIndex = scan.nextInt();
		if (departmentsIndex == 1) {
			return "";
		} else {
			return departments[departmentsIndex - 1];
		}
	}

	public String getPassword() {
		return password;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	public void showInfo() {
		String information="DISPLAY NAME: "+firstname+" "+lastname+
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY: "+mailboxCapacity+"MB";
		System.out.println(information);
	}
	
}
