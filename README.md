<h1 align="center">Movie App ( MVVM ) </h1>
 &nbsp;&nbsp;
<h2 align="center"> Android App only for educational purpose and inspired by hamrah -e aval academy project with MVVM architecture</h2> &nbsp;&nbsp;
<p align="center">
<img width="400" height="800"
 src="https://github.com/Harvey-abs-17/academy_movie/assets/138676273/0347fae4-8a5a-4677-97aa-9150d70f864f"/>
<img width="400" height="800" src="https://github.com/Harvey-abs-17/academy_movie/assets/138676273/37a3cda0-1c75-4bd3-96ab-f39b4d1d61ef"/>
<img width="400" height="800" src="https://github.com/Harvey-abs-17/academy_movie/blob/master/Animation.gif"/>
 &nbsp;&nbsp;
</p> &nbsp;&nbsp;

<h2 align="left">Patterns and Third party libraries applied</h2> &nbsp;&nbsp;
<ol>
        <li>Hilt : for dependency injection.</li>
        <li>Retrofit : Construct the REST APIs and paging network data.</li>
        <li>Coroutine : is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.</li>
        <li>Picasso : Loading images from network/resource.</li>
        <li>Single Activity Pattern.</li>
        <li>Navigation Component : allows the user to move from one screen to another and back out to a different one.</li>
        <li>View binding : makes it easier to write code that interacts with views.</li>
        <li>Live Data : observable data holder class.</li>
        <li>ViewModel : Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.</li>
        <li> <a href="http://www.omdbapi.com/">  Movie api </a> : a free Movie api which provide movie detail information for us.</li>
</ol>

<h2 align="left">How to work with omdb Api</h2>
<ol>

<li>we can use these api to search and find detail of movies like the code has been writen below</li>&nbsp;&nbsp;

     ```
    @GET(" ")
    suspend fun searchMovie(
        @Query("apikey") apikey: String = API_KEY,
        @Query("s") s: String,
        @Query("page") page: Int
    ): Response<SearchMovieResponse>

    @GET(" ")
    suspend fun getMovieDetailData(
        @Query("apikey") apikey :String = API_KEY,
        @Query("i") i :String
    ) :Response<DetailMovieResponse>
  
    ```

   <li>get api key from <a href"http://www.omdbapi.com/">here</a> and replace your key in this line. you can find this line in <code>Utils/Constants</code></li>&nbsp;&nbsp;

     ```
             const val API_KEY = "your api key"
  
    ```
  
</ol>


