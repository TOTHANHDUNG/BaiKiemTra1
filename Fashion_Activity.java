package com.example.siger;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Fashion_Activity extends AppCompatActivity {

    ListView lvFashion;
    ArrayList<Fashion> arrayFashion;
    FashionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dong_fashion);
        AnhXa();
        adapter = new FashionAdapter(this, R.layout.activity_fashion, arrayFashion);
        lvFashion.setAdapter(adapter);

        lvFashion.setOnItemLongClickListener(new ItemLongClickRemove());
    }
    private void AnhXa(){
        lvFashion = (ListView) findViewById(R.id.listviewFashion);
        arrayFashion = new ArrayList<>();

        arrayFashion.add(new Fashion("NGÔ KIẾN HUY","BẮP", R.drawable.anhtu,"100*"));
        arrayFashion.add(new Fashion("TRẤN THÀNH","THÀNH CRY",R.drawable.toctien,"67*"));
        arrayFashion.add(new Fashion("TÔ KIM ANH","TÓC TIÊN",R.drawable.nkh,"99*"));
        arrayFashion.add(new Fashion("LÊ THỊ THỦY TIÊN","THUYE TIÊN",R.drawable.tranthanh,"77*"));
        arrayFashion.add(new Fashion("TRẦN ANH TÚ","ANH TÚ",R.drawable.thuytien,"88*"));
        arrayFashion.add(new Fashion("LÊ ANH TÚ","VÂN ANH",R.drawable.anhtu,"43*"));
        arrayFashion.add(new Fashion("NGUYỄN TRẤN THÀNH","A XÌN",R.drawable.nkh,"34*"));
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Fashion_Activity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    arrayFashion.remove(position);
                    //cập nhật lại listview
                    adapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}