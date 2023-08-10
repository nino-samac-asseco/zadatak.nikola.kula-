package praksa.zadatak.maven.eclipse;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TecajnaListaIspis {

    private static final String API_URL = "https://api.hnb.hr/tecajn-eur/v3";

    public static void showTecajnaLista() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            TecajnaLista[] tecajnaLista = gson.fromJson(response.toString(), TecajnaLista[].class);

            System.out.println("Odnos EUR naprema:");

            for (TecajnaLista rate : tecajnaLista) {
                System.out.println(rate.getValuta() + ": " + rate.getSrednji_tecaj());
            }

            System.out.println("Pritisnite Enter za povratak na izbornik.");
            new Scanner(System.in).nextLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
