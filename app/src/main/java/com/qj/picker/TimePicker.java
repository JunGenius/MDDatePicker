package com.qj.picker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;

import java.util.Calendar;

/**
 * @des 时间选择控件
 * @author qujun
 * @time 2019/1/18 0:17
 * Because had because, so had so, since has become since, why say why。
 **/


public class TimePicker extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //得到日期对象
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }
//    @Override
//    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
////        Toast.makeText(getActivity(), "当前时间设置为： " + hourOfDay + " : " + minute, Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        listener.onTimeSet(view, hourOfDay, minute);
    }

    private OnTimeSetListener listener = null;

    public void setOnTimeSetListener(OnTimeSetListener listener) {
        this.listener = listener;
    }

    public interface OnTimeSetListener {
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute);
    }
}
