package SimpleRxjava;

import SimpleRxjava.Observable.OnSubscribe;
import SimpleRxjava.Observable.Operator;

public class Test {
	
	static class Student
	{
		String nameString;
		int number;
		
		public Student(String name, int number) {
			this.nameString = name;
			this.number = number;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Observable<String> obsevable = Observable.create(new OnSubscribe<String>() {

			@Override
			public void call(Observer<String> observer) {
				observer.onStrat();
				observer.onNext("aa");
				observer.onNext("bb");
				observer.onComplete();
				
			}
		});
		
		obsevable.subscribe(new Observer<String>() {
			@Override
			public void onNext(String t) {
				System.out.println(t);
				
			}
			
			@Override
			public void onError() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStrat() {
				System.out.println("begin to print");
				
			}
		});
		
		Observable.create(new OnSubscribe<Student>() {

			@Override
			public void call(Observer<Student> observer) {
				observer.onStrat();
				observer.onNext(new Student("Tony", 1));
				observer.onNext(new Student("Many", 2));
				observer.onNext(new Student("Lily", 3));
				observer.onComplete();
				
			}
			
		}).lift(new Operator<String, Test.Student>() {

			@Override
			public Observer<Student> call(final Observer<String> observer) {
				return new Observer<Test.Student>() {
					
					@Override
					public void onStrat() {
						System.out.println("begin to convert student");
						
					}
					
					@Override
					public void onNext(Student t) {
						observer.onNext(t.nameString);
						
					}
					
					@Override
					public void onError() {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onComplete() {
						System.out.println("convert student complete");
						
					}
				};
			}
			
		}).subscribe(new Observer<String>(){

			@Override
			public void onStrat() {
				System.out.println("begin to print name");
				
			}

			@Override
			public void onNext(String t) {
				System.out.println("student name is " + t);
				
			}

			@Override
			public void onComplete() {
				System.out.println("print name complete");
				
			}

			@Override
			public void onError() {
				// TODO Auto-generated method stub
				
			}
			
		});
		

	}

}
