// 範例 2：使用 java.io 實作檔案讀寫功能

import java.io.*;

public class Example2 {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String content = "Hello world";

        // 寫入檔案
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("成功寫入檔案：" + fileName);
        } catch (IOException e) {
            System.out.println("寫入檔案時發生錯誤：" + e.getMessage());
        }

        // 讀取檔案
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("檔案內容如下：");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("讀取檔案時發生錯誤：" + e.getMessage());
        }
    }
}
