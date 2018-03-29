package com.example.ahmed.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Listitem> listitems = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listitems.add(new Listitem("ahmed "+i,"hi ahmed"));
        }
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(listitems);
        ListView listView = (ListView) findViewById(R.id.lstView);
        listView.setAdapter(myCustomAdapter);

    }
    class  MyCustomAdapter extends BaseAdapter{
    ArrayList<Listitem> items=new ArrayList<>();

        public MyCustomAdapter(ArrayList<Listitem> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i).name;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.row_view,null);
            final TextView nameTXT=(TextView) view1.findViewById(R.id.textView);
            TextView descTXT = (TextView) view1.findViewById(R.id.textView2);

            nameTXT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),nameTXT.getText(),Toast.LENGTH_SHORT).show();
                }
            });
            nameTXT.setText(items.get(i).name);
            descTXT.setText(items.get(i).Desc);

            return  view1;
        }
    }
}
