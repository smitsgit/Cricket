package com.cricket.material.cricket;

/**
 * Created by smitald on 7/16/2015.
 */
public class SectionItem<T> {
    private String mTitle;
    private T[] mItems;


    public SectionItem(String title, T[] items){
        mItems = items;
        mTitle = title;
    }


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public T[] getmItems() {
        return mItems;
    }

    public void setmItems(T[] mItems) {
        this.mItems = mItems;
    }

    public int getCount(){
        return mItems.length + 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(null != obj && obj instanceof SectionItem){
            return ((SectionItem) obj).getmTitle().equals(mTitle);
        }
        return false;
    }

    public T getItem(int position){
         return mItems[position];
    }

}
