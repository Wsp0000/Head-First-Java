package practice.ch15;

import java.io.*;
import java.net.Socket;

public class DailyAdviceClient {

    public void go() {

        try {
            Socket socket = new Socket("127.0.0.1",4242);

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
//            inputStreamReader.readLine();
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String advice = reader.readLine();
            System.out.println("Today you should: " +advice);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
