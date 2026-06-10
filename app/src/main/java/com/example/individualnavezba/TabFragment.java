package com.example.individualnavezba;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment {
    private String category;
    private CompanyAdapter adapter;
    private AppDatabase db;

    public static TabFragment newInstance(String category) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString("category", category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        category = getArguments().getString("category");
        db = AppDatabase.getInstance(getContext());

        ListView listView = view.findViewById(R.id.listView);
        EditText etSearch = view.findViewById(R.id.etSearch);

        List<Company> companies = db.companyDao().getByCategory(category, "");
        adapter = new CompanyAdapter(getContext(), companies);
        listView.setAdapter(adapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<Company> filtered = db.companyDao().getByCategory(category, s.toString());
                adapter.updateData(filtered);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }
}