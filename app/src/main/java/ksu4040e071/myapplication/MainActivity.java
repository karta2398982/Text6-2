package ksu4040e071.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText ethomework, etexam, ettime, ettest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    private void findviews() {
        ethomework = (EditText) findViewById(R.id.ethomework);
        etexam = (EditText) findViewById(R.id.etexam);
        ettime = (EditText) findViewById(R.id.ettime);
        ettest = (EditText) findViewById(R.id.ettest);
    }

    private boolean isValid(EditText editText) {
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String test = editText.getText().toString();
        if (!test.matches(pattern)) {
            editText.setError("0 ~ 100");
            return false;
        } else {
            return true;
        }
    }

    public void onSubmit(View view) {
        boolean isValid =
                isValid(ethomework) & isValid(etexam) & isValid(ettime) & isValid(ettest);
        if (!isValid) {
            return;
        }
        int homework = Integer.parseInt(ethomework.getText().toString());
        int exam = Integer.parseInt(etexam.getText().toString());
        int time = Integer.parseInt(ettime.getText().toString());
        int test = Integer.parseInt(ettest.getText().toString());
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("homework", homework);
        bundle.putInt("exam", exam);
        bundle.putInt("time", time);
        bundle.putInt("test", test);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}



