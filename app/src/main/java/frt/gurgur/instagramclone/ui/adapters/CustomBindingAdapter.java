package frt.gurgur.instagramclone.ui.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import frt.gurgur.instagramclone.imagesliderview.CustomImageSliderView;

public class CustomBindingAdapter {


    @BindingAdapter("init_indicator")
    public static void initIndicator(CustomImageSliderView view, int isMultiplePhoto) {
        if (isMultiplePhoto==0){
            view.hideIndicator(true);
        }else {
            view.hideIndicator(false);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, String url) {
        if (url == null) {
            view.setImageDrawable(null);
        } else {
            //Picasso.get().load(url).into(view);
            Glide.with(view.getContext())
                    .load(url)
                    .into(view);
        }
    }


}
