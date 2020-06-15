package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: DicarMulti
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/13 12:09
 * @Author: zhouguanbao@sensetime.com
 * @Description: TODO
 **/
public class DicarMulti {

    public String[] dicar(String[][] source){
        String[] dicar = source[0];

        for (int i = 1; i < source.length; i++) {

            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < dicar.length; j++) {
                for (int k = 0; k < source[i].length; k++) {
                    tmp.add(dicar[j] + source[i][k]);
                }
            }

            dicar = tmp.toArray(new String[0]);
        }

        return dicar;
    }


    public static void main(String[] args) {
        String[][] arr = new String[3][];

        arr[0] = new String[]{"a", "b"};
        arr[1] = new String[]{"c", "d"};
        arr[2] = new String[]{"e"};

        DicarMulti dicarMulti = new DicarMulti();
        String[] dicar = dicarMulti.dicar(arr);

        for (String s : dicar) {
            System.out.println(s);
        }
    }
}
