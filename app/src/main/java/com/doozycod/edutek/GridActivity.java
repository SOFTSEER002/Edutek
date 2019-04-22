package com.doozycod.edutek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

public class GridActivity extends AppCompatActivity {
    LinearLayout notice_button;
    public static int[] grid_icons = {R.drawable.time_table,
            R.drawable.home_work,
            R.drawable.attendence,
            R.drawable.fees,
            R.drawable.gallery_icon,
            R.drawable.events_icon,
            R.drawable.birthday_icon,
            R.drawable.poll_icon,
            R.drawable.discussions_icon,
            R.drawable.result_icon,
            R.drawable.syllabus,
            R.drawable.ptm_icon};
    public static String[] url = {"", "http://eduteksolutions.in/Parent/frmInBox.aspx","http://eduteksolutions.in/Parent/frmStudentAttendance.aspx","","","","","","","","",""};
    String notice_url ="http://eduteksolutions.in/Parent/frmViewSMS.aspx";
    public static String[] grid_item_names = {"Time Table", "Homework", "Attendence", "Fees", "Gallery", "Events", "Birthday", "Poll", "Discussions", "Result", "Syllabus", "PTM"};
    GridView gridView;
    GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.grid_view);

        gridView.setAdapter(new GridAdapter(this, grid_item_names, grid_icons,url));

        notice_button = findViewById(R.id.Notification_button);
        notice_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridActivity.this,WebViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url",notice_url);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}

