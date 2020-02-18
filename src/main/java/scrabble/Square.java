package scrabble;

public class Square {
    enum Modifier {
        DOUBLE_WORD,
        DOUBLE_LETTER,
        TRIPLE_WORD,
        TRIPLE_LETTER,
        NORMAL,
        STAR
    };

    private Tile tile = null;
    private Modifier mod;
    private char letter = 0;

    public Square(Modifier mod) {
        this.mod = mod;
    }

    public Tile getTile() {
        return tile;
    }

    public void setBlankTile(char letter) {
        this.tile = Tile.BLANK;
        this.letter = letter;
    }

    public void setTile(Tile tile) {
        if (tile == Tile.BLANK) {
            throw new IllegalArgumentException();
        }
        this.tile = tile;
        this.letter = tile.getSymbol();
    }

    public Modifier getModifier() {
        return mod;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isEmpty() {
        return tile == null;
    }

    // empty print square if full print tile.
    public String toString() {
        if (getTile() != null) {
            return getLetter() + " ";
        } else {
            switch (getModifier()) {
                case DOUBLE_WORD:
                    return "DW";
                case DOUBLE_LETTER:
                    return "DL";
                case TRIPLE_WORD:
                    return "TW";
                case TRIPLE_LETTER:
                    return "TL";
                case NORMAL:
                    return "  ";
                case STAR:
                    return "* ";
            }
        }
        return null;
    }
}
