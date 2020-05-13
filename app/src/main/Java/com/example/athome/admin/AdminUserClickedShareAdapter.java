package com.example.athome.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.athome.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdminUserClickedShareAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<AdminUserClickedShareData> data = null;
    private int layout;

    //생성자
    public AdminUserClickedShareAdapter(Context context, int layout, ArrayList<AdminUserClickedShareData> data)
    {
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout=layout;
    }

    //화면 갱신되기전 호출
    //처음 생성될때도 getCount()가 호출되어 아이템이 몇개 그려질지 결정
    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public String getItem(int position)
    {
        return data.get(position).getId();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    //리턴할때 각 아이템레이아웃을 넘겨주면 화면에 표시
    //포지션으로 현재 몇번째 아이템이 표시해야되는지 알 수 있음
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.admin_user_clicked_share_item, parent, false);
        }

        AdminUserClickedShareData shareData=data.get(position);
        TextView userId = convertView.findViewById(R.id.clicked_share_id);
        TextView loc = (TextView) convertView.findViewById(R.id.clicked_share_place);
        TextView shareDate = (TextView) convertView.findViewById(R.id.clicked_share_date);
        TextView shareStart = (TextView) convertView.findViewById(R.id.clicked_share_start);
        TextView shareEnd = (TextView) convertView.findViewById(R.id.clicked_share_end);
        TextView shareState = (TextView) convertView.findViewById(R.id.clicked_share_state);

        userId.setText(shareData.getId());
        loc.setText(shareData.getLoc());
        shareDate.setText(shareData.getShare_date());
        shareStart.setText(shareData.getShare_start());
        shareEnd.setText(shareData.getShare_end());
        shareState.setText(shareData.getState());


        return convertView;
    }


}
