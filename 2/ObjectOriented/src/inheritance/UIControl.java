package inheritance;

public abstract class UIControl {
    private boolean isEnable = true;

    public UIControl() {

    }

    public UIControl(boolean isEnable) {
        this.isEnable = isEnable;
        System.out.println("UIControl");
    }

    public abstract void render();

    public void enable() {
        isEnable = true;
    }

    public void disable() {
        isEnable = false;
    }

    public boolean isEnable() {
        return isEnable;
    }

}
