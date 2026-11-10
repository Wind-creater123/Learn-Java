package different_class.enum_class;

public class Move {
    public static void main(String[] args) {
        move(Direction.UP);
    }

    private static void move(Direction direction) {
        switch (direction) {
            case UP:
                System.out.println(Direction.UP.ordinal());
                break;
            case DOWN:
                System.out.println(Direction.DOWN.ordinal());
                break;
            case LEFT:
                System.out.println(Direction.LEFT.ordinal());
                break;
            case RIGHT:
                System.out.println(Direction.RIGHT.ordinal());
                break;
            default:
                break;
        }
    }
}
