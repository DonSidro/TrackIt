package com.atidon.trackit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SidonKK on 30/03/2017.
 */

public class TaskViewController extends RecyclerView.Adapter<TaskViewController.Holder>  {



    private ArrayList<Task> listData;
    private LayoutInflater inflater;

    private ItemClickCallBack itemClickCallBack;


    public interface ItemClickCallBack {

        void onItemClick(View v, int p);

    }

    public void setItemClickCallBack(final ItemClickCallBack itemClickCallBack) {
        this.itemClickCallBack = itemClickCallBack;
    }

    public TaskViewController(ArrayList<Task> listData, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.listData = listData;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_item, parent, false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Task task = listData.get(position);
        holder.title.setText(task.getTitle());
        holder.subTitle.setText(task.getDescription());
        holder.status.setText(task.getStatus());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView subTitle;
        private TextView status;
        private ImageView icon;
        private View container;

        AdapterView.OnItemClickListener mItemClickListener;


        public Holder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title_task);
            subTitle = (TextView) itemView.findViewById(R.id.subtitle_task);
            status = (TextView) itemView.findViewById(R.id.status_task);
            container = itemView.findViewById(R.id.itemCard);
            container.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.itemCard) {
                itemClickCallBack.onItemClick(v, getAdapterPosition());
            }

        }

    }
}
