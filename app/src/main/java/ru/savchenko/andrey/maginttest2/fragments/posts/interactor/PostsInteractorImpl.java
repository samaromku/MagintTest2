package ru.savchenko.andrey.maginttest2.fragments.posts.interactor;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.maginttest2.entities.Data;
import ru.savchenko.andrey.maginttest2.entities.RecentContainer;
import ru.savchenko.andrey.maginttest2.network.RequestManager;
import ru.savchenko.andrey.maginttest2.repository.BaseSpec;
import ru.savchenko.andrey.maginttest2.storage.Prefs;

/**
 * Created by Andrey on 14.09.2017.
 */

public class PostsInteractorImpl implements PostsInteractor {

    @Override
    public Observable<RecentContainer> loadPosts() {
        Data data = new BaseSpec<>(Data.class).getItem();
        return RequestManager.getRetrofitService()
                .getUsersRecent(data.getId(), Prefs.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
