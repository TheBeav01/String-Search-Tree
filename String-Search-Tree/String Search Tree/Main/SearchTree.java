package Main;

import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class SearchTree {
    private Node root;
    private Set<Edge> edgeSet;
    public SearchTree() {
        root = new Node();
        edgeSet = new TreeSet<Edge>();

    }
    public void buildTree(String... s) {
        Node cur;
        char c = '?';
        Edge cachedEdge;
        Pattern pattern = Pattern.compile(":");
        String splitDom[];
        for(String fullStr : s) {
            cur = root;
            splitDom = pattern.split(fullStr,2);
            String str = splitDom[1];
            for(int l = 0; l < str.length(); l++) {
                c = str.charAt(l);
                if(!cur.hasChild(c)) {
                    cachedEdge = cur.addEdge(c,cur);
                    if(l == str.length()-1) {
                        Node child = cachedEdge.getChild();
                        child.toggleEndOfWord();
                        child.setNames(splitDom[1],splitDom[0]);

                    }
                }
                cur = cur.getNextNode(c);
            }


        }
    }

    public Node getRoot() {
        return root;
    }

    public Node searchTreeForNode(String key) {
        String lowerKey = key.toLowerCase();
        System.out.println("Performing search on " + key);
        Node cur = root;
        int numMatches = 0;
        for(int l = 0; l < key.length(); l++) {
            char c = lowerKey.charAt(l);
            if(cur.hasMatchingEdge(c)) {
                numMatches++;
                cur = cur.getNextNode(c);
            }
            else {
                if(numMatches == 0) {
                    System.out.println("No matches found for: " + key);
                    return new Node();
                }
                return cur;
            }
        }

        return cur;
    }


    public ArrayList<String> enumerateKeysAfter(String key) {
        Stack<Node> nodesToTraverse = new Stack<Node>();
        nodesToTraverse.push(searchTreeForNode(key));
        while(!nodesToTraverse.isEmpty()) {
            Node n = nodesToTraverse.pop();
            Set<Edge> edges = n.getEdgeSet();
            if(n.isEndOfWord()) {
                System.out.println(n.getFullName());
            }
            for (Edge edge : edges) {
                nodesToTraverse.push(edge.getChild());
            }
        }
        return null;
    }
    public void printKeyset(String key) {
        enumerateKeysAfter(key);
    }
}
