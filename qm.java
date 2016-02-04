class qm implements Runnable {
    final /* synthetic */ qg a;

    private qm(qg qgVar) {
        this.a = qgVar;
    }

    public void run() {
        if (!this.a.u) {
            this.a.a();
        } else if (this.a.getAdapter() != null) {
            this.a.post(this);
        }
    }
}
