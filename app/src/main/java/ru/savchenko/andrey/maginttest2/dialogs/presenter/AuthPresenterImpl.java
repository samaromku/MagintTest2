package ru.savchenko.andrey.maginttest2.dialogs.presenter;

import ru.savchenko.andrey.maginttest2.dialogs.interacotr.AuthInteractorImpl;
import ru.savchenko.andrey.maginttest2.dialogs.interacotr.AuthInterator;
import ru.savchenko.andrey.maginttest2.dialogs.view.AuthView;
import ru.savchenko.andrey.maginttest2.entities.Data;
import ru.savchenko.andrey.maginttest2.interfaces.OnAuthChangeListenter;

/**
 * Created by Andrey on 13.09.2017.
 */

public class AuthPresenterImpl implements AuthPresenter {
    private AuthInterator interator;
    private AuthView view;
    private OnAuthChangeListenter listenter;

    public AuthPresenterImpl(AuthView view, OnAuthChangeListenter listenter) {
        this.interator = new AuthInteractorImpl();
        this.view = view;
        this.listenter = listenter;
    }

    @Override
    public void checkUrl(String url) {
        interator.getData(url)
                .subscribe(dataContainer -> {
                            view.onSuccess();
                            Data data = dataContainer.getData();
                    listenter.setBio(data.getBio());
                    listenter.setImage(data.getProfilePicture());
                    listenter.setLogin(data.getUsername());
                    listenter.setName(data.getFullName());
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            view.errorToast();
                        });
    }

}
