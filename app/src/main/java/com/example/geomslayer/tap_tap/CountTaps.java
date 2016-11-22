package com.example.geomslayer.tap_tap;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.NumberPicker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountTaps extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.count_taps));

        final NumberPicker count = new NumberPicker(getContext());
        count.setMinValue(1);
        count.setMaxValue(Integer.MAX_VALUE);
        count.setWrapSelectorWheel(false);
        count.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        count.setValue(((MainActivity) getActivity()).getCountTaps());

        FrameLayout parent = new FrameLayout(getActivity());
        parent.addView(count, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER));
        builder.setView(parent);

        builder.setPositiveButton(getString(R.string.apply), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((MainActivity) getActivity()).setCountTaps(count.getValue());
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

}
