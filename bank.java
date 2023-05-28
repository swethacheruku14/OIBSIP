import java.util.*;
class demo{
	String name,pass;
	double balance;
	demo(String name1,String pass1,double xx1){
		this.name=name1;
		this.pass=pass1;
		this.balance=xx1;
	}

  void deposit(double xx){
  System.out.println("Amount Deposited");
  balance=balance+xx;
 }

 void withdraw(double xx){
  if(xx>balance){
   System.out.println("Amount exceeded to withdraw");
  }
  else{
   System.out.println("Amount withdrawn");
   balance=balance-xx;
  }
 }
}
class bank{
 public static void main(String args[]){
  Scanner sc=new Scanner(System.in);
  System.out.println("enter number of users");
  int m=sc.nextInt();
  demo[] x=new demo[m];
  int i;
  for(i=0;i<m;i++){
	  System.out.println("enter username,password and initial balance of "+(i+1));
	  String user=sc.next();
	  String pass=sc.next();
	  double balance=sc.nextDouble();
	  demo d1=new demo(user,pass,balance);
	  x[i]=d1;
  }
  
  System.out.println("--Enter user name and password--");
  String username=sc.next();
  String pwd=sc.next();
  int f=0,count=0;
  for(i=0;i<m;i++){
	  String name1=x[i].name;
	  String pass1=x[i].pass;
	  if(name1.equals(username) && pass1.equals(pwd)){
		  count=1;
		  f=i;
		  System.out.println("");
		  System.out.println("----Logged In Successfully----");
		  break;
	  }
  }
  if(count==0){
   System.out.println("--Mismatched User Credentials");
  }
  else{
   List<String> ts=new LinkedList<String>();
   Date d=new Date();
   System.out.println("");
   System.out.println("--Enter Choice--");
   System.out.println("1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Exit\n");
   int ch=sc.nextInt();
   while(ch!=5){
     switch(ch){
	  case 1:System.out.println("enter amount to deposit");
	         double amount=sc.nextDouble();
			 x[f].deposit(amount);
			 ts.add("Deposited "+amount+"  "+ d.toString());
			 break;
	  case 2:System.out.println("enter amount to withdraw");
	         double am=sc.nextDouble();
			 x[f].withdraw(am);
			 ts.add("Withdrawn "+am+"  "+d.toString());
			 break;
	  case 3:System.out.println("enter user name to transfer");
	          String u=sc.next();
			  String temp=x[f].name;
			  if(temp.equals(u)){
				  System.out.println("to same account cannot be transferred amount");
			  }
			  else{
			   System.out.println("enter amount to transfer ");
			   double xx=sc.nextDouble();
			   for(i=0;i<m;i++){
				   String name1=x[i].name;
				   if(u.equals(name1) && i!=f){

					   if(xx>x[f].balance){
						   System.out.println("Amount Exceed balance");
					   }
					   else{
						x[i].deposit(xx);
					   //System.out.println("balance=="+x[i].balance);
					   x[f].balance=x[f].balance-xx;
					   System.out.println(xx+" Amount transferred Successfully");
					   ts.add("Transferred "+xx+"  "+d.toString());
					   }
					   break;
				   }
			   }
			  }
			  break;
	  case 4:System.out.println("Transaction History\n");
	         System.out.println("Balance "+x[f].balance);
	         for(String mm:ts){
			  System.out.println(mm);
			 }
			 break;
	  case 5:break;
	  default:System.out.println("Invalid input");
	           break;
	 }
	 System.out.println("");
	 System.out.println("");
	 System.out.println("--Enter Choice--");
   System.out.println("1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Exit\n");
   ch=sc.nextInt();
   }
  }

 }
}