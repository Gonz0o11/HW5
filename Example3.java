// 範例 3：使用 java.net 建立簡單的網路 Socket 通訊

import java.io.*;
import java.net.*;

public class Example3 {
    public static void main(String[] args) {
        // 啟動 Server 端
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(12345)) {
                System.out.println("伺服器已啟動，等待連線...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("已連接到客戶端：" + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("收到訊息：" + message);

                out.println("伺服器回覆：" + message.toUpperCase());

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // 啟動 Client 端
        try (Socket socket = new Socket("localhost", 12345)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello, Server!");
            String response = in.readLine();
            System.out.println("來自伺服器的回應：" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
