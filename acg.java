import ir.seraj.fanoos.Fragment.ConversationFragment;

public class acg implements Runnable {
    final /* synthetic */ ConversationFragment a;

    public acg(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void run() {
        if (ConversationFragment.aC > 50) {
            this.a.aB.setSelection(0);
        } else {
            this.a.aB.setSelection(50 - ConversationFragment.aC);
        }
    }
}
