package com.zwonb.chattest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private List<ChatBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.main_list_view);


        for (int i = 0; i < 50; i++) {
            ChatBean bean = new ChatBean();
            bean.setContent("ChatContent"+i);
            mList.add(bean);
        }
        listView.setAdapter(new MyAdapter(mList));
    }

    private class MyAdapter extends BaseAdapter {

        private List<ChatBean> mList;

        MyAdapter(List<ChatBean> mList) {
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                holder = new Holder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent,false);
                holder.textView = (TextView) convertView.findViewById(R.id.item_content);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.textView.setText(mList.get(position).getContent());
            return convertView;
        }

        class Holder {
            TextView textView;
        }
    }


}
