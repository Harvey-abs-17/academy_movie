package com.example.academy_movie.data.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class DetailMovieResponse(
    @SerializedName("Actors")
    var actors: String?, // Christian Bale, Michael Caine, Ken Watanabe
    @SerializedName("Awards")
    var awards: String?, // Nominated for 1 Oscar. 14 wins & 79 nominations total
    @SerializedName("BoxOffice")
    var boxOffice: String?, // $206,863,479
    @SerializedName("Country")
    var country: String?, // United States, United Kingdom
    @SerializedName("DVD")
    var dVD: String?, // 09 Sep 2009
    @SerializedName("Director")
    var director: String?, // Christopher Nolan
    @SerializedName("Genre")
    var genre: String?, // Action, Crime, Drama
    @SerializedName("imdbID")
    var imdbID: String?, // tt0372784
    @SerializedName("imdbRating")
    var imdbRating: String?, // 8.2
    @SerializedName("imdbVotes")
    var imdbVotes: String?, // 1,535,514
    @SerializedName("Language")
    var language: String?, // English, Mandarin
    @SerializedName("Metascore")
    var metascore: String?, // 70
    @SerializedName("Plot")
    var plot: String?, // After witnessing his parents' death, Bruce learns the art of fighting to confront injustice. When he returns to Gotham as Batman, he must stop a secret society that intends to destroy the city.
    @SerializedName("Poster")
    var poster: String?, // https://m.media-amazon.com/images/M/MV5BOTY4YjI2N2MtYmFlMC00ZjcyLTg3YjEtMDQyM2ZjYzQ5YWFkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg
    @SerializedName("Production")
    var production: String?, // N/A
    @SerializedName("Rated")
    var rated: String?, // PG-13
    @SerializedName("Ratings")
    var ratings: List<Rating?>?,
    @SerializedName("Released")
    var released: String?, // 15 Jun 2005
    @SerializedName("Response")
    var response: String?, // True
    @SerializedName("Runtime")
    var runtime: String?, // 140 min
    @SerializedName("Title")
    var title: String?, // Batman Begins
    @SerializedName("Type")
    var type: String?, // movie
    @SerializedName("Website")
    var website: String?, // N/A
    @SerializedName("Writer")
    var writer: String?, // Bob Kane, David S. Goyer, Christopher Nolan
    @SerializedName("Year")
    var year: String? // 2005
) : Parcelable {
    @Parcelize
    data class Rating(
        @SerializedName("Source")
        var source: String?, // Internet Movie Database
        @SerializedName("Value")
        var value: String? // 8.2/10
    ) : Parcelable
}