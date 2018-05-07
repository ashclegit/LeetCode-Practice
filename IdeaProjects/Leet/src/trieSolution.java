import java.io.*;
import java.util.*;


public class trieSolution {

    public static class Node {

        private static int Number_Of_chars = 26;
        Node[] children = new Node[Number_Of_chars];

        private static int getCharIndex(char c)
        {
            return c - 'a';
        }

        private Node getNode(char c)
        {
            return children[getCharIndex(c)];
        }

        private void setNode(char c,Node node)
        {
            children[getCharIndex(c)] = node;
        }

        private void add(String s)
        {
            add(s,0);
        }

        private void add(String s,int index)
        {
            if(index == s.length()) return ;
            char current = s.charAt(index);
            int charCode = getCharIndex((current));
            Node child = getNode(current);
            if(child == null)
            {
                child = new Node();
                setNode(current,new Node());
            }

            child.add(s,index + 1);
        }

        public int findCount(String s, int index)
        {
            //if()
            return 1;
        }
    }

}
