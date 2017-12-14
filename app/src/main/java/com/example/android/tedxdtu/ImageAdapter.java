package com.example.android.tedxdtu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Vartul Bhardwaj on 10-12-2017.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context context){
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
            R.drawable.tedxdtu, R.drawable.tedxdtu,
            R.drawable.tedxdtu, R.drawable.tedxdtu,
            R.drawable.tedxdtu, R.drawable.tedxdtu,
            R.drawable.tedxdtu, R.drawable.tedxdtu,
            R.drawable.tedxdtu, R.drawable.tedxdtu,
    };
}
