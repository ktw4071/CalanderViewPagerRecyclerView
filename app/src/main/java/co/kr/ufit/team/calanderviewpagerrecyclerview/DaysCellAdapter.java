package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ccei on 2016-07-25.
 */
public class DaysCellAdapter extends RecyclerView.Adapter<DaysCellAdapter.ViewHolder>{
    int maximumDay;
    int startDay = 1;
    Context mContext;

    public DaysCellAdapter(Context mContext, int maximumDay){
        this.mContext = mContext;
        this.maximumDay = maximumDay;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRoot = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_grid_cell, parent, false);
        ViewHolder holder = new ViewHolder(itemRoot);
//        holder.day.setText(firstDay++);
//        holder.itemView.setTag(holder);
        return holder;
    }

    @Override
    public int getItemCount() {
        return maximumDay;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int abc = 123;
//        holder.day.setText("abc");
        holder.day.setText(String.valueOf(startDay++));

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView day;
        public ViewHolder(View itemView) {
            super(itemView);
            day = (TextView)itemView.findViewById(R.id.textView);
        }
    }


}
