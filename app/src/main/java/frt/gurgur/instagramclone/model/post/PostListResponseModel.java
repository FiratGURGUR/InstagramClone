package frt.gurgur.instagramclone.model.post;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostListResponseModel{

	@SerializedName("Status")
	private int status;

	@SerializedName("Posts")
	private List<PostsItem> posts;

	public int getStatus(){
		return status;
	}

	public List<PostsItem> getPosts(){
		return posts;
	}
}