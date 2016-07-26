package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    private RecyclerView mRecycler;

    private GridLayoutManager mGM;
    private int columnCount = 7;
    private int firstDay;
    private DaysCellAdapter mAdapter;




    static final String[] monday_to_sunday = new String[]{
            "M", "T", "W", "T", "F", "S", "S"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.grid_view_monday_to_sunday);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monday_to_sunday);
        gridView.setAdapter(adapter);

        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mGM = new GridLayoutManager(this, columnCount, 1, false);


        mRecycler.setLayoutManager(mGM);
        mRecycler.addItemDecoration(new DividerItemDecoration(this, 1));
//        mRecycler.addItemDecoration(new DividerItemDecoration(this, 0));
        mAdapter = new DaysCellAdapter(this, firstDay);
        mRecycler.setAdapter(mAdapter);

    }
}
