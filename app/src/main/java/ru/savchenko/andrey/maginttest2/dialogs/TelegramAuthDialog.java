package ru.savchenko.andrey.maginttest2.dialogs;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.maginttest2.R;
import ru.savchenko.andrey.maginttest2.dialogs.presenter.AuthPresenter;
import ru.savchenko.andrey.maginttest2.dialogs.presenter.AuthPresenterImpl;
import ru.savchenko.andrey.maginttest2.dialogs.view.AuthView;
import ru.savchenko.andrey.maginttest2.drawer.DrawerActivity;
import ru.savchenko.andrey.maginttest2.interfaces.OnAuthChangeListenter;
import ru.savchenko.andrey.maginttest2.storage.Const;

import static android.content.ContentValues.TAG;
import static ru.savchenko.andrey.maginttest2.storage.Const.CLIENT_ID;
import static ru.savchenko.andrey.maginttest2.storage.Const.REDIRECT_URI;

/**
 * Created by Andrey on 13.09.2017.
 */

public class TelegramAuthDialog extends DialogFragment implements AuthView {
    @BindView(R.id.wvTelegram)
    WebView wvTelegram;
    private AuthPresenter presenter;
    private OnAuthChangeListenter listenter;


    public void setListenter(OnAuthChangeListenter listenter) {
        this.listenter = listenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_webview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter = new AuthPresenterImpl(this, listenter);
        wvTelegram.getSettings().setDomStorageEnabled(true);
        wvTelegram.getSettings().setJavaScriptEnabled(true);
        wvTelegram.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                checkUrl(url);
                return false;
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (url.startsWith("https://www.instagram.com/accounts/login/")) {
                    Log.i(TAG, "onPageFinished: hui");
                    // TODO: 14.09.2017 заменить имя и пароль на нормальные 
                    view.evaluateJavascript("javascript:document.getElementById('id_username').value = '" + "userName" + "';" +
                            "javascript:document.getElementById('id_password').value='" + "userPwd" + "';" +
                            "javascript:document.getElementById('login-form').submit();", s -> {
                    });
                }
            }
        });
        wvTelegram.loadUrl(Const.BASE_URL + "/oauth/authorize/" + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=token");
    }

    private void checkUrl(String url) {
        presenter.checkUrl(url);
    }

    @Override
    public void onSuccess() {
        getDialog().dismiss();
        startActivity(new Intent(getActivity(), DrawerActivity.class));
    }

    @Override
    public void errorToast() {
//        Toast.makeText(getActivity(), "error getting data", Toast.LENGTH_SHORT).show();
    }
}
