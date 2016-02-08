package aghazadeh.ahmad.endlessrecyclerview;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by 890683 on 1/10/2016.
 */
public class BindingCustom {



    @BindingAdapter({"imageUrl", "error", "paletteResId"})
    public static void loadImage(final ImageView view, String url, @Nullable Drawable error, @Nullable final int paletteResId) {
        com.squareup.picasso.Callback callback = new Callback() {
            @Override
            public void onSuccess() {
                Bitmap photo = Project.drawableToBitmap(view.getDrawable());
                Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        int mutedLight = palette.getMutedColor(view.getContext().getResources().getColor(android.R.color.white));
                        View paletteLayout = (view.getRootView()).findViewById(paletteResId);
                        if(paletteLayout!=null){
                            paletteLayout.setBackgroundColor(mutedLight);
                        }
                    }
                });
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }

            @Override
            public void onError() {
            }
        };
        Picasso.with(view.getContext()).load(url).error(error).into(view, callback);

    }


}
