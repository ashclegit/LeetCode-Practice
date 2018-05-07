public class heapTest {

    private int capacity = 10;
    private int size  = 0;

    int [] items  =  new int[capacity];


    private  int getLeftChildIndex(int parentIndex)
    {
        return 2*parentIndex+ 1;

    }

    private int getRightChildIndex(int parentIndex)
    {
        return 2*parentIndex + 2;
    }

    private int getParentIndex(int childIndex)
    {
        return (childIndex - 1)/2;
    }

    private boolean hasParent(int index)
    {
        return getParentIndex(index) < size;
    }

    public void swap()
    {

    }

    public int leftChild(int index)
    {
        return items[getRightChildIndex(index)];
    }


    public int rightChild(int index)
    {
        return items[getLeftChildIndex(index)];
    }

    public int peek()
    {
        if(size == 0)
        {
            throw  new IllegalStateException();
        }
        else
        {
            return items[0];
        }
    }

    public int poll()
    {
        if(size == 0) throw new IllegalStateException();

        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        //ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public boolean hasChild(int index)
    {
        return true;
    }

    public int parent(int index)
    {
        return 1;
    }

    public boolean hasRightChild(int index)
    {
        return true;
    }

    public void heapifyUp()
    {
        int index  = size - 1;
        while(hasParent(index) && parent(index) > items[index])
        {
            //swap(getParentIndex(index),index);
            index =  getParentIndex(index);
        }
    }

    public void heapifyDown()
    {
        int index = 0;
        while(hasChild(index))
        {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index))
            {
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerChildIndex])
            {
                break;
            }
            else
            {
                //swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

}
