package designpatterns.structuralpatterns.bridge;

abstract class DataTrans {
    protected DataTransImpl imp;

    public void setImp(DataTransImpl imp) {
        this.imp = imp;
    }

    public abstract void transFile(String fileName);
}
