package com.rifky.simlik.service;

import com.rifky.simlik.model.Kegiatan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rifky on 07/05/17.
 */

public interface ServiceApi {
    /*@GET("/")
    Call<ListKegiatan> getListKegiatan(
            @Query("bulan") String bulan,
            @Query("tahun") String tahun
    );

    @GET("/")
    Call<List<Kegiatan>> getKegiatan(
            @Query("bulan") String bulan,
            @Query("tahun") String tahun
    );*/
    @GET("api.php")
    Call<Kegiatan> getKegiatan(
            @Query("bulan") String bulan,
            @Query("tahun") String tahun
    );


}
