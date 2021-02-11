package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    Fruit[] fruitList = {new Fruit ("Груша", "Это груша", R.drawable.grusha),
            new Fruit ("Апельсин", "Это не апельсин", R.drawable.juice),
            new Fruit ("Горчица", "Кот в горчице", R.drawable.gorchica),
            new Fruit ("?", "А где?", R.drawable.tabletka),
            new Fruit ("В", "D:", R.drawable.osujdayu),
            new Fruit ("Горчица", "Кот в горчице", R.drawable.gorchica)};

    Random rand = new Random();
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        FruitAdapter adapter = new FruitAdapter(this, fruits);
        int numberOfColumns = 3;
        int spacingInPixels = 10;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerView.setAdapter(adapter);
        rand = new Random();
        setTitle("Фрукты, овощи, я");
    }
    private void setInitialData(){
        for (int i = 0; i < 20; i++){
            fruits.add(fruitList[rand.nextInt(fruitList.length-1)]);
        }
    }

    public void callToast(View view) {
        TextView nameTW = view.findViewById(R.id.name);
        String name = nameTW.getText().toString();
        toast.makeText(getApplicationContext(),"Выбран элемент - " + name,Toast.LENGTH_SHORT).show();
    }
}