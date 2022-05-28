package F8E1;

import java.util.*;
import java.util.List;
import java.util.function.IntFunction;

/**
 *
 * @author Pedro Simões [30007732]
 *         Gonçalo Lemos [30007523]
 */
public class MethodReference<intArray1> {
    //4.
    private static class MyComparator {
        public int compare(final Integer a, final Integer b) {
            return a.compareTo(b);
        }
    }

    public static void main(String args[]) {
        //1.
            List<Integer> list = Arrays.asList(2,7,4, 5, 1, 6, 8, 3, 10, 9);
            for(int number : list) System.out.println(number);
        //2.
            list.forEach(n -> System.out.println(n));
        //3.
            list.forEach(System.out::println);
        //5.
            final MyComparator myComparator = new MyComparator();
            list.sort((a, b) -> myComparator.compare(a, b));
        //6.
            list.sort(myComparator::compare);
        //7.
            list.forEach(System.out::println);
        //8.
            List<String> list2 = new ArrayList<>();
            list2.add("Bianca");
            list2.add("João");
            list2.add("joana");
            list2.add("Maria");
            list2.add("Julio");
            list2.add("Patricia");
            list2.add("Roberto");
            list2.add("Marcelo");
            list2.add("Leonor");
            list2.add("lea");
        //9.
            list2.sort((a, b) -> a.compareToIgnoreCase(b));
        //10.
            list2.sort(String::compareToIgnoreCase);
        //11.
            list2.forEach(System.out::println);
        //12.
            IntFunction<int[]> array1 = size -> new int[size];
            int[] intArray1 = array1.apply(5);
            for (int i = 0; i < intArray1.length; i++) {
                intArray1[i] = i * i - i / 2;
            }
            System.out.println(Arrays.toString(intArray1));
        //13.
            IntFunction<int[]> array2 = int[]::new;
            int[] intArray2 = array2.apply(5);
            for (int i = 0; i < intArray2.length; i++) {
                intArray2[i] = i * i - i / 2;
            }
            System.out.println(Arrays.toString(intArray2));
        //14.
            IntFunction<String> i = (x)->Integer.toString(x);
            System.out.println(i.apply(34).length());
        //15. Referência a um método de instância de um objeto qualquer de um dado tipo.
            IntFunction<String> i2 = Integer::toString;
            System.out.println(i2.apply(34).length());
    }
}