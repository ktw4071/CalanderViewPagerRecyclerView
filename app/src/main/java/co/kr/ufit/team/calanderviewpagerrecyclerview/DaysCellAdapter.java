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
    int firstDay;
    Context mContext;

    public DaysCellAdapter(Context mContext, int firstDay){
        this.mContext = mContext;
        this.firstDay = firstDay;
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
        return 31;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int abc = 123;
//        holder.day.setText("abc");
        holder.day.setText(String.valueOf(abc++));

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView day;
        public ViewHolder(View itemView) {
            super(itemView);
            day = (TextView)itemView.findViewById(R.id.textView);
        }
    }
}
