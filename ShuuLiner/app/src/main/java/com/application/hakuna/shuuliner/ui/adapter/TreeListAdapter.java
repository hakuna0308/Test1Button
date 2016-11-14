package com.application.hakuna.shuuliner.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.application.hakuna.shuuliner.R;
import com.application.hakuna.shuuliner.ui.parcel.PartItem;

import java.util.ArrayList;

public class TreeListAdapter extends ArrayAdapter<PartItem> {

    private static final int resource = R.layout.list_item;

    public TreeListAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // super.getView() は 呼ばない(カスタムビューにしているため)
        View view;

        // テンプレート処理
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }

        // データをgetItemで取る
        PartItem partItem = this.getItem(position);

        TextView name = (TextView) view.findViewById(R.id.main_text);
        name.setText(partItem.getMainText());

        return view;
    }

    // 設定されている CustomListItem の ArrayList を返す。
    // 縦横切替などでデータを移行するために使う。
    public ArrayList<PartItem> getPartItemList() {
        // 今回は Bundle#putParcelableArrayList() を使うことを想定する。
        // 必要に応じて Bundle#putSparseParcelableArray() を使ってもいい。

        int size = getCount();
        ArrayList<PartItem> PartItemList = new ArrayList<PartItem>(size);
        for (int index = 0; index < size; index++) {
            PartItemList.add(getItem(index));
        }
        return PartItemList;
    }

//    // Bundleから復元するときに必要になるはず。
//    public void addAll(ArrayList<PartItem> parcelableArrayList) {
//        // 強制でキャスト。落ちる場合は、設計か実装が間違っている。
//        @SuppressWarnings("unchecked")
//        ArrayList<PartItem> PartItemList = (ArrayList<PartItem>) parcelableArrayList;
//        super.addAll(PartItemList);
//    }
//
//    public void add(String partid, String mainText) {
//        PartItem partItem = PartItem.CREATOR;
//        super.add(partItem);
//    }
//
//    // 削除
//    public void remove(int index) {
//        if (index < 0 || index >= getCount()) {
//            return;
//        }
//        remove(getItem(index));
//    }
}