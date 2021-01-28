package diiage.potherat.demo.demoapp3.ui.home;

import android.app.Activity;
import android.app.ActivityManager;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import diiage.potherat.demo.demoapp3.dal.repository.QuoteRepository;
import diiage.potherat.demo.demoapp3.model.Quote;

public class HomeViewModel extends ViewModel {

    private QuoteRepository quoteRepository;

    @Inject
    @ViewModelInject
    public HomeViewModel(QuoteRepository quoteRepository)
    {
        this.quoteRepository = quoteRepository;
    }

    public LiveData<String> getNumbers()
    {
        return Transformations.map(quoteRepository.getNumbers(), numbers ->
        {
            return numbers.toString();
        });
    }

    public LiveData<Quote> getLast()
    {
        return quoteRepository.getLast();
    }

    public LiveData<String> getDistincts()
    {
        return Transformations.map(quoteRepository.getDistincts(), source ->
        {
            return source.toString();
        });
    }


}