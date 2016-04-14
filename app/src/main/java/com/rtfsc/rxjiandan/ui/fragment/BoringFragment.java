package com.rtfsc.rxjiandan.ui.fragment;

import com.rtfsc.rxjiandan.adapter.PictureAdapter;
import com.rtfsc.rxjiandan.rest.executor.PicturesExecutor;

/**
 * Created by rtfsc on 2016/4/14.
 */
public class BoringFragment extends PictureFragment {
    @Override
    protected PictureAdapter getAdapter() {
        return new PictureAdapter(this, PicturesExecutor.Builder.API_BORING_PICTURE);
    }
}
