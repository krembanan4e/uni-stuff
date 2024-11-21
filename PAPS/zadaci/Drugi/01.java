/*
Edna lista da se podeli na 2 listi, edna od parni brojki, edna od neparni brojki
PROMENATA DA SE NAPRAVI SO PROMENA NA VRSKITE MEGJU JAZLITE

input:
14
1 5 2 3 0 6 4 3 7 9 1 4 6 8

output:
2->0->6->4->4->6->8
1->5->3->3->7->9->1
*/

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.zip.ZipEntry;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp.element;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "->" + tmp.element;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }
    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }

    public void setFirst(SLLNode<E> node) {
        first = node;
    }
}

public class Main {

    public static void promeni(SLL<Integer> lista, SLL<Integer> parni, SLL<Integer> neparni){
        SLLNode<Integer> curr = lista.getFirst();
        SLLNode<Integer> neparniLast = null;
        SLLNode<Integer> parniLast = null;

        while (curr != null) {
            if (curr.element % 2 == 0){
                if (parniLast == null){
                    parni.setFirst(curr);
                    parniLast = curr;
                }
                else {
                    parniLast.succ = curr;
                }
                parniLast = curr;
            }
            else{
                if (neparniLast == null){
                    neparni.setFirst(curr);
                    neparniLast = curr;
                }
                else{
                    neparniLast.succ = curr;
                }
                neparniLast = curr;
            }
            curr = curr.succ;
        }

        if (neparniLast != null){
            neparniLast.succ = curr;
        }
        if (parniLast != null){
            parniLast.succ = curr;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Integer> lista = new SLL<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }

        SLL<Integer> parni = new SLL<>();
        SLL<Integer> neparni = new SLL<>();
        promeni(lista, parni, neparni);

        System.out.println(parni);
        System.out.println(neparni);
    }
}

