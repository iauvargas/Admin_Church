package com.optimalsystems.AdminChurch.adapters;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.optimalsystems.AdminChurch.R;
import com.optimalsystems.AdminChurch.providers.PostProvider;
import com.optimalsystems.AdminChurch.utils.RelativeTime;

public class PostAdapter extends AppCompatActivity {


    PostProvider mPostProvider;


    String mExtraPostId;


    TextView mTextViewRelativeTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        mTextViewRelativeTime = findViewById(R.id.textViewRelativeTime);

    }


    private void getPost() {
        mPostProvider.getPostById(mExtraPostId).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    if (documentSnapshot.contains("timestamp")) {
                        long timestamp = documentSnapshot.getLong("timestamp");
                        String relativeTime = RelativeTime.getTimeAgo(timestamp, PostAdapter.this);
                        mTextViewRelativeTime.setText(relativeTime);
                    }

                }
            }
        });
    }


}
