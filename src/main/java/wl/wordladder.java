package wl;

import java.util.HashSet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class wordladder {
    public static class node{
        private String obj;
        private node left = null;
        private node right = null;
        private node next = null;

        node(String obj){
            this.obj = obj;
        }
    }

    private node head = null;
    private node tail = null;
    private HashSet linked = new HashSet();
    private HashSet words = new HashSet();

    public void letin(node n){
        if(head==null){
            head = n;
            tail = n;
            return;
        }
        else{
            tail.right = n;
            n.left = tail;
            tail = n;
        }
    }

    public node letout(){
        if(head==tail && head!=null){
            node res = head;
            head = null;
            tail = null;
            return res;
        }
        else if (head==null){
            return null;
        }
        else{
            node res = head;
            head = head.right;
            return res;
        }
    }

    public node push(node t,String obj){
        node res = new node(obj);
        res.next = t;
        return res;
    }

    public void printNode(node n){
        while (n!=null){
            System.out.print(n.obj);
            System.out.print("->");
            n = n.next;
        }
    }

    public boolean makeWordSet(String filename){
        File file = new File(filename);
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = reader.readLine())!=null){
                words.add(s);
//                System.out.println(s);
            }
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private boolean finded = false;
    private node result = null;

    public void findNearBy(node n,String dest){
        char[] thisstring = n.obj.toCharArray();
        int l = n.obj.length();
        for (int i=0;i<l;i++){
            for (char j='a';j<='z';j++){
                char[] newcc = thisstring.clone();
                newcc[i]=j;
                String newss = new String(newcc);
                if (words.contains(newss) && !linked.contains(newss)){
                    node newnn = push(n,newss);
                    letin(newnn);
                    if(newss.equals(dest)){
                        result = newnn;
                        finded = true;
                        return;
                    }
                    linked.add(newss);
                }
            }
        }
    }

    public static void main(String[] args){
        wordladder w = new wordladder();
        w.makeWordSet("./src/dicts/dictionary.txt");
//        String s1 = "data";
//        String s2 = "code";
        Scanner s = new Scanner(System.in);
        String s1 = null;
        String s2 = null;
        System.out.print("#word1:");
        s1 = s.next();
        System.out.print("#word2:");
        s2 = s.next();

        w.letin(new node(s1));
        w.linked.add(s1);

        while (!w.finded && w.head!=null){
            node thisn = w.letout();
            w.findNearBy(thisn,s2);
        }
        if (w.result != null){
            w.printNode(w.result);
            return;
        }
        else{
            System.out.println("not exist");
            System.out.print(w.linked);
            return;
        }
    }


}
