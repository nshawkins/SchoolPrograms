import java.io.File;
import java.io.FileNotFoundException;

public abstract class Image {

    // Image attributes
    protected String magic;
    protected int width;
    protected int height;
    protected int depth;

    // Accessors: getMagic(), getWidth(), etc...

    public String getMagic(){
        return this.magic;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getDepth(){
        return this.depth;
    }

    // Modifiers: setMagic(string m), setWidth(int w), etc...
    public void image(){
        magic = "--";
        width = 0;
        height = 0;
        depth = 0;
    }

    public void setMagic(String m){
        this.magic = m;
    }

    public void setWidth(int w){
        this.width = w;
    }

    public void setHeight(int h){
        this.height = h;
    }

    public void setDepth(int d){
        this.depth = d;
    }
    // -------------------
    // abstract functions
    // -------------------
    public abstract void flip_horizontally();
    public abstract void flip_vertically();
    public abstract void rotate_right_90();

}