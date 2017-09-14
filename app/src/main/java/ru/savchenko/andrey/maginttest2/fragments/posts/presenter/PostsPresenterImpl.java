package ru.savchenko.andrey.maginttest2.fragments.posts.presenter;

import java.util.ArrayList;
import java.util.List;

import ru.savchenko.andrey.maginttest2.entities.Datum;
import ru.savchenko.andrey.maginttest2.entities.Images;
import ru.savchenko.andrey.maginttest2.fragments.posts.interactor.PostsInteractor;
import ru.savchenko.andrey.maginttest2.fragments.posts.interactor.PostsInteractorImpl;
import ru.savchenko.andrey.maginttest2.fragments.posts.view.PostsView;

/**
 * Created by Andrey on 14.09.2017.
 */

public class PostsPresenterImpl implements PostsPresenter {
    private PostsInteractor interactor;
    private PostsView view;

    public PostsPresenterImpl(PostsView view) {
        this.interactor = new PostsInteractorImpl();
        this.view = view;
    }

    @Override
    public void loadPosts() {
        interactor.loadPosts()
                .subscribe(recentContainer -> {
                    List<Datum>datas = recentContainer.getData();
                    List<Images>images = new ArrayList<>();
                    for(Datum datum:datas){
                        images.add(datum.getImages());
                    }
                    view.setAdapterData(images);
                });
    }
}
