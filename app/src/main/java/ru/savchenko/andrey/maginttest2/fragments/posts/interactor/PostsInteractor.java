package ru.savchenko.andrey.maginttest2.fragments.posts.interactor;


import io.reactivex.Observable;
import ru.savchenko.andrey.maginttest2.entities.RecentContainer;

/**
 * Created by Andrey on 14.09.2017.
 */

public interface PostsInteractor {
    Observable<RecentContainer> loadPosts();
}
