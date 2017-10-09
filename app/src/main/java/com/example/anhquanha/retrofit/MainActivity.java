package com.example.anhquanha.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<List<Post>> {

    List<Post> postArr;
    PostAdapter postAdapter;
    ListView lisView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lisView = findViewById(R.id.list_item);
        startingDownload();

    }

    private void startingDownload() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://jsonplaceholder.typicode.com")
                .build();
        PostInterface postInterface = retrofit.create(PostInterface.class);
        Call<List<Post>> call = postInterface.getPost();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
        if(response.isSuccessful())
        {
            //Toast.makeText(this, response.body().toString(), Toast.LENGTH_LONG).show();
            postArr = response.body();
            postAdapter = new PostAdapter(this, android.R.layout.simple_list_item_1 , postArr);
            lisView.setAdapter(postAdapter);
            //postAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {
        Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();

    }
}
