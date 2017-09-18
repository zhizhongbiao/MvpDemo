package cn.com.tianyudg.mvpdemo.mvp.reveiver;

public class NetworkStateEvent {
    public boolean hasNetworkConnected;

    public NetworkStateEvent(boolean hasNetworkConnected) {
        this.hasNetworkConnected = hasNetworkConnected;
    }
}
