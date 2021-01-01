package frt.gurgur.instagramclone.imagesliderview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import frt.gurgur.instagramclone.R;
import frt.gurgur.instagramclone.model.post.PostsItem;
import frt.gurgur.instagramclone.ui.listeners.LikeListener;
import me.relex.circleindicator.CircleIndicator;

public class CustomImageSliderView extends CircleIndicator {
    private ViewPager mPager;
    public ImageView likeButton,commentButton,sendButotn,saveButotn;
    private List<String> ImagesArray = new ArrayList<>();
    CircleIndicator indicator;
    LikeListener listener;


    public CustomImageSliderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_imageslider_view, this);

        mPager = findViewById(R.id.pager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        likeButton = findViewById(R.id.btnLike);
        commentButton = findViewById(R.id.btnComment);
        sendButotn = findViewById(R.id.btnSend);
        saveButotn = findViewById(R.id.btnSave);

    }




    public void setup(Context context, PostsItem item){
        for (int i =0 ;i<item.getImages().size();i++){
            ImagesArray.add(item.getImages().get(i).getImageUrl());
        }
        mPager.setAdapter(new SlidingImage_Adapter(context,ImagesArray));
        indicator.setViewPager(mPager);
    }

    public void hideIndicator(boolean showOrHide){
        if (showOrHide)
            indicator.setVisibility(GONE);
        else
            indicator.setVisibility(VISIBLE);
    }





}
