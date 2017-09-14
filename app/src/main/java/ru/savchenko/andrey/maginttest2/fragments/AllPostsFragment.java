package ru.savchenko.andrey.maginttest2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import ru.savchenko.andrey.maginttest2.R;
import ru.savchenko.andrey.maginttest2.adapters.ImageAdapter;
import ru.savchenko.andrey.maginttest2.base.BaseFragment;
import ru.savchenko.andrey.maginttest2.entities.Images;
import ru.savchenko.andrey.maginttest2.fragments.posts.presenter.PostsPresenter;
import ru.savchenko.andrey.maginttest2.fragments.posts.presenter.PostsPresenterImpl;
import ru.savchenko.andrey.maginttest2.fragments.posts.view.PostsView;
import ru.savchenko.andrey.maginttest2.storage.Prefs;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 14.09.2017.
 */

public class AllPostsFragment extends BaseFragment implements PostsView{
    private PostsPresenter presenter;
    private ImageAdapter adapter;
    private GridView gridview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_posts, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridview = view.findViewById(R.id.gridPosts);
        Log.i(TAG, "onViewCreated: " + Prefs.getToken());
        presenter = new PostsPresenterImpl(this);
        presenter.loadPosts();
        adapter = new ImageAdapter(getActivity());


        gridview.setOnItemClickListener((parent, v, position, id) -> {
            Log.i(TAG, "onViewCreated: " + position);
        });
    }

    @Override
    public void setAdapterData(List<Images> list) {
        Log.i(TAG, "setAdapterData: " + list.size());
        adapter.setImages(list);
        gridview.setAdapter(adapter);
    }
}
