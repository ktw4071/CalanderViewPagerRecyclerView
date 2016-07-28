package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by ccei on 2016-07-26.
 */
public class CalenderFragment extends Fragment {
    private String title;
    private int page;

    /////프래그먼트가 리싸이클러뷰를 감싸는 코드 변수
    private RecyclerView mRecycler;
    private GridLayoutManager mGM;
    private int columnCount = 7;
    private DaysCellAdapter mAdapter;

    //    private Calendar today = Calendar.getInstance(Locale.getDefault());

    public static CalenderFragment newInstance(int  month, int maximumDay) {
        CalenderFragment calenderFragment = new CalenderFragment();
        Bundle args = new Bundle();
        args.putInt("ThisMonth", month);
        args.putInt("ThisMaximumDay", maximumDay);
        calenderFragment.setArguments(args);
        return calenderFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        mRecycler = (RecyclerView)view.findViewById(R.id.recycler);
        mGM = new GridLayoutManager(super.getContext(), columnCount, 1, false);
        mRecycler.setLayoutManager(new GridLayoutManager(super.getContext(), columnCount, 1, false));
        mRecycler.addItemDecoration(new DividerItemDecoration(super.getContext(), 1));
        mAdapter = new DaysCellAdapter(super.getContext(), super.getArguments().getInt("ThisMaximumDay"));
        mRecycler.setAdapter(mAdapter);

        final GestureDetector mGestureDetector = new GestureDetector(super.getContext(), new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        mRecycler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = mRecycler.findChildViewUnder(e.getX(), e.getY());
                if (child != null && mGestureDetector.onTouchEvent(e)) {
                    child.setBackgroundColor(Color.parseColor("#FFFF00"));
                    Toast.makeText(getActivity() , "The Item Clicked is: " + (rv.getChildAdapterPosition(child) + 1) + "일 출첵!", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });



//        mRecycler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//                Toast.makeText(getContext(), "adfdsf", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
        return view;
    }



}
