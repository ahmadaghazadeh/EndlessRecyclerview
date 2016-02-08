package aghazadeh.ahmad.endlessrecyclerview;

import jp.satorufujiwara.binder.ViewType;

/**
 * Created by 890683 on 1/10/2016.
 */
public enum CardViewType implements ViewType {

    CardPic,
    CardText,
    CardVideo ;

    @Override
    public int viewType() {
        return ordinal();
    }

}
