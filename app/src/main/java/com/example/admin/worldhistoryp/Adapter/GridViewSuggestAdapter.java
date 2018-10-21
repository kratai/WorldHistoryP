package com.example.admin.worldhistoryp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.admin.worldhistoryp.Common.Common;
import com.example.admin.worldhistoryp.picquiz;

import java.util.List;




public class GridViewSuggestAdapter extends BaseAdapter {

    private List<String> suggestSource;
    private Context context;
    private picquiz picquizq;

    public GridViewSuggestAdapter(List<String> suggestSource, Context context, picquiz picquiz) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.picquizq = picquiz;
    }

    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if(convertView == null)
        {
            if(suggestSource.get(position).equals("null"))
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);
            }
            else
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);
                button.setTextColor(Color.YELLOW);
                button.setText(suggestSource.get(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //If correct answer contains character user selected
                        if(String.valueOf(picquizq.answer).contains(suggestSource.get(position)))
                        {
                            char compare = suggestSource.get(position).charAt(0); // Get char

                            for(int i =0;i<picquizq.answer.length;i++)
                            {
                                if(compare == picquizq.answer[i])
                                    Common.user_submit_answer[i] = compare;
                            }

                            //Update UI
                            GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(Common.user_submit_answer,context);
                            picquizq.gridViewAnswer.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();

                            //Remove from suggest source
                            picquizq.suggestSource.set(position,"null");
                            picquizq.suggestAdapter = new GridViewSuggestAdapter(picquizq.suggestSource,context,picquizq);
                            picquizq.gridViewSuggest.setAdapter(picquizq.suggestAdapter);
                            picquizq.suggestAdapter.notifyDataSetChanged();
                        }
                        else // else
                        {
                            //Remove from suggest source
                            picquizq.suggestSource.set(position,"null");
                            picquizq.suggestAdapter = new GridViewSuggestAdapter(picquizq.suggestSource,context,picquizq);
                            picquizq.gridViewSuggest.setAdapter(picquizq.suggestAdapter);
                            picquizq.suggestAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
        else
            button = (Button)convertView;
        return button;

    }
}