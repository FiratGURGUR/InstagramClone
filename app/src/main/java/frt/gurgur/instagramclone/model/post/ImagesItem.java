package frt.gurgur.instagramclone.model.post;

import com.google.gson.annotations.SerializedName;

public class ImagesItem{

	@SerializedName("user_id")
	private int userId;

	@SerializedName("gonderi_id")
	private int gonderiId;

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("id")
	private int id;

	public int getUserId(){
		return userId;
	}

	public int getGonderiId(){
		return gonderiId;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public int getId(){
		return id;
	}
}