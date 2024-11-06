package JAVA应用开发.图形用户界面开发;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// 一架飞机从上面飞下来，轨迹随机，底部有一个子弹飞向飞机，打中后提示“！！！” 
public class test3 extends JPanel implements ActionListener {
  private Timer timer; // 定时器，用于控制动画刷新
  private int planeX, planeY; // 飞机的坐标
  private int bulletX, bulletY; // 子弹的坐标
  private boolean hit; // 标记是否击中

  // 构造函数，初始化游戏状态
  public test3() {
    timer = new Timer(30, this); // 每30毫秒触发一次actionPerformed方法
    timer.start(); // 启动定时器
    planeX = new Random().nextInt(400); // 随机生成飞机的初始X坐标
    planeY = new Random().nextInt(400);// 飞机的初始Y坐标为0
    bulletX = new Random().nextInt(400); // 子弹的初始X坐标
    bulletY = new Random().nextInt(400); // 子弹的初始Y坐标
    hit = false; // 初始状态未击中
  }

  // 重写paintComponent方法，绘制游戏画面
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); // 调用父类的paintComponent方法，清除背景
    if (hit) {
      g.drawString("!!!", 200, 200); // 如果击中，显示“！！！”
    } else {
      g.fillRect(planeX, planeY, 50, 20); // 绘制飞机
      g.fillRect(bulletX, bulletY, 5, 10); // 绘制子弹
    }
  }

  // 定时器触发的事件处理方法
  @Override
  public void actionPerformed(ActionEvent e) {
    planeY += 5; // 飞机向下移动
    bulletY -= 10; // 子弹向上移动
    if (bulletY < 0) {
      bulletY = 400; // 如果子弹飞出屏幕，重置子弹位置
    }
    if (planeY > 400) {
      planeY = 0; // 如果飞机飞出屏幕，重置飞机位置
      planeX = new Random().nextInt(400); // 随机生成新的飞机X坐标
    }
    // 检测子弹是否击中飞机
    if (new Rectangle(planeX, planeY, 50, 20).intersects(new Rectangle(bulletX, bulletY, 5, 10))) {
      hit = true; // 如果击中，设置hit为true
      timer.stop(); // 停止定时器
    }
    repaint(); // 重新绘制游戏画面
  }

  // 主方法，启动游戏
  public static void main(String[] args) {
    JFrame frame = new JFrame("Plane and Bullet Game"); // 创建窗口
    test3 game = new test3(); // 创建游戏面板
    frame.add(game); // 将游戏面板添加到窗口
    frame.setSize(400, 400); // 设置窗口大小
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
    frame.setVisible(true); // 显示窗口
  }
}