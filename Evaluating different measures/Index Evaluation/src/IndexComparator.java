import java.util.Comparator;

/**
 * 
 * This code is taken from stackoverflow.
 *
 */
public class IndexComparator implements Comparator<Integer> {
	private final Float[] array;
	public IndexComparator(Float[] array) {
		this.array = array;
	}
	
	public Integer[] createIndexArray()
    {
        Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
        {
            indexes[i] = i;
        }
        return indexes;
    }

    @Override
    public int compare(Integer index1, Integer index2)
    {
        return array[index2].compareTo(array[index1]);
    }

}
