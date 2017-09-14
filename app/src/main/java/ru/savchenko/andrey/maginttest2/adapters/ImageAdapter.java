package ru.savchenko.andrey.maginttest2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.savchenko.andrey.maginttest2.R;
import ru.savchenko.andrey.maginttest2.entities.Images;

/**
 * Created by Andrey on 14.09.2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Images>images;

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//        if (convertView == null) {
//            // if it's not recycled, initialize some attributes
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            Images image = images.get(position);
//            Log.i(TAG, "getView: " + image);
//            Picasso.with(mContext).load(image.getStandardResolution().getUrl()).into(imageView);
//        } else {
//            imageView = (ImageView) convertView;
//        }
        Images image = images.get(position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        convertView = inflater.inflate(R.layout.item_post, parent, false);
        ImageView ivPost = convertView.findViewById(R.id.ivPost);
        Picasso.with(mContext).load(image.getStandardResolution().getUrl()).into(ivPost);
        return ivPost;
    }
}