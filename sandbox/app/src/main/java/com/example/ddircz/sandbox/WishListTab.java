package com.example.ddircz.sandbox;

/**
 * This class stores all of the information about the wish list (2nd) tab
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WishListTab extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wishlisttab, container, false);
        return rootView;
    }
}