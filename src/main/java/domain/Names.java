package domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Names {
    private final List<Name> names;

    public Names(final List<String> names) {
        this.names = createNames(names);
        validate(names);
    }

    private static List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(Name::new)
                .toList();
    }

    private void validate(final List<String> names) {
        if (hasDuplicatePlayers(names)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다");
        }
    }

    private boolean hasDuplicatePlayers(final List<String> names) {
        return Set.copyOf(names).size() != names.size();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int size() {
        return names.size();
    }

    public Name get(final int index) {
        if (index >= size()) {
            throw new IllegalArgumentException("존재하는 이름만큼만 조회할 수 있습니다.");
        }
        return names.get(index);
    }
}