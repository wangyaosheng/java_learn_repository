package JAVA应用开发.图形用户界面开发;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;

public class GUI extends JFrame {
  private ImageIcon icon1 = new ImageIcon(getClass().getResource("/JAVA应用开发/图形用户界面开发/image.jpg"));
  private JPanel panel = new JPanel();
  private JLabel label = new JLabel("中南大学注册系统");
  private JButton button = new JButton("新生注册", icon1);
  private JTextField textField = new JTextField("Please input your name");
  private JComboBox<String> comboBox = new JComboBox<String>();
  private JCheckBox checkBox = new JCheckBox("是否购买会员");
  private JTextArea textArea = new JTextArea("输入个人分数", 20, 10);

  public GUI() {
    // 将所有组件添加到 panel 中
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(comboBox, gbc);
    comboBox.addItem("美国");
    comboBox.addItem("中国");
    comboBox.addItem("韩国");
    gbc.gridy++;
    panel.add(checkBox, gbc);
    gbc.gridy++;
    panel.add(button, gbc);
    gbc.gridy++;
    panel.add(textField, gbc);
    gbc.gridy++;
    panel.add(label, gbc);
    gbc.gridy++;
    panel.add(textArea, gbc);

    panel.setBackground(new Color(255, 255, 0));
    label.setForeground(Color.RED);
    button.setForeground(Color.GREEN);
    textField.setFont(new Font("楷体", Font.BOLD, 20));
    textArea.setFont(new Font("宋体", Font.BOLD, 20));

    // 将 panel 添加到 JFrame 中
    add(panel);

    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocation(300, 300);
  }

  public static void main(String[] args) {
    new GUI();
  }
}
