package info.baejw.sample.retrofit

import info.baejw.sample.entity.Board
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface RetrofitApiService {
    @GET("board")
    fun gets(): Observable<List<Board>>

    @GET("board/{boardid}")
    fun get(@Path("boardid") boarid: String): Observable<List<Board>>

    @Headers("Content-type: application/json")
    @POST("board")
    fun set(@Body board: Board): Observable<Board?>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): RetrofitApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("url")
                    .build()

            return retrofit.create(RetrofitApiService::class.java)
        }
    }
}