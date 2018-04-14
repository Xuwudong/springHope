package base;

public class Singleton {
	private Singleton(){
		
	}
	private static volatile Singleton instance;
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}

class Singleton2{
	private Singleton2(){
		
	}
	private static class LazyHolder{
		private static Singleton2 instance = new Singleton2();
	}
	
	public static Singleton2 getInstance(){
		return  LazyHolder.instance;
	}
}