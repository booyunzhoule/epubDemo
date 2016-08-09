package com.daxing.epubtestdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.model.ReadableFile;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by win7 on 2016/8/9.
 */
public class FileChooseAdapter extends BaseAdapter {
    private Context context;
    private List<ReadableFile> list;

    public FileChooseAdapter(Context context, List<ReadableFile> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_file_choose, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.nameText.setText(list.get(i).fileName);
        Log.i("MSG", list.get(i).fileName);
        if (list.get(i).fileSize < 1024) {
            viewHolder.sizeText.setText(list.get(i).fileSize + "byts");
        } else if (list.get(i).fileSize > 1024 && list.get(i).fileSize < 1048576) {
            viewHolder.sizeText.setText(list.get(i).fileSize / 1024 + "kb");
        } else if (list.get(i).fileSize > 1048576) {
            viewHolder.sizeText.setText(list.get(i).fileSize / 1048576 + "M");
        }
        viewHolder.urlText.setText(list.get(i).fileURL);
        return view;
    }

    public static class ViewHolder {
        TextView nameText, sizeText, urlText;
        public ViewHolder(View itemView) {
            nameText = (TextView) itemView.findViewById(R.id.tv_item_file_choose_file_name);
            sizeText = (TextView) itemView.findViewById(R.id.tv_item_file_choose_file_size);
            urlText = (TextView) itemView.findViewById(R.id.tv_item_file_choose_file_url);
        }
    }
}
