package ru.savchenko.andrey.maginttest2;

import android.app.Application;

import io.realm.Realm;
import ru.savchenko.andrey.maginttest2.network.RequestManager;
import ru.savchenko.andrey.maginttest2.storage.Prefs;

/**
 * Created by Andrey on 13.09.2017.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        RequestManager.init();
        Prefs.init(this);
        Realm.init(this);
    }
}
