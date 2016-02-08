package aghazadeh.ahmad.endlessrecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import org.json.JSONArray;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RecyclerViewActivity extends AppCompatActivity implements Callback<String> {

    private  int count=0;
    private SwipeRefreshLayout swipeContainer;
    @InjectView(R.id.recycler_view)
    RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private final RecyclerBinderAdapter<TitleSection, CardViewType> adapter
            = new RecyclerBinderAdapter<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(count);
                count++;
            }
        });

        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        fetchTimelineAsync(0);
        count++;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://xomorod.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SimpleService.StackOverflowAPI stackOverflowAPI = retrofit.create(SimpleService.StackOverflowAPI.class);

        Call<String> call = stackOverflowAPI.loadQuestions("android");
        //asynchronous call
        call.enqueue(this);
    }


    public void fetchTimelineAsync(int page) {




    }

    @Override
    public void onResponse(Response<String> response, Retrofit retrofit) {
        setProgressBarIndeterminateVisibility(false);


            CardPic cardPic=new CardPic(this,new PicData("Title" +response.body(),response.body(),"https://pixabay.com/static/uploads/photo/2015/04/10/00/41/yellow-715540_960_720.jpg"));
            adapter.add(TitleSection.SECTION_3, cardPic);


    }

    @Override
    public void onFailure(Throwable t) {
String ss=t.getMessage();
        ss=ss+"sss";
    }
}
