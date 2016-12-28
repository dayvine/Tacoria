package com.davidvinegar.tacoria.Activities;
//helpful http://arjunu.com/2015/10/android-recyclerview-with-different-cardviews/
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidvinegar.tacoria.Adapters.FirstChoiceAdapter;
import com.davidvinegar.tacoria.Adapters.FirstChoiceOption;
import com.davidvinegar.tacoria.R;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class OrderFirstChoiceActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutMnaager;
    private ArrayList<FirstChoiceOption> firstChoiceOptionList;

    private String[] mDataSet = {"Burrito", "Tacos", "Quesadillas Suiza"};

    TextView foodName;
    ImageView foodPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_order_choice_activity_layout);

//        foodPhoto = (ImageView)findViewById(R.id.beautiful_burrito);
//        foodName = (TextView)findViewById(R.id.burrito_text);
//
//        foodName.setText("Burrito");
//        foodPhoto.setImageResource(R.drawable.burrito);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutMnaager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutMnaager);

        mRecyclerView.setHasFixedSize(true);



        initializeData();
        mAdapter = new FirstChoiceAdapter(firstChoiceOptionList, this.getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initializeData (){
        firstChoiceOptionList = new ArrayList<>();
        FirstChoiceOption burrito = new FirstChoiceOption("Burrito", R.drawable.burrito);
        FirstChoiceOption tacos = new FirstChoiceOption("Tacos", R.drawable.tacos);

        firstChoiceOptionList.add(burrito);
        firstChoiceOptionList.add(tacos);
    }


}