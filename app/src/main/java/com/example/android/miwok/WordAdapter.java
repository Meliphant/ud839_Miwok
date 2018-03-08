package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Meliphant on 24.02.2018.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    public WordAdapter(Activity activity, ArrayList<Word> words){
        super(activity, 0, words);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentListItemView = convertView;
        if (currentListItemView == null){
            currentListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView currentMiwokWord = (TextView) currentListItemView.findViewById(R.id.template_miwok);
        currentMiwokWord.setText(currentWord.getMiwokTranslation());

        TextView currentEnglishWord = (TextView) currentListItemView.findViewById(R.id.template_english);
        currentEnglishWord.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) currentListItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImage());
            imageView.setVisibility(View.VISIBLE);
        }
        else imageView.setVisibility(View.GONE);
        return currentListItemView;
    }
}
