package ui;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {

  }

  public static int inputLadderWidth() {
    System.out.println("사다리의 넓이는 몇 개인가요?");
    return Integer.parseInt(scanner.nextLine());
  }

  public static int outputLadderHeight() {
    System.out.println("사다리의 높이는 몇 개인가요?");
    return Integer.parseInt(scanner.nextLine());
  }
}
