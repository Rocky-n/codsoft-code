import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== Currency Converter (Real-Time) ===");
            System.out.print("Enter base currency (e.g., USD): ");
            String base = sc.next().toUpperCase();

            System.out.print("Enter target currency (e.g., INR): ");
            String target = sc.next().toUpperCase();

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            
            String urlStr = "https://open.er-api.com/v6/latest/" + base;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            StringBuilder sb = new StringBuilder();
            Scanner apiScanner = new Scanner(reader);
            while (apiScanner.hasNext()) {
                sb.append(apiScanner.nextLine());
            }
            apiScanner.close();

            String response = sb.toString();

    
            String searchKey = "\"" + target + "\":";
            int index = response.indexOf(searchKey);

            if (index == -1) {
                System.out.println("Currency not found in response!");
                sc.close();
                return;
            }

            int start = index + searchKey.length();
            int end = response.indexOf(",", start);
            if (end == -1) {
                end = response.indexOf("}", start);
            }

            String rateStr = response.substring(start, end).trim();
            double rate = Double.parseDouble(rateStr);

            double converted = amount * rate;
            System.out.println(amount + " " + base + " = " + converted + " " + target);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
