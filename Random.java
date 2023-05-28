import java.util.*;

class play {
  int count;

  play(int c) {
    count = c;
  }

  void check() {
    Scanner sc = new Scanner(System.in);
    int t = 5,x=0,found=0;
    int num = 1 + (int) (100 * Math.random());
    //System.out.println("num:" + num);
    System.out.println("Total 5 trails you have to guess Number\n");
    for (int i = 0; i < t; i++) {
      System.out.println("\nEnter Number between 1-100");
      int m = sc.nextInt();
      if (m <= 100) {
        if (m == num) {
          count++;
		  x+=(10-i)*10;
		  found=1;
          break;
        } else if (m < num) {
          System.out.println("You have guessed lesser number\n");
        } else {
          System.out.println("You have guessed greater number\n");
        }
      } else {
        try {
          throw new Exception("NUMBER GREATER THAN 100 ");

        } catch (Exception e) {
          System.out.println(e);
          break;
        }
      }
    }

    if (found!=0) {
      System.out.println("-------You have Guessed Correct Number------");
      System.out.println("******Score******");
	  System.out.println(count);
	  //points based on no.of attempts
	  System.out.println("******Points*****");
	    System.out.println(x);
    }
	else{
		System.out.println("----Attempts Exceeded--- \n----Better Luck Next Time----\n\n");
	}
  }
}

class Random_number {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("---Enter your choice---");
    System.out.println("1.PLAY\n2.REPLAY\n3.EXIT  \n");
    int ch = sc.nextInt();
    int c = 0;
    play x = new play(c);
    while (ch != 3) {
      switch (ch) {
        case 1:
          x.check();
          break;
        case 2:
          x.check();
          break;
        case 3:
          break;
      }
      System.out.println("----Enter your choice---");
      System.out.println("1.PLAY\n2.REPLAY\n3.EXIT  \n");
      ch = sc.nextInt();
    }

  }
}