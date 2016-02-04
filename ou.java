class ou {
    final Object b;

    ou(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.b = obj;
    }
}
