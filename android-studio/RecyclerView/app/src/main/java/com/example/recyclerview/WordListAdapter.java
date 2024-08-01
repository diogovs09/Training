package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    public final TextView wordItemView;
    final WordListAdapter mAdapter;

    public WordViewHolder(View itemView, WordListAdapter adapter) {
        super(itemView);
        wordItemView = (TextView) itemView.findViewById(R.id.word);
        this.mAdapter = adapter;
    }
}
