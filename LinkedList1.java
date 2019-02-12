import java.util.*;
class Node
{
    Node next;
    int data;

    Node()
    {
        this.next=null;
        this.data=0;
    }

    Node(int data)
    {
        this.next=null;
        this.data=data;
    }

}
class LinkedList
{
    Node head=null;
    public Node add(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=n;
        }
        return head;
    }

    public Node insertPos(Node head,int pos,int data)
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
            return head;
        }
        else
        {
            Node n=new Node(data);
            Node adr=temp.next;
            temp.next=n;
            n.next=adr;
        }
        return head;
    }
    public void display(Node head)
    {
        Node temp=head;
        if(head==null)
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
    public Node deleteBeg(Node head)
    {
        if(head.next==null)
        {
            head=null;
            return head;
        }
        head=head.next;
        return head;
    }
    public Node deletePos(Node head,int pos)
    {
        if (pos==1)
        {
            head=head.next;
            return head;
        }
        Node pre=null;
        Node temp=head;
        int count=1;
        while(temp!=null)
        {
            if(count==pos)
            {
                count=99;
                break;
            }
            count++;
            pre=temp;
            temp=temp.next;
        }
        if(count!=99)
        {
            System.out.println("Invalid Position");
            return head;
        }
        else
        {
            temp=pre;
            if(temp.next==null)
            {
                return head;
            }
            temp.next=temp.next.next;
        }
        return head;
    }
    public Node deleteEnd(Node head)
    {
        Node temp=head;
        Node pre=head;
        while(temp.next!=null)
        {
            pre=temp;
            temp=temp.next;
        }
        if(pre==temp)
        {
            head=null;
        }
        pre.next=null;
        return head;
    }
}

class LinkedList1
{
    public static void main(String[] args)
    {
        LinkedList n1=new LinkedList();
        int a;
        Node d;
        int len;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter length of Link List :");
        len=s.nextInt();
        System.out.println("Enter Elements :");
        do {
            a=s.nextInt();
            d=n1.add(a);
            len--;
        } while (len>=1);
        System.out.println("Link List :");
        n1.display(d);
        System.out.println("Enter 1 to Insert element at a position");
        System.out.println("Enter 2 to Delete element at the begining");
        System.out.println("Enter 3 to Delete element at a position");
        System.out.println("Enter 4 to Delete element at end");
        System.out.println("Anything else to skip");
        int inp=s.nextInt();
        if(inp==1)
        {
            System.out.println("Enter value of element");
            int val=s.nextInt();
            System.out.println("Enter position to insert");
            int pos=s.nextInt();
            d=n1.insertPos(d, pos, val);
            System.out.println("Link List :");
            n1.display(d);
        }
        else if(inp==2)
        {
            d=n1.deleteBeg(d);
            System.out.println("Link List :");
            n1.display(d);
        }
        else if(inp==3)
        {
            System.out.println("Enter position to delete");
            int pos=s.nextInt();
            d=n1.deletePos(d,pos);
            System.out.println("Link List :");
            n1.display(d);
        }
        else if(inp==4)
        {
            d=n1.deleteEnd(d);
            System.out.println("Link List :");
            n1.display(d);
        }
    }
}