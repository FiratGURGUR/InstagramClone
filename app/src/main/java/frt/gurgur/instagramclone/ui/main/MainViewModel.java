package frt.gurgur.instagramclone.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import frt.gurgur.instagramclone.data.remote.repo.MainRepo;
import frt.gurgur.instagramclone.model.post.PostListResponseModel;
import frt.gurgur.instagramclone.model.post.PostsItem;
import frt.gurgur.instagramclone.ui.base.BaseViewModel;
import frt.gurgur.instagramclone.util.ErrorUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel  extends BaseViewModel {

    private final MainRepo mainRepo;
    private CompositeDisposable disposable;
    private MutableLiveData<List<PostsItem>> postList = new MutableLiveData<>();

    @Inject
    public MainViewModel(MainRepo mainRepo) {
        this.mainRepo = mainRepo;
        disposable = new CompositeDisposable();
    }

    public LiveData<List<PostsItem>> getPostList() {
        return postList;
    }

    public void loadPostList() {

        disposable.add(mainRepo.getPostList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribeWith(new DisposableSingleObserver<PostListResponseModel>() {

                    @Override
                    public void onSuccess(PostListResponseModel resultsResponse) {
                        postList.setValue(resultsResponse.getPosts());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        onError.setValue(ErrorUtils.showError(e));
                    }
                }));

    }

}
