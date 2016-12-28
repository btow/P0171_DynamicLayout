package com.example.samsung.p0171_dynamiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup)findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnCreate.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int viewId = v.getId();

        switch (viewId) {

            case R.id.btnCreate :
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.rbLeft :
                        layoutParams.gravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter :
                        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight :
                        layoutParams.gravity = Gravity.RIGHT;
                        break;
                }

                Button btnNew = new Button(this);
                btnNew.setId(llMain.getChildCount() + 1);
                btnNew.setText(etName.getText().toString());
                btnNew.setOnClickListener(this);
                llMain.addView(btnNew, layoutParams);

                break;
            case R.id.btnClear :
                llMain.removeAllViews();
                Toast.makeText(MainActivity.this, "All views is cleared", Toast.LENGTH_SHORT).show();
                break;
            default :
                Button button =  (Button) llMain.getChildAt(viewId);
                button.setText(button.getText().toString() + " " + viewId);
                break;
        }

    }
}
