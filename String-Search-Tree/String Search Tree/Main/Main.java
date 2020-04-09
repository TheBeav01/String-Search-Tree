package Main;

public class Main {

    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        searchTree.buildTree("Dirt", "Dirty", "Dirt Sapling", "Sapling", "Iron", "Iron Blocks", "Iron Bricks",
                "Iron Sapling");
        searchTree.printKeyset("D");
        searchTree.printKeyset("I");
        searchTree.printKeyset("X");
        searchTree.printKeyset("DIZZZ");
        searchTree.printKeyset("Sapling");
        searchTree.printKeyset("Iron");
    }
}
