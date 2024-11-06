# 开发图形用户界面：java.swing

## 框架容器
* java.swing.Frame:界面整体框架（javax:x means扩展）
 * 构造函数：constructor()
 * 通过setVisible()来显示
 * eg.
  ``` JAVA
  public class GUI extends JFrame {
    GUI() {
        super("Hello, World!");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(300, 300);
    }
  }
  ```


* 和Frame有关的其他类：
  * `JDialog`: 用于创建对话框窗口。
  * `JPanel`: 用于创建面板，可以在其中添加其他组件。
  * `JWindow`: 用于创建无边框窗口。
  * `JApplet`: 用于创建嵌入在网页中的应用程序。
  * `JInternalFrame`: 用于创建内部窗口，可以嵌入到另一个窗口中。

## 控件：界面上可以和用户进行操作的组件
* 控件要加到一个容器，面板上，将面板加到界面上，面板是：javax.swing.JPanel
 * BUTTON:javax.swing.JButton
 * 文本框:javax.swing.JTextField
 * 静态文本:javax.swing.JLabel
 * 复选框:javax.swing.JChatBox
 * 菜单
 * 下拉菜单:javax.swing.JComboBox
 * 滚动条
 * 密码框：javax.swing.JPasswardField
* eg.
  ``` JAVA
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
  
  ```
*注意：先插文档，了解功能，添加到界面*

## 渲染：颜色，字体，图标

### 颜色:java.awt.color
* 设置背景颜色：setBackground
* 设置前景颜色: setFrontground

### 字体:java.awt.font
* 设置字体：setFont

### 图标：java.
* 某些控件在构造函数中支持设置图标，具体见文档
 * Button
 * eg.
 * 
 ``` JAVA
   private ImageIcon icon1 = new ImageIcon(getClass().getResource("/JAVA应用开发/图形用户界面开发/image.jpg"));
   private JButton button = new JButton("新生注册", icon1);
 
```
 ## 布局
 * 如何自己控制控件在界面上的位置
  * 默认控件位置是从上到下，从左到右，放不下另起一行：流布局
  * 如何自己布局：
   * 将界面布局设置为布局
   * 用setSize设置控件大小,setLocation设置位置