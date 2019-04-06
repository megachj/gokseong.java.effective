package chap06_enum과어노테이션.rule33_EnumMap.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Herb_33 {
    public enum Type { ANNUAL, PERENNIAL, BIENNIAL }

    private final String name;
    private final Type type;

    @Override
    public String toString() {
        return name;
    }
}
