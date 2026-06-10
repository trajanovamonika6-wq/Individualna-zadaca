package com.example.individualnavezba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CompanyAdapter extends BaseAdapter {
    private Context context;
    private List<Company> companies;

    public CompanyAdapter(Context context, List<Company> companies) {
        this.context = context;
        this.companies = companies;
    }

    public void updateData(List<Company> newList) {
        this.companies = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() { return companies.size(); }

    @Override
    public Object getItem(int position) { return companies.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_company, parent, false);
        }
        Company c = companies.get(position);
        ((TextView) convertView.findViewById(R.id.tvName)).setText(c.name);
        ((TextView) convertView.findViewById(R.id.tvAddress)).setText(c.address);
        ((TextView) convertView.findViewById(R.id.tvPhone)).setText(c.phone);
        ((TextView) convertView.findViewById(R.id.tvWebsite)).setText(c.website);
        return convertView;
    }
}