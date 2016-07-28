package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //날짜계산을 해보자
    Calendar calender = Calendar.getInstance(Locale.getDefault());

    int this_year = calender.get(Calendar.YEAR);
    int this_month = calender.get(Calendar.MONTH);
    int this_maximum_day = calender.getActualMaximum(calender.DAY_OF_MONTH);

    int currentPosition;

    {
        Log.d("칼랜더 정보!", "" + calender);
    }

    {
        Log.d("이달의 날짜수", "" + calender.getActualMaximum(calender.DAY_OF_MONTH));
    }

    {
        Log.d("먼쓰 테스트", "" + calender.DAY_OF_MONTH);
    }

    {
        Log.d("이번달은?", "" + calender.get(Calendar.MONTH));
    }

    {
        Log.d("이번년은?", "" + calender.get(Calendar.YEAR));
    }

    private Context mContext;
    TextView textView;
    GridView gridView;
    ListView listview;


//    private RecyclerView mRecycler;
//
//    private GridLayoutManager mGM;
//    private int columnCount = 7;
//    private int firstDay;
//    private DaysCellAdapter mAdapter;

    ViewPager pager;
    CalenderFragmentPagerAdapter mFragmentAdapter = new CalenderFragmentPagerAdapter(getSupportFragmentManager(), this_year, this_month);

    static final String[] monday_to_sunday = new String[]{
            "M", "T", "W", "T", "F", "S", "S"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.tv_date);
        gridView = (GridView)findViewById(R.id.grid_view_monday_to_sunday);
        listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1,new String[]{(this_month + 1) + "월 스케쥴입니다", "원빈 10시","장동건 12시","이나영 1시","정우성 4시"}));


        textView.setText(this_year + " . " + (++this_month));

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
        pager.setCurrentItem(this_month + 20736);
        currentPosition = pager.getCurrentItem();
        Log.e("메인에서의 포지션", "" + currentPosition);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

//            private ViewPager   mViewPager;
            private int         mCurrentPosition;
            private int         mScrollState;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageSelected(int position) {
                if(currentPosition < position) {
                    if(this_month == 12){
                        this_month = 1;
                        this_year++;
                    }

                    else
                        ++this_month;
                } else if(currentPosition > position){
                    if(this_month == 1) {
                        this_month = 12;
                        this_year--;
                    }
                    else
                        --this_month;
                }
                currentPosition = position;



                textView.setText(this_year + " . " + (this_month));
                listview.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1,new String[]{(this_month) + "월 스케쥴입니다", "원빈 10시","장동건 12시","이나영 1시","정우성 4시"}));
//                Log.d("왼쪽", "" + pager.getNextFocusLeftId());
//                Log.d("오른쪽", "" +pager.getNextFocusRightId());
                Log.d("지금보는 월은?", "" + (pager.getCurrentItem()+1));



                // 다시 어뎁터 셋을 하면, 새로운 뷰 로딩이 무척 늦어짐..
                // 스크롤 시에, 바뀌는 달을 프래그먼트에 전달하는 방법은 뭘까?
//                pager.setAdapter(new CalenderFragmentPagerAdapter(getSupportFragmentManager(), this_year, this_month, this_maximum_day));

            }

//            private void handleScrollState(final int state) {
//                if (state == ViewPager.SCROLL_STATE_IDLE) {
//                    setNextItemIfNeeded();
//                }
//            }
//
//            private void setNextItemIfNeeded() {
//                if (!isScrollStateSettling()) {
//                    handleSetNextItem();
//                }
//            }
//
//            private boolean isScrollStateSettling() {
//                return mScrollState == ViewPager.SCROLL_STATE_SETTLING;
//            }
//
//            private void handleSetNextItem() {
//                final int lastPosition = pager.getAdapter().getCount() - 1;
//                if(mCurrentPosition == 0) {
//                    pager.setCurrentItem(lastPosition, false);
//                } else if(mCurrentPosition == lastPosition) {
//                    pager.setCurrentItem(0, false);
//                }
//            }

        });


        //listview.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1,new String[]{"원빈 10시","장동건 12시","이나영 1시","정우성 4시"}));


    }
}
