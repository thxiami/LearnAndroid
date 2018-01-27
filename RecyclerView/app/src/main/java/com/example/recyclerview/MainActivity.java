package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruitList();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        FruitAdapter adapter = new FruitAdapter(fruitList);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initFruitList() {
        String[] nameList = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape"};
        int[] idList = {R.drawable.apple_pic, R.drawable.banana_pic, R.drawable.orange_pic,
                R.drawable.watermelon_pic, R.drawable.pear_pic, R.drawable.grape_pic};

        for (int j=0; j < 4; j++) {
            for (int i = 0; i < nameList.length; i++) {
                Fruit fruit = new Fruit(getRandomName(nameList[i]), idList[i]);
                fruitList.add(fruit);
            }
        }


//        for (int i = 0; i < 2; i++) {
//            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
//            fruitList.add(apple);
//            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
//            fruitList.add(banana);
//            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
//            fruitList.add(orange);
//            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
//            fruitList.add(watermelon);
//            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
//            fruitList.add(pear);
//            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
//            fruitList.add(grape);
//            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
//            fruitList.add(pineapple);
//            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
//            fruitList.add(strawberry);
//            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
//            fruitList.add(cherry);
//            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
//            fruitList.add(mango);
//        }
    }

    private String getRandomName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();

        for(int i=0; i< length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}