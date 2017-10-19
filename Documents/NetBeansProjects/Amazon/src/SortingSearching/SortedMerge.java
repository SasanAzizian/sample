

package SortingSearching;

/**
 *
 * @author sazizian
 */
public class SortedMerge {
    public static void main(String[] args){
        int[] a={5,7,17,22,0,0,0,0};
        int[] b={10,15,20,25};
        int[] c=sortedMerge(a,b);
        for(int i:c)
            System.out.println(i);
    }
          
    
    
    private static int[] sortedMerge(int[] a, int[] b){
        int indexA=(a.length -1)-(b.length);
        int indexB=b.length-1;
        int indexMerge=a.length-1;
        while(indexB>=0){
            if(a[indexA]>b[indexB]){
                a[indexMerge]=a[indexA];
                --indexA;
            }else{
                a[indexMerge]=b[indexB];
                --indexB;
            }
            --indexMerge;
        }
        return a;
        
    }
    
}
