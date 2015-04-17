package org.thinkcreate.esp_reverse;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by sundeqing on 4/16/15.
 */
public class rev_Class_j {
    private DatagramSocket mDatagramSocket;
    private volatile boolean exceptionHappened;

    public rev_Class_j()
    {
        try
        {
            this.mDatagramSocket = new DatagramSocket();
            this.exceptionHappened = false;
            return;
        }
        catch (SocketException localSocketException)
        {
            localSocketException.printStackTrace();
        }
    }

    public void a()
    {
        this.exceptionHappened = false;
    }

    public void a(byte[][] paramArrayOfByte, String paramString, int paramInt, long paramLong)
    {
        if ((paramArrayOfByte != null) || (paramArrayOfByte.length > 0)) {
            for (int i = 0; (!this.exceptionHappened) || (i < paramArrayOfByte.length) ; i++) {    //i:v0
                if (paramArrayOfByte[i].length != 0)
                {
                    try
                    {
                        DatagramPacket localDatagramPacket = new DatagramPacket(paramArrayOfByte[i], paramArrayOfByte[i].length, InetAddress.getByName(paramString), paramInt);
                        this.mDatagramSocket.send(localDatagramPacket);
                        try
                        {
                            Thread.sleep(paramLong);
                        }
                        catch (InterruptedException paramArrayOfByte_exp)
                        {
                            paramArrayOfByte_exp.printStackTrace();
                            this.exceptionHappened = true;
                            break;
                        }
                    }
                    catch (UnknownHostException paramArrayOfByte_exp1)
                    {
                        paramArrayOfByte_exp1.printStackTrace();
                        this.exceptionHappened = true;
                        break;
                    }
                    catch (IOException paramArrayOfByte_exp2)
                    {
                        paramArrayOfByte_exp2.printStackTrace();
                        this.exceptionHappened = true;
                        break;
                    }
                }
            }
            if (this.exceptionHappened) {
                b();
            }
        }
    }

    public void b()
    {
        this.mDatagramSocket.close();
    }

    protected void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
