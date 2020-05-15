package com.langqu.httpdemo.utils.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager implements SubjectListener {

    //观察者接口集合
    private List<ObserverListener> list = new ArrayList<>();
    private static ObserverManager manager;

    public static ObserverManager getInstance() {
        if (manager == null) {
            synchronized (ObserverManager.class) {
                if (manager == null) {
                    manager = new ObserverManager();
                }
            }
        }
        return manager;
    }

    @Override
    public void add(ObserverListener listener) {
        list.add(listener);
    }

    @Override
    public void notifyObserver(String str) {
        for (ObserverListener listener : list) {
            listener.observerUpDate(str);
        }
    }

    @Override
    public void removeObserver(ObserverListener listener) {
        if (list.contains(listener)){
            list.remove(listener);
        }
    }
}
