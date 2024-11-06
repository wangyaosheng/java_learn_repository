package JAVA应用开发.图形用户界面开发;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test1 {
  /* 让按钮从界面上面掉下，并在panel最底下返回上部 */
  
  private void run() {
    new Thread(() -> {
      try {
        while (true) {
          if (button.getY() >= panel.getHeight() - button.getHeight()) {
            button.setLocation(button.getX(), 0);
          } else {
            button.setLocation(button.getX(), button.getY() + 1);
          }
          Thread.sleep(10);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
  }
  private int y=0;
  private int j=0;
  private ImageIcon icon1 = new ImageIcon("src/JAVA应用开发/图形用户界面开发/image.jpg");
  private JPanel panel = new JPanel();
  private JLabel label = new JLabel("中南大学注册系统");
  private JButton button = new JButton("新生注册", icon1);

  public test1() {
    // 将所有组件添加到 panel 中
    panel.add(button);
    button.setLocation(100,y);
    panel.setLayout(null);
    button.setSize(100, 50);
    panel.add(label);

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setContentPane(new test1().panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
    test1 t = new test1();
    t.run();
  }
}
