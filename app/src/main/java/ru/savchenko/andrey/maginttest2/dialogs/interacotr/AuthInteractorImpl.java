package ru.savchenko.andrey.maginttest2.dialogs.interacotr;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.maginttest2.entities.DataContainer;
import ru.savchenko.andrey.maginttest2.network.RequestManager;
import ru.savchenko.andrey.maginttest2.storage.Prefs;

import static ru.savchenko.andrey.maginttest2.storage.Const.ACCESS_TOKEN;
import static ru.savchenko.andrey.maginttest2.storage.Const.REDIRECT_URI;

/**
 * Created by Andrey on 13.09.2017.
 */

public class AuthInteractorImpl implements AuthInterator {
    @Override
    public Observable<DataContainer> getData(String url) {
        return Observable.just(url)
                .filter(s -> url.startsWith(REDIRECT_URI))
                .map(s -> url.split(ACCESS_TOKEN))
                .filter(strings -> strings.length != 0)
                .flatMap(strings ->
                {
                    String token = strings[1];
                    Prefs.saveToken(token);
                    return RequestManager.getRetrofitService().getUserSelf(token)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                });

    }
}
