
/**
 * 
 * Dieses Interface definiert Methoden zum Umgang mit Objekten, ueber die iteriert werden kann.
 * 
 * @see AccountIterator
 * @author Annalena Maier
 * @author Dominik Schuessler
 * */
public interface Iterator {
	
	boolean hasNext(int position);

	Object next(int position);

	boolean hasPrev(int position);

}
