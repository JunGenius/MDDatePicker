package com.qj.picker;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qj.picker.calendarview.CalendarDay;
import com.qj.picker.calendarview.MaterialCalendarView;
import com.qj.picker.tool.DateUtil;

import java.util.Date;

/**
 * @des 自定日期选择器
 * @author qujun
 * @time 2019/1/18 0:17
 * Because had because, so had so, since has become since, why say why。
 **/

public class CustomCalendarViewDialog {

    private Context context = null;

    private String title = "";

    private int iconTitle = 0;

    private MaterialCalendarView mcv = null;

    private Date currentDate = null;

    private OnDetermineSeleterListener onDetermineSeleterListener = null;

    private boolean isCancle = false;

    public CustomCalendarViewDialog(Context context) {
        this.context = context;
    }

    public CustomCalendarViewDialog(Context context, int icon, String title) {
        this.context = context;
        this.title = title;
        this.iconTitle = icon;
    }

    public void setCurremtDate(Date date) {
        currentDate = date;
    }

    public void setOnDetermineSeleterListener(OnDetermineSeleterListener onDetermineSeleterListener) {
        this.onDetermineSeleterListener = onDetermineSeleterListener;
    }

    public void setIsCancle(boolean isCancle) {
        this.isCancle = isCancle;
    }


    public void show() {
        final AlertDialog normalDialog =
                new AlertDialog.Builder(context).create();
        normalDialog.setCancelable(isCancle);
        normalDialog.show();
        Window window = normalDialog.getWindow();
        // *** 主要就是在这里实现这种效果的.
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.custom_datetime_view);

        mcv = (MaterialCalendarView) window.findViewById(R.id.mcv);
        Button btn = (Button) window.findViewById(R.id.button);
        ImageView imgTitleIcon = (ImageView) window.findViewById(R.id.img_icon);
        TextView txtTitle = (TextView) window.findViewById(R.id.txt_title);

        imgTitleIcon.setImageResource(iconTitle);
        txtTitle.setText(title);

        if (currentDate == null) {
            currentDate = new Date();
        }
        mcv.setSelectedDate(currentDate);
        mcv.setCurrentDate(currentDate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDetermineSeleterListener == null) {
                    return;
                }
                CalendarDay date = mcv.getSelectedDate();
                if (date == null) {
                    onDetermineSeleterListener.noSeleter();
                    return;
                }
                onDetermineSeleterListener.determineSeleter(DateUtil.getNextDateStr(date.getDate(), 0), date.getDate());
                normalDialog.dismiss();
            }
        });
    }


    public interface OnDetermineSeleterListener {

        public void determineSeleter(String dateStr, Date date);

        public void noSeleter();
    }
}
