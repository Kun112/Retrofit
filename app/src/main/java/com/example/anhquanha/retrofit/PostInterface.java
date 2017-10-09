package com.example.anhquanha.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anhquan.ha on 10/9/2017.
 */

public interface PostInterface {
    @GET("/posts")
    Call<List<Post>> getPost();
}
