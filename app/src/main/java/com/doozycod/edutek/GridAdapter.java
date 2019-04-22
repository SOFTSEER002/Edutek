package com.doozycod.edutek;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GridAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    String[] grid_name_list;
    String[] url;
    int[] grid_ico;

    public GridAdapter(GridActivity mainActivity, String[] name_list, int[] grid_icon, String[] url) {
        context = mainActivity;
        grid_name_list = name_list;
        grid_ico = grid_icon;
        this.url = url;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return grid_name_list.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        Holder holder = new Holder();
        View view;
        view = inflater.inflate(R.layout.grid_view_list, null);

        holder.icon = view.findViewById(R.id.imageview);
        holder.textView = view.findViewById(R.id.grid_text_view);
        holder.layout = view.findViewById(R.id.layout);
        holder.textView.setText(grid_name_list[position]);
        Glide.with(context).load(grid_ico[position]).into(holder.icon);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url", url[position]);
                Log.e("url", url[position]);
                Intent intent = new Intent(parent.getContext(), WebViewActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return view;
    }

    class Holder {
        ImageView icon;
        LinearLayout layout;
        TextView textView;

    }
}
