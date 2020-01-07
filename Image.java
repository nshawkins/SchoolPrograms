public abstract class Image {
    protected String magic_number;
    protected int width;
    protected int height;
    protected int depth;

    abstract void Rotate90(); //rotate 90 degrees clockwise
    abstract void FlipVertical(); 
}