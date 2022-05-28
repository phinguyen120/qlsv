/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Qlsv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.io.ObjectStreamConstants.STREAM_MAGIC;
import static java.io.ObjectStreamConstants.STREAM_VERSION;
import java.io.OutputStream;

/**
 *
 * @author maithuyha
 */
public class AppendObjectOutputStream extends ObjectOutputStream{
    private boolean append;
    private boolean initialized;
    private DataOutputStream dout;

    public AppendObjectOutputStream(boolean append) throws IOException {
        super();
        this.append = append;
        this.initialized = true;
    }

    public AppendObjectOutputStream(OutputStream out,boolean append) throws IOException {
        super(out);
        this.append = append;
        this.initialized = true;
        this.dout = new DataOutputStream(out);
        this.writeStreamHeader();
    }

   
     @Override
    protected void writeStreamHeader() throws IOException {
        if (!this.initialized || this.append) return;
        if (dout != null) {
            dout.writeShort(STREAM_MAGIC);
            dout.writeShort(STREAM_VERSION);
        }
    }
}
