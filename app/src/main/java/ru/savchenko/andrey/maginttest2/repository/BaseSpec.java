package ru.savchenko.andrey.maginttest2.repository;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Andrey on 14.09.2017.
 */

public class BaseSpec<T extends RealmObject> {
    private Class<T>type;

    public BaseSpec(Class<T>type){
        this.type = type;
    }

    private Realm realmInstance(){
        return Realm.getDefaultInstance();
    }

    public void addItem(T item){
        realmInstance().executeTransaction(realm -> realm.insertOrUpdate(item));
        realmInstance().close();
    }

    public T getItem(){
        T t = realmInstance().where(type).findFirst();
        realmInstance().close();
        return t;
    }
}
