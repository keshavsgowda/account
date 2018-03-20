import java.util.*;

public class Account
{
	int acc, phone;
	String name;
	public float balance;
	Scanner sc = new Scanner(System.in);
	
	void getDetails() {
		System.out.println("Enter name: ");
		name = sc.nextLine();
		System.out.println("Enter account number: ");
		acc = sc.nextInt();
		System.out.println("Enter phone number: ");
		phone = sc.nextInt();
		System.out.println("Enter balance: ");
		balance = sc.nextFloat();
		if(balance < 0)
		{
			System.out.println("Value cannot be less than zero! Defaulting to zero.\n");
			balance = 0;
		}
	}
	
	void deposit() {
		float dep;
		System.out.println("Enter amount to deposit: ");
		dep = sc.nextFloat();
		if(dep<=0)
			System.out.println("Cannot deposit! Balance: "+balance+"\n");
		else
		{
			balance+=dep;
			System.out.println("Updated balance: "+balance+"\n");
		}
	}
	
	void withdraw() {
		float with;
		System.out.println("Enter amount to withdraw: ");
		with = sc.nextFloat();
		if(with <= balance && with >= 0)
		{
			balance-=with;
			System.out.println("Updated balance: "+balance+"\n");
		}
		else
			System.out.println("Cannot withdraw! Balance: "+balance+"\n");
	}
	
	void showDetails() {
		System.out.println("Name: "+name+"\nAccountNo: "+acc+"\nPhoneNo: "+phone+"\nBalace: "+balance+"\n");
	}
	
	public static void main (String[] args) 
	{
		System.out.println("Enter number of employees: ");
		Scanner s1 = new Scanner(System.in);
		int num = s1.nextInt();
		Account[] A = new Account[num];
		for(int i = 0; i < num; i++)
			A[i] = new Account();
		int ch, n;
		for(int i = 0; i < num; i++)
			A[i].getDetails();
		System.out.println("\nBalance less than 10000: ");
		for(int i = 0; i < num; i++)
		{
			if(A[i].balance < 10000)
				A[i].showDetails();
		}
		boolean flag = true;
		while(flag) {
			System.out.println("\nEnter choice: \n1) Withdraw \n2) Deposit: \n3) Show Details \n4) Exit: ");
			ch = s1.nextInt();
			switch(ch) {
				case 1 : System.out.println("Enter employee number (" + (num) + "): ");
						 n = s1.nextInt(); 
						 n -= 1;
						 if(n < num && n >= 0)
							 A[n].withdraw();
						 else
							 System.out.println("Wrong employee number!");
					     break;
				case 2 : System.out.println("Enter employee number (" + (num) + "): ");
						 n = s1.nextInt(); 
						 n -= 1;
						 if(n < num && n >= 0)
							 A[n].deposit();
						 else
							 System.out.println("Wrong employee number!");
						 break;
				case 3 : System.out.println("Enter employee number (" + (num) + "): ");
				 		 n = s1.nextInt(); 
				 		 n -= 1;
				 		 if(n < num && n >= 0)
				 			 A[n].showDetails();
				 		 else
							 System.out.println("Wrong employee number!");
				 		 break;
				case 4 : flag = false;
					 	 break;
				default : System.out.println("Incorrect choice!");
					  	  break;
			}
		}
	}
}
