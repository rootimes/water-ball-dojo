package cardframework.core;

import java.util.ArrayList;
import java.util.List;

public abstract class HandCard<T extends Card> {

	protected List<T> cards = new ArrayList<>();

	public void addCard(T card) {
		cards.add(card);
	}

	public T get(int index) {
		return cards.get(index);
	}

	public List<T> getAllCards() {
		return new ArrayList<>(cards);
	}

	public T remove(int index) {
		return cards.remove(index);
	}

	public int size() {
		return cards.size();
	}
}
