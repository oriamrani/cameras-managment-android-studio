package com.example.tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CameraAdapter extends BaseAdapter {

    Context context;
    List<CameraModel> cameras;
    private static LayoutInflater inflater = null;

    public CameraAdapter(Context context, List<CameraModel> cameras) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.cameras = cameras;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cameras.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return cameras.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);

        TextView text = (TextView) vi.findViewById(R.id.text);

        text.setText(cameras.get(position).getCameraName());
        return vi;
    }
}
