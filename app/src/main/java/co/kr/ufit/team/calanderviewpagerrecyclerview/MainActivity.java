package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    GridView gridView;
    ListView listview;
//    private RecyclerView mRecycler;
//
//    private GridLayoutManager mGM;
//    private int columnCount = 7;
//    private int firstDay;
//    private DaysCellAdapter mAdapter;

    ViewPager pager;
    CalenderFragmentPagerAdapter mFragmentAdapter = new CalenderFragmentPagerAdapter(getSupportFragmentManager());

    static final String[] monday_to_sunday = new String[]{
            "M", "T", "W", "T", "F", "S", "S"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.grid_view_monday_to_sunday);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monday_to_sunday);
        gridView.setAdapter(adapter);
//        mRecycler = (RecyclerView) findViewById(R.id.recycler);
//        mGM = new GridLayoutManager(this, columnCount, 1, false);


//
//
//        mRecycler.setLayoutManager(mGM);
//        mRecycler.addItemDecoration(new DividerItemDecoration(this, 1));
//        mRecycler.addItemDecoration(new DividerItemDecoration(this, 0));
//        mAdapter = new DaysCellAdapter(this, firstDay);
//        mRecycler.setAdapter(mAdapter);

        pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(mFragmentAdapter);

        listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1,new String[]{"원빈 10시","장동건 12시","이나영 1시","정우성 4시"}));


    }
}
