import java.io.*;

public class ExceptionHandling {
    public static void main(String[] args) throws IOException {
        int i = 12;
        int j = 4;

        try {
            int result = i / (j - 2);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        int total = 0;
        String FileName = "D:\\Learning\\Java\\company-learning\\Module9\\ErrorAndExceptionHandling\\src\\numbers.txt";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(FileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
