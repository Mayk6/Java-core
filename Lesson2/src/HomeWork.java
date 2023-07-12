class HomeWork2 {
    public static void main(String[] args) {
        int[] array = {1,1,2,2,5,6,9,0,0};
        int[] array2 = new int[0];
        System.out.println(task1(array));
        System.out.println(task2(array2));
        System.out.println(task3(array));
        
    }
    
    public static int task1(int[] arr){
        if (isEmpty(arr)) {
            emptyError();
            return -1;
        }
        int evenCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) evenCount++;
        }
        return evenCount;
    }
    
    public static int task2(int[] arr) {
        if (isEmpty(arr)){
            emptyError();
            return -1;
        }
        int min = arr[0];
        int max = arr[0];
        for (int num : arr){
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return max - min;
    }
    
    public static boolean task3(int[] arr){
        if (isEmpty(arr)) {
            emptyError();
            return false;
        }
        int prevNum = 1;
        for (int num : arr) {
            if (prevNum == 0 && num == prevNum) return true;
            prevNum = num;
        }
        return false;
    }
    
    public static boolean isEmpty(int[] arr) {
        if (arr.length == 0) return true;
        return false;
    }
    
    public static void emptyError() {
        System.out.println("the passed array is empty");
    }
}
