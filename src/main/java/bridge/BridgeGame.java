package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final int bridgeSize;
    private int gameCount;
    private final List<String> resultBridge;

    public BridgeGame(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
        this.bridgeSize = bridge.size();
        this.gameCount = 1;
        this.resultBridge = new ArrayList<>();
    }

    public int getBridgeSize() {
        return this.bridgeSize;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int sequence, String moving) {
        if (this.bridge.get(sequence).equals(moving)) {
            insertResult(moving, "O");
            return true;
        }
        insertResult(moving, "X");
        return false;
    }

    public void insertResult(String moving, String result) {
        if (moving.equals(BridgeValue.UP.getValue())) {
            resultBridge.add(result);
            resultBridge.add(" ");
            return;
        }
        resultBridge.add(" ");
        resultBridge.add(result);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
