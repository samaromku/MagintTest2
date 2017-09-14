package ru.savchenko.andrey.maginttest2.activities.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.OnClick;
import ru.savchenko.andrey.maginttest2.R;
import ru.savchenko.andrey.maginttest2.activities.main.view.MainView;
import ru.savchenko.andrey.maginttest2.dialogs.TelegramAuthDialog;
import ru.savchenko.andrey.maginttest2.interfaces.OnAuthChangeListenter;

public class MainActivity extends AppCompatActivity implements MainView, OnAuthChangeListenter {
    public static final String TAG = "MainActivity";

    @OnClick(R.id.btnAuth)
    void btnClick(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelegramAuthDialog dialog = new TelegramAuthDialog();
        dialog.setListenter(this);
        dialog.show(getFragmentManager(), "Telegram");
        dialog.setCancelable(false);
    }

    @Override
    public void setName(String name) {
//        tvFullName.append(name);
    }

    @Override
    public void setLogin(String login) {
//        tvUserName.append(login);
    }

    @Override
    public void setImage(String image) {
//        Picasso.with(this).load(image).into(ivProfilePic);
    }

    @Override
    public void setBio(String bio) {
//        tvBio.append(bio);
    }
}
