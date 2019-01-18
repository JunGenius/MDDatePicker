package com.qj.picker;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.qj.picker.calendarview.CalendarDay;
import com.qj.picker.calendarview.MaterialCalendarView;
import com.qj.picker.tool.DateUtil;

import java.util.Date;

/**
 * @author qujun
 * @des 自定日期选择器
 * @time 2019/1/18 0:17
 * Because had because, so had so, since has become since, why say why。
 **/

public class MDCalendarDialog {

    private MaterialCalendarView mcv = null;

    private Button btnSure = null;

    private TextView txtTitle = null;

    private MDCalendarDialog.Builder mBuilder = null;

    private AlertDialog dialog = null;

    MDCalendarDialog(MDCalendarDialog.Builder builder) {
        this.mBuilder = builder;
    }

    public void show() {

        dialog = new AlertDialog.Builder(mBuilder.mContext).create();
        dialog.setCancelable(mBuilder.isCancel);
        dialog.show();

        Window window = dialog.getWindow();

        if (window == null) {
            return;
        }

        window.setContentView(R.layout.custom_datetime_view);
        mcv = window.findViewById(R.id.mcv);
        btnSure = window.findViewById(R.id.btn_sure);
        txtTitle = window.findViewById(R.id.txt_title);
        txtTitle.setText(mBuilder.title);

        if (mBuilder.currentDate == null) {
            mBuilder.currentDate = new Date();
        }
        mcv.setSelectedDate(mBuilder.currentDate);
        mcv.setCurrentDate(mBuilder.currentDate);
        mcv.setSelectionColor(mBuilder.selectionColor);

        btnSure.setBackgroundResource(mBuilder.sureBackGroundColor);

        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBuilder.onDetermineSelectorListener == null) {
                    return;
                }
                CalendarDay date = mcv.getSelectedDate();
                if (date == null) {
                    mBuilder.onDetermineSelectorListener.noSelector();
                    return;
                }
                mBuilder.onDetermineSelectorListener.determineSelector(DateUtil.getNextDateStr(date.getDate(), 0), date.getDate());
                dialog.dismiss();
            }
        });
    }


    public static class Builder {

        private boolean isCancel = false;

        private Date currentDate = null;

        private String title = "";

        private Context mContext = null;

        private @ColorInt
        int selectionColor = Color.parseColor("#03a9f4");

        private @DrawableRes int sureBackGroundColor = R.drawable.login_btn_bg;

        private OnDetermineSelectorListener onDetermineSelectorListener = null;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setIsCancel(boolean isCancel) {
            this.isCancel = isCancel;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setCurrentDate(Date date) {
            currentDate = date;
            return this;
        }

        public Builder setSelectionColor(@StringRes int color) {
            selectionColor = color;
            return this;
        }

        public Builder setSureBackGroudColor(@StringRes int color) {
            sureBackGroundColor = color;
            return this;
        }

        public Builder onDetermineSeleterListener(OnDetermineSelectorListener onDetermineSelectorListener) {
            this.onDetermineSelectorListener = onDetermineSelectorListener;
            return this;
        }

        public MDCalendarDialog build() {
            return new MDCalendarDialog(this);
        }
    }


    public interface OnDetermineSelectorListener {

        void determineSelector(String dateStr, Date date);

        void noSelector();
    }
}
