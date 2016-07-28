package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by ccei on 2016-07-27.
 */
public class CalenderFragmentPagerAdapter extends FragmentStatePagerAdapter {
    Calendar calender = Calendar.getInstance(Locale.getDefault());
    int year;
    int month;
    int maximum_day;

    public CalenderFragmentPagerAdapter(FragmentManager fm, int year, int month) {
        super(fm);
        this.year = year;
        this.month = month;
        this.maximum_day = calender.getActualMaximum(calender.DAY_OF_MONTH);

//        calender.set(Calendar.YEAR, year);
//        calender.set(Calendar.MONTH, month);
        calender.set(Calendar.DATE, 1);

        int startDay = calender.get(Calendar.DAY_OF_WEEK);

        Log.e("첫째날 기본값된다 ? ? ", ""+ startDay);

        Log.e("이달의 최대일수는 ? ", ""+this.maximum_day);

        int abc = calender.getFirstDayOfWeek();
        Log.e("123123첫재쭈 일수는 ? ? ", ""+ abc);
//        Log.e("111첫재쭈 일수는 ? ? ", ""+ calender.DAY_OF_WEEK_);
        calender.set(2015, 6, 1);
        startDay = calender.get(Calendar.DAY_OF_WEEK);

//        abc = calender.getFirstDayOfWeek();
        Log.e("야야야 일수는 ? ", ""+ startDay);

        calender.set(Calendar.YEAR, 2015);
        calender.set(Calendar.MONTH, 6);
        calender.set(Calendar.DATE, 1);

        startDay = calender.get(Calendar.DAY_OF_WEEK);

        Log.e("동일하지만다른 일수는 ? ", ""+ startDay);

    }

    //    public CalenderFragmentPagerAdapter(FragmentManager fm) {
//        super(fm);
//    }



    @Override
    public int getCount() {
        return 50000;
    }

    @Override
    public Fragment getItem(int position) {
        int startingDay;
        Log.e("프래그먼트 포지션 getITEM", "" + position);
        Log.e("다음달 포지션월은 뭐지?", "" + (position % 12));

     return CalenderFragment.newInstance(month, maximum_day);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d("파괴", position + "번째");
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.e("프래그먼트 포지션 tantiateItem", "" + position);
        return super.instantiateItem(container, position);
    }

//    @Override
//    public float getPageWidth(int position) {
//        return 0.5f;
//    }


}
