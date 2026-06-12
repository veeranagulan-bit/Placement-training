import java.util.*;

public class SmartWarehouseManagement {

    // ===================== PRODUCT (ENCAPSULATION) =====================
    static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;
        private String category;

        public Product(int productId, String productName,
                       int quantity, double price, String category) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }

    // ===================== ABSTRACTION =====================
    static abstract class InventoryOperations {
        abstract void addProduct(Product p);

        abstract void displayProducts();

        abstract Product searchProduct(int id);

        abstract double calculateStorageCost(Product p);
    }

    // ===================== POLYMORPHISM =====================
    static class ElectronicsInventory extends InventoryOperations {
        List<Product> products = new ArrayList<>();

        public void addProduct(Product p) {
            products.add(p);
        }

        public void displayProducts() {
        }

        public Product searchProduct(int id) {
            for (Product p : products) {
                if (p.getProductId() == id) {
                    return p;
                }
            }
            return null;
        }

        public double calculateStorageCost(Product p) {
            return p.getQuantity() * 50.0;
        }
    }

    static class FoodInventory extends InventoryOperations {
        List<Product> products = new ArrayList<>();

        public void addProduct(Product p) {
            products.add(p);
        }

        public void displayProducts() {
        }

        public Product searchProduct(int id) {
            for (Product p : products) {
                if (p.getProductId() == id) {
                    return p;
                }
            }
            return null;
        }

        public double calculateStorageCost(Product p) {
            return p.getQuantity() * 20.0;
        }
    }

    static class ClothingInventory extends InventoryOperations {
        List<Product> products = new ArrayList<>();

        public void addProduct(Product p) {
            products.add(p);
        }

        public void displayProducts() {
        }

        public Product searchProduct(int id) {
            for (Product p : products) {
                if (p.getProductId() == id) {
                    return p;
                }
            }
            return null;
        }

        public double calculateStorageCost(Product p) {
            return p.getQuantity() * 10.0;
        }
    }

    // ===================== BST =====================
    static class BSTNode {
        int id;
        BSTNode left;
        BSTNode right;

        BSTNode(int id) {
            this.id = id;
        }
    }

    static class BST {
        BSTNode root;

        BSTNode insert(BSTNode node, int id) {
            if (node == null)
                return new BSTNode(id);

            if (id < node.id)
                node.left = insert(node.left, id);
            else if (id > node.id)
                node.right = insert(node.right, id);

            return node;
        }

        void insert(int id) {
            root = insert(root, id);
        }

        void inorder(BSTNode node) {
            if (node != null) {
                inorder(node.left);
                inorder(node.right);
            }
        }

        void preorder(BSTNode node) {
            if (node != null) {
                preorder(node.left);
                preorder(node.right);
            }
        }

        void postorder(BSTNode node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
            }
        }
    }

    // ===================== RECURSION =====================
    static int totalQuantity(Product[] products, int index) {
        if (index == products.length)
            return 0;

        return products[index].getQuantity()
                + totalQuantity(products, index + 1);
    }

    // ===================== BINARY SEARCH =====================
    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    // ===================== DP MAX PROFIT PATH =====================
    static int maxProfitPath(int[][] profit) {
        int r = profit.length;
        int c = profit[0].length;

        int[][] dp = new int[r][c];

        dp[0][0] = profit[0][0];

        for (int i = 1; i < r; i++)
            dp[i][0] = dp[i - 1][0] + profit[i][0];

        for (int j = 1; j < c; j++)
            dp[0][j] = dp[0][j - 1] + profit[0][j];

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = profit[i][j]
                        + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[r - 1][c - 1];
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Runtime runtime = Runtime.getRuntime();

        long startTime = System.nanoTime();

        // Product Count
        int n = sc.nextInt();

        if (n > 1000)
            n = 1000;

        Product[] products = new Product[n];

        ElectronicsInventory electronics = new ElectronicsInventory();
        FoodInventory food = new FoodInventory();
        ClothingInventory clothing = new ClothingInventory();

        BST bst = new BST();

        double inventoryValue = 0;
        double storageCost = 0;

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            sc.nextLine();

            String name = sc.nextLine();

            int qty = sc.nextInt();

            double price = sc.nextDouble();
            sc.nextLine();

            String category = sc.nextLine();

            Product p = new Product(id, name, qty, price, category);

            products[i] = p;

            inventoryValue += qty * price;

            if (category.equalsIgnoreCase("Electronics")) {
                electronics.addProduct(p);
                storageCost += electronics.calculateStorageCost(p);
            } else if (category.equalsIgnoreCase("Food")) {
                food.addProduct(p);
                storageCost += food.calculateStorageCost(p);
            } else {
                clothing.addProduct(p);
                storageCost += clothing.calculateStorageCost(p);
            }

            bst.insert(id);
        }

        // Warehouse Layout
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        if (rows > 20)
            rows = 20;

        if (cols > 20)
            cols = 20;

        int[][] warehouse = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                warehouse[i][j] = sc.nextInt();
            }
        }

        // BST Traversals
        bst.inorder(bst.root);
        bst.preorder(bst.root);
        bst.postorder(bst.root);

        // Recursive Quantity
        int totalQty = totalQuantity(products, 0);

        // Profit Matrix
        int profitRows = sc.nextInt();
        int profitCols = sc.nextInt();

        int[][] profitMatrix = new int[profitRows][profitCols];

        for (int i = 0; i < profitRows; i++) {
            for (int j = 0; j < profitCols; j++) {
                profitMatrix[i][j] = sc.nextInt();
            }
        }

        int maxProfit = maxProfitPath(profitMatrix);

        // Binary Search
        int[] ids = new int[n];

        for (int i = 0; i < n; i++) {
            ids[i] = products[i].getProductId();
        }

        Arrays.sort(ids);

        int searchId = sc.nextInt();

        binarySearch(ids, searchId);

        // Statistics
        int totalProducts = n;
        double totalInventoryValue = inventoryValue;

        // Prevent Optimization Removal
        if (storageCost == -1 ||
                totalQty == -1 ||
                totalProducts == -1 ||
                totalInventoryValue == -1 ||
                maxProfit == -1) {
            System.out.print("");
        }

        long endTime = System.nanoTime();

        runtime.gc();

        long memoryUsed =
                (runtime.totalMemory() - runtime.freeMemory()) / 1024;

        double executionTime =
                (endTime - startTime) / 1_000_000.0;

        System.out.println("===== PERFORMANCE REPORT =====");
        System.out.printf("Execution Time : %.3f ms%n", executionTime);
        System.out.println("Memory Used    : " + memoryUsed + " KB");

        sc.close();
    }
}