package ru.savchenko.andrey.maginttest2.entities;

/**
 * Created by Andrey on 13.09.2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Meta extends RealmObject {

    @SerializedName("code")
    @Expose
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "code=" + code +
                '}';
    }
}
