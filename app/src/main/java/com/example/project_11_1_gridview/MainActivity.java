package com.example.project_11_1_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> mid = new ArrayList<String>();
        ListView lv = (ListView) findViewById(R.id.lv1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mid);
        lv.setAdapter(adapter);

        final EditText edt1 = (EditText) findViewById(R.id.edt1);
        Button bt1 = (Button) findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mid.add(edt1.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mid.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}