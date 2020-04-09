public class Main {

    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        searchTree.buildTree("Dirt", "Dirty", "Dirt Sapling", "Sapling", "Iron", "Iron Blocks", "Iron Bricks", "Iron Planks");
        searchTree.printKeyset("D");
        searchTree.printKeyset("I");
        searchTree.printKeyset("X");
        searchTree.printKeyset("Iron Planks");
    }
}
