package effectiveJava;

import java.util.HashSet;

/**
 * @author GuanBin
 * @version InstrumentHashSet.java, v1 2018/1/4 上午12:47 GuanBin Exp $$
 */
public class InstrumentHashSet<E> extends HashSet<E> {

    private int num = 0;

    public InstrumentHashSet() {

    }

    public InstrumentHashSet(int a, int b) {

        super(a, b);
    }

    @Override
    public boolean add(E e) {
        num++;
        return super.add(e);
    }

}
