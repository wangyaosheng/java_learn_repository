package JAVA应用开发.图形用户界面开发;

import javax.swing.*;

public class GUI extends JFrame {

  private JPanel panel = new JPanel();
  private JLabel label = new JLabel("Hello, World!");
  private JButton button = new JButton("新生注册");
  private JTextField textField = new JTextField("Please input your name");
  private JComboBox<String> comboBox = new JComboBox<String>();
  private JCheckBox checkBox = new JCheckBox("是否购买会员");
  private JTextArea textArea = new JTextArea("输入个人分数",20,10);

  public GUI() {
    // 将所有组件添加到 panel 中
    panel.add(comboBox);
    comboBox.addItem("美国");
    comboBox.addItem("中国");
    comboBox.addItem("日本");
    comboBox.addItem("韩国");
    panel.add(checkBox);
    panel.add(button);
    panel.add(textField);
    panel.add(label);
    panel.add(textArea);

    // 将 panel 添加到 JFrame 中
    add(panel);

    setSize(300, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocation(300, 300);
}

  public static void main(String[] args) {
    new GUI();
  }
}
