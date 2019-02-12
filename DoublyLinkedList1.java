import java.util.*;
class Node
{
    Node next;
    Node prev;
    int data;
    Node()
    {
        this.next=null;
        this.prev=null;
        this.data=0;
    }
    Node(int data)
    {
        this.next=null;
        this.prev=null;
        this.data=data;
    }
}
class DoublyLinkedList
{
    Node head=null;
    Node tail=null;
    public void insertBeg(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }
        else
        {
            head.prev=n;
            n.next=head;
            head=n;
        }
    }
    public void insertEnd(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }
        else
        {
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
    }
    public void insertPos(int pos,int data)
    {
        int count=1;
        Node temp=head;
        while(temp!=null)
        {
            if(count+1==pos)
            {
                count=99;
                break;
            }
            count++;
            temp=temp.next;
        }
        if(count!=99)
        {
            System.out.println("Invalid Position");
        }
        else
        {
            Node n=new Node(data);
            Node pre=temp.next;
            temp.next=n;
            n.prev=temp;
            n.next=pre;
        }
    }
    public void traverse()
    {
        Node temp=head;
        if(head==null||tail==null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            while(temp.next!=null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
            System.out.println(temp.data);
        }
    }
    public void traverseRev()
    {
        Node temp=tail;
        if(head==null||tail==null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            while(temp.prev!=null)
            {
                System.out.println(temp.data);
                temp=temp.prev;
            }
            System.out.println(temp.data);
        }
    }
    public void deleteBeg()
    {
        if(head==null)
        {
            return ;
        }
        if(head.next!=null)
        {
            head=head.next;
            head.prev=null;
        }
        else
        {
            head=null;
        }
    }
    public void deleteEnd()
    {
        if(tail==null)
        {
            return ;
        }
        if(tail.prev!=null)
        {
            tail=tail.prev;
            tail.next=null;
        }
        else
        {
            tail=null;
        }
    }
    public void deletePos(int pos)
    {
        int count=1;
        Node temp=head;
        if(head==null)
        {
            return ;
        }
        else
        {
            while(temp!=null)
            {
                if(count==pos)
                {
                    count=99;
                    break;
                }
                temp=temp.next;
                count++;
            }
            if(count!=99)
            {
                System.out.println("Invalid Position");
            }
            else
            {
                if(temp.next==null&&temp.prev==null)
                {
                    head=null;
                    tail=null;
                    return;
                }
                if(temp.next==null)
                {
                    tail=tail.prev;
                    tail.next=null;
                    return ;
                }
                else if(temp.prev==null)
                {
                    head=head.next;
                    head.prev=null;
                    return ;
                }
                temp.prev.next=temp.next;
                temp.next.prev=temp;  
            }

        }
    }
}

class DoublyLinkedList1
{
    public static void main(String[] args)
    {
        DoublyLinkedList n1=new DoublyLinkedList();
        int a;
        Node d;
        int len;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter length of Link List :");
        len=s.nextInt();
        System.out.println("Enter Elements :");
        do {
            a=s.nextInt();
            n1.insertEnd(a);
            len--;
        } while (len>=1);
        System.out.println("Link List :");
        n1.traverse();
        System.out.println("Reverse Link List :");
        n1.traverseRev();
        System.out.println("Enter 1 to Delete element at the begining");
        System.out.println("Enter 2 to Delete element at the end");
        System.out.println("Enter 3 to Insert element at a position");
        System.out.println("Enter 4 to Delete element at a position");
        System.out.println("Anything else to skip");
        int inp=s.nextInt();
        if(inp==1)
        {
            n1.deleteBeg();
            System.out.println("Link List :");
            n1.traverse();
        }
        else if(inp==2)
        {
            n1.deleteEnd();
            System.out.println("Link List :");
            n1.traverse();
        }
        else if(inp==3)
        {
            System.out.println("Enter value of element");
            int val=s.nextInt();
            System.out.println("Enter position to insert");
            int pos=s.nextInt();
            n1.insertPos(pos, val);
            System.out.println("Link List :");
            n1.traverse();
        }
        else if(inp==4)
        {
            System.out.println("Enter position to delete at");
            int pos=s.nextInt();
            n1.deletePos(pos);
            System.out.println("Link List :");
            n1.traverse();
        }
    }
}