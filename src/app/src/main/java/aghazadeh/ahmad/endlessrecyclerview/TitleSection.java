package aghazadeh.ahmad.endlessrecyclerview;

import jp.satorufujiwara.binder.Section;

/**
 * Created by 890683 on 1/10/2016.
 */
public enum TitleSection implements Section {
    SECTION_1,
    SECTION_2,
    SECTION_3;
    @Override
    public int position() {
        return ordinal();
    }
}
