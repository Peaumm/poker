package project.tool;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public abstract class Functions {
  static Scanner scan = new Scanner(System.in);

  public static int alea(int min, int max) {
    return (int) (Math.random()* (max - min + 1) + min);
  }

  public static String demanderString(String question) {
    System.out.println(question);
    String reponse = scan.next();
    System.out.print("\n");
    return reponse;
  }

  public static int demanderInt(String question) {
    System.out.println(question);
    int reponse = scan.nextInt();
    System.out.print("\n");
    return reponse;
  }

}
