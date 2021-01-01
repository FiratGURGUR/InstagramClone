package frt.gurgur.instagramclone.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import frt.gurgur.instagramclone.R;
import frt.gurgur.instagramclone.databinding.ItemPostListBinding;
import frt.gurgur.instagramclone.model.post.PostsItem;
import frt.gurgur.instagramclone.ui.listeners.LikeListener;


public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.MyViewHolder> {
    private static final int TYPE_PHOTO = 1;
    private List<PostsItem> postList;
    Context context;
    LikeListener likeListener;

    public PostListAdapter() {

    }

    @Inject
    public PostListAdapter(Context context, List<PostsItem> postList,LikeListener likeListener) {
        this.postList = postList;
        this.context=context;
        this.likeListener= likeListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ViewDataBinding binding;
        switch (viewType) {
            case TYPE_PHOTO:
                binding = DataBindingUtil.inflate(inflater, R.layout.item_post_list, parent, false);
                return new MyViewHolder((ItemPostListBinding) binding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case TYPE_PHOTO:

                ItemPostListBinding bindingImage = holder.binding;
                bindingImage.setPost(postList.get(position));
                bindingImage.sliderView.setup(context,postList.get(position));

                Glide.with(context)
                        .load("https://pbs.twimg.com/profile_images/1261721978639187969/RORTLrUo_400x400.jpg")
                        .into(bindingImage.ivUserPhoto);

                break;
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemPostListBinding binding;

        public MyViewHolder(ItemPostListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.sliderView.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    likeListener.clickLike(binding.getPost());
                }
            });
            binding.sliderView.commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    likeListener.clickComment();
                }
            });
            binding.sliderView.sendButotn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    likeListener.clickSend();
                }
            });
            binding.sliderView.saveButotn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    likeListener.clickSave(binding.getPost());
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (postList.get(position).getIsMultiPhoto() == 0) { //değişecek
            return TYPE_PHOTO;
        } else {
            return TYPE_PHOTO;
        }
    }

}
