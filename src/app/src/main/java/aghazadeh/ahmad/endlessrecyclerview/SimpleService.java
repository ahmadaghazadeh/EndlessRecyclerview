package aghazadeh.ahmad.endlessrecyclerview;

/**
 * Created by 890683 on 08/02/2016.
 */
import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;


public final class SimpleService {
    public static final String API_URL = "http://xomorod.com/api";

    public class StackOverflowQuestions {
        List<Question> items;
    }

    public interface StackOverflowAPI {
        @GET("/api/products")
        Call<String> loadQuestions(@Query("tagged") String tags);
    }


}