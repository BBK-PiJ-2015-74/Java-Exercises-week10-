package examples;

// an example of a generic functional interface in Java which can be used to pass a lambda expression

public interface GenericFunc<T> {
	
		T genericfunc (T t); // T is the Type, t is the argument passed to the function
}
