package design;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: ObserverPattern
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/19 16:25
 * @Author: zhouguanbao@sensetime.com
 * @Description: 观察者模式
 **/
public class ObserverPattern {

    static class ObservableObject {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyObserver();
        }

        private String name;

        List<TargetObserver> targetObservers = new ArrayList<>();

        public void registry(TargetObserver targetObserver){
            targetObservers.add(targetObserver);
        }

        public void notifyObserver(){
            targetObservers.forEach(targetObserver -> targetObserver.update(this));
        }
    }


    static class TargetObserver {
        public void update(ObservableObject observableObject){
            System.out.println("received new object is: " + observableObject.getName());
        }

        public void listen(ObservableObject observableObject){
            observableObject.registry(this);
        }
    }

    public static void main(String[] args) {
        ObservableObject observableObject = new ObservableObject();
        TargetObserver targetObserver1 = new TargetObserver(), targetObserver2 = new TargetObserver();
        targetObserver1.listen(observableObject);
        targetObserver2.listen(observableObject);

        observableObject.setName("changed");
    }

}
