package chap05_제네릭.rule28_한정적와일드카드.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Job_28 implements Comparable<Job_28>{
    private int sellery;

    @Override
    public int compareTo(Job_28 o) {
        if (this.sellery < o.sellery)
            return -1;
        else if (this.sellery == o.sellery)
            return 0;
        else
            return 1;
    }
}