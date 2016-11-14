package com.application.hakuna.shuuliner.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.hakuna.shuuliner.R;
import com.application.hakuna.shuuliner.ui.adapter.TreeListAdapter;
import com.application.hakuna.shuuliner.ui.parcel.PartItem;

public class TreeListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // カスタムアダプタを使用してリストにデータを詰める
        TreeListAdapter adapter = new TreeListAdapter(getActivity());

        //テストデータの追加
        adapter.add(new PartItem(0L, null, 1L, "1", 0L, 0L));
        adapter.add(new PartItem(1L, 0L, 1L, "1-1", 0L, 0L));
        adapter.add(new PartItem(2L, 0L, 2L, "1-2", 0L, 0L));
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tree_list_fragment, container, false);
    }
}