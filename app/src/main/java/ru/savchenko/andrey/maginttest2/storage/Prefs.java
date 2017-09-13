package ru.savchenko.andrey.maginttest2.storage;

import android.content.Context;
import android.content.SharedPreferences;

import static ru.savchenko.andrey.maginttest2.storage.Const.TOKEN;

/**
 * Created by Andrey on 13.09.2017.
 */

public class Prefs {
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    public static void init(Context context){
        sp = context.getSharedPreferences("myPrefs", 0);
        editor = sp.edit();
    }

    public static void saveToken(String token){
        editor.putString(token, TOKEN);
    }

    public static String getToken(){
        return sp.getString(TOKEN, "");
    }
}
