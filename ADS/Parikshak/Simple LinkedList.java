public class SingleLinkedList{
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void printList(){
        Node n=head;
        while(n!=null){
            System.out.print(n.data+" ");
        }
        System.out.println();
    }
    public void addAtBeginning(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public void addAtEnd(int data){
         Node newNode=new Node(data);
         if(head==null){
             head=newNode;
             return;
         }
         Node lastNode=head;
         while(lastNode.next!=null){
             lastNode=lastNode.next;
         }
         lastNode.next=newNode;
    }
    public void addAfter(int afd,int data){
         Node n=head;
         while(n!=null && n.data!=afd){
             n=n.next;
         }
         if(n!=null){
             Node newNode=new Node(data);
             newNode.next=n.next;
             n.next=newNode;
         }
          else{
            System.out.print(afd);
        }
    }
    public void addBefore(int abd,int data){
       if(head==null)return;
       if(head.data=abd){
           addAtBeginning(data);
           return;
       }
       Node n=head;
       while(n.next!=null && n.next.data!=abd){
           n=n.next;
       }
       if(n.next!=null){
            Node newNode=new Node(data);
            newNode.next=n.next;
            n.next=newNode;
       }
       else{
            System.out.print(abd);
        }
    }
    public void deleteNode(int k){
         Node n=head, prev=null;
         if(n!=null && n.data!=k){
             head=n.next;
             return;
         }
         while(n!=null && n.data!=k){
             prev=n;
             n=n.next;
         }
         if(n==null)return;
         prev.next=n.next;
    }
    public void deleteAfter(int dan){
        Node n=head;
        while(n!=null && n.data!=dan){
            n=n.next;
        }
        if(n!=null && n.next!=null){
            n.next=n.next.next;
        }
        else{
            System.out.print(dan);
        }
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        SingleLinkedList sl=new SingleLinkedList();
         int n = sc.nextInt(); // Number of operations
        sc.nextLine(); // Consume the newline

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "addAtBeginning":
                    sl.addAtBeginning(Integer.parseInt(parts[1]));
                    break;
                case "addAtEnd":
                    sl.addAtEnd(Integer.parseInt(parts[1]));
                    break;
                case "addAfter":
                    sl.addAfter(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
                case "addBefore":
                    sl.addBefore(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
                case "deleteNode":
                    sl.deleteNode(Integer.parseInt(parts[1]));
                    break;
                case "deleteAfter":
                    sl.deleteAfter(Integer.parseInt(parts[1]));
                    break;
            }
        }

        sl.printList(); // Print the final list
        sc.close(); // Close the scanner
    }
}
