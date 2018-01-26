package com.example.neil.rereofitdeom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.neil.rereofitdeom.model.Museum;

import java.util.List;

/**
 * Created by neil on 2018/1/25.
 */

public class MuseumAdapter extends BaseAdapter {

    // --------------------------------------------------------
    private List<Museum.DataBeanX> dataBeans;

    // --------------------------------------------------------
    public MuseumAdapter(List<Museum.DataBeanX> dataBeans) {
        this.dataBeans = dataBeans;
    }

    // --------------------------------------------------------
    @Override
    public int getCount() {
        return dataBeans.size();
    }

    // --------------------------------------------------------
    @Override
    public Object getItem(int i) {
        return i;
    }

    // --------------------------------------------------------
    @Override
    public long getItemId(int i) {
        return 0;
    }

    // --------------------------------------------------------
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        TitleViewHolder holder;

        if (view == null) {

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_museum, viewGroup, false);
            holder = new TitleViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (TitleViewHolder) view.getTag();
        }

        holder.title.setText(dataBeans.get(position).getData().get(0).getName());

        return view;
    }

    // --------------------------------------------------------
    static class TitleViewHolder {

        TextView title;

        public TitleViewHolder(View view) {
            title = view.findViewById(R.id.title);
        }
    }

    // --------------------------------------------------------
}
