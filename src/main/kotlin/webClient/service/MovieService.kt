package webClient.service

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import webClient.IMDB_API_KEY

interface MovieService {

    @GET(IMDB_API_KEY)
    fun findTop250Movies(): Call<ResponseBody>

}