package ksu4040e071.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = (TextView) findViewById(R.id.result);
        showResults();
    }

    private void showResults() {
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int homework = bundle.getInt("homework");
        int exam = bundle.getInt("exam");
        int time = bundle.getInt("time");
        int test = bundle.getInt("test");
        int sum = homework + exam + time + test;
        double average = sum / 4.0;
        String output = "作業成績 = " + homework +
                "\n小考成績 = " + exam +
                "\n平時成績 = " + time +
                "\n期末考成績 = " + test +
                "\n總分 = " + sum +
                "\n平均 = " + nf.format(average);
        result.setText(output);
    }

    public void onBack(View view){
        finish();
    }
}
