package com.moesystems.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        series= new ArrayList<>();
        rv= findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();


        adapter=new SeriesAdapter(series, new SeriesAdapter.MyAdapterListener(){
            @Override
            public void toastOnClick(View v, int position) {
                Toast.makeText(getApplicationContext() ,series.get(position).getDesc()+"\nPages: "+series.get(position).getCaps() ,Toast.LENGTH_SHORT).show();

            }
        });
        rv.setAdapter(adapter);
    }

    private void prepareSeries() {

        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("The Walking Dead","13", R.drawable.twd,"Tv show 1"));
        series.add(new Serie("Games of Thrones","13", R.drawable.got,"Tv show 2"));
        series.add(new Serie("Breaking Bad","13", R.drawable.bb,"Tv show 3"));


    }
    public void btnView(View v){

    }


}
