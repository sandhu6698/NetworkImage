package com.example.lenovo.networkimage;

import android.graphics.Bitmap;
import android.media.MediaSync;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {
     Button button;
     ImageView imageView;
     String url="http://www.edufect.com/images/courses/edufect.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        imageView=(ImageView)findViewById(R.id.imageview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }   , 0, 0, ImageView.ScaleType.FIT_XY, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                    }
                });
               CustomRequest.getInstance(MainActivity.this).addToRequestQue(imageRequest);
            }


        });
    }
}
