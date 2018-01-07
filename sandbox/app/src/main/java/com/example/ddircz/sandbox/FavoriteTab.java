package com.example.ddircz.sandbox;

/**
 * Created by acer-pc on 4/9/2017.
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FavoriteTab extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.favoritestab, container, false);
        return rootView;
    }
}
