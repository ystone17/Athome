package com.example.athome.payment_list;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.athome.R;

import java.util.ArrayList;

public class ChargeListFragment extends Fragment {
    private ListView charge_listview = null;
    private ArrayList<ItemPayListData> data = null;
    PaymentListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.charge_list_fragment, container, false);
        charge_listview = (ListView) view.findViewById(R.id.charge_listview);
        ArrayList<ItemPayListData> itemList = new ArrayList<>();

        //서버와 연동해서 값 띄워야함
        data = new ArrayList<>();

        ItemPayListData list1 = new ItemPayListData("2020-05-04 09:00","10000원","포인트충전");

        //리스트에 추가
        data.add(list1);


        //리스트 속의 아이템 연결
        adapter = new PaymentListAdapter(getContext(), R.layout.pay_listview_item, data);
        charge_listview.setAdapter(adapter);

        //해당 내역 클릭시 삭제
        charge_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(getContext())
                        .setTitle("충전내역 삭제")
                        .setMessage("해당 내역을 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                data.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();

                return;
            }
        });



        return view;

    }
}