package aghazadeh.ahmad.endlessrecyclerview;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import aghazadeh.ahmad.endlessrecyclerview.databinding.CardViewPicBinding;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

/**
 * Created by 890683 on 12/31/2015.
 */

public class CardPic extends RecyclerBinder<CardViewType>  {


    private PicData picData;

    public CardPic(Activity activity, PicData picData) {
        super(activity, CardViewType.CardPic);
        this.picData = picData;
    }


    @Override
    public int layoutResId() {
        return R.layout.card_view_pic;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(View parent) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(layoutResId(), (ViewGroup) parent, false);
        BindingHolder holder = new BindingHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
       final BindingHolder holder = (BindingHolder) viewHolder;
        holder.binding.setPicData(picData);
     }



    public static class BindingHolder extends RecyclerView.ViewHolder {
        CardViewPicBinding binding;
        public BindingHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);

        }
   }
}
