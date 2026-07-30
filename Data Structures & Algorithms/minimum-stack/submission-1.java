class MinStack {

    List<Integer> arr1;
    List<Integer> arr2;

    public MinStack() {
        this.arr1 = new ArrayList<>();
        this.arr2 = new ArrayList<>();
    }
    
    public void push(int val) {
        arr1.add(val);
        if (arr2.isEmpty() || val <= arr2.getLast()) {
            arr2.addLast(val);
        }

    }
    
    public void pop() {
        int pop = arr1.removeLast();
        if (pop <= arr2.getLast()) {
            arr2.removeLast();
        }
    }
    
    public int top() {
        return arr1.getLast();
    }
    
    public int getMin() {
        return arr2.getLast();
    }
}
