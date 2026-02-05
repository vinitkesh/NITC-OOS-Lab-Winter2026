import java.util.*;
import java.util.stream.Collectors;

public class Assg1 {

    // 1) Factorial
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i; // multiply 1..n
        return result;
    }

    // 2) Binary Search (iterative) - array must be sorted ascending
    public static int binarySearch(int[] sorted, int key) {
        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (sorted[mid] == key) return mid;
            if (sorted[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // 3) Students: read + sort by roll number
    public static class Student {
        String name;
        int roll;

        Student(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }

        @Override
        public String toString() {
            return "Roll=" + roll + ", Name=" + name;
        }
    }

    public static Student[] readStudents(Scanner sc, int n) {
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student " + (i + 1) + " name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter student " + (i + 1) + " roll: ");
            int roll = Integer.parseInt(sc.nextLine().trim());
            students[i] = new Student(name, roll);
        }
        return students;
    }

    public static void sortStudentsByRoll(Student[] students) {
        Arrays.sort(students, Comparator.comparingInt(s -> s.roll));
    }

    // 4) Check if vowel present in a string
    public static boolean containsVowel(String s) {
        if (s == null) return false;
        String lower = s.toLowerCase(Locale.ROOT);
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        }
        return false;
    }

    // 5) Reverse string
    public static String reverseString(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    // 6) Fibonacci series (first n terms)
    public static long[] fibonacciSeries(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long[] f = new long[n];
        if (n == 0) return f;
        f[0] = 0;
        if (n == 1) return f;
        f[1] = 1;
        for (int i = 2; i < n; i++) f[i] = f[i - 1] + f[i - 2];
        return f;
    }

    // 7) Menu-driven arithmetic using switch
    // op: 1=add, 2=sub, 3=mul, 4=div
    public static double calculate(int a, int b, int op) {
        switch (op) {
            case 1: return a + b;
            case 2: return a - b;
            case 3: return (double) a * b;
            case 4:
                if (b == 0) throw new ArithmeticException("Division by zero");
                return (double) a / b;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    // 8) Transpose of a 2D matrix
    public static int[][] transpose(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            throw new IllegalArgumentException("Matrix must be non-empty");
        int rows = A.length;
        int cols = A[0].length;
        int[][] B = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            if (A[i].length != cols) throw new IllegalArgumentException("Jagged matrix not supported");
            for (int j = 0; j < cols; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }

    // 9) Frequency of each character in a word (keeps insertion order)
    public static Map<Character, Integer> charFrequency(String word) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        if (word == null) return freq;
        for (char ch : word.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }

    // 10) Swap two strings without using a third variable
    public static String[] swapStringsNoTemp(String a, String b) {
        if (a == null || b == null) throw new IllegalArgumentException("Strings must be non-null");
        int lenB = b.length();
        a = a + b;
        b = a.substring(0, a.length() - lenB);
        a = a.substring(b.length());
        return new String[]{a, b};
    }

    // ---------- Helpers for interactive I/O ----------
    private static int[][] readMatrix(Scanner sc, int r, int c) {
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("A[" + i + "][" + j + "]= ");
                m[i][j] = Integer.parseInt(sc.nextLine().trim());
            }
        }
        return m;
    }

    private static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Assignment 1 Menu =====");
        System.out.println("1. Factorial");
        System.out.println("2. Binary Search");
        System.out.println("3. Student sort by roll");
        System.out.println("4. Vowel present in string");
        System.out.println("5. Reverse string");
        System.out.println("6. Fibonacci series");
        System.out.println("7. Arithmetic (switch menu)");
        System.out.println("8. Transpose matrix");
        System.out.println("9. Character frequency");
        System.out.println("10. Swap strings (no temp)");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                continue;
            }

            try {
                switch (choice) {
                    case 0:
                        System.out.println("Exiting...");
                        return;

                    case 1: {
                        System.out.print("Enter n: ");
                        int n = Integer.parseInt(sc.nextLine().trim());
                        System.out.println("Factorial = " + factorial(n));
                        break;
                    }

                    case 2: {
                        System.out.print("Enter array size: ");
                        int n = Integer.parseInt(sc.nextLine().trim());
                        int[] arr = new int[n];
                        System.out.println("Enter " + n + " integers (SORTED ascending):");
                        for (int i = 0; i < n; i++) {
                            System.out.print("arr[" + i + "]= ");
                            arr[i] = Integer.parseInt(sc.nextLine().trim());
                        }
                        System.out.print("Enter key to search: ");
                        int key = Integer.parseInt(sc.nextLine().trim());
                        int idx = binarySearch(arr, key);
                        System.out.println(idx >= 0 ? "Found at index " + idx : "Not found");
                        break;
                    }

                    case 3: {
                        System.out.print("Enter number of students n: ");
                        int n = Integer.parseInt(sc.nextLine().trim());
                        Student[] students = readStudents(sc, n);
                        sortStudentsByRoll(students);
                        System.out.println("Sorted by roll:");
                        for (Student s : students) System.out.println(s);
                        break;
                    }

                    case 4: {
                        System.out.print("Enter a string: ");
                        String s = sc.nextLine();
                        System.out.println(containsVowel(s) ? "Vowel present" : "No vowel present");
                        break;
                    }

                    case 5: {
                        System.out.print("Enter a string: ");
                        String s = sc.nextLine();
                        System.out.println("Reversed: " + reverseString(s));
                        break;
                    }

                    case 6: {
                        System.out.print("Enter number of terms n: ");
                        int n = Integer.parseInt(sc.nextLine().trim());
                        long[] f = fibonacciSeries(n);
                        System.out.println("Fibonacci: " + Arrays.toString(f));
                        break;
                    }

                    case 7: {
                        System.out.print("Enter a: ");
                        int a = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter b: ");
                        int b = Integer.parseInt(sc.nextLine().trim());
                        System.out.println("1=Add 2=Subtract 3=Multiply 4=Divide");
                        System.out.print("Choose operation: ");
                        int op = Integer.parseInt(sc.nextLine().trim());
                        System.out.println("Result: " + calculate(a, b, op));
                        break;
                    }

                    case 8: {
                        System.out.print("Enter rows: ");
                        int r = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter cols: ");
                        int c = Integer.parseInt(sc.nextLine().trim());
                        int[][] A = readMatrix(sc, r, c);
                        int[][] B = transpose(A);
                        System.out.println("Transpose:");
                        printMatrix(B);
                        break;
                    }

                    case 9: {
                        System.out.print("Enter a word: ");
                        String word = sc.nextLine();
                        Map<Character, Integer> freq = charFrequency(word);
                        System.out.println(
                            freq.entrySet()
                                .stream()
                                .map(e -> e.getKey() + " -> " + e.getValue())
                                .collect(Collectors.joining(", "))
                        );
                        break;
                    }

                    case 10: {
                        System.out.print("Enter string a: ");
                        String a = sc.nextLine();
                        System.out.print("Enter string b: ");
                        String b = sc.nextLine();
                        String[] swapped = swapStringsNoTemp(a, b);
                        System.out.println("After swap: a=" + swapped[0] + ", b=" + swapped[1]);
                        break;
                    }

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
