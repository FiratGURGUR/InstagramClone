package frt.gurgur.instagramclone.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import frt.gurgur.instagramclone.R;
import frt.gurgur.instagramclone.di.ViewModelFactory;
import frt.gurgur.instagramclone.model.post.PostsItem;
import frt.gurgur.instagramclone.ui.adapters.PostListAdapter;
import frt.gurgur.instagramclone.ui.base.BaseFragment;
import frt.gurgur.instagramclone.ui.listeners.LikeListener;


public class MainFragment extends BaseFragment {

    ViewDataBinding binding;
    @Inject
    ViewModelFactory vmFactory;
    MainViewModel vm;
    @BindView(R.id.rcyclePostList)
    public RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    GridLayoutManager gridLayoutManager;
    private List<PostsItem> postList = new ArrayList<>();
    PostListAdapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vm = ViewModelProviders.of(this, vmFactory).get(MainViewModel.class);
        vm.loadPostList();
        observePostList();
        observeLoadStatus();
        observerErrorStatus();
        setRecyclerView();

    }

    @Override
    protected void observerErrorStatus() {
        vm.getErrorStatus().observe(this,
                error -> {
                    if (error != null) {
                        showProgressBar(false);
                    }
                });
    }

    @Override
    protected void observeLoadStatus() {
        vm.getLoadingStatus().observe(
                this,
                isLoading -> showProgressBar(isLoading)
        );
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    public void observePostList() {
        vm.getPostList().observe(this, new Observer<List<PostsItem>>() {
            @Override
            public void onChanged(List<PostsItem> dataItems) {
                if (dataItems != null) {
                    postList.addAll(dataItems);
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        });
    }

    private void setRecyclerView() {
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        adapter = new PostListAdapter(getContext(),postList,likeListener);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }


    LikeListener likeListener = new LikeListener() {
        @Override
        public void clickLike(PostsItem item) {
            Toast.makeText(mActivity, item.getDescription(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void clickComment() {
            Toast.makeText(mActivity, "Yorumlar", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void clickSend() {
            Toast.makeText(mActivity, "Gönder", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void clickSave(PostsItem item) {
            Toast.makeText(mActivity, "Kaydet", Toast.LENGTH_SHORT).show();
        }
    };

}