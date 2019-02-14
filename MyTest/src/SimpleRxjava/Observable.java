package SimpleRxjava;

public class Observable<T> {
	public interface OnSubscribe<T>
	{
		void call(Observer<T> observer);
	}
	
	public interface Operator<R, X>
	{
		Observer<X> call(Observer<R> observer);
	}
	
	private OnSubscribe<T> onSubscribe;
	
	public static <T> Observable<T> create(OnSubscribe<T> onSubscribe)
	{
		return new Observable<T>(onSubscribe);
	}
	
	private Observable(OnSubscribe<T> onSubscribe)
	{
		this.onSubscribe = onSubscribe;
	}
	
	public void subscribe(Observer<T> observer)
	{
		onSubscribe.call(observer);
	}
	
	public <U> Observable<U> lift(final Operator<U, T> operator)
	{
		return Observable.create(new OnSubscribe<U>() {
			
			@Override
			public void call(Observer<U> observer) {
				Observer<T> newObserver = operator.call(observer);
				onSubscribe.call(newObserver);
			
			}
		});
	}
}
