public class JobQueue{

    private MaxHeap<Job> heap;

    public JobQueue(){
        heap = new MaxHeap<>();
    }

    public void insert(Job job){
        heap.insert(job);
    }

    public void runHighestPriority(){
        heap.extractMax().execute();
    }

}
