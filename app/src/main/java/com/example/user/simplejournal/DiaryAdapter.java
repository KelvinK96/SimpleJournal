package com.example.user.simplejournal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.simplejournal.data.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    private List<ListDiary> listDiaries;
    ViewDiaryContent viewDiaryContent;

    public DiaryAdapter(List<ListDiary> listDiaries, Context context, ViewDiaryContent viewDiaryContent) {
        this.listDiaries = listDiaries;
        Context context_l = context;
        this.viewDiaryContent = viewDiaryContent;
    }


    @NonNull
    @Override
    public DiaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_diary_content, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryAdapter.ViewHolder holder, int position) {
        ListDiary diary = listDiaries.get(position);
        String dTitle = diary.getDiaryTitle();
        String dContent = diary.getDiaryContent();

        holder.textViewTitle.setText(dTitle);
        holder.textViewContent.setText(dContent);
        holder.cardView_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDiaryContent.showSelectedContent();
//                viewDiaryContent.switchToTodoDetails();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDiaries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewContent;
        CardView cardView_d;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.tv_title);
            textViewContent = itemView.findViewById(R.id.tv_content);
            cardView_d = itemView.findViewById(R.id.cv_list_diary);
        }
    }


}
