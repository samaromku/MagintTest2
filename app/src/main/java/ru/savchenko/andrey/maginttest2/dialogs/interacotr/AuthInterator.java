package ru.savchenko.andrey.maginttest2.dialogs.interacotr;


import io.reactivex.Observable;
import ru.savchenko.andrey.maginttest2.entities.DataContainer;

/**
 * Created by Andrey on 13.09.2017.
 */

public interface AuthInterator {
    Observable<DataContainer> getData(String token);
}
