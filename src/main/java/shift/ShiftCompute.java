package shift;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: ShiftCompute
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/5/9 17:51
 * @Author: piccasi@163.com
 * @Description: 位移、取模、取余操作
 **/
public class ShiftCompute {

    private int first = 1;

    {
        System.out.println("first: " + first);
        first = 3;
        System.out.println("first: " + first);
    }

    static {
        int index = 5;
        System.out.println("static: " + (index >> 1) );
        System.out.println("static: " +  (index << 1) );
        System.out.println("static: " + (index / 2 ) );
        System.out.println("static: " +  (index % 2) );
    }

    public static void main(String[] args) {
        System.out.println("main");
        ShiftCompute shiftCompute = new ShiftCompute();
        System.out.println("main");

        System.out.println( 15 & 16);
    }
}
