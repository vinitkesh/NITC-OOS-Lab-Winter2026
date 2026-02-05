import java.util.Scanner;

public class Assg2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Assignment 2 Menu ---");
            System.out.println("1. Check Substring Existence");
            System.out.println("2. Replace Substring");
            System.out.println("3.Longest Common Substring in 2D Array");
            System.out.println("4. Find Max Element (Recursive)");
            System.out.println("5. Reverse String (Recursive)");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    problemOne(scanner );
                    break;
                case 2:
                    problemTwo(scanner);
                    break;
                case 3:
                    problemThree();
                    break;
                case 4:
                    problemFour(scanner);
                    break;
                case 5:
                    problemFive(scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    // 1. Check if substring exists
    public static void problemOne(Scanner sc) {
        System.out.print("Enter main string: ");
        String mainStr = sc.nextLine();
        System.out.print("Enter substring to find: ");
        String subStr = sc.nextLine();
        System.out.println("Result: " + mainStr.contains(subStr));
    }

    // 2. Replace all occurrences
    public static void problemTwo(Scanner sc) {
        System.out.print("Enter original string: ");
        String input = sc.nextLine();
        System.out.print("Target substring: ");
        String target = sc.nextLine();
        System.out.print("Replacement substring: ");
        String replacement = sc.nextLine();
        System.out.println("Result:" + input.replace(target, replacement));
    }

    // 3. Longest Common Substring in 2D Rows
    public static void problemThree() {
        String[][] strArray = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"interview", "interrupt",  "integrate", "interval"}
        };

        System.out.println("Processing 2D Array...");
        for (int i = 0; i < strArray.length; i++) {
            String lcs = findLongestCommonSubstring(strArray[i]);
            System.out.print("Row " + i + " Result: [");
            for (int j = 0; j < strArray[i].length; j++) {
                if (!lcs.isEmpty()) {
                    strArray[i][j] = strArray[i][j].replaceFirst( lcs, lcs.toUpperCase());
                }
                System.out.print("\"" + strArray[i][j] + "\"" + (j == strArray[i].length - 1 ? "" : ", "));
            }
            System.out.println("]");
        }
    }

    private static String findLongestCommonSubstring(String[] arr) {
        if (arr == null || arr.length == 0) return "";
        String first = arr[0];
        String longest = ""   ;

        for (int i = 0; i < first.length(); i++) {
            for (int j = i + 1; j <= first.length(); j++) {
                String stem = first.substring(i, j);
                boolean isCommon = true;
                for (int k = 1; k < arr.length; k++) {
                    if (!arr[k].contains(stem)) {
                        isCommon = false;
                        break;
                    }
                }
                if (isCommon && stem.length() > longest.length()) {
                    longest = stem;
                }
            }
        }
        return longest ;
    }

    // 4. Max Element Recursive
    public static void problemFour(Scanner sc) {
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Max Element: " + findMax(arr, n));
    }

    private static int findMax(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.max(arr[n - 1], findMax(arr, n - 1));
    }

    // 5. Reverse String Recursive
    public static void problemFive(Scanner sc) {
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        System.out.println("Reversed: " + reverseString(input));
    }

    private static String reverseString(String str) {
        if (str.isEmpty()) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}