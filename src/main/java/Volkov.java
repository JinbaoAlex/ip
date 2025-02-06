import java.util.Scanner;

public class Volkov {
    private static String[] storeText = new String[100];
    private static int storeTextIndex = 0;
    public static String basicResponse(String msg) {
        return "    ____________________________________________________________\n"
                + msg + "\n"
                + "    ____________________________________________________________\n";
    }

    public static void main(String[] args) {
        String opening = "    ____________________________________________________________\n"
                + "    Hello! I'm Volkov\n"
                + "    What can I do for you?\n"
                + "    ____________________________________________________________\n";
        System.out.println(opening);

        Scanner sc = new Scanner(System.in);

        while (true) {
            boolean shouldBreak = false;
            String input = sc.nextLine();

            switch (input) {
                case "bye":
                    System.out.println(basicResponse("    Bye. Hope to see you again soon!"));
                    shouldBreak = true;
                    break;
                case "list":
                    StringBuilder sb = new StringBuilder();
                    boolean first = true;
                    for (int i = 0; i < storeTextIndex; i++) {
//                        reply = reply + "    " + storeText[i] + "\n";
                        if (first) {
                            first = false;
                        } else {
                            sb.append("\n");
                        }
                        sb.append(storeText[i]);
                    }
                    System.out.println(basicResponse(sb.toString()));
                    break;
                default:
                    String reply = basicResponse("    " + input);
                    System.out.println(reply);
                    storeText[storeTextIndex] = (storeTextIndex + 1) + ". " + input;
                    storeTextIndex++;
            }

            if (shouldBreak) {
                break;
            }
        }
    }
}
