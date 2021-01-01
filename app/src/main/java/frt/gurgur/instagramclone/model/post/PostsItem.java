package frt.gurgur.instagramclone.model.post;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostsItem{

	@SerializedName("is_multiPhoto")
	private int isMultiPhoto;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("username")
	private String username;

	@SerializedName("photo")
	private String photo;

	@SerializedName("Images")
	private List<ImagesItem> images;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	public int getIsMultiPhoto(){
		return isMultiPhoto;
	}

	public int getUserId(){
		return userId;
	}

	public List<ImagesItem> getImages(){
		return images;
	}

	public String getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPhoto() {
		return photo;
	}
}