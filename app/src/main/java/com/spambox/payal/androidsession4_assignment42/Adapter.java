package com.spambox.payal.androidsession4_assignment42;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<People> {

    private List<People> list;
    private Context context;

    public Adapter(List<People> list, Context ctx) {
        super(ctx,R.layout.row_layout, list);
        this.list = list;
        this.context = ctx;
    }
    public int getCount() {
        return list.size();
    }
    public People getItem(int position) {
        return list.get(position);
    }
    public long getItemId(int position) {
        return list.get(position).hashCode();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        PersonHolder holder = new PersonHolder();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.row_layout, null);
            TextView name = (TextView) v.findViewById(R.id.name);
            TextView num = (TextView) v.findViewById(R.id.num);
            holder.nameView = name;
            holder.numView = num;
            v.setTag(holder);
        }
        else
            holder = (PersonHolder) v.getTag();
        People p = list.get(position);
        holder.nameView.setText(p.getName());
        holder.numView.setText("" + p.getDistance());
        return v;
    }

    private static class PersonHolder {
        public TextView nameView;
        public TextView numView;
    }
}
