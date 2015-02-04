
public class SelectionSort implements ISorter {

    int numComparisons;
    int numAssignments;

    public SelectionSort() {
        this.numComparisons = 0;
        this.numAssignments = 0;
    }

    public SortStats sort(int[] a) {
        //init sortstat variables (this is separate so that variable tracking works)
        this.numComparisons = 0;
        this.numAssignments = 0;
        long startTime = System.nanoTime();

        //call the actual sort alg
        actualsort(a);

        return new SortStats("Selection Sort",
                a.length,
                this.numComparisons,
                this.numAssignments,
                System.nanoTime() - startTime);
    }

    private void actualsort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minindex = 0;
            for (int currentread = 0; currentread <= i; currentread++) {
                numComparisons++;
                if (a[currentread] < a[minindex]) {
                    minindex = currentread;
                }
            }
            swap(a, i, minindex);
        }
    }
    
    private void swap(int[] a, int i, int min) {
        int temp = a[i];
        numAssignments++;
        a[i] = a[min];
        numAssignments++;
        a[min] = temp;
        numAssignments++;
    }
}
