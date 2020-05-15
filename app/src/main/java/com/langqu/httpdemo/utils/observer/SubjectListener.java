package com.langqu.httpdemo.utils.observer;

/**
 * 被观察者
 */
public interface SubjectListener {

    void add(ObserverListener listener);
    void notifyObserver(String str);
    void removeObserver(ObserverListener listener);
}
