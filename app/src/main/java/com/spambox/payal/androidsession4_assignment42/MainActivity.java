package com.spambox.payal.androidsession4_assignment42;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    List<People> planetsList = new ArrayList<People>();
    Adapter aAdpt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        ListView lv = (ListView) findViewById(R.id.list);
        aAdpt = new Adapter(planetsList, this);
        lv.setAdapter(aAdpt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                TextView clickedView = (TextView) view;
                Toast.makeText(MainActivity.this, "Item with id ["+id+"] - Position ["+position+"] " +
                        "- Person ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();

            }
        });
        registerForContextMenu(lv);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        People person =  aAdpt.getItem(aInfo.position);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        planetsList.remove(aInfo.position);
        aAdpt.notifyDataSetChanged();
        return true;
    }
    private void initList() {
        planetsList.add(new People("Harry Potter", 123456789));
        planetsList.add(new People("Ron Weasley", 234567891));
        planetsList.add(new People("Hermione Granger", 345678912));
        planetsList.add(new People("Neville Longbottom", 456789123));
        planetsList.add(new People("Dumbledore", 567891234));
        planetsList.add(new People("Mc Gonagal", 678912345));
        planetsList.add(new People("Hargrid", 789123456));
    }
}