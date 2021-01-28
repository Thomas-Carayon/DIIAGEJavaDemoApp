package diiage.potherat.demo.demoapp3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import diiage.potherat.demo.demoapp3.R;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        viewModel =  new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(HomeViewModel.class);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        viewModel.getNumbers().observe(getViewLifecycleOwner(), number -> {
            TextView numberTextView =  this.getView().findViewById(R.id.txtNumberOfQuotes);
            numberTextView.setText(number.toString());
        });

        viewModel.getLast().observe(getViewLifecycleOwner(), quote -> {
            TextView numberTextView =  this.getView().findViewById(R.id.txtQuote);
            TextView sourceTextView =  this.getView().findViewById(R.id.txtSource);
            numberTextView.setText(quote.getQuote());
        });

        viewModel.getDistincts().observe(getViewLifecycleOwner(), source -> {
            TextView numberTextView =  this.getView().findViewById(R.id.txtNumberOfQuotes);
            numberTextView.setText(source.toString());
        });
    }
}