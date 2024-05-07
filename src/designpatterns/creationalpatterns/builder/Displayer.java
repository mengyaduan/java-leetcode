package designpatterns.creationalpatterns.builder;

import lombok.Data;

@Data
public class Displayer {
    private String menu;
    private String playList;
    private String mainWindow;
    private String controllerBar;
    private String favoriteList;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("创建一个显示模式");
        if (this.getMenu() != null) {
            stringBuilder.append("\n菜单=" + this.getMenu());
        }
        if (this.getFavoriteList() != null) {
            stringBuilder.append("\n抽藏列表=" + this.getFavoriteList());
        }
        if (this.getControllerBar() != null) {
            stringBuilder.append("\n控制条=" + this.getControllerBar());
        }
        if (this.getPlayList() != null) {
            stringBuilder.append("\n播放列表=" + this.getPlayList());
        }
        if (this.getMainWindow() != null) {
            stringBuilder.append("\n主窗口=" + this.getMainWindow());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
