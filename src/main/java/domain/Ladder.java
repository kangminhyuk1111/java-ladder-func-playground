package domain;

import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        validateLines(lines);

        this.lines = lines;
    }

    private void validateLines(final List<Line> lines) {
        validateEmpty(lines);
        validateWidth(lines);
        validateHeight(lines);
    }

    public static Ladder of(final List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> lines() {
        return lines;
    }

    public int width() {
        return lines().get(0).size() + 1;
    }

    private static void validateEmpty(final List<Line> lines) {
        if (lines.isEmpty()) {
            throw new RuntimeException("빈 라인은 들어올 수 없습니다.");
        }
    }

    private void validateWidth(List<Line> lines) {
        int firstLineWidth = lines.get(0).size();

        if (firstLineWidth < 1) {
            throw new RuntimeException("사다리 폭은 최소 2 이상이어야 합니다.");
        }

        for (Line line : lines) {
            if (line.size() != firstLineWidth) {
                throw new RuntimeException("모든 라인의 폭이 동일해야 합니다.");
            }
        }
    }

    private void validateHeight(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new RuntimeException("사다리 높이는 최소 1 이상이어야 합니다.");
        }
    }
}
