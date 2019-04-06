package chap03_모든객체의공통메서드.rule11_clone재정의.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RefX_11 implements Cloneable {
    private int a;

    private String str;

    private final int[] intArr;

    @Override
    public RefX_11 clone() {
        try {
            return (RefX_11) super.clone();
        } catch ( CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
