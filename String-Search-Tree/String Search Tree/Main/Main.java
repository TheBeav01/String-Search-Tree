package Main;

public class Main {

    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        searchTree.buildTree("mc:dirt", "mc:dirty", "xd:dirt_sapling", "a:sapling", "ab:iron", "d:iron_blocks", "x:Iron Bricks",
                "x:Iron Sapling");
        searchTree.printKeyset("D");
        searchTree.printKeyset("I");
        searchTree.printKeyset("X");
        searchTree.printKeyset("DIZZZ");
        searchTree.printKeyset("Sapling");
        searchTree.printKeyset("Iron");
    }
}
