package Chapter3;
/**
 * 
 * @author emeliewidegren
 * 
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in,
 * first out" basis. People must adopt either the "oldest" (based on arrival time) of
 * all animals at the shelter, or they can select whether they would prefer a dog or
 * a cat (and will receive the oldest animal of that type). They cannot select which
 * specific animal they would like. Create the data structures to maintain this system
 * and implement operations such as enqueue, dequeueAny, dequeueDog and
 * dequeueCat.You may use the built-in LinkedList data structure.
 */
public class Q7 {
	public static void main(String[] args) {
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("Elsa"));
		animals.enqueue(new Cat("Viola"));
		animals.enqueue(new Dog("Odd"));
		animals.enqueue(new Dog("Sofie"));
		animals.enqueue(new Cat("Luke"));
		animals.enqueue(new Dog("Dexter"));
		animals.enqueue(new Dog("Magnus"));
		animals.enqueue(new Cat("Leia"));
		
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dog("Lilo"));
		animals.enqueue(new Cat("Stich"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}
	}
}
