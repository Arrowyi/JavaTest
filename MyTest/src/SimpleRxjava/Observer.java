package SimpleRxjava;

public interface Observer<T> {
	void onStrat();
	void onNext(T t);
	void onComplete();
	void onError();
}
