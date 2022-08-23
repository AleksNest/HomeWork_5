import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Intersect_task_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (hm.containsKey(nums1[i])) {
                hm.put(nums1[i], hm.get(nums1[i]) + 1);
            } else {
                hm.put(nums1[i], 1);                                 // ключ - элемент nums1, значение - кол таких элемиентов в mus 1
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (hm.containsKey(nums2[i]) && hm.get(nums2[i]) != 0) {  // проверка на наличии в ключе значения равного значению nums2
                list.add(nums2[i]);
                hm.put(nums2[i], hm.get(nums2[i]) - 1);                 // перезапись в словарь данного значения, но уже с кол элементов - 1
            }

        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1, 2};
        int[] nums2 = {2, 2, 2, 1};

        System.out.println(Arrays.toString((intersect(nums1, nums2))));

    }
}


