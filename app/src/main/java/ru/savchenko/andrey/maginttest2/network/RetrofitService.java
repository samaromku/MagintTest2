package ru.savchenko.andrey.maginttest2.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.savchenko.andrey.maginttest2.entities.DataContainer;
import ru.savchenko.andrey.maginttest2.entities.RecentContainer;

/**
 * Created by Andrey on 12.09.2017.
 */

public interface RetrofitService {
    @GET("/v1/users/self/")
    Observable<DataContainer> getUserSelf(@Query("access_token") String accessToken);

    @GET("/v1/users/{userId}/media/recent/")
    Observable<RecentContainer> getUsersRecent(@Path("userId") String userId, @Query("access_token") String accessToken);

}
