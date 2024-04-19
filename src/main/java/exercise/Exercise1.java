package exercise;

import io.reactivex.rxjava3.core.Observable;

public class Exercise1 {

    public static void main(String[] args) {
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Click number 1");
            emitter.onNext("Click number 2");
            emitter.onError(new Throwable("Error"));
            emitter.onNext("Click number 3");
            emitter.onComplete();
        });

        observable.subscribe(System.out::println, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> System.out.println("Observable is Completed."));
    }
}
