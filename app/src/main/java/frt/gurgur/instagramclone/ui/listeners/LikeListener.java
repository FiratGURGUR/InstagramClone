package frt.gurgur.instagramclone.ui.listeners;

import frt.gurgur.instagramclone.model.post.PostsItem;

public interface LikeListener {
    void clickLike(PostsItem item);
    void clickComment();
    void clickSend();
    void clickSave(PostsItem item);
}
