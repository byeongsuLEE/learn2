package geneic;

/**
 * 작성자  : lbs
 * 날짜    : 2025-09-13
 * 풀이방법
 **/


public class GenericsMain {
    public static void main(String[] args) {
        Generics<Double> doubleGenerics = new Generics<Double>(3.16);
        doubleGenerics.getNumType();

        Generics<Integer> integerGenerics = new Generics<Integer>(123);

        integerGenerics.getNumType();
    }
}
