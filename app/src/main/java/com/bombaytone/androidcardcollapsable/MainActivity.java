package com.bombaytone.androidcardcollapsable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeScroll;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cvRoot;
    Button btnToggle;
    ConstraintLayout clToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvRoot = findViewById(R.id.cvRoot);
        btnToggle = findViewById(R.id.btnToggle);
        clToggle = findViewById(R.id.clToggle);

        btnToggle.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnToggle:

                if(clToggle.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cvRoot, new AutoTransition());
                    clToggle.setVisibility(View.VISIBLE);
                    float deg = btnToggle.getRotation() + 90F;
                    btnToggle.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
                } else {
                    TransitionManager.beginDelayedTransition(cvRoot, new AutoTransition());
                    clToggle.setVisibility(View.GONE);
                    float deg = btnToggle.getRotation() - 90F;
                    btnToggle.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
                }
                break;
        }
    }
}