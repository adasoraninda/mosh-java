package inheritance;

public class Main {

    public static void main(String[] args) {
        uiControl();
    }

    public static void uiControl() {
        UIControl[] controls = { new TextBox(), new CheckBox() };

        for (var control : controls)
            control.render();
    }

}
