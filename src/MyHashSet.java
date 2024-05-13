import java.util.ArrayList;

public class MyHashSet<T> {
    private ArrayList<T>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float PERCENTAGE_OF_FULLED_ARRAY = 0.7f;

    public MyHashSet() {
        buckets = new ArrayList[DEFAULT_CAPACITY];
        size = 0;

    }

    public void add(T element) {
        int index = getIndex(element);
        if (buckets[index]==null)
        {
            buckets[index] = new ArrayList<>();
        }
        else
        {
            if (buckets[index].contains(element))
            {
                return;
            }
        }
        buckets[index].add(element);
        size++;
        if (size==buckets.length*PERCENTAGE_OF_FULLED_ARRAY) {
            resize();
        }
    }

    public boolean contains(T element) {
        int index = getIndex(element);
        ArrayList<T> bucket = buckets[index];
        return bucket.contains(element);
    }

    public int size() {
        return size;
    }

    private int getIndex(T element) {
        return element.hashCode() % buckets.length;
    }

    private void resize() {
        ArrayList<T>[] oldBuckets = buckets;
        buckets = new ArrayList[oldBuckets.length * 2];
        size = 0;
        for (ArrayList<T> bucket : oldBuckets) {
            if (bucket!=null)
            {
                for (T element : bucket) {
                    add(element);
                }
            }
        }
    }
}