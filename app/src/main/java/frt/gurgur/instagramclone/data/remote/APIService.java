package frt.gurgur.instagramclone.data.remote;


import frt.gurgur.instagramclone.model.post.PostListResponseModel;
import frt.gurgur.instagramclone.util.Constants;
import io.reactivex.Single;
import retrofit2.http.GET;


public interface APIService {


    @GET(Constants.POST_LIST)
    Single<PostListResponseModel> postList();



}
