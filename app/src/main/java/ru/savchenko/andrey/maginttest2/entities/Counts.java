package ru.savchenko.andrey.maginttest2.entities;

/**
 * Created by Andrey on 13.09.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts {

    @SerializedName("media")
    @Expose
    private int media;
    @SerializedName("follows")
    @Expose
    private int follows;
    @SerializedName("followed_by")
    @Expose
    private int followedBy;

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(int followedBy) {
        this.followedBy = followedBy;
    }

    @Override
    public String toString() {
        return "Counts{" +
                "media=" + media +
                ", follows=" + follows +
                ", followedBy=" + followedBy +
                '}';
    }
}