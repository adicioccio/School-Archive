public class Tile {

    private boolean bomb;
    private int location;
    private boolean marked;
    private boolean selected;

    Tile () {}

    Tile (boolean bomb, int location) {
        this.bomb = bomb;
        this.location = location;
    }

    void setMark(boolean mark) {
        this.marked = mark;
    }

    void setSelect(boolean select) {
        this.selected = select;
    }

    boolean getMark() {
        return marked;
    }

    boolean getSelect() {
        return selected;
    }

    boolean getBomb() {
        return bomb;
    }

    int getLoc() {
        return location;
    }

    String printTile() {
        return "Bomb: " + bomb + " | Coord: " + location;
    }


}
