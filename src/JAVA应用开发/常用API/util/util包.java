package JAVA应用开发.常用API.util;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class util包 {
  /* java集合框架：变长数组
   * (collection)
   * -List系列：元素按照加入顺序，可通过索引访问
   * --ArrayList：数组实现，查询快，增删慢
   * --LinkedList：链表实现，查询慢，增删快
   * --Vector：线程安全，效率低
   * --三者使用方法功能相同
   * --三者如何选择：查询多用ArrayList，增删多用LinkedList
   * -----------------------------------------------------------------
   * -Set系列：原素不重复，无下标，存储速度快
   * --HashSet：哈希表实现，无下标，无序，不重复
   * --TreeSet：二叉树实现，有序，自然排序，不重复
   * --LinkedHashSet：链表实现，有序，不重复,按加入顺序,查询快,性能不如HashSet
   * -----------------------------------------------------------------
   * -Map系列：键值对，键不重复，值可重复，二维数组，映射
   * --结构：两列多行数组，第一列键，第二列值，键不重复
   * --例如：键：学号，值：姓名
   * --TreeMap：二叉树实现，有序，键不重复
   * --LinkedHashMap：链表实现，有序，键不重复，按加入顺序
   * --HashMap：哈希表实现，无序，键不重复
   */
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList< String>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    list.remove("a");
    list.set(1, "f");
/*     for(int i=0;i<list.size();i++){
      System.out.println(list.get(i));
    } */
   for(String s:list){
     System.out.println(s);
   }
   HashSet <String> set = new HashSet<String>();
    set.add("a");
    set.add("b");
    set.add("c");
    set.add("d");
    set.add("e");
    set.remove(1);
    for(String s:set){
      System.out.println(s);
    }
    LinkedHashMap<String, String> map = new LinkedHashMap<>();
    map.put("a", "1");
    map.put("b", "2");
    map.put("c", "3");
    map.put("d", "4");
    map.put("e", "5");
    //在map中添加一个名叫张三的住址信息
    map.put("张三", "北京");
    map.remove(map.get("张三"));
    for(String key:map.keySet()){
      System.out.println(key+" "+map.get(key));
    }
  }
  // 练习：红楼梦中  import java.io.BufferedReader;
  /* public class HongLouMeng {
      public static void main(String[] args) {
          HashSet<Character> hanziSet = new HashSet<>();
          try (BufferedReader reader = new BufferedReader(new FileReader("hongloumeng.txt"))) {
              int ch;
              while ((ch = reader.read()) != -1) {
                  char character = (char) ch;
                  if (isChineseCharacter(character)) {
                      hanziSet.add(character);
                  }
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
          System.out.println("红楼梦中使用了 " + hanziSet.size() + " 个不同的汉字。");
      }
  
      private static boolean isChineseCharacter(char ch) {
          return (ch >= 0x4E00 && ch <= 0x9FA5);
      }
  } */

}
/* 动态数剧集，最好是插入排序
    规模N            预处理     查找
   普通查找：          O(N) 
 * 二分查找：          O(N2)    O(logN)
 * 二叉树查找：         O(NlogN) O(logN)（可能退化为普通查找）
 * 哈希表查找：         O(N)     O(1)
 * 二叉+平衡树查找：    O(NlogN) O(logN)
*/

/* 练习：有一个长字符串，请统计其中每个字符出现多少次
 * 1.创建一个Map集合，键是字符，值是出现次数
 * 2.遍历字符串，得到每一个字符
 * 3.拿到当前字符，到Map集合中查看是否有这个字符
 * 4.如果没有这个字符，就将字符作为键，1作为值存储
 * 5.如果有这个字符，就将值加1，然后将字符和值重新存储到Map集合中
 * 6.遍历结束，打印Map集合
 * 
 */
/* import java.util.HashMap;
import java.util.Map;
public class 练习 {
  public static void main(String[] args) {
    String str = "aabbccdd";
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, 1);
      } else {
        map.put(c, map.get(c) + 1);
      }
    }
    System.out.println(map);
  }
} */