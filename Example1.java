// 範例 1：使用 java.awt 和 java.awt.event 實作簡單視窗按鈕事件

import java.awt.*;
import java.awt.event.*;

public class Example1 extends Frame implements ActionListener {
    private Button button;  // 按鈕元件
    private Label label;    // 標籤元件

    public Example1() {
        // 設定視窗標題與佈局
        setTitle("AWT 範例 - 按鈕事件");
        setSize(300, 150);
        setLayout(new FlowLayout());

        // 初始化元件
        button = new Button("點我");
        label = new Label("尚未點擊按鈕");

        // 加入元件到視窗
        add(button);
        add(label);

        // 設定按鈕事件監聽器
        button.addActionListener(this);

        // 關閉視窗
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        label.setText("按鈕已被點擊！");
    }

    public static void main(String[] args) {
        new Example1();
    }
}

