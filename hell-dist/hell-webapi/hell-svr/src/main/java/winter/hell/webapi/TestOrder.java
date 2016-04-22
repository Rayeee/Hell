package winter.hell.webapi;

/**
 * Created by ZGY on 16/3/10.
 */
public class TestOrder {

    private static int[] array = {900,21,512,212,41,63,663};
    static int length = array.length;

    public static void swap(int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void print(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void mappao() {
        for(int tag = length-1;tag > 1;tag--){
            for(int i = 0;i < length-1;i++){
                if(array[i] > array[i+1]){
                    swap(i, i+1);
                }
            }
        }
        print(array);
    }

    public static void xuanze(){
        for (int i=0;i<length;i++){
            for(int j = i+1;j<length;j++){
                if(array[j]<array[i]){
                    swap(i, j);
                }
            }
        }
        print(array);
    }



    public static void main(String[] args) {
//        mappao();
        xuanze();
    }
}
