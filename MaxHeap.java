import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {

    private ArrayList<T> heap;
    private int size;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private boolean isLeaf(int i){
        return i > size / 2 && i <= size;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapify(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);
        if (left < size && heap.get(left).compareTo(heap.get(largest)) > 0) {
            largest = left;
        }
        if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void insert(T element) {
        heap.add(element);
        size++;

        int c = size -1;

        while (c > 0 && heap.get(c).compareTo(heap.get(parent(c))) > 0) {
            swap(c, parent(c));
            c = parent(c);
        }

    }

    public T extractMax() {
        if(size == 0) return null;
        T max = heap.getFirst();

        if(size > 1){
            heap.set(0, heap.get(size - 1));
            heap.remove(size - 1);
            size--;
            heapify(0);
        }else{
            heap.removeFirst();
            size = 0;
        }

        return max;
    }

}
