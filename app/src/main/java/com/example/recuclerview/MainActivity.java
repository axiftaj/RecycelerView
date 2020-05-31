package com.example.recuclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.example.recuclerview.Model.RowModel;
import com.example.recuclerview.MyAdapter.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    Adapter myAadpter ;
    List<RowModel> modelList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Recycler View");
        actionBar.setDisplayShowHomeEnabled(true);
        recyclerView = findViewById(R.id.recylerView) ;
        modelList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList.add(new RowModel("John Wick" , "Hi there i'm doing great" , R.drawable.profile));
        modelList.add(new RowModel("Ali john" , "this is john " , R.drawable.profile));
        modelList.add(new RowModel("Compare things" , "I;m fine " , R.drawable.profile));
        modelList.add(new RowModel("Pakistan" , "I;m fine " , R.drawable.profile));
        modelList.add(new RowModel("India" , "I;m fine " , R.drawable.profile));
        modelList.add(new RowModel("USA" , "I;m fine " , R.drawable.profile));
        modelList.add(new RowModel("China" , "I;m fine " , R.drawable.profile));
        modelList.add(new RowModel("Rusia" , "I;m fine " , R.drawable.profile));
        modelList.add(new RowModel("Japan" , "I;m fine " , R.drawable.profile));
        modelList.add(new RowModel("Professor" , "Hi there i'm doing great" , R.drawable.profile));
        modelList.add(new RowModel("Berlin" , "Hi there i'm doing great" , R.drawable.usertwo));
        modelList.add(new RowModel("Oslo" , "Hi there i'm doing great" , R.drawable.profile));
        modelList.add(new RowModel("John Wick" , "Hi there i'm doing great" , R.drawable.profile));
        modelList.add(new RowModel("John Wick" , "Hi there i'm doing great" , R.drawable.profile));
        modelList.add(new RowModel("John Wick" , "Hi there i'm doing great" , R.drawable.profile));


//        for (int i = 0 ; i < 10 ; i++ ){
//            RowModel rowModel = new RowModel("John Wick" , "Hi there i'm doing great" , R.drawable.profile);
//            modelList.add(rowModel);
//
//        }
        myAadpter = new Adapter(this , modelList);
        recyclerView.setAdapter(myAadpter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);

        MenuItem item = menu.findItem(R.id.search_bar);

        SearchView searchView = (SearchView)item.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myAadpter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAadpter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
