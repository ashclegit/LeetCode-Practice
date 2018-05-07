class Node
{
    Node next;
    int data;
    public Node(int data)
    {
        this.data=data;
    }
}


public class linkedList {

    static Node head1,head2;

    /*public void append(Node head,int data)
    {
        if(head == null)
        {
            head = new Node(data);
            return;
        }
        Node cur = head;
        while(cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = new Node(data);
    }*/

    /*public void prepend(int data)
    {
        Node newNode =  new Node(data);
        newNode.next = head;
        head = newNode;
    }*/

    /*public void deleteByValue(int data)
    {
        Node current = head;

        if(current.data == data)
        {
            current.next = current;
        }
        else
        {
            while(current.next != null)
            {
                if(current.next.data ==  data)
                {
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }

    }*/


    public void displayNodes(Node head)
    {
        Node cur = head;
        while(cur!=  null)
        {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    /*public void reverse()
    {
        Node cur = head;
        Node prev = null;

        while(cur != null)
        {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }*/

    public Node addNodes(Node l1,Node l2)
    {
        int sum = 0;
        Node dummy = new Node(0);
        Node p = dummy;


        while(l1 != null || l2 != null || sum != 0)
        {
            if(l1 != null)
            {
                sum = sum + l1.data;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                sum = sum + l2.data;
                l2 = l2.next;
            }

            p.next = new Node(sum%10);
            sum = sum/10;
            p = p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        //linkedList l = new linkedList();
        //linkedList l2 = new linkedList();
        linkedList l = new linkedList();

        l.head1 = new Node(1);
        l.head1.next =  new Node(2);
        l.head1.next.next = new Node(3);

        l.head2 = new Node(3);
        l.head2.next = new Node(4);
        l.head2.next.next = new Node(10);

        Node addNode = l.addNodes(head1,head2);

        l.displayNodes(addNode);



        //l.displayNodes(head);
        //l.reverse();
        //l.displayNodes(head);
    }

}


