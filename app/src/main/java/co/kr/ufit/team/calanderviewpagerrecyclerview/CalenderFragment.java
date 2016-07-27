package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private int firstDay;
    private DaysCellAdapter mAdapter;

    public static CalenderFragment newInstance(String title, int page) {
        CalenderFragment calenderFragment = new CalenderFragment();
        Bundle args = new Bundle();
        args.putInt("SomeInt", page);
        args.putString("SomeTitle", title);
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
        RecyclerView mRecycler = (RecyclerView)view.findViewById(R.id.recycler);
        mGM = new GridLayoutManager(super.getContext(), columnCount, 1, false);
        mRecycler.setLayoutManager(new GridLayoutManager(super.getContext(), columnCount, 1, false));
        mRecycler.addItemDecoration(new DividerItemDecoration(super.getContext(), 1));
        mAdapter = new DaysCellAdapter(super.getContext(), firstDay);
        mRecycler.setAdapter(mAdapter);
        return view;
    }
}
