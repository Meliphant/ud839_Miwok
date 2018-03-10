package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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

    private int mColorResourceId;
    //private int mSound;

    public WordAdapter(Activity activity, ArrayList<Word> words, int colorBackground) {
        super(activity, 0, words);
        mColorResourceId = colorBackground;
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

        View textContainer = currentListItemView.findViewById(R.id.text_template);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        //mSound = currentWord.getSound();

        return currentListItemView;
    }
}
