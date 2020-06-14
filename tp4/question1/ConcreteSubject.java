package question1;

import java.util.Observable;
import java.util.ArrayList;

/**
 * Décrivez votre classe ConcreteSubject ici.
 * 
 * @author Sergio
 * @version 1.0
 */
public class ConcreteSubject extends Observable {

	/** ConcreteSubject est composé d'une liste list */
	private ArrayList<String> list;

	public ConcreteSubject() {
		list = new ArrayList<String>();
	}

	public void insert(String name) {
		list.add(name);
		setChanged();
		notifyObservers(name);
	}

	public String toString() {
		return list.toString();
	}

}
