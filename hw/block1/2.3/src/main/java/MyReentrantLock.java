//
//class MyReentrantLock {
//
//    private final NonReentrantLockFactory factory;
//    private final NonReentrantLock baseLock;
//
//    public MyReentrantLock(NonReentrantLockFactory factory) {
//        this.factory = factory;
//        this.baseLock = factory.create();
//    }
//
//    public void lock() {
//        // TODO: implement me
//    }
//
//    public void unlock() {
//        // TODO: implement me
//    }
//}

interface NonReentrantLockFactory {
    NonReentrantLock create();
}