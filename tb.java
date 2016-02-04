class tb implements Runnable {
    final /* synthetic */ ta a;

    private tb(ta taVar) {
        this.a = taVar;
    }

    public void run() {
        this.a.d.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
