package com.example.android.tedxdtu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by vartul1010 on 17/4/18.
 */

public class GalleryAdapter extends BaseAdapter {

    private Context mContext;

    public GalleryAdapter(Context context){
        mContext = context;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 200));
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {
        R.drawable.thats1, R.drawable.thats2, R.drawable.thats3,
            R.drawable.thats4, R.drawable.thats5, R.drawable.thats6,
            R.drawable.thats7, R.drawable.alisha, R.drawable.durjoy,
            R.drawable.manav, R.drawable.mascot, R.drawable.meher
    };
}
