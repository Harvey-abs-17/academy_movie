package com.example.academy_movie.data.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class SearchMovieResponse(
    @SerializedName("Response")
    var response: String?, // True
    @SerializedName("Search")
    var search: List<Search?>?,
    @SerializedName("totalResults")
    var totalResults: String? // 545
) : Parcelable {
    @Parcelize
    data class Search(
        @SerializedName("imdbID")
        var imdbID: String?, // tt4853102
        @SerializedName("Poster")
        var poster: String?, // https://m.media-amazon.com/images/M/MV5BMTdjZTliODYtNWExMi00NjQ1LWIzN2MtN2Q5NTg5NTk3NzliL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg
        @SerializedName("Title")
        var title: String?, // Batman: The Killing Joke
        @SerializedName("Type")
        var type: String?, // movie
        @SerializedName("Year")
        var year: String? // 2016
    ) : Parcelable
}