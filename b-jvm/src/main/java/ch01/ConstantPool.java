package ch01;

/**
 * 类说明: 常量池的变化
 */
public class ConstantPool {
    
    public static void main(String[] args){
       String b = "享学";
       String a = b + "课堂";
       System.out.println(a.intern() == a);
    }
}
