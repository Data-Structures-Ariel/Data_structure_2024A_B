package Les01.L04.Generics;

import java.util.ArrayList;

public class Car<T> {

    ArrayList arrayList;


    public Car(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

//    public T getByIndex(int index){
//        return arrayList.get(index);
//    }
}
