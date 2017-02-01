package com.example.denischuvasov.viper.domain.common;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by denischuvasov on 16.01.17.
 */

public abstract class Interactor<ResultType, ParameterType> {
    private final CompositeSubscription subscription = new CompositeSubscription();
    private final Scheduler jobScheduler;
    private final Scheduler uiScheduler;

    public Interactor(Scheduler jobScheduler, Scheduler uiScheduler) {
        this.jobScheduler = jobScheduler;
        this.uiScheduler = uiScheduler;
    }

    protected abstract Observable<ResultType> buildObservable(ParameterType parameterType);

    public void execute(ParameterType parameterType, Subscriber<ResultType> subscriber) {
        subscription.add(buildObservable(parameterType)
                .subscribeOn(jobScheduler)
                .observeOn(uiScheduler)
                .subscribe(subscriber));
    }
}
