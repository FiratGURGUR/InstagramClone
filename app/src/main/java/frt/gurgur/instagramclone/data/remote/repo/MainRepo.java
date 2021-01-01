package frt.gurgur.instagramclone.data.remote.repo;

import javax.inject.Inject;

import frt.gurgur.instagramclone.data.remote.APIService;
import frt.gurgur.instagramclone.model.post.PostListResponseModel;
import io.reactivex.Single;


public class MainRepo {

    private final APIService api;

    @Inject
    public MainRepo(APIService api) {
        this.api = api;
    }

    public Single<PostListResponseModel> getPostList(){
        return api.postList();
    }


}
