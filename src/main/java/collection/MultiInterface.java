package collection;

import java.util.*;
import java.util.function.Predicate;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: multiInterface
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/5/9 15:10
 * @Author: zhouguanbao@sensetime.com
 * @Description: TODO
 **/
public class MultiInterface implements Interface2 {

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static void main(String[] args) {
        MultiInterface multiInterface = new MultiInterface();
        System.out.println(multiInterface.size());

        Collection<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        Iterator<Integer> integerIterator = integers.iterator();

        while(integerIterator.hasNext()){
            System.out.println("num: " + integerIterator.next());
        }

        ((ArrayList<Integer>) integers).sort(Comparator.comparingInt(Integer::intValue));

        integers.removeIf(t -> t.equals(1));

        integerIterator = integers.iterator();
        while(integerIterator.hasNext()){
            System.out.println("num: " + integerIterator.next());
        }

    }

}
