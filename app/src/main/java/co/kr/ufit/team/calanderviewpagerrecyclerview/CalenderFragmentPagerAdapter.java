package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

/**
 * Created by ccei on 2016-07-27.
 */
public class CalenderFragmentPagerAdapter extends FragmentStatePagerAdapter {

    public CalenderFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Fragment getItem(int position) {
        return CalenderFragment.newInstance("달력", 15);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
