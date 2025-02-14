class ProductOfNumbers {
    private List<Integer> nums;
    private List<Integer> prefixProducts; // To store the products up to each point
    private int lastZeroIndex;

    public ProductOfNumbers() {
        this.nums = new ArrayList<>();
        this.prefixProducts = new ArrayList<>();
        this.lastZeroIndex = -1; // Track position of the last zero
        prefixProducts.add(1); // To facilitate product calculation
    }

    public void add(int num) {
        nums.add(num);
        
        if (num == 0) {
            lastZeroIndex = nums.size() - 1; // Update lastZeroIndex when zero is added
            prefixProducts.add(1); // Reset product multipliers
        } else {
            // Multiply the last known product with the current number
            int newProduct = prefixProducts.get(prefixProducts.size() - 1) * num;
            prefixProducts.add(newProduct);
        }
    }

    public int getProduct(int k) {
        int size = nums.size();

        // If the last zero index is within the range of k
        if (lastZeroIndex >= size - k) {
            return 0;
        }

        // We want the product of the range [size - k, size)
        // This can be calculated using the prefix product array
        int totalProduct = prefixProducts.get(size);
        int previousProduct = prefixProducts.get(size - k);

        return totalProduct / previousProduct; // Product of the last k elements
    }
}
