Java Classloading
	We have many concepts in class loading
		Core classes
			Java core classes that comes with the java. Classes like Math, lang..etc
		Extension classes
			These are shipped by Orcale for other processes. Like Cryptography..etc
		Delegation 
			Class loaders check the classpath to load the classes. If not found its delegated to the parent class loader and then to its parent. If not found it back tracks to the initial class loader and fails.
		
Class loader works on delegating the loading of classes

There are 3 class loaders for even a simle applciation we run
		1. Bootstrap classloader
		2. Extensions classloader
		3. application classloader
		
		
			