package aghazadeh.ahmad.endlessrecyclerview;

import android.databinding.Bindable;

import java.util.Observable;

/**
 * Created by 890683 on 1/3/2016.
 */
public class PicData   {


    private String title;

    private String desc ;

    private String url;


    public PicData(String title, String desc, String url) {
        this.title = title;
        this.desc = desc;
        this.url=url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}