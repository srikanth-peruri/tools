package design.patterns.creational.prototype;

public class PrototypeApp {
	public static void main(String[] args) {
		PrototypeExample prototypeExample = new PrototypeExample();
		prototypeExample.setInitialStr("Srikanth");
		PrototypeExample newP = (PrototypeExample) prototypeExample.clone();
		System.out.println("init string is : " + prototypeExample.getInitialStr());
		System.out.println("init string is : " + newP.getInitialStr());
	}
}
