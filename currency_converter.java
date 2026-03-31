import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class InputHandler {
    Scanner sc = new Scanner(System.in);

    double inputAmount() {
        System.out.print("Enter the amount to convert: ");
        return sc.nextDouble();
    }

    String inputCurrency(String prompt) {
        System.out.print(prompt);
        return sc.next().toUpperCase(); 
    }
}

public class currency_converter {
    public static void main(String[] args) {
        InputHandler input = new InputHandler();

        double amount = input.inputAmount();
        String baseCurrency = input.inputCurrency("Enter the base currency (e.g., USD, INR): ");
        String targetCurrency = input.inputCurrency("Enter the target currency (e.g., USD, INR): ");

      
        String API_KEY = "YOUR API KEY"; 
        String urlString = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCurrency;

        try {
            URL reqUrl = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) reqUrl.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String res = response.toString();

            
            String search = "\"" + targetCurrency + "\":";
            int index = res.indexOf(search);
            if (index == -1) {
                System.out.println("Target currency not found in API response.");
                return;
            }

            int start = index + search.length();
            int end = res.indexOf(",", start);
            if (end == -1) end = res.indexOf("}", start); 

            double rate = Double.parseDouble(res.substring(start, end));
            double convertedAmount = amount * rate;

            System.out.printf("%,.2f %s = %,.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        } catch (Exception e) {
            System.out.println("Something went wrong with the API request: " + e.getMessage());
        }
    }
}